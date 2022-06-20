package com.example.demo.services;

import com.example.demo.config.TwilioConfiguration;
import com.example.demo.entities.OneTimePassword;
import com.example.demo.entities.User;
import com.example.demo.repos.OneTimePasswordRepository;
import com.example.demo.repos.UserRepository;
import com.example.demo.requests.*;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Burak Fircasiguzel < www.github.com/burakfircasiguzel >
 */

@Service("twilioService")
public class TwilioSmsSender implements OTPSmsSender {

    private Map<String, String> otpMap = new HashMap<>();

    private static final Logger LOGGER = LoggerFactory.getLogger(TwilioSmsSender.class);

    private final TwilioConfiguration twilioConfiguration;

    @Autowired
    OneTimePasswordRepository oneTimePasswordRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    public TwilioSmsSender(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

    @Override
    public void sendSms2(UserRequest userRequest) {
        User user = userRepository.findByUsername(userRequest.getUsername());
        if (user != null) {
            PhoneNumber to = new PhoneNumber(user.getTelephoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
            String otp = generateOTP();
            String otpMessage = "Dear Customer , Your OTP is ##" + otp + "##";
            //MessageCreator creator = Message.creator(to, from, otpMessage);
            //creator.create();
            OneTimePassword oneTimePassword = new OneTimePassword();
            if (user.getUsername() != null) {
                oneTimePassword.setUser(user);
                oneTimePassword.setCode(otp);
                oneTimePasswordRepository.save(oneTimePassword);
            }
            LOGGER.info("SMS sent to the relevant phone number {} ", oneTimePassword.getUser().getTelephoneNumber());
            LOGGER.info("OTP: " + otp);
        }

    }


    private String generateOTP() {
        return new DecimalFormat("000000")
                .format(new Random().nextInt(999999));
    }
}
