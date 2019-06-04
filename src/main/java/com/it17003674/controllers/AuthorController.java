package com.it17003674.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.it17003674.models.Author;
import com.it17003674.services.AuthorService;
import com.it17003674.services.BookService;

@RestController
@RequestMapping("/Authors")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	@Autowired
	private BookService bookService;
	
	//Rest controller to get all authors
	@RequestMapping(method=RequestMethod.GET, value="/")
	public ResponseEntity<Map<String, Object>> getAllAuthors(){
		
		return authorService.getAllAuthors();
	}
	
	//Rest controller to add a new author
	@RequestMapping(method=RequestMethod.POST, value="/")
	public ResponseEntity<Map<String, Object>> addNewAuthor(@RequestBody Author author){
		
		return authorService.addAuthor(author.getFirstName(),author.getLastName(), author.getNationality());
	}
	
	//Rest controller to get a list of books under a given author
	@RequestMapping(method=RequestMethod.GET, value="/{authorName}/Books")
	public ResponseEntity<Map<String, Object>> getBooksByAuthor(@PathVariable("authorName") String authorName){
		
		return bookService.getBookByAuthor(authorName);
	}

}
