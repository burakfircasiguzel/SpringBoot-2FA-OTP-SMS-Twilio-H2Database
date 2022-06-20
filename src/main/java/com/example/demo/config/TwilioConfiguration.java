package com.example.demo.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Burak Fircasiguzel < www.github.com/burakfircasiguzel >
 */

@Configuration
@ConfigurationProperties("twilio")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TwilioConfiguration {

    private String accountSid;
    private String authToken;
    private String trialNumber;
}

