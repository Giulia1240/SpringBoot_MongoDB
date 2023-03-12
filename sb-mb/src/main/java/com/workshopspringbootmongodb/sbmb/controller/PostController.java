package com.workshopspringbootmongodb.sbmb.controller;

import com.workshopspringbootmongodb.sbmb.domain.Post;
import com.workshopspringbootmongodb.sbmb.domain.User;
import com.workshopspringbootmongodb.sbmb.dto.UserDTO;
import com.workshopspringbootmongodb.sbmb.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/posts")
public class PostController {
    @Autowired
    private PostService service;
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}

