# Creating and Consuming a Simple Web API

## Overview
This lab focuses on building and consuming a simple web API using Spring Boot. The task was divided into two main parts:
1. Creating a REST API that provides greeting messages
2. Developing a client application to consume the API

---

## Part 1: Creating the API (GreetingAPI)

### Implementation
- Created a Spring Boot project using Spring Initializr with the Spring Web dependency
- Developed a `Greeting` model using a Java record class to represent response data (id and message)
- Implemented a `GreetingController` using `@RestController`
- Created REST endpoints:
  - `/greeting` → returns a default greeting
  - `/greeting/name?name=...` → returns a personalized greeting
- Tested endpoints using a browser or Postman

### Key Features
- Stateless API design
- JSON response format
- Unique ID generation for each greeting

---

## Part 2: Consuming the API (Getgreetings)

### Implementation
- Created a second Spring Boot project to act as a client
- Configured it to run on a different port (8081)
- Created a `Greeting` record class to map API responses
- Implemented the following methods:
  - `getHttpClient()` → returns a RestTemplate instance
  - `getGreeting()` → calls `/greeting`
  - `getGreetingByName()` → calls `/greeting/name`
  - `makeCalls()` → executes API calls and prints responses
- Used RestTemplate to consume REST endpoints

---

## Part 3: Enhancements
- Added a new endpoint to include the current date in the greeting
- Updated the client application to handle the new response structure
- Ensured all endpoints continue to function correctly

---

## Technologies Used
- Java
- Spring Boot
- REST APIs
- Maven
- VS Code

---

## Theoretical Concepts Learned

### API (Application Programming Interface)
APIs enable communication between different software systems using defined protocols such as HTTP.

### REST Architecture
- Stateless client-server communication
- Uses HTTP methods such as GET and POST
- Resources are identified using URLs
- Data is exchanged in JSON format

### Spring Boot Framework
- Simplifies Java application development
- Provides built-in server and dependency management
- Supports rapid development of REST APIs

### Controller Layer
- Handles incoming HTTP requests
- Maps endpoints using annotations such as `@RestController` and `@GetMapping`

### Record Classes (Java)
- Used as immutable data carriers
- Reduce boilerplate code such as getters and constructors

### REST Client (RestTemplate)
- Used to consume APIs from another application
- Sends HTTP requests and receives responses
- Converts JSON responses into Java objects

### Client-Server Architecture
- API acts as the server
- Consumer application acts as the client
- Communication happens over HTTP

---

## Learning Outcomes Achieved
- Applied framework-based development using Spring Boot
- Implemented RESTful web services
- Understood client-server communication
- Practiced consuming APIs programmatically
- Gained experience with industry tools and practices

---

## How to Run

### API (GreetingAPI)
- Run the Spring Boot application
- Access:
  - http://localhost:8080/greeting
  - http://localhost:8080/greeting/name?name=YourName

### Client (Getgreetings)
- Run the application
- Outputs API responses in the console

## Testing with Postman
The API can also be tested using Postman by sending HTTP GET requests to the endpoints:

- http://localhost:8080/greeting  
- http://localhost:8080/greeting/name?name=YourName  

Postman allows sending requests and viewing JSON responses in a more structured and user-friendly way compared to a browser.