# Create Global Exception Handler in Spring Boot

1. Create an exception class:

```java
public class ServerErrorException extends RuntimeException {
    private String message;
    public ServerErrorException(String message) {
        super(message);
        this.message = message;
    }

    public ServerErrorException() {}
}
```

2. create a global exception handler controller advice class:

```java
@RestControllerAdvice
public class GlobalExceptionController {
    @ExceptionHandler(value = ServerErrorException.class)
    @org.springframework.web.bind.annotation.ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ResponseDTO<String>> handleServerError(ServerErrorException ex) {
        ResponseError error = new ResponseError(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "SERVER-ON-FIRE-500",
                ErrorMessage.SERVER_ERROR
        );
        ResponseDTO<String> response = new ResponseDTO<>(
                null,
                ResponseStatus.ERROR,
                error
        );
        return ResponseEntity.status(500).body(response);
    }
}
```

3. Now you can throw the `ServerErrorException` from any controller or service, and it will be handled by the global exception handler:
