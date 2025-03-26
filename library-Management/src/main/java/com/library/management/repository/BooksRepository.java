package com.library.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.library.management.model.Book;

public interface BooksRepository extends JpaRepository<Book,String> {
   
	@Query("SELECT b FROM Book b WHERE b.id = :query OR b.title LIKE %:query%")
	List<Book> searchByIdOrTitle(@Param("query")String query);
}
