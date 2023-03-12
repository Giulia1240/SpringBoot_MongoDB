package com.workshopspringbootmongodb.sbmb.service;

import com.workshopspringbootmongodb.sbmb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
}
