package com.workshopspringbootmongodb.sbmb.controller;

import com.workshopspringbootmongodb.sbmb.domain.Post;
import com.workshopspringbootmongodb.sbmb.domain.User;
import com.workshopspringbootmongodb.sbmb.dto.UserDTO;
import com.workshopspringbootmongodb.sbmb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = userService.findAll();
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User obj = userService.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }

    @PostMapping
    public ResponseEntity<UserDTO> save(@RequestBody UserDTO user) {
        User obj = userService.fromDto(user);
        obj= userService.save(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
    @PutMapping(value="/{id}")
    public ResponseEntity<UserDTO> put(@RequestBody UserDTO user,@PathVariable String id) {
        User obj = userService.fromDto(user);
        obj.setId(id);
        obj= userService.update(obj);

        return ResponseEntity.noContent().build();
    }
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> deleteByUSer(@PathVariable String id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @RequestMapping(value="/{id}/posts", method=RequestMethod.GET)
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
        User obj = userService.findById(id);
        return ResponseEntity.ok().body(obj.getPosts());
    }

}

