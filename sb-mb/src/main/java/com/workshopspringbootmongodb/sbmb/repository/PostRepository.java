package com.workshopspringbootmongodb.sbmb.repository;

import com.workshopspringbootmongodb.sbmb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
