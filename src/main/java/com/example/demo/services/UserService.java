package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.repos.UserRepository;
import com.example.demo.requests.UserRequest;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Burak Fircasiguzel < www.github.com/burakfircasiguzel >
 */

@Service
public class UserService {

    @Getter
    @Setter
    // Normally, we should create session then keep credentials encrypted in cookie. But this enough for this scenario.
    private boolean logged = false;

    @Autowired
    UserRepository userRepository;

    public boolean loginControl(UserRequest userRequest) {
        User user = userRepository.findByUsernameAndPassword(userRequest.getUsername(), userRequest.getPassword());
        if (user != null) {
            return true;
        }
        return false;
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public boolean save(UserRequest userRequest) {
        User user = new User();
        User u = userRepository.findByUsername(userRequest.getUsername());
        if (u == null) {
            user.setUsername(userRequest.getUsername());
            user.setPassword(userRequest.getPassword());
            user.setTelephoneNumber(userRequest.getTelephoneNumber());
            userRepository.save(user);
            return true;
        }
        return false;
    }
}
