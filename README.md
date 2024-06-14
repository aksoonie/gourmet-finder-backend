# Gourmet Finder Platform
## Summary
Gourmet Finder is a development illustrated with JAVA, Spring Boot Framework, and Spring Data JPA on a PostgreSQL database. It also implements open-api documentation configuration and integration with Swagger UI.  
## Features
- RESTful API
- OpenAPI Documentation
- Swagger UI
- Spring Boot Framework
- Spring Data JPA
- Validation
- PostgreSQL Database
- Domain-Driven Design
- Bounded Contexts

This version of Gourmet Finder Platform has a bounded context, which is responsible for managing the creation of events, hence its name is "marketing".  
## Marketing Context
The Marketing Context is responsible for managing the events of the platform. It includes the following features:  
- Create an event that meets the conditions of the platform, for example, an event with the same name, location, and type of cuisine as an existing one cannot be created.
- An event organized by the same organizer on the same day cannot be created.
This context also includes messages indicating the creation of an event, and if applicable, the reason why it was not possible to create it.  

Use this URL http://localhost:8090/swagger-ui/index.html to run the API.