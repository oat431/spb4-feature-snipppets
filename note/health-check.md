# Application Health Check

official document: [here](https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html)

1. Add Spring Boot Actuator Dependency

If you're using Maven, add the following dependency to your `pom.xml` file:
```xml
 <dependency>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-starter-actuator</artifactId>
 </dependency>
```

For Gradle, add this line to your `build.gradle` file:
```groovy
 implementation 'org.springframework.boot:spring-boot-starter-actuator'
```

2. Configure Application Properties (or YAML)
You can customize the Actuator endpoints by adding properties to your `application.properties` or `application.yml` file.
Example for `application.properties`:
```properties
 management.endpoints.web.exposure.include=health,info
 management.endpoint.health.show-details=always
```

Example for `application.yml`:
```yaml
 management:
   endpoints:
     web:
       exposure:
         include: health,info
   endpoint:
     health:
       show-details: always
```

3. Access Health Endpoint

Once you've added the dependency and configured the properties, you can access the health endpoint by navigating to:
```
http://localhost:8080/actuator/health
```