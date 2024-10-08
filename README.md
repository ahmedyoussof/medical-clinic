Medical Clinic Appointments
============================================

Features
--------

*   View all of today's appointments
*   Add new appointments
*   Cancel appointments with reasons (No show, Patient request, Physician apology)
*   Filter appointments by date (future or history)
*   Filter appointments by patient name
*   Preview patient appointment history

Technologies Used
-----------------

*   Java
*   Spring Boot
*   Spring Data JPA
*   Hibernate
*   MySQL
*   Docker
*   Swagger for API documentation

Prerequisites
-------------

*   Java JDK 17 or later
*   Maven
*   Docker and Docker Compose (for containerized deployment)
*   MySQL (for local deployment without Docker) with created schema `clinicdb`

Running Locally
---------------

1.  Clone the repository:


    `git clone https://github.com/your-username/medical-clinic.git cd medical-clinic`


2.  Build the project:


    `mvn clean install`

3.  Run the application:


    `java -jar target/medical-clinic-appointment-system.jar`

4.  The application will be available at `http://localhost:8080`

Running with Docker Compose
---------------------------

1.  Make sure you have Docker and Docker Compose installed on your system.
2.  Clone the repository:


    `git clone https://github.com/your-username/medical-clinic.git cd medical-clinic`

3.  Build and run the containers:


    `docker-compose up --build`

4.  The application will be available at `http://localhost:8080`

API Documentation
-----------------

Swagger UI is used for API documentation. After running the application, you can access the API documentation at:

Copy

`http://localhost:8080/swagger-ui.html`

Project Structure
-----------------

The project follows a layered architecture with proper separation of concerns:

*   `com.clinic.controller`: REST API endpoints
*   `com.clinic.service`: Business logic layer
*   `com.clinic.repository`: Data access layer
*   `com.clinic.model`: Data models and entities
*   `com.clinic.dto`: Data Transfer Objects
*   `com.clinic.exception`: Custom exception handling
