# 📝 Task Management API (Spring Boot & PostgreSQL)

A robust, production-ready RESTful API built with **Spring Boot 3.x** and **PostgreSQL**. This project demonstrates a secure backend architecture with a focus on task delegation and user management.

---

## 🚀 Live Demo
The application is deployed on **Render** and integrated with **Neon Database**.
👉 **[Explore Swagger UI](https://task-management-api-31u0.onrender.com/swagger-ui/index.html)**

> **Note:** Access is secured via Basic Authentication. Use the authorized credentials to test the endpoints.

---

## ✨ Key Features
- **🔒 Secure Authentication:** Implemented Spring Security 6.x with Basic Auth to protect sensitive task data.
- **🛠️ Interactive API Docs:** Full Swagger UI/OpenAPI 3.0 integration for seamless testing and documentation.
- **🐘 Cloud Database:** Integrated with **Neon PostgreSQL** for scalable data storage.
- **🛡️ Security Hardened:** Passwords are never exposed in responses, and specific fields are protected via DTO patterns/Schema annotations.
- **✅ CRUD Operations:** Full lifecycle management for both Users and Tasks.

---

## 🏗️ Tech Stack
- **Backend:** Java 17+, Spring Boot 3.x, Spring Security, Hibernate/JPA
- **Database:** PostgreSQL (Neon)
- **Documentation:** OpenAPI 3.0 (Swagger UI)
- **Deployment:** Render

---

## 📂 Project Structure & Clean Code
This project follows the standard **Controller-Service-Repository** pattern to ensure separation of concerns and maintainability.

- `controller`: Handles HTTP requests and API documentation logic.
- `service`: Contains business logic and transactional management.
- `repository`: Manages database interactions via Spring Data JPA.
- `entity`: Defines the data structure and relationships (One-to-Many).

---

## ⚙️ Local Setup
1. **Clone the repo:**
   ```bash
   git clone [https://github.com/Md-Sadiq947/task-management-api.git]
   
2. **Configure Databases**
   Update src/main/resources/application.properties with your PostgreSQL credentials.

3. **Run the App**
   ```bash
   ./mvnw spring-boot:run
