# Baby Classes Locator API

A RESTful API built with Java 21, Spring Boot, and MySQL for discovering baby and toddler classes.

The API allows parents and carers to search for classes by:
- 📍 Proximity (distance from a given postcode or coordinates) Endpoint /postcode 
- 📅 Upcoming dates endpoint /upcoming
- Type (e.g. music, swimming, sensory)
- Age group (e.g. 0–12 months, 1–3 years)  

The project is developed using Test-Driven Development (TDD), with unit and integration tests in JUnit and Mockito.


## Features
- Retrieve all available baby classes  
- Filter by location (using proximity search)  
- Filter by upcoming schedule  
- Filter by type of class
- Filter by age group 
- Add new classes (admin use)  
- Update and delete existing classes  (admin use)



## 🛠️ Tech Stack
- Java 21
- Spring Boot 3.5.5
- Spring Data JPA (Hibernate)
- MySQL (relational database)
- JUnit 5 & Mockito (testing)
- Maven Wrapper ('./mvnw') for build and test
- Endpoints can be tested using postman. (Proximity get endpoint /Postcode/(user postcode)), (Upcoming classes get endpoint /Upcoming), (Type of class get endpoint /Type), (Age group get endpoint /Age/(baby age in months).

## Database 
- MySQL database dump located [## Database](https://github.com/ChinwenduOgboh/baby-classes/blob/cde2adaa3a9722542fea594705a4d8cf90589555/Baby%20Classes%20Kent/babyclassesdump.sql)

