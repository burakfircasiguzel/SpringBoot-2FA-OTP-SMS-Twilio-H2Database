package com.example.demo.requests;

import lombok.Data;

/**
 * @author Burak Fircasiguzel < www.github.com/burakfircasiguzel >
 */
@Data
public class UserRequest {
    private String username;
    private String password;
    private String telephoneNumber;
}
