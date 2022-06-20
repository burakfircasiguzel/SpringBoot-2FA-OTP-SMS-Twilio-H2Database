package com.example.demo.controllers;

import com.example.demo.entities.OneTimePassword;
import com.example.demo.entities.User;
import com.example.demo.requests.SignOTPRequest;
import com.example.demo.requests.UserRequest;
import com.example.demo.repos.responses.StandartResponse;
import com.example.demo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 *
 * @author Burak Fircasiguzel < www.github.com/burakfircasiguzel >
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private OneTimePasswordService oneTimePasswordService;

    private final SmsService smsService;

    @Autowired
    public UserController(SmsService smsService) {
        this.smsService = smsService;
    }

    @PostMapping
    public ResponseEntity<StandartResponse> isLogin(@RequestBody @Valid UserRequest userRequest) {
        if (userService.loginControl(userRequest)) {
            userService.setLogged(true);
            smsService.sendSmsByService(userRequest);
            return ResponseEntity.ok(new StandartResponse("SMS sent to the relevant phone number"));
        }
        return ResponseEntity.ok(new StandartResponse("Bad credentials, try again"));
    }

    @GetMapping
    public List<User> getAll(){
        return userService.getAll();
    }

    @PostMapping("/register")
    public ResponseEntity<StandartResponse> register(@RequestBody UserRequest userRequest) {
        if (userService.save(userRequest)) {
            return ResponseEntity.ok(new StandartResponse("Register succesfully"));
        }
        return ResponseEntity.ok(new StandartResponse("Error while user registering"));
    }

    @PostMapping("/secret")
    public ResponseEntity<StandartResponse> secretPlace(@RequestBody SignOTPRequest signOTPRequest) {
        if (userService.isLogged()) {
            User user = userService.getUserByUsername(signOTPRequest.getUsername());
            if(user == null){
                return ResponseEntity.ok(new StandartResponse("User not found"));
            }
            OneTimePassword oneTimePassword = oneTimePasswordService.findTopByUserId(user.getId());
            if(oneTimePassword != null && oneTimePassword.getCode().equalsIgnoreCase(signOTPRequest.getCode())){
                oneTimePassword.setStatus(true);
                oneTimePasswordService.save(oneTimePassword);
                return ResponseEntity.ok(new StandartResponse("Welcome the secret page"));
            }
            return ResponseEntity.ok(new StandartResponse("OTP not found"));
        }
        return ResponseEntity.ok(new StandartResponse("OTP did not confirmed"));
    }


}
