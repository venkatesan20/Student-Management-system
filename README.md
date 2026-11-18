# Student Management System – Microservices Architecture

## Project Overview

The Student Management System is a Spring Boot-based microservices application designed to manage student and department information. It uses independent microservices for better modularity, service discovery, inter-service communication, and centralized API routing.

## Technologies Used

- Java
- Spring Boot
- Spring Cloud
- Spring Data JPA
- PostgreSQL
- Spring Cloud Gateway
- Netflix Eureka Server
- OpenFeign
- Spring Cloud LoadBalancer
- Maven
- REST APIs
- Postman

## Microservices Architecture

The application consists of the following services:

### 1. Student Service
- Manages student information.
- Provides CRUD operations.
- Communicates with Department Service using OpenFeign.
- Uses PostgreSQL for data persistence.

### 2. Department Service
- Manages department information.
- Provides CRUD operations.
- Uses Spring Data JPA and PostgreSQL.

### 3. Eureka Server
- Registers and discovers microservices.
- Maintains service instance information.

### 4. API Gateway
- Acts as a single entry point for client requests.
- Routes requests to the appropriate microservices.
- Integrates with service discovery and load balancing.

## Architecture Flow

```text
             Client / Postman
                    |
                    v
               API Gateway
                    |
          ---------------------
          |                   |
          v                   v
     Student Service    Department Service
          |                   |
          |---- OpenFeign ----|
                    |
                    v
              Eureka Server
```

## Project Structure

```text
Student-Management-System/
│
├── Student-Service/
├── Department-Service/
├── API-Gateway/
├── Student-Management-system-microservice-main/
└── README.md
```

## Key Features

- Student CRUD Operations
- Department CRUD Operations
- Microservices Architecture
- Service Registration and Discovery
- Centralized API Gateway
- Inter-Service Communication using OpenFeign
- Client-Side Load Balancing
- PostgreSQL Database Integration

## How to Run the Project

1. Clone the repository.
2. Open each Spring Boot microservice in IntelliJ IDEA.
3. Configure PostgreSQL database credentials in the respective application properties.
4. Start the Eureka Server.
5. Start the Department Service.
6. Start the Student Service.
7. Start the API Gateway.
8. Test the REST APIs using Postman.

## GitHub Repository

[Student Management System – GitHub](https://github.com/venkatesan20/Student-Management-system)

## Author

**Venkatesan R.**

Java Full Stack Developer | Spring Boot | Microservices
