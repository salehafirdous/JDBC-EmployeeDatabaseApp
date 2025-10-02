# Task 7 :  Java JDBC – Employee Database App

## Overview
This project is a simple **Java console application** that connects to a MySQL database using **JDBC**.  
It allows you to **Add**, **View**, **Update**, and **Delete** employee records.
This was built as part of the Elevate Labs Java Developer Internship (Task-7).

## Tools & Technologies
- Java (JDK 8+)
- JDBC API (DriverManager, Connection, PreparedStatement, ResultSet)
- MySQL Database (or any JDBC-compatible DB)
- Eclipse IDE

## Project Structure
```
ElevateLabsInternship/
└── src/
└── com.elevatelabs.tasks.task7
├── Employee.java  # model class
└── EmployeeApp.java  # main Class (JDBC connection + CRUD)
```


## How I Set Up & Run
1. Created the database and table in MySQL:
   ```sql
   CREATE DATABASE employee_app;
   USE employee_app;
   CREATE TABLE employees (
     id INT PRIMARY KEY AUTO_INCREMENT,
     name VARCHAR(100),
     department VARCHAR(50),
     salary DOUBLE
   );
 2. In Eclipse, add the MySQL JDBC driver (mysql-connector-j .jar) to the project Build Path.
 3. Provided the DB URL, username, and password in EmployeeApp.java.
 ```
private static final String URL = "jdbc:mysql://localhost:3306/employee_app";
private static final String USER = "root";
private static final String PASS = "password";
```
4. Run EmployeeApp.java as a Java Application.


## What I Did in This Task:
Created an Employee model class to represent an employee record.
Built a menu-driven EmployeeApp class to:
- Connect to MySQL database via JDBC
- Use PreparedStatement for all SQL queries (prevents SQL injection)
- Implement CRUD operations: Add, View, Update, Delete
- Followed best practice to close connections with try-with-resources.

## Sample Output:
```
Employee Database Menu..
1. Add Employee
2. View Employees
3. Update Employee
4. Delete Employee
5. Exit
Enter your choice: 1
Enter name: Sonam Mishra
Enter department: CSE
Enter salary: 35000
Employee added successfully.

Employee Database Menu..
1. Add Employee
2. View Employees
3. Update Employee
4. Delete Employee
5. Exit
Enter your choice: 2
Employee List...
1 | Saleha Syed Qamar |  Data Science | 30000.0
2 | Kamran Syed Qamar | IT | 40000.0
3 | Sonam Mishra | CSE | 35000.0

Employee Database Menu..
1. Add Employee
2. View Employees
3. Update Employee
4. Delete Employee
5. Exit
Enter your choice: 3
Enter Employee ID to update: 2
Enter new department: Information Technology
Enter new salary: 30000
Employee updated successfully.

Employee Database Menu..
1. Add Employee
2. View Employees
3. Update Employee
4. Delete Employee
5. Exit
Enter your choice: 5
Exit
```

<img width="993" height="441" alt="image" src="https://github.com/user-attachments/assets/c55ef3e7-4fa0-4ca4-9594-e8388efb1128" />


## Concepts Learned:
-Basics of JDBC API.
-How to connect Java to a relational database.
-Using PreparedStatement to execute parameterized SQL safely.
-Handling ResultSet to fetch query results.
-Managing resources with try-with-resources to avoid leaks.
-Simple console menu application structure.

- Name: Saleha Firdous Syed Qamar
- Domain: Java Full Stack Development
- Date: 2 October 2025




