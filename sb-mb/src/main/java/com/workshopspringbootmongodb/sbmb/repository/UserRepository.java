package com.workshopspringbootmongodb.sbmb.repository;


import com.workshopspringbootmongodb.sbmb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
}
