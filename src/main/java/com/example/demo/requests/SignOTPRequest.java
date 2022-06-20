package com.example.demo.requests;

import lombok.Data;

/**
 * @author Burak Fircasiguzel < www.github.com/burakfircasiguzel >
 */
@Data
public class SignOTPRequest {
    private String username;
    private String code;
}
