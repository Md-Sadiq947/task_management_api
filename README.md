# Spring Boot CRUD REST API

A simple REST API built with **Spring Boot 3.x**, **Spring Data JPA**, and **PostgreSQL** for full CRUD operations on the `person` table.

## Features
- GET `/person/fetch` — Fetch all persons
- POST `/person/insert` — Create a new person
- PUT `/person/fetchId/{id}` — Update person by ID
- DELETE `/person/delete/{id}` — Delete person by ID

## Technologies Used
- Java 21
- Spring Boot 3.x
- Spring Data JPA + Hibernate
- PostgreSQL
- Maven
- Lombok

## How to Run Locally
1. Clone the repo:
   ```bash
   git clone https://github.com/Md-Sadiq947/task-api.git

2. Setup PostgreSQL:Create database: test
   Ensure person table exists (with columns like person_id, first_name, etc.)

3. Update database credentials in src/main/resources/application.properties

4. Run the app:
   mvn spring-boot:run

5. Test endpoints
   . Base URL http://localhost:8080


## Endpoints (Postman Collection)
GET http://localhost:8080/person/fetch
POST http://localhost:8080/person/insert

<img width="1600" height="1000" alt="image" src="https://github.com/user-attachments/assets/ee25dd9a-7d45-4926-b230-4a9a27d94f09" />
<img width="1600" height="1000" alt="image" src="https://github.com/user-attachments/assets/7dfc3881-28a6-47ec-a640-97911a53cc4f" />



Status
   . Currently working on: Validation, Exception Handling, Deployment (Railway/Render)
   . Learning Spring Boot to build production-ready backend APIs





