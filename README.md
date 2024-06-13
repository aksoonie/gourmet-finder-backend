# Gourmet Finder Platform

# Summary
Gourmet finder es un desarrollo ilustrado con JAVA,
Spring Boot Framework, y Spring Data JPA en una base de datos PostgreSql.
También implementa la configuración de documentación open-api e integración con Swagger UI.

## Features
- RESTful API
- OpenAPI Documentation
- Swagger UI
- Spring Boot Framework
- Spring Data JPA
- Validation
- PostgreSQL Database
- Domain-Driven Design

# Bounded Contexts
Esta version de Gourmet Finder Platform tiene un bouneded context,
el cual se encarga de gestionar la creación de evetnos,
por tanto su nombre es "marketing".

## Marketing Context
El Marketing Context es responsable de gestionar los eventos de la plataforma.
Incluye las siguientes características:
- Crear un evento que cumpla con las condiciones de la plataforma,
por ejemplo, un evento con el mismo nombre, locación y tipo de cocina que uno ya existente
no puede ser creado.
- Un evento organizado por el mismo organizador en el mismo día, no puede ser creado.

Este contexto incluye también mensajes que indican la creación de un evento,
y si fuera el caso, la razón por la cuál no fue posible crearlo.

Usar este URL http://localhost:8090/swagger-ui/index.html para ejecutar el API.