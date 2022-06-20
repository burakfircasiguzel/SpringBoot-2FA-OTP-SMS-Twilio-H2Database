package com.example.demo.repos;

import com.example.demo.entities.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Burak Fircasiguzel < www.github.com/burakfircasiguzel >
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String userName);

    User findByUsernameAndPassword(String userName, String password);

}
