# User Management API

This project implements a User Management API with functionality to create, update, delete users, search for users by 
birth date range, and handle errors gracefully.

## About project 

1. **Fields:**
    - Email (required, validated against email pattern)
    - First name (required)
    - Last name (required)
    - Birth date (required, must be earlier than the current date)
    - Address (optional)
    - Phone number (optional)

2. **Functionality:**
    - **Create User:** Registers users who are more than 18 years old. The age limit can be configured in the properties file.
    - **Update User Fields:** Allows updating one, a few or all user fields.
    - **Delete User:** Deletes a user.
    - **Search Users by Birth Date Range:** Returns a list of users within a specified birth date range. Validates that the "From" date is less than the "To" date.

3. **Testing:** Code is covered by unit tests using Spring.

4. **Error Handling:** API responses are in JSON format and include appropriate error handling.

5. **Technology Stack:**
    - Spring Boot 3.2.5
    - Java 17

6. **Database:** PostgreSql.

## Usage

To use this API, follow these steps:

1. Clone the repository.
2. Configure the project according to your environment.
3. Build and run the application.
4. Access the API endpoints using a REST client or browser.

## API Endpoints

- **POST /api/v1/users:** Create a new user.
- **PUT /api/v1/users/{id}:** Update one or more fields of a user.
- **PATCH /api/v1/users/{id}:** Update all fields of a user.
- **DELETE /api/v1/users/{id}:** Delete a user.
- **GET /api/v1/users/search-by-dates:** Search users by birth date range.

## Testing

The project includes unit tests covering. Run the tests to ensure proper functionality.

## Error Handling

The API handles errors gracefully and returns appropriate JSON responses with error details.

## Examples body for 

- **POST /api/v1/users:**
{
"email": "john.doe@example.com",
"firstName": "John",
"lastName": "Doe",
"birthDate": "2000-05-15",
"address": "123 Main St, City",
"phoneNumber": "1234567890"
}

- **GET /api/v1/users/search-by-dates:**
{
"from": "1993-05-14",
"to": "1999-05-16"
}