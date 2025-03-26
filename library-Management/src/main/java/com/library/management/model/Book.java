package com.library.management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Book {
   
	@Id
	private String id;
	
	@NotBlank(message="Title is mandatory")
	private String title;
	@NotBlank(message="Author is mandatory")
	private String author;
	
	private String genre;
	
	 @Enumerated(EnumType.STRING)  
	 @Column(nullable = false)
	private AvailablityStatus availablityStatus;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public AvailablityStatus getAvailablityStatus() {
		return availablityStatus;
	}

	public void setAvailablityStatus(AvailablityStatus availablityStatus) {
		this.availablityStatus = availablityStatus;
	}

	public Book(String id, @NotBlank(message = "Title is mandatory") String title,
			@NotBlank(message = "Author is mandatory") String author, String genre,
			AvailablityStatus availablityStatus) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.availablityStatus = availablityStatus;
	}

	
	public Book() {
        this.availablityStatus = AvailablityStatus.AVAILABLE; // Default value
    }
	
	
	
}
