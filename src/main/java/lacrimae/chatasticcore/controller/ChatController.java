package lacrimae.chatasticcore.controller;

import lacrimae.chatasticcore.model.Message;
import lacrimae.chatasticcore.service.MessageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@AllArgsConstructor
@Controller
@Slf4j
public class ChatController {

    private final MessageService messageService;
    private final SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat")
    public void sendMessage(Message message, @DestinationVariable String userId) {
        // Todo: add from/to to logging message.
        log.debug("Send message with id");
//        messageService.send(message);
        messagingTemplate.convertAndSendToUser(userId, "/chat", message);
    }
}
