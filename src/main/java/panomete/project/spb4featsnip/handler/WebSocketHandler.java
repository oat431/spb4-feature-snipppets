package panomete.project.spb4featsnip.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

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
