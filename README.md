# Literalura - Sistema de Gestión de Libros

![image](https://github.com/user-attachments/assets/4c551068-5c99-495e-97bf-1321cb7078a7)


**Literalura** es una aplicación desarrollada en Java utilizando Spring Boot para gestionar libros y autores. Permite buscar libros por título, listar libros registrados, listar autores registrados y filtrar libros por idioma.

## Tecnologías utilizadas

- Java
- Spring Boot
- Maven
- Dotenv (para manejo de variables de entorno)
- Base de datos (puede integrarse con MySQL, PostgreSQL, etc.)

## Configuración del proyecto

1. **Clonar el repositorio**

```bash
git clone <url-del-repositorio>
cd literalura
```

2. **Configurar las variables de entorno**

Crea un archivo `.env` en el directorio raíz del proyecto con el siguiente contenido:

```
DB_USER=tu_usuario
DB_PASSWORD=tu_contraseña
```

3. **Configurar la base de datos**

Asegúrate de tener una base de datos configurada y actualiza el archivo `application.properties` o `application.yml` con los detalles de conexión:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/literalura
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}
spring.jpa.hibernate.ddl-auto=update
```

4. **Instalar dependencias**

Ejecuta el siguiente comando para descargar las dependencias necesarias:

```bash
mvn clean install
```

5. **Ejecutar la aplicación**

Inicia la aplicación ejecutando:

```bash
mvn spring-boot:run
```

## Estructura del proyecto

```
com.challeng_1.literalura
|-- api
|   |-- consumoApi.java
|   |-- convertData.java
|   |-- IconvertData.java
|
|-- entity
|   |-- Libro.java         
|   |-- Autor.java         
|
|-- model
|   |-- data.java
|   |-- infoAutor.java
|   |-- infoLibros.java
|
|-- repositories
|   |-- AutorRepository.java
|   |-- LibroRepository.java
|
|-- services
|   |-- literaluraService.java 
|
|-- LiteraluraApplication.java 
|-- MenuRunner.java           
|-- main.java                  
```

## Características

- Buscar libros por título y mostrar información detallada
- Listar todos los libros y autores registrados
- Filtrar libros según idioma

## Captura de pantalla

![image](https://github.com/user-attachments/assets/64e14dfc-41bb-4865-a7f4-43d2c4f18bd7)

![image](https://github.com/user-attachments/assets/1c7117d0-17a8-4fa5-9961-7bc826adaf17)

![image](https://github.com/user-attachments/assets/f6e9e97b-a74b-4269-bd22-dd9f89839fef)




