package com.moises.spring_start_mongoDB.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.moises.spring_start_mongoDB.domain.AuthorDTO;

@Repository
public interface UserRepository extends MongoRepository<AuthorDTO, String> {

}