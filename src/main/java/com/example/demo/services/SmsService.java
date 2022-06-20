package com.example.demo.services;

import com.example.demo.requests.OTPSmsSender;
import com.example.demo.requests.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author Burak Fircasiguzel < www.github.com/burakfircasiguzel >
 */

@Service
public class SmsService {

    private final OTPSmsSender smsSender;

    @Autowired
    public SmsService(@Qualifier("twilioService") TwilioSmsSender smsSender) {
        this.smsSender = smsSender;
    }

    public void sendSmsByService(UserRequest userRequest) {
        smsSender.sendSms2(userRequest);
    }

}
