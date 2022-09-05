package com.connection.funchat.controller;

import com.connection.funchat.UserBase;
import com.connection.funchat.conventer.MessageConventer;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.connection.funchat.model.MessageInput;
import com.connection.funchat.model.MessageOutput;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class ChatController {

    @Autowired
    private UserBase base;

    @MessageMapping("/message")
    @SendTo("/chat/messages")
    public MessageOutput getMessages(MessageInput message) {
        System.out.println("[MSG] from: " + message.getFrom() + " | message: " + message.getMessage());
        String uName = base.getUserNameForUUID(message.getFrom());
        return MessageConventer.convert(message, uName);
    }
}
