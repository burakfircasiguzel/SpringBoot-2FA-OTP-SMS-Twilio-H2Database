package com.example.demo.repos;

import com.example.demo.entities.OneTimePassword;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Burak Fircasiguzel < www.github.com/burakfircasiguzel >
 */
public interface OneTimePasswordRepository extends JpaRepository<OneTimePassword, Long> {

    OneTimePassword findTopByUserIdAndCode(Long userId, String code);

    OneTimePassword findTopByUserIdOrderByIdDesc(Long id);
}
