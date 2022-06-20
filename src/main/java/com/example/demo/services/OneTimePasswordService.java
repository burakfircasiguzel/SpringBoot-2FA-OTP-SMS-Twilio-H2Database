package com.example.demo.services;

import com.example.demo.entities.OneTimePassword;
import com.example.demo.repos.OneTimePasswordRepository;
import org.springframework.stereotype.Service;
import java.util.List;


/**
 * @author Burak Fircasiguzel < www.github.com/burakfircasiguzel >
 */

@Service
public class OneTimePasswordService {

    private OneTimePasswordRepository oneTimePasswordRepository;

    public OneTimePasswordService(OneTimePasswordRepository oneTimePasswordRepository) {
        this.oneTimePasswordRepository = oneTimePasswordRepository;
    }

    public OneTimePassword save(OneTimePassword oneTimePassword){
        return oneTimePasswordRepository.save(oneTimePassword);
    }

    public OneTimePassword findTopByUserId(Long id){
        return oneTimePasswordRepository.findTopByUserIdOrderByIdDesc(id);
    }

    public List<OneTimePassword> getAll() {
         return oneTimePasswordRepository.findAll();
    }
}
