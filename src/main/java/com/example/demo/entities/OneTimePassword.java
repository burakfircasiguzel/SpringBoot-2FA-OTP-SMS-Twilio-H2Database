package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Burak Fircasiguzel < www.github.com/burakfircasiguzel >
 */

@Entity
@Table(name = "onetimepassword")
@Data
public class OneTimePassword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    User user;

    String code;
    boolean status;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    Date date;


}
