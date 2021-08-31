package com.example.demo.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Users;

@Repository
public interface UserRepository extends MongoRepository<Users, String> {

	List<Users> findAllByName(String name);

	Users findByUserId(String userId);


}
