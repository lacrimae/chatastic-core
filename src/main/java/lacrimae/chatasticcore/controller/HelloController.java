package lacrimae.chatasticcore.controller;

import lacrimae.chatasticcore.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Message greeting(Message message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return Message.builder().content("HELLO").build();
    }
}
