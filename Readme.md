# 🧑‍💼 Employee Management System

A Spring Boot web application that allows you to manage employee records with Create, Read, Update, and Delete (CRUD) operations. Built using Spring Boot, Spring Data JPA, Thymeleaf (or JavaScript), and MySQL.

---

## 🚀 Technologies Used

- Java 21
- Spring Boot 3.2.5
- Spring Data JPA
- Thymeleaf or JavaScript
- MySQL
- Swagger (Springdoc OpenAPI)
- Maven Daemon (mvnd)

---

## ⚙️ How to Run

## 🛠️ Step-by-Step Setup

1. **Clone the project**
   ```bash
   git clone <your-repo-url>
   cd employee-management-app

---

2. **🗄️ MySQL Configuration**

   - Open MySQL and create a new database:
     ```sql
     CREATE DATABASE employee_db;
   - In src/main/resources/application.properties, set your DB credentials:
     ```sql
     spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
     spring.datasource.username=root
     spring.datasource.password=your_password
     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.show-sql=true
     spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

---

3. **Run the Application**
    
   - Use Maven Daemon (or regular Maven) to run the Spring Boot application:
        ```bash
        ./mvnw spring-boot:run
   
   - Or with regular Maven:
        ```bash
        ./mvnw spring-boot:run
---

## 🗂️ Project Structure
```bash
    employee-management-app/
    ├── src/
    │   ├── main/
    │   │   ├── java/
    │   │   │   └── com/employee/management/
    │   │   │       ├── controller/     # REST & Web Controllers
    │   │   │       ├── model/          # Employee entity
    │   │   │       ├── repository/     # Spring Data JPA Repositories
    │   │   │       └── service/        # Service layer
    │   │   └── resources/
    │   │       ├── static/             # Static assets (CSS/JS)
    │   │       ├── templates/          # Thymeleaf HTML templates
    │   │       └── application.properties
    │   └── test/                       # Unit & integration tests
    ├── pom.xml                         # Project dependencies
    └── README.md                       # Documentation
