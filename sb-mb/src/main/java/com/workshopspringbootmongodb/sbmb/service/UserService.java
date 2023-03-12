package com.workshopspringbootmongodb.sbmb.service;


import com.workshopspringbootmongodb.sbmb.dto.User;
import com.workshopspringbootmongodb.sbmb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
