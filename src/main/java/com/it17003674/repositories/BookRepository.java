package com.it17003674.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.it17003674.models.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, String>{
	
	public Book findByName(String name);
	public List<Book> findByAuthor(String author);

}
