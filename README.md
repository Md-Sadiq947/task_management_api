 # Task Management REST API 🚀

A robust Backend API developed using **Java** and **Spring Boot**, designed to help users organize and track their daily tasks. This project demonstrates the implementation of relational database management with **PostgreSQL** and clean RESTful principles.

## 🛠 Tech Stack
- **Language:** Java 17+
- **Framework:** Spring Boot 3.x
- **Database:** PostgreSQL
- **Persistence:** Spring Data JPA (Hibernate)
- **API Testing:** Postman

## ✨ Core Features
- **User Management:** Full CRUD operations for User profiles.
- **Task Organization:** Assign specific tasks to users using **One-to-Many** bidirectional relationships.
- **Data Integrity:** Handled using `@Transactional` to ensure safe database updates.
- **Efficient Retrieval:** Custom JPA Query derivation (e.g., `findByUserName`).
- **Clean JSON Responses:** Optimized data serialization using `@JsonManagedReference` and `@JsonBackReference` to prevent infinite recursion.

## 📂 Project Structure
- `controller/`: Handles HTTP requests and maps them to service methods.
- `service/`: Contains the core business logic and transaction management.
- `entity/`: Defines the database schema using JPA annotations.
- `repository/`: Interface for direct database interaction.

## 🚀 Getting Started

### Prerequisites
- JDK 17 or higher
- Maven 3.x
- PostgreSQL installed and running

### Installation & Setup
1. **Clone the repository:**
   ```bash
   git clone [https://github.com/Md-Sadiq947/task_management_api.git](https://github.com/Md-Sadiq947/task_management_api.git)

2. **Database Configuration**

   Create a database named "test" in your PostgreSQL instance (or update the name in your local application.properties).
   
   Navigate to src/main/resources/application.properties .
   
   Update the following lines with your credentials:-
   
      spring.datasource.url=jdbc:postgresql://localhost:5432/test
      spring.datasource.username=your_username
      spring.datasource.password=your_password

4. **Run the Application**

    mvn spring-boot:run


### API ENDPOINTS

**Method --> Endpoint --> Description**

GET -> /task/{userName} -> Fetch all tasks for a specific user

POST -> /task/{userName} -> Create a new task and link it to a user

GET -> /task/id/{id} -> Find a specific task by its ID

PUT -> /task/id/{id} -> Update title or description of a task

DELETE -> /task/id/{id} -> Delete a task from the database

**Screenshots of postman**
<img width="1882" height="755" alt="image" src="https://github.com/user-attachments/assets/c2a2f4d1-34c4-4631-9bf7-073c849113ad" />

<img width="1902" height="855" alt="image" src="https://github.com/user-attachments/assets/afc9a924-ada7-420a-957e-4c1c32277a72" />

<img width="1843" height="899" alt="image" src="https://github.com/user-attachments/assets/76cee55a-aedd-401f-a97e-3e856861d187" />

<img width="1906" height="964" alt="image" src="https://github.com/user-attachments/assets/c671c556-c8a4-4494-af14-bdc07119162f" />



