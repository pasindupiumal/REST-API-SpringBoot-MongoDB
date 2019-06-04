package com.it17003674.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.it17003674.models.Book;
import com.it17003674.services.BookService;

@RestController
@RequestMapping("/Books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(method=RequestMethod.GET, value="/")
	public ResponseEntity<Map<String, Object>> getAllBooks(){
		
		return bookService.getAllBooks();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/")
	public ResponseEntity<Map<String, Object>> addNewBook(@RequestBody Book newBook){
		
		return bookService.addBook(newBook.getName(), newBook.getIsbn(), newBook.getAuthor(), newBook.getPrice(), newBook.getYearOfPublication(), newBook.getPublisher());
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{author}")
	public ResponseEntity<Map<String, Object>> getBookByAuthor(@PathVariable("author") String author){
		
		return bookService.getBookByAuthor(author);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/")
	public ResponseEntity<Map<String, Object>> deleteAllBooks(){
		
		return bookService.deleteAllBooks();
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{bookName}")
	public ResponseEntity<Map<String, Object>> deleteBook(@PathVariable("bookName") String bookName){
		
		return bookService.deleteBook(bookName);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/")
	public ResponseEntity<Map<String, Object>> updateBook(@RequestBody Book book){
		
		return bookService.updateBook(book.getName(), book.getIsbn(), book.getAuthor(),  book.getPrice(),  book.getYearOfPublication(), book.getPublisher());
	}
	


}
