package com.workshopspringbootmongodb.sbmb.service;


import com.workshopspringbootmongodb.sbmb.domain.Post;
import com.workshopspringbootmongodb.sbmb.domain.Post;
import com.workshopspringbootmongodb.sbmb.repository.PostRepository;
import com.workshopspringbootmongodb.sbmb.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Not found Object"));
    }

}
