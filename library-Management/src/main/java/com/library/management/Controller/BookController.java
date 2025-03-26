package com.library.management.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.management.model.Book;
import com.library.management.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
     
	
	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@PostMapping
	public ResponseEntity<?> addBook(@RequestBody Book book){
		try {
			return new ResponseEntity<>(bookService.addBook(book),HttpStatus.CREATED);
		}catch(IllegalArgumentException e){
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Book>> getAllBooks(){
		return new ResponseEntity<>(bookService.getAllBook(),HttpStatus.OK);
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<Book>> searchBook(@RequestParam String query){
		return new ResponseEntity<>(bookService.searchBook(query),HttpStatus.OK);
	}
	 @DeleteMapping("/{id}")
	    public ResponseEntity<?> deleteBook(@PathVariable String id) {
	        bookService.deleteBook(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 }
	 @PutMapping("/{id}")
	    public ResponseEntity<?> updateBook(@PathVariable String id, @RequestBody Book book) {
	        try {
	            return new ResponseEntity<>(bookService.updateBook(id, book), HttpStatus.OK);
	        } catch (IllegalArgumentException e) {
	            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	        }
	    } 
	
}
