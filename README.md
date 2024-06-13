# Importantes
## Application properties

link del swagger ui
http://localhost:8090/swagger-ui/index.html

spring.application.name=gourmet-finder-platform
Spring DataSource Configuration
JDBC : SGDB :// HOST : PORT / DB
spring.datasource.url: jdbc:postgresql://localhost:5432/gourmetfinder
spring.datasource.username: postgres
spring.datasource.password: pedito1234
spring.datasource.driver-class-name: org.postgresql.Driver

pring Data JPA Configuration
spring.jpa.database: postgresql
spring.jpa.show-sql: true

Spring Data JPA Hibernate Configuration
cuando se ejecute por primera vez, cambiar a *create* (para el auditable)
luego cambiar a update
con el create se pierden los datos cada vez que se corre la aplicacion
con update se mantiene la data (pero no funcion el auditable al inicio)
spring.jpa.hibernate.ddl-auto: create
spring.jpa.open-in-view=true
spring.jpa.properties.hibernate.format_sql: true
spring.jpa.properties.hibernate.dialect: org.hibernate.dialect.PostgreSQLDialect
server.port: 8090

## En pom.xml
<!--para snake case-->
		<dependency>
			<groupId>io.github.encryptorcode</groupId>
			<artifactId>pluralize</artifactId>
			<version>1.0.0</version>
		</dependency>

  # Estructura de archivos
![image](https://github.com/aksoonie/gourmet-finder-backend/assets/134560396/04ba3b29-42c5-4a42-b6d6-bbb7691b2924)
![image](https://github.com/aksoonie/gourmet-finder-backend/assets/134560396/c81f8894-2fed-464f-a0d7-98c44e4d4385)

  
