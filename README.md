# Spring Boot CRUD Operations

This is a simple CRUD (Create, Read, Update, Delete) application built with Spring Boot, Hibernate, and PostgreSQL database. It provides RESTful APIs for managing a collection of books.

#### Features
* Retrieve all books
* Retrieve a specific book by ID
* Add a new book
* Update an existing book
* Delete a book by ID

#### Technologies Used
* Java
* Spring Boot
* Hibernate
* DevTool spring-boot
* H2 Database*******
* PostgreSQL

###### The application will start running at http://localhost:8080.

* API Endpoints
* GET /book: Retrieve all books.
* GET /book/{bookid}: Retrieve a specific book by ID.
* POST /books: Add a new book.
* PUT /books: Update an existing book.
* DELETE /book/{bookid}: Delete a book by ID.

#### Interacting with the Database
To interact with the database, you can use tools like Postman API to execute GET, POST, PUT, and DELETE requests to the appropriate endpoints.
Note: I ensured to set the request headers, request bodies (if required), and use the correct HTTP methods while interacting with the API.
