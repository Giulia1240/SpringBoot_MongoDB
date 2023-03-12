package com.workshopspringbootmongodb.sbmb.repository;

import com.workshopspringbootmongodb.sbmb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
