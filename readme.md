# Question and Answer Application

### Table of Contents
#### <a href="#Introduction">1.Introduction</a>
#### <a href="#Technologies Used">2.Technologies Used</a>
#### <a href="#Database Design">3.Database Design</a>
#### <a href="#REST API Endpoints">4.REST API Endpoints</a>
#### <a href="#Exception Handling">5.Exception Handling</a>
#### <a href="#Spring Security(JWT)">6.Spring Security(JWT)</a>

<a id="Introduction"></a>
### 1. Introduction
  > This application allows users to ask questions and answer questions asked by others.
   The application has two roles, ADMIN and USER. Only ADMINs are allowed to add questions to the system,
   but both ADMINs and USERS can answer questions.The requests use DTOs and responses use response objects.

<a id="Technologies Used"></a>
### 2. Technologies Used
* JAVA 17
* Spring Boot
* JPA Repository
* REST API
* PostgreSQL

<a id="Database Design"></a>
### 3. Database Design
   There are three tables in this application:

- Users
- Questions
- Options

The Questions and Options tables are related through a many-to-one relationship.

<a id="REST API Endpoints"></a>
### 4. REST API Endpoints
In the application, the following REST API endpoints are available:

- POST  /user : Adds a new user.
- GET  /api/auth/login : For login.
- GET  /v1/question/{id} : Returns the question with the specified id.
- POST /v1/question : Adds a new question.
- GET  /v1/question/answer/{id}/?no={no} : Adds an answer to the specified question.

<a id="Exception Handling"></a>
### 5. Exception Handling
   The application implements exception handling to provide a user-friendly, generic error message in case of any error.

<a id="Spring Security(JWT)"></a>
### 6. Spring Security(JWT)
   This application uses Spring Security for authentication and authorization. The authentication mechanism allows users to log in to the application,
   while the authorization mechanism ensures that only users with the correct permissions can access the resources they request. The authorization mechanism uses JSON Web Tokens (JWT) for authentication.
   

>In the application.properties file, you can specify the settings for JSON Web Token (JWT) and the database. 