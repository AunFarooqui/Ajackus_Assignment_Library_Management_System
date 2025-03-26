# Ajackus_Assignment_Library_Management_System

A Spring Boot application for managing library books with MySQL integration.

## Features
- Add new books with unique IDs
- Update book details
- Search books by ID or title
- View all books
- Delete books
- Track availability status (Available/Checked Out)

## Prerequisites
- Java 17 or higher
- MySQL 8.x
- Maven 3.6.x or higher

## initial db config
spring.datasource.url=jdbc:mysql://localhost:3306/library_db
spring.datasource.username=library_user
spring.datasource.password=library_pass

##Initially I created a database with following entites

    @Id
    private String id;  // To create a unique Id

    @NotBlank(message = "Title is mandatory") // so that it is not an empty string
    private String title;

    @NotBlank(message = "Author is mandatory")  // so that it is not an empty string
    private String author;

    private String genre;

    @Enumerated(EnumType.STRING)  //I have used enum to maintain only two states available and checked out
    private AvailabilityStatus availabilityStatus;
##Book management Endpoints
Method	Endpoint	Description
POST	/api/books	Add a new book
GET	/api/books	Get all books
GET	/api/books/search?query	Search books by ID or title
PUT	/api/books/{id}	Update a book
DELETE	/api/books/{id}	Delete a book
Exit   /exit to shut down the program

The major challenges I faced while creating the applications was assigning enum value as it was automatically being assingned to null and to create a thread to shutdown the program or exit the program 

    
