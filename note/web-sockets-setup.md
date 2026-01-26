# Setup Web Sockets with Spring Boot
offical doc: [spb_w_ws](https://docs.spring.io/spring-framework/reference/web/websocket/server.html)

## Step 1: Add dependencies

``` groovy
    implementation 'org.springframework.boot:spring-boot-starter-websocket:4.0.2'
```

## Step 2: Configure WebSocket
Create a configuration class and handler class to enable WebSocket support, register endpoints and handler the socket.

configuration class:
``` java
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketHandler(), "/chat").setAllowedOrigins("*");
    }

    @Bean
    public WebSocketHandler webSocketHandler() {
        return new WebSocketHandler();
    }
}
```

handler class:
``` java
@Slf4j
public class WebSocketHandler extends TextWebSocketHandler {
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String clientMessage = message.getPayload();
        log.info("Received message: {}", clientMessage);

        String replyMessage = "Server: Hi " + clientMessage;
        session.sendMessage(new TextMessage(replyMessage));
    }
}
```

## Step 3: Test WebSocket
You can use an online WebSocket like [piehost](https://piehost.com/websocket-tester)

- Connect to `ws://localhost:8080/chat`
- Send a message like `Alice`
- You should receive a reply: `Server: Hi Alice`

