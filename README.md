# Employee & Manager Management System  
### Spring Boot + MySQL + REST API

A complete **Employee & Manager Management System** built using **Spring Boot**, **Spring Data JPA**, and **MySQL**.  
This project supports full CRUD operations for both **Employees** and **Managers**.

---

## Features

### Manager Features
- Add new managers  
- Update manager details  
- View all managers  
- Fetch manager by ID  
- Delete managers  

### Employee Features
- Add new employees  
- Update employee info  
- View all employees  
- Fetch employee by ID  
- Delete employees  

---
### Additional Feature
- Integrated **Swagger API Documentation** for exploring and testing APIs easily.
---

## Tech Stack
| Category | Technology |
|----------|------------|
| Backend | Java, Spring Boot, Spring Web |
| ORM | Spring Data JPA (Hibernate) |
| Database | MySQL |
| Build Tool | Maven |
| API Testing | Postman, Insomnia |

---

## Project Structure
```
employee-management-system/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── som/
│       │           └── ems/
│       │               ├── EmsApplication.java
│       │               │
│       │               ├── controller/
│       │               │   ├── EmployeeController.java
│       │               │   └── ManagerController.java
│       │               │
│       │               ├── dto/
│       │               │   ├── ErrorResponseDto.java
│       │               │   └── ResponseMessageDto.java
│       │               │
│       │               ├── entity/
│       │               │   ├── Employee.java
│       │               │   └── Manager.java
│       │               │
│       │               ├── exceptions/
│       │               │   ├── ResourceNotFoundException.java
│       │               │   └── GlobalExceptionHandler.java
│       │               │
│       │               ├── repository/
│       │               │   ├── EmployeeRepository.java
│       │               │   └── ManagerRepository.java
│       │               │
│       │               ├── service/
│       │               │   ├── EmployeeService.java
│       │               │   └── ManagerService.java
│       │               │
│       │               ├── serviceImpl/
│       │               │   ├── EmployeeServiceImpl.java
│       │               │   └── ManagerServiceImpl.java
│       │               │
│       │               └── utility/
│       │                   └── Constants.java
│       │
│       └── resources/
│           └── application.properties
│
├── pom.xml
├── .gitignore
└── README.md
```

---

## Package Description

- #### `com.som.ems`
Main application package containing `EmsApplication.java`.

- #### `com.som.ems.controller`
Contains all REST API controllers.

- #### `com.som.ems.dto`
Contains DTO classes used for response models.

- #### `com.som.ems.entity`
Contains JPA entity classes mapped to database tables.

- #### `com.som.ems.exceptions`
Contains custom exceptions and the global exception handler.

- #### `com.som.ems.repository`
Contains Spring Data JPA repository interfaces.

- #### `com.som.ems.service`
Contains service layer interfaces.

- #### `com.som.ems.serviceImpl`
Contains implementation of service interfaces.

- #### `com.som.ems.utility`
Contains common reusable utility/helper classes.


---
## API Endpoints

### Employee APIs

| Method | Endpoint                               | Description                               |
|--------|------------------------------------------|-------------------------------------------|
| POST   | `/api/employees`                         | Create new employee                        |
| GET    | `/api/employees`                         | Get all employees                          |
| GET    | `/api/employees/{id}`                    | Get employee by ID                         |
| PUT    | `/api/employees/{id}`                    | Update employee details                    |
| DELETE | `/api/employees/{id}`                    | Delete employee                            |


---

### Manager APIs

| Method | Endpoint                               | Description                                   |
|--------|------------------------------------------|-----------------------------------------------|
| POST   | `/api/managers`                          | Create new manager                             |
| GET    | `/api/managers`                          | Get all managers                               |
| GET    | `/api/managers/{id}`                     | Get manager by ID                              |
| PUT    | `/api/managers/{id}`                     | Update manager details                         |
| DELETE | `/api/managers/{id}`                     | Delete manager                                 |


---

## Future Enhancements

- Loggers(SLF4J) for easy debugging & maintenance
- Pagination & Sorting for Employee and Manager Lists
- Frontend UI for better user interaction 

--- 

## Author

**Som Gupta**

- GitHub: https://github.com/somguptaa  
- LinkedIn: https://www.linkedin.com/in/som-gupta-2k3/  
- Portfolio: https://som9889.github.io/
- Email: somgupta0011@gmail.com 



## Licence
- Released Under <a href="https://github.com/somguptaa/EMS-EmployeeManagementSystem/blob/main/LICENSE"> MIT Licence </a>
