# Bank-Project

# Bank Project 🏦

A bank account management system using Spring Boot, MySQL, and REST APIs.

🚀 Features

✅ Create, update, delete bank accounts✅ Deposit & Withdraw money✅ Transfer money between accounts✅ Scheduled payments processing✅ Transaction history with pagination & filtering✅ Email notifications for transactions 

🛠️ Technologies Used

Java 21

Spring Boot

Spring Data JPA

MySQL

Maven

Spring Scheduler (for scheduled payments)

Spring Mail (for email notifications)


⚙️ Setup & Installation

1️⃣ Clone the repository:

git clone https://github.com/Tharvinprakash/Bank-Project.git
cd Bank-Project

2️⃣ Configure MySQL Database in src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/bank_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your_email@gmail.com
spring.mail.password=your_email_password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

3️⃣ Run the application:

mvn spring-boot:run

4️⃣ Access APIs via Postman or browser:

http://localhost:8080/api/accounts


## API Endpoints

🔗 API Endpoints

🔹 Account Management

Method

Endpoint

Description

POST

/api/accounts

Create a new account

GET

/api/accounts/{id}

Fetch a specific account

PUT

/api/accounts/{id}/deposit

Deposit money into an account

PUT

/api/accounts/{id}/withdraw

Withdraw money from an account

GET

/api/accounts

Fetch all accounts

DELETE

/api/accounts/{id}

Delete an account

🔹 Transactions

Method

Endpoint

Description

GET

/api/accounts/{id}/transactions

Fetch account transaction history

GET

/api/accounts/{id}/paginated

Fetch paginated transaction history

🔹 Fund Transfers

Method

Endpoint

Description

POST

/api/accounts/transfer

Transfer money between accounts

🔹 Scheduled Payments

Method

Endpoint

Description

POST

/api/scheduled-payments

Schedule a future payment

GET

/api/scheduled-payments

Fetch all scheduled payments

📌 Example JSON Response

{
  "id": 1,
  "accountHolderName": "Dharun",
  "balance": 5000.0,
  "email": "dharun@example.com"
}


