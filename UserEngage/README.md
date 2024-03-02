# UserEngage

## Overview

UserEngage is a Spring Boot-based demo project designed to illustrate a user engagement platform. This application facilitates user management, coupon distribution, and product reviews, integrating various technologies for robust and scalable development. It demonstrates the practical use of Spring Boot in building RESTful APIs, with a focus on real-world functionalities such as CRUD operations, data mapping, and API documentation.

### Key Features

- **User Management**: Supports operations such as creating, updating, viewing, and deleting user information.
- **Coupon System**: Enables the management of coupons for users, including assigning coupons, listing all coupons for a user, and deleting coupons.
- **User Reviews**: Allows users to submit reviews for products, providing endpoints for adding, updating, and listing reviews based on user or product ID.
- **Swagger API Documentation**: Offers comprehensive API documentation and testing capabilities through Swagger UI.

### Technologies Used

- **Spring Boot**: Framework for building stand-alone, production-grade Spring-based Applications.
- **Spring Data JPA**: Simplifies data access within databases, improving persistence and retrieval of data.
- **H2 Database**: In-memory database for rapid prototyping and development phases.
- **Lombok**: Reduces boilerplate code for model/data objects.
- **MapStruct**: Facilitates object mapping, simplifying the conversion between different object models.
- **Springfox Swagger**: Integrates Swagger 2 for documenting RESTful APIs.

## Getting Started

### Prerequisites

- JDK 21 or above
- Maven 3.6 or above
- Spring Boot 3.2.2 or above

### Installation and Setup


   ```sh
   git clone https://github.com/your-repository/UserEngage.git
   cd UserEngage
   mvn clean install
   mvn spring-boot:run
    
   ```

##  Architecture
This project adopts a clean, layered architecture for separation of concerns and easier maintenance:

- Controller Layer: Defines the REST endpoints and handles HTTP requests and responses.
- Service Layer: Contains business logic and service interfaces for handling business operations.
- Repository Layer: Interfaces with the database, performing CRUD operations.
- Model/Entity Layer: Represents the data model, mapping to the underlying database structure.

## Usage
###  Users
 - Create User: POST /api/v1/users
 - Get All Users: GET /api/v1/users
 - Get User by ID: GET /api/v1/users/{id}
 - Update User: PUT /api/v1/users/{id}
 - Delete User: DELETE /api/v1/users/{id}
### Coupons
 - Assign Coupon to User: POST /api/v1/userCoupons
 - List Coupons for User: GET /api/v1/userCoupons/{userId}
 - Delete Coupon: DELETE /api/v1/userCoupons/{id}/coupon
###  Reviews
 - Submit Review: POST /api/v1/reviews
 - List Reviews by User ID: GET /api/v1/reviews/userId/{userId}
 - List Reviews by Product ID: GET /api/v1/reviews/productId/{productId}
 - Get Review by ID: GET /api/v1/reviews/{id}
 - Update Review by ID: PATCH /api/v1/reviews/{id}
### Categories
- Create Category: POST /api/v1/categories
- List All Categories: GET /api/v1/categories
- Get Category by ID: GET /api/v1/categories/{id}
- Update Category: PUT /api/v1/categories/{id}
- Delete Category: DELETE /api/v1/categories/{id}
### Products
- Create Product: POST /api/v1/products
- List All Products: GET /api/v1/products
- Get Product by ID: GET /api/v1/products/{id}
- Update Product: PUT /api/v1/products/{id}
- Delete Product: DELETE /api/v1/products/{id}
 
After you run the project, you can access more detailed documentation about APIs from this site with the Swagger UI implementation.
 http://localhost:8080/swagger-ui.html