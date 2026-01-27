# Webhook Setup Guide

It just a simple API endpoint that can receive HTTP POST requests from external services.

```java
public class WebHookController {
    
    @PostMapping("/webhook")
    public ResponseDTO<String> webhook() {
        // do whatever you want with the webhook data
        return new ResponseDTO<>(
                "webhook triggered successfully",
                ResponseStatus.SUCCESS,
                null
        );
    }
    
}

```
