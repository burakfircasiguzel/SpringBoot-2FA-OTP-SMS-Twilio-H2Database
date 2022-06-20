package com.example.demo.controllers;

import com.example.demo.entities.OneTimePassword;
import com.example.demo.services.OneTimePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author Burak Fircasiguzel < www.github.com/burakfircasiguzel >
 */

@RestController
@RequestMapping("/msg")
public class OneTimePasswordController {

    @Autowired
    private OneTimePasswordService oneTimePasswordService;

    @GetMapping
    public List<OneTimePassword> main() {
        return oneTimePasswordService.getAll();
    }


}
