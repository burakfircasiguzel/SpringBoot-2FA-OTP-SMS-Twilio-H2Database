package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

/**
 * @author Burak Fircasiguzel < www.github.com/burakfircasiguzel >
 */
@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;

    @JsonIgnore
    String password;
    String telephoneNumber;

}