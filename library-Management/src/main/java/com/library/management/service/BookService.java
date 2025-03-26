package com.library.management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.library.management.model.Book;
import com.library.management.repository.BooksRepository;

@Service
public class BookService {

	private final BooksRepository booksRepository;

	public BookService(BooksRepository booksRepository) {
		this.booksRepository = booksRepository;
	}
	
	public Book addBook(Book book) {
		if(booksRepository.existsById(book.getId())) {
			throw new IllegalArgumentException("Book already exists");
		}
		return booksRepository.save(book);
	}
	public List<Book> getAllBook(){
		return booksRepository.findAll();
	}
	public List<Book> searchBook(String query){
		return booksRepository.searchByIdOrTitle(query);
	}
	public void deleteBook(String id) {
        booksRepository.deleteById(id);
    }
	
	public Book updateBook(String id, Book updatedBook) {
        return booksRepository.findById(id).map((Book book) -> {
            if (updatedBook.getTitle() != null) book.setTitle(updatedBook.getTitle());
            if (updatedBook.getAuthor() != null) book.setAuthor(updatedBook.getAuthor());
            if (updatedBook.getGenre() != null) book.setGenre(updatedBook.getGenre());
            if (updatedBook.getAvailablityStatus() != null) 
                book.setAvailablityStatus(updatedBook.getAvailablityStatus());
            return booksRepository.save(book);
        }).orElseThrow(() -> new IllegalArgumentException("Book not found"));
    }

	
	
	
}
