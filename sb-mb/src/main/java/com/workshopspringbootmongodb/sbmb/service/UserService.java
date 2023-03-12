package com.workshopspringbootmongodb.sbmb.service;


import com.workshopspringbootmongodb.sbmb.domain.User;
import com.workshopspringbootmongodb.sbmb.service.exception.ObjectNotFoundException;
import com.workshopspringbootmongodb.sbmb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}
