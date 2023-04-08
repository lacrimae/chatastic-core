package lacrimae.chatasticcore.controller;

import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
import lacrimae.chatasticcore.model.Message;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint("api/v1/chat")
public class ChatController {
    private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<>());

    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);
    }

    @OnMessage
    public void onMessage(Session session, Message message) throws EncodeException, IOException {
        for (Session s : sessions) {
            if (!session.getId().equals(s.getId())) {
                s.getBasicRemote().sendObject(message);
            }
        }
    }

    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);
    }
}
