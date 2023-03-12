package com.workshopspringbootmongodb.sbmb.controller;

import com.workshopspringbootmongodb.sbmb.domain.User;
import com.workshopspringbootmongodb.sbmb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    ResponseEntity<List<User>> findAll() {
        User maria = new User(null, "Maria", "maria@teste.com");
        User alex = new User(null, "Alex", "alex@teste.com");
        User joao = new User(null, "Joao", "joao@teste.com");

        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria, alex, joao));

        return ResponseEntity.ok().body(list);
    }
}

