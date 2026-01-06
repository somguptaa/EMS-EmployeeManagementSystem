# Employee & Manager Management System
### Spring Boot + MySQL + React + Material UI

A complete **Full-Stack Employee & Manager Management System** built using **Spring Boot (REST APIs)** on the backend and **React with Material UI** on the frontend.  
This application supports full **CRUD operations** for both **Employees** and **Managers** with a clean and responsive UI.

---

## Features

### Manager Management
- Add new managers
- Update manager details
- View all managers
- Fetch manager by ID
- Delete manager
- Delete all managers

### Employee Management
- Add new employees
- Update employee details
- View all employees
- Fetch employee by ID
- Delete employee
- Delete all employees

### Frontend Features
- Responsive UI built with React
- Modern design using Material UI (MUI)
- REST API integration with Spring Boot
- Form validation and user-friendly alerts
- Component-based architecture

### Additional Features
- Integrated Swagger API Documentation
- SLF4J Logging for debugging and maintenance
- Centralized Global Exception Handling
- RESTful API design

---

## Tech Stack

### Backend
| Technology | Usage |
|-----------|-------|
| Java | Backend language |
| Spring Boot | Application framework |
| Spring Web | REST APIs |
| Spring Data JPA | ORM (Hibernate) |
| MySQL | Database |
| Maven | Dependency management |

### Frontend
| Technology | Usage |
|-----------|-------|
| React | Frontend framework |
| Material UI (MUI) | UI components |
| Axios | API communication |
| JavaScript (ES6+) | Frontend logic |
| HTML5 & CSS3 | UI styling |

### Tools
- Postman / Insomnia – API testing
- Swagger UI – API documentation
- Git & GitHub – Version control

---

## Project Structure

### Backend (Spring Boot)

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

### Frontend (React)
```
ems-frontend/
├── src/
│ ├── components/
│ │ ├── employees/
│ │ ├── managers/
│ │ └── common/
│ ├── services/
│ │ └── api.js
│ ├── pages/
│ ├── App.js
│ └── index.js
│
├── public/
└── package.json
```

---

## Package Description (Backend)

- controller – REST API controllers
- dto – Response and error DTOs
- entity – JPA entities mapped to database tables
- exceptions – Custom exceptions and global handler
- repository – Spring Data JPA repositories
- service – Service layer interfaces
- serviceImpl – Business logic implementations
- utility – Constants and helper classes

---

## API Endpoints

### Employee APIs

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/employees | Create employee |
| GET | /api/employees | Get all employees |
| GET | /api/employees/{id} | Get employee by ID |
| PUT | /api/employees/{id} | Update employee |
| DELETE | /api/employees/{id} | Delete employee |
| DELETE | /api/employees | Delete all employees |

### Manager APIs

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/managers | Create manager |
| GET | /api/managers | Get all managers |
| GET | /api/managers/{id} | Get manager by ID |
| PUT | /api/managers/{id} | Update manager |
| DELETE | /api/managers/{id} | Delete manager |
| DELETE | /api/managers | Delete all managers |

---

## Future Enhancements
- Pagination and sorting
- Role-based authentication (JWT)
- Search and filter functionality
- Dashboard analytics
- Docker support
- Cloud deployment

---

## Author

Som Gupta  

GitHub: https://github.com/somguptaa  
LinkedIn: https://www.linkedin.com/in/som-gupta-2k3/  
Portfolio: https://som9889.github.io/  
Email: somgupta0011@gmail.com

---

## License

This project is licensed under the MIT License.

https://github.com/somguptaa/EMS-EmployeeManagementSystem/blob/main/LICENSE
