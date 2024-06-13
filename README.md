# Importantes
## Application properties

link del swagger ui: 
http://localhost:8090/swagger-ui/index.html

spring.application.name=gourmet-finder-platform

spring.datasource.url: jdbc:postgresql://localhost:5432/gourmetfinde

spring.datasource.username: postgres

spring.datasource.password: pedito1234

spring.datasource.driver-class-name: org.postgresql.Driver

spring.jpa.database: postgresql

spring.jpa.show-sql: true

spring.jpa.hibernate.ddl-auto: create

spring.jpa.open-in-view=true

spring.jpa.properties.hibernate.format_sql: true

spring.jpa.properties.hibernate.dialect: org.hibernate.dialect.PostgreSQLDialect

server.port: 8090

## En pom.xml (para snake case)
<!--para snake case-->
		<dependency>
			<groupId>io.github.encryptorcode</groupId>
			<artifactId>pluralize</artifactId>
			<version>1.0.0</version>
		</dependency>

# Estructura de archivos
![image](https://github.com/aksoonie/gourmet-finder-backend/assets/134560396/04ba3b29-42c5-4a42-b6d6-bbb7691b2924)
![image](https://github.com/aksoonie/gourmet-finder-backend/assets/134560396/c81f8894-2fed-464f-a0d7-98c44e4d4385)

# Java docs
A continuación se ofrece una tabla con las etiquetas principales que se usan en JAVADOC con su descripción funcional:

| Etiqueta | Descripción |
| --- | --- |
| @author | Autor del elemento a documentar |
| @version | Versión del elemento de la clase |
| @return | Indica los parámetros de salida |
| @exception | Indica la excepción que puede generar |
| @param | Código para documentar cada uno de los parámetros |
| @see | Una referencia a otra clase o utilidad |
| @deprecated | El método ha sido reemplazado por otro |

### Comentarios de clases

A continuación se presenta un ejemplo que muestra cómo se indican, en los comentarios de una clase, la descripción, el autor, la versión y la fecha.

Ejemplo:
/**
* Frase corta descriptiva
* Descripción de la clase
* @author Nombre Apellido / Empresa
* @version 0.1, 2004/05/30
*/
  
