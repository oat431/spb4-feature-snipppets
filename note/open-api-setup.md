# Setup OpenAPI for Spring Boot Application

1. Add This Dependency

   If you're using Maven, add the following dependency to your `pom.xml` file:

   ```xml
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        <version>3.0.1</version>
    </dependency>
   ```

   For Gradle, add this line to your `build.gradle` file:

   ```groovy
    implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:3.0.1'
   ```
   
    Remark: Version number may change over time. Please check the [springdoc maven repository](https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-starter-webmvc-ui) for the latest version.

2. Configure Application Properties (or YAML)

   You can customize the OpenAPI documentation by adding properties to your `application.properties` or `application.yml` file.

   Example for `application.properties`:

   ```properties
    springdoc.swagger-ui.path=/api-ui
    springdoc.swagger-ui.try-it-out-enabled=true
    springdoc.swagger-ui.filter=true
    springdoc.swagger-ui.operations-sorter=alpha
    springdoc.swagger-ui.tags-sorter=alpha
    springdoc.api-docs.path=/api-docs
    springdoc.show-actuator=true
   ```

   Example for `application.yml`:

   ```yaml
    springdoc:
      swagger-ui:
        path: /api-ui
        try-it-out-enabled: true
        filter: true
        operations-sorter: alpha
        tags-sorter: alpha
      api-docs:
        path: /api-docs
      show-actuator: true
    ```
3. You can also config OpenAPI programmatically by creating a configuration class:

   ```java
    import io.swagger.v3.oas.annotations.OpenAPIDefinition;
    import io.swagger.v3.oas.annotations.info.Info;
    import org.springframework.context.annotation.Configuration;

    @Configuration
    @OpenAPIDefinition(
        info = @Info(
            title = "Spring Boot Feature Snippets API",
            version = "1.0",
            description = "API documentation for Feature Snippets that going to be used in other spring boot projects."
        )
    )
    public class OpenAPIConfig { }

   ```

4. Access the Swagger UI and OpenAPI Documentation
   Once your application is running, you can access the Swagger UI at:

   ```
   http://localhost:8080/api-ui
   ```

   And the OpenAPI documentation in JSON format at:

   ```
   http://localhost:8080/api-docs
   ```