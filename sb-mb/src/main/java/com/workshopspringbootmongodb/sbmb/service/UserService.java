package com.workshopspringbootmongodb.sbmb.service;


import com.workshopspringbootmongodb.sbmb.domain.User;
import com.workshopspringbootmongodb.sbmb.dto.UserDTO;
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
        return obj.orElseThrow(() -> new ObjectNotFoundException("Not found Object"));
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public User update(User user) {
        User newUser = findById(user.getId());
        updateData(newUser, user);
        return userRepository.save(newUser);
    }

    private void updateData(User newObj, User user) {

        newObj.setName(user.getName());
        newObj.setEmail(user.getEmail());
    }

    public void delete(String id){
        userRepository.delete(findById(id));
    }
    public User fromDto(UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}
