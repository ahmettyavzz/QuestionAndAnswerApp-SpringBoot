# Question and Answer Application

### Table of Contents
#### Introduction
#### Technologies Used
#### Database Design
#### REST API Endpoints
#### Exception Handling
#### Spring Security(JWT)


### 1. Introduction
  > This application allows users to ask questions and answer questions asked by others.
   The application has two roles, ADMIN and USER. Only ADMINs are allowed to add questions to the system,
   but both ADMINs and USERS can answer questions.The requests use DTOs and responses use response objects.

### 2. Technologies Used
* JAVA 17
* Spring Boot
* JPA Repository
* REST API
* PostgreSQL

### 3. Database Design
   There are three tables in this application:

- Users
- Questions
- Options

The Questions and Options tables are related through a many-to-one relationship.


### 4. REST API Endpoints
In the application, the following REST API endpoints are available:

- POST  /user : Adds a new user.
- GET  /api/auth/login : For login.
- GET  /v1/question/{id} : Returns the question with the specified id.
- POST /v1/question : Adds a new question.
- GET  /v1/question/answer/{id}/?no={no} : Adds an answer to the specified question.

### 5. Exception Handling
   The application implements exception handling to provide a user-friendly, generic error message in case of any error.

### 6. Spring Security
   This application uses Spring Security for authentication and authorization. The authentication mechanism allows users to log in to the application,
   while the authorization mechanism ensures that only users with the correct permissions can access the resources they request. The authorization mechanism uses JSON Web Tokens (JWT) for authentication.