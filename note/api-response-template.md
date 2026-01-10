# API Response Template

My Personal API Response Template, inspired by [Jsend](https://github.com/omniti-labs/jsend) format.

```json
{
  "status": "SUCCESS | FAIL | ERROR",
  "data": {
    // Your response data goes here
  },
  "error" : {
    "httpCode": "HTTP_STATUS_CODE",
    "errorCode": "PROGRAM_ERROR_CODE",
    "message": "Detailed error message"
  }
}
```

---

Java Class Representation:

ResponseStatus.java
```java
public enum ResponseStatus {
    SUCCESS, FAIL, ERROR
}

```

ResponseError.java
```java
public record ResponseError(
        Integer httpCode,
        String errorCode,
        String message
) { }

```

ResponseDTO.java
```java
public record ResponseDTO<T>(
        T data,
        ResponseStatus status,
        ResponseError error
) { }

```
