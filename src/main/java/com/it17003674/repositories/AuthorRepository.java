package com.it17003674.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.it17003674.models.Author;

@Repository
public interface AuthorRepository extends MongoRepository<Author, String>{

}
