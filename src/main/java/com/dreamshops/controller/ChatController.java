package com.dreamshops.controller;

import com.dreamshops.request.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/chat") // frontend: /app/chat
    @SendTo("/topic/messages") // frontend: subscribe /topic/messages
    public ChatMessage send(ChatMessage message) {
        System.out.println("New message: " + message.getContent());
        message.setTimestamp(java.time.LocalTime.now().toString());
        return message;
    }
}

