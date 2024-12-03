#### **Mercatura | Product Catalog with Authentication**

**Overview**

This project aims to develop a secure REST API for managing a product catalog and its categories using Spring Boot. Key features include:

* **Authentication:** Stateful authentication using JDBC for user management.
* **Authorization:** Role-based access control for different user roles (ADMIN, USER).
* **Product Management:** CRUD operations, searching, filtering, and pagination.
* **Category Management:** CRUD operations, product association, and pagination.
* **Security:** BCryptPasswordEncoder for password hashing and Spring Security for overall security.
* **Deployment:** Containerization with Docker and CI/CD using Jenkins.

**Technologies Used**

* **Backend:** Spring Boot, Spring Data JPA, Spring Security
* **Database:** MariaDB 
* **Build Tool:** Maven 
* **Containerization:** Docker
* **CI/CD:** Jenkins

**Getting Started**

1. **Clone the repository:**
   ```bash
   git clone https://github.com/bachiriy/mercatura.git
   ```
2. **Build the project:**
   ```bash
   ./mvnw clean package
   ```
3. **Run the application:**
   ```bash
   java -jar target/mercatura.jar
   ```

**Project Structure**

* **src/main/java:** Contains the main Java source code, including controllers, services, entities, and repositories.
* **src/test/java:** Contains unit and integration tests.
* **docker:** Contains Dockerfiles and related scripts.

**API Endpoints**

* **Authentication:**
  * `/api/auth/login`
  * `/api/auth/register`
* **Product Management:**
  * `/api/user/products`
  * `/api/admin/products`
* **Category Management:**
  * `/api/user/categories`
  * `/api/admin/categories`
* **User Management:**
  * `/api/admin/users`

**Contributing**

1. **Fork the repository.**
2. **Create a new branch.**
3. **Make your changes.**
4. **Push to your branch.**
5. **Create a pull request.**

**Additional Notes**

* **Database Configuration:** Update the `application.properties` file with your database credentials.
* **Docker:** Build and run the Docker image using the provided Dockerfile.
* **Jenkins:** Configure Jenkins to build, test, and deploy the application.
* **Testing:** Run the tests using your preferred testing framework.

**Author**

Bachiriy

