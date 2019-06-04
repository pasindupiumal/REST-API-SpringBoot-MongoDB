package com.it17003674.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.it17003674.models.Author;
import com.it17003674.repositories.AuthorRepository;
@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository authorRepository;
	private Map<String, Object> response = new HashMap<String, Object>();
	
	//Method to add a new author
	public ResponseEntity<Map<String, Object>> addAuthor(String firstName, String lastName, String nationality){
		
		Author newAuthor = authorRepository.save(new Author(firstName, lastName, nationality));
		
		response.clear();
		response.put("message",  "New Author Added Successfully");
		response.put("data", newAuthor);
		
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	//Method to get all authors 
	public ResponseEntity<Map<String, Object>> getAllAuthors(){
		
		List<Author> allAuthors = authorRepository.findAll();
		
		response.clear();
		
		if(allAuthors.size() == 0) {
			
			response.put("message", "Not Authors Found");
		}
		else {
			response.put("message",  "All Authors. Count - " + allAuthors.size());
			response.put("data",  allAuthors);
		}
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
