# Setup Redirect Feature for Spring Boot Application

```java
    public ResponseEntity<Void> redirectToLocation() {
        return ResponseEntity.status(301)
                .header("Location", URL)
                .build();
    }
```

301 Moved Permanently indicates that the resource requested has been permanently moved to a new URL provided in the Location header.
