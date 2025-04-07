## 📘 API Endpoints Summary

    Method	    Endpoint	                Description
    
    GET	    /api/employees	        Get all employees
    GET	    /api/employees/{id}	        Get employee by ID
    POST	    /api/employees	        Create a new employee
    PUT	    /api/employees/{id}     	Update employee by ID
    DELETE	    /api/employees/{id}     	Delete employee by ID

---
## 🔍 Swagger UI
- Swagger UI: http://localhost:8080/swagger-ui/index.html
- OpenAPI Docs: http://localhost:8080/v3/api-docs

---

## 📦 Swagger Dependency

In your pom.xml, add this:

    <dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.3.0</version>
    </dependency>