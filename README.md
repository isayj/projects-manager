This project involves developing a Spring Boot application with a PostgreSQL database to manage customers and their projects, providing RESTful APIs for CRUD operations and data export, along with an HTML UI for interacting with these functionalities.
## Project Manager

### Overview
Project Manager is a Spring Boot application designed to manage projects. 
It includes functionalities to view, create, update, and delete projects. 
The application uses a PostgreSQL database to store project data.

### Technologies Used
- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven


### Prerequisites
- Java 17 or higher
- Spring Boot 3.3.2 or higher
- Maven 3.9.7 or higher
- PostgreSQL 17

### Setup Instructions


#### Application Configuration
1. Clone the repository:
   ```bash
   git clone https://github.com/isayj/projects-manager.git
   ```
2. Open Docker Desktop.

#### Database Configuration
1. Configure `compose.yaml` for the PostgreSQL.

#### Build and Run
1. using IntelliJ: Click the run button
2. using Bash:
   ```bash
   ./mvnw spring-boot:run
   ```

### Accessing the HTTP endpoints
- Open your browser and go to `http://localhost:8080/api/projects`.

### API Endpoints
- **GET /api/projects**: Retrieve all projects.
- **GET /api/projects/{id}**: Retrieve a project by ID.
- **POST /api/projects**: Create a new project.
- **PUT /api/projects/{id}**: Update an existing project.
- **DELETE /api/projects/{id}**: Delete a project by ID.
- **GET /api/projects/filter/{start}/{end}**: Filter projects created within a period.

### Example CRUD operations with [httpie](https://httpie.io/docs/cli/examples)
#### PUT Retrieve All Projects
```bash
http :8080/api/projects
```
#### PUT Retrieving One Project by ID
```bash
http :8080/api/projects/2
```

### Example CRUD operations with http requests `api/manager.http`
#### POST Create a New Project
```http request
### Create a new project
POST http://localhost:8080/api/projects
Content-Type: application/json

{
  "id": 6,
  "name": "project 6",
  "description": "created http",
  "createdOn": "2024-07-24",
  "version": null
}
```
#### PUT Update a Project
```http request
### Update an existing project
PUT http://localhost:8080/api/projects/6
Content-Type: application/json

{
  "id": 6,
  "name": "project 6",
  "description": "updated http",
  "createdOn": "2024-07-24",
  "version": null
}
```
#### DELETE Delete a Project
```http request
### Delete a project
DELETE http://localhost:8080/api/projects/6
```


[//]: # (### Troubleshooting)

[//]: # (- **Content of `index.html` not showing up in the browser**: Ensure `index.html` is located in `src/main/resources/static/` and the `HomeController` is correctly configured to return the view name without the `.html` extension.)

[//]: # ()
[//]: # (### Contributing)

[//]: # (1. Fork the repository.)

[//]: # (2. Create a new branch &#40;`git checkout -b feature-branch`&#41;.)

[//]: # (3. Make your changes and commit them &#40;`git commit -m 'Add some feature'`&#41;.)

[//]: # (4. Push to the branch &#40;`git push origin feature-branch`&#41;.)

[//]: # (5. Create a new Pull Request.)

[//]: # ()
[//]: # (### License)

[//]: # (This project is licensed under the MIT License. See the `LICENSE` file for details.)