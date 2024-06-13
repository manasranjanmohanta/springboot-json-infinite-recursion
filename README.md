# springboot-json-infinite-recursion

## Features
- **Spring Boot:** Simplifies the development process and provides a robust framework for building enterprise-level applications.
- **H2 Database:** An in-memory database used for simplicity and ease of demonstration.
- **JPA/Hibernate:** Manages the persistence layer and entity relationships.
- **Jackson Annotations:** Handles JSON serialization and prevents infinite recursion with `@JsonManagedReference` and `@JsonBackReference`.

## How to Run
1. Clone the repository:
    ```bash
    git clone https://github.com/manasranjanmohanta/springboot-json-infinite-recursion.git
    ```
2. Navigate to the project directory:
    ```bash
    cd springboot-json-infinite-recursion
    ```
3. Build and run the application:
    ```bash
    ./mvnw spring-boot:run
    ```
4. Access the application:
    - The application will start on `http://localhost:8080`.
    - Use the provided endpoints to interact with the entities and see how infinite recursion is prevented during JSON serialization.

## Endpoints
- `/students`: Fetch and create student entities.
- `/classes`: Fetch and create class entities.

## Technologies Used
- Spring Boot
- Spring Data JPA
- H2 Database
- Jackson

## Example JSON Request
```json
{
    "id": 2,
    "name": "prangya",
    "aClassEntity": {
        "id": 1
    }
}
```

- You can check you persistent data at `http://localhost:8080/h2-console`
