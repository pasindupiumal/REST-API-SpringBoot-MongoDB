package com.it17003674.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.it17003674.BookID;
import com.it17003674.models.Book;
import com.it17003674.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	private Map<String, Object> response = new HashMap<String, Object>();
	
	//Method to add a new book
	public ResponseEntity<Map<String, Object>> addBook(String name, String isbn, String author, double price, int yearOfPublication, String publisher){
		
		Book newBook = bookRepository.save(new Book(name, isbn, author, price, yearOfPublication, publisher));
		
		//create a response
		response.clear();
		response.put("message",  "New Book Successfully Added");
		response.put("data",  newBook);
		
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	//Method to get the total amount for a set of given book ids
	public ResponseEntity<Map<String, Object>> getTotalAmount(BookID bookID){
		
		double totalAmount = 0;
		
		for(String id: bookID.getBookIDList()) {
			
			//Get the book details for the id
			Optional<Book> findBook = bookRepository.findById(id);
			
			Book currentBook = findBook.get();
			
			totalAmount += currentBook.getPrice();
			
		}
		
		response.clear();
		response.put("message",  "Total Price For The Books");
		response.put("data",  totalAmount);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	//Method to get all available books
	public ResponseEntity<Map<String, Object>> getAllBooks(){
		
		List<Book> allBooks = bookRepository.findAll();
		
		response.clear();
		
		if(allBooks.size() == 0) {
			
			response.put("message",  "No Books Found");
		}
		else {
			response.put("message",  "All Books");
			response.put("data",  allBooks);
		}
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	//Method to get written by a specific author
	public ResponseEntity <Map<String, Object>> getBookByAuthor(String author){
		
		List<Book> booksByAuthor = bookRepository.findByAuthor(author);
		
		response.clear();
		
		if(booksByAuthor.size() == 0) {
			response.put("message",  "No Books Found Under The Given Author");
		}
		else {
			response.put("message",  "All Books Written By " + author);
			response.put("data",  booksByAuthor);
		}
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	//Method to delete all books
	public ResponseEntity<Map<String, Object>> deleteAllBooks(){
		
		
		List<Book> deletedBooks = bookRepository.findAll();
		
		int count = deletedBooks.size();
		
		bookRepository.deleteAll();
		
		response.clear();
		
		response.put("message",  "Deleted All Books. Book Count - " + count);
		response.put("data",  deletedBooks);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
	
	//Method to delete a single book by name
	public ResponseEntity<Map<String, Object>> deleteBook(String bookName){
		
		Book bookToDelete = bookRepository.findByName(bookName);
		
		bookRepository.delete(bookToDelete);
		
		response.clear();
		response.put("data",  bookToDelete);
		response.put("message", "Book " + bookToDelete.getName() + " Deleted");
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	//Method to update details of a book
	public ResponseEntity<Map<String, Object>> updateBook(String name, String isbn, String author, double price, int yearOfPublication, String publisher){
		
		Book book = bookRepository.findByName(name);
		
		book.setIsbn(isbn);
		book.setAuthor(author);
		book.setPrice(price);
		book.setYearOfPublication(yearOfPublication);
		book.setPublisher(publisher);
		
		bookRepository.save(book);
		
		response.clear();
		response.put("message",  "Book " + book.getAuthor() + " Updated");
		response.put("data",  book);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
