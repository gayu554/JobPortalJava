# Job Portal System (Java + MySQL)

## Project Overview
This is a Job Portal Backend Project developed using Java, JDBC, and MySQL.

The system allows:
- Student Registration & Login
- Company Registration & Login
- Post Jobs
- View Jobs
- Search Jobs
- Apply for Jobs
- View Applications
- Accept/Reject Applications

## Technologies Used
- Java
- JDBC
- MySQL
- OOP
- VS Code

## Project Structure

src/
├── dao/
├── database/
├── model/
├── ui/
└── main/

## Database
MySQL Database: `jobportal`

Tables:
- student
- company
- jobs
- applications

## How to Run

1. Import the project into VS Code.
2. Add MySQL Connector JAR.
3. Create the MySQL database.
4. Update the database username and password in `DBConnection.java`.
5. Compile and run:

```bash
javac -d .. database/*.java model/*.java dao/*.java ui/*.java main/Main.java
java main.Main
```

## Features

- Student Login
- Company Login
- Job Posting
- Job Search
- Apply Job
- View Applications
- Application Status Update

## Author

**Gayatri Gavhane**
