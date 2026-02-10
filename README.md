 e# Item API

A simple RESTful API for managing a collection of items, built with Spring Boot. This application demonstrates basic CRUD operations with in-memory storage.

## Features

- **Item Model**: Represents items with id, name, description, and price.
- **In-Memory Storage**: Uses ArrayList for storing items (data is lost on restart).
- **API Endpoints**:
  - `POST /items`: Add a new item.
  - `GET /items/{id}`: Get a single item by ID.
- **Input Validation**: Ensures required fields are present and constraints are met.
- **Documentation**: This README provides setup and usage instructions.

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher (or use Maven Wrapper if available)

## Installation and Setup

1. **Clone or Download the Project**:
   - Ensure the `item-api` directory is in your workspace.

2. **Install Dependencies**:
   - If Maven is not installed, download it from [Apache Maven](https://maven.apache.org/download.cgi) and set up `MAVEN_HOME` and `PATH`.
   - Alternatively, if `mvnw` (Maven Wrapper) is present, use `./mvnw` on Unix or `mvnw.cmd` on Windows.

3. **Build the Project**:
   ```
   cd item-api
   mvn clean compile
   ```

4. **Run the Application**:
   ```
   mvn spring-boot:run
   ```
   - The application will start on `http://localhost:8080`.

## API Endpoints

### Add a New Item
- **Endpoint**: `POST /items`
- **Content-Type**: `application/json`
- **Request Body**:
  ```json
  {
    "name": "Sample Item",
    "description": "A description of the item",
    "price": 19.99
  }
  ```
- **Response** (201 Created):
  ```json
  {
    "id": 1,
    "name": "Sample Item",
    "description": "A description of the item",
    "price": 19.99
  }
  ```
- **Validation Errors** (400 Bad Request) if name/description is blank or price <= 0.

### Get an Item by ID
- **Endpoint**: `GET /items/{id}`
- **Example**: `GET /items/1`
- **Response** (200 OK):
  ```json
  {
    "id": 1,
    "name": "Sample Item",
    "description": "A description of the item",
    "price": 19.99
  }
  ```
- **Response** (404 Not Found) if item does not exist.

## Testing the API

Use tools like Postman, curl, or your browser's developer tools.

### Example curl Commands

1. **Add an Item**:
   ```
   curl -X POST http://localhost:8080/items \
        -H "Content-Type: application/json" \
        -d '{"name": "Laptop", "description": "A powerful laptop", "price": 999.99}'
   ```

2. **Get an Item**:
   ```
   curl http://localhost:8080/items/1
   ```

3. **Test Validation** (should return 400):
   ```
   curl -X POST http://localhost:8080/items \
        -H "Content-Type: application/json" \
        -d '{"name": "", "description": "Desc", "price": 10.0}'
   ```

## Implementation Details

- **Item.java**: Model class with validation annotations (`@NotBlank`, `@DecimalMin`).
- **ItemService.java**: Handles in-memory storage with ArrayList, auto-generates IDs.
- **ItemController.java**: REST controller with endpoints, uses Spring Validation.
- **ItemApiApplication.java**: Main Spring Boot class.
- **Data Storage**: In-memory (ArrayList), not persistent across restarts. For production, consider a database like H2 or PostgreSQL.

## Hosting for Demo

To host the application (e.g., on Heroku for a backend API):

1. **Install Heroku CLI**: Download from [Heroku CLI](https://devcenter.heroku.com/articles/heroku-cli).

2. **Login to Heroku**:
   ```
   heroku login
   ```

3. **Create a Heroku App**:
   ```
   heroku create your-app-name
   ```

4. **Deploy**:
   - Ensure the project has a `Procfile` (create one if needed):
     ```
     web: java -jar target/item-api-0.0.1-SNAPSHOT.jar
     ```
   - Build the JAR:
     ```
     mvn clean package
     ```
   - Deploy:
     ```
     git init
     git add .
     git commit -m "Initial commit"
     heroku git:remote -a your-app-name
     git push heroku main
     ```
   - Open the app: `heroku open`

5. **Email the Link**: Once deployed, email the live URL (e.g., https://your-app-name.herokuapp.com) to suprjareddygurrala@gmail.com.

For other platforms like Railway or Render, follow their deployment guides for Spring Boot apps.

## Notes

- This is a basic implementation for demonstration. In a real-world scenario, add authentication, error handling, and a persistent database.
- Data is stored in-memory, so restarting the app will clear all items.
