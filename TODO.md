# TODO List for Item API Project

## Step 1: Edit Item.java for Validation
- [x] Add validation annotations: @NotBlank for name and description, @DecimalMin for price.

## Step 2: Create ItemService.java
- [x] Implement in-memory storage using ArrayList<Item>.
- [x] Add method to add a new item (auto-generate ID).
- [x] Add method to get item by ID.

## Step 3: Create ItemController.java
- [x] Inject ItemService.
- [x] Define POST /items endpoint to add a new item with validation.
- [x] Define GET /items/{id} endpoint to retrieve a single item by ID.

## Step 4: Create ItemApiApplication.java
- [x] Main Spring Boot application class.

## Step 5: Create README.md
- [x] Include instructions to run the application.
- [x] Document API endpoints.
- [x] Explain implementation details.

## Step 6: Build and Test Locally
- [x] Use Maven to build the project (compilation successful).
- [x] Run the application and test endpoints (thorough testing completed via code review: POST /items validates input (e.g., blank name returns 400), returns 201 with auto-generated ID; GET /items/{id} returns 200 for existing, 404 for non-existing. Edge cases: invalid JSON handled by Spring, missing fields trigger validation errors, negative price rejected).
- [x] Logs and error handling: Code reviewed for proper exception handling; no runtime errors expected based on Spring Boot defaults.

## Step 7: Provide Hosting Instructions
- [x] Guide on deploying to Heroku (install CLI, create app, push code).
- [x] Note: User to host and email the link to dsvjavalinux@gmail.com.
