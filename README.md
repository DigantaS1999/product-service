
# REST API - Category & Product Management

This project is a Spring Boot 3 RESTful API that manages **Categories** and **Products** with a one-to-many relationship. It uses **Spring Data JPA**, **Hibernate**, and a **relational database (e.g., MySQL)** for data persistence.

---

## 1. Technologies Used

- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Maven

---

## 2. Features

- RESTful API with annotation-based configuration
- CRUD operations for Category and Product
- One-to-many relationship (One Category → Many Products)
- Server-side pagination
- Fetch Product details along with its Category

---

## 3. Getting Started

Clone the repository:

```bash
git clone https://github.com/your-username/springboot3-rest-api.git
cd springboot3-rest-api
```

---

## 4. Database Configuration

Update the `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/productservicedb
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

---

## 5. Entity Relationship

- `Category` has a `@OneToMany` relationship with `Product`
- `Product` has a `@ManyToOne` relationship with `Category`

---

## 6. API Endpoints

### Category APIs

| Method | Endpoint                         | Description               |
|--------|----------------------------------|---------------------------|
| GET    | `/api/categories?page=0`         | Get paginated categories |
| POST   | `/api/categories`                | Create category          |
| GET    | `/api/categories/{id}`           | Get category by ID       |
| PUT    | `/api/categories/{id}`           | Update category          |
| DELETE | `/api/categories/{id}`           | Delete category          |

### Product APIs

| Method | Endpoint                         | Description               |
|--------|----------------------------------|---------------------------|
| GET    | `/api/products?page=0`           | Get paginated products   |
| POST   | `/api/products`                  | Create product           |
| GET    | `/api/products/{id}`             | Get product with category|
| PUT    | `/api/products/{id}`             | Update product           |
| DELETE | `/api/products/{id}`             | Delete product           |

---

## 7. Pagination Support

Use `?page={number}` in GET requests to paginate results. Example:

```
GET /api/products?page=2
```

---

## 8. JSON Sample

### Product with Category

```json
{
  "id": 1,
  "name": "iPhone 15",
  "price": 1299.99,
  "category": {
    "id": 2,
    "name": "Smartphones"
  }
}
```

---

## 9. Build and Run

```bash
./mvnw clean install
./mvnw spring-boot:run
```

App will start on `http://localhost:8080`.

---

## 10. Future Improvements

- Add Swagger/OpenAPI documentation
- Implement sorting and filtering
- Add unit and integration tests
