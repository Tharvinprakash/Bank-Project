# Bank-Project

# Bank Project 🏦

A simple bank account management system using Spring Boot, MySQL, and REST APIs.

## Features
✅ Create, update, delete bank accounts  
✅ Deposit & Withdraw money  
✅ Fetch all accounts  

## Technologies Used
- Java 21
- Spring Boot
- MySQL
- Spring Data JPA
- Maven

## Setup & Installation
1. Clone the repo:

  git clone https://github.com/Tharvinprakash/Bank-Project.git
  cd Bank-Project

2. Configure MySQL Database in src/main/resources/application.properties:

  spring.datasource.url=jdbc:mysql://localhost:3306/bank_db
  spring.datasource.username=root
  spring.datasource.password=your_password
  spring.jpa.hibernate.ddl-auto=update

3. Run the application: 

  mvn spring-boot:run

4. Access APIs via Postman or browser:

  http://localhost:8080/api/accounts

## API Endpoints

## 🔗 API Endpoints  
| **Method** | **Endpoint**                     | **Description**                |
|-----------|---------------------------------|----------------------------------|
| **POST**   | `/api/accounts`                 | Create a new account            |
| **GET**    | `/api/accounts/{id}`            | Fetch a specific account        |
| **PUT**    | `/api/accounts/{id}/deposit`    | Deposit money into an account   |
| **PUT**    | `/api/accounts/{id}/withdraw`   | Withdraw money from an account  |
| **GET**    | `/api/accounts`                 | Fetch all accounts              |
| **DELETE** | `/api/accounts/{id}`            | Delete an account               |


## Example JSON Response

{
  "id": 1,
  "accountHolder": "dharun",
  "balance": 5000.0
}


