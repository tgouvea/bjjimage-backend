package com.bjjimage.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bjjimage.model.User;

public interface UserRepository extends MongoRepository<User, String>{

	User findByEmail(String email);

}
