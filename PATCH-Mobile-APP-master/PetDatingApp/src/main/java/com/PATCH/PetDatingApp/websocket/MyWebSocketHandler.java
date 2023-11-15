package com.PATCH.PetDatingApp.websocket;




import com.PATCH.PetDatingApp.model.Message;
import com.PATCH.PetDatingApp.repository.MessageRepository;
import com.PATCH.PetDatingApp.service.MessageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class MyWebSocketHandler extends TextWebSocketHandler {

    private final MessageService messageService;
    private List<WebSocketSession> sessions = new ArrayList<>();
    private MessageRepository messageRepository;
    private final SimpMessagingTemplate messagingTemplate;



    @Autowired
    public MyWebSocketHandler(MessageService messageService, MessageRepository messageRepository, SimpMessagingTemplate messagingTemplate){
        this.messageService = messageService;
        this.messageRepository = messageRepository;
        this.messagingTemplate = messagingTemplate;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // Handle connection establishment
    }



    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        // Handle transport errors
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        // Handle connection closure
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
//    @Override
//    public void handleMessage(WebSocketSession session, WebSocketMessage<?> webSocketMessage) throws Exception {
//        // Extract the message payload
//        String messagePayload = webSocketMessage.getPayload().toString();
//
//        // Process the received WebSocket message
//        // Add your custom logic here, such as validating the message, updating its status, etc.
//        // For example:
//        Message message = new Message();
//        message.setBody(messagePayload);
//        message.setStatus("received");
//
//        // Save the updated message
//        messageService.saveMessage(message);
//
//        // Optionally, you can send a response back to the client
//        String response = "Message received successfully!";
//
//    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) {
        // Fall back to handleTextMessage()
        if (message instanceof TextMessage) {
            handleTextMessage(session, (TextMessage) message);
        }
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        // Assuming the received message is in JSON format, deserialize it to Message object
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Message receivedMessage = objectMapper.readValue(message.getPayload(), Message.class);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String timestamp = sdf.format(new Date());
            String msid = "MSID-" + timestamp;
            receivedMessage.setMsid(msid);
            receivedMessage.setStatus("delivered");
            receivedMessage.setDateCreated(new Date());

            // Save the receivedMessage to the MongoDB collection
            messageService.saveMessage(receivedMessage);
            messagingTemplate.convertAndSend("/topic/messages", receivedMessage);
            ObjectMapper responseMapper = new ObjectMapper();
            String response = responseMapper.writeValueAsString(Map.of("message", "Message received successfully!"));

            try {
                session.sendMessage(new TextMessage(response));
            } catch (IOException e) {
                // Handle the exception if sending the confirmation message fails
                e.printStackTrace();
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
//            try {
//                // Send a confirmation message back to the client
//                String response = "Message received successfully!";
//                session.sendMessage(new TextMessage(response));
//            } catch (IOException e) {
//                // Handle the exception if sending the confirmation message fails
//                e.printStackTrace();
//            }
//
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
    }


//    @Override
//    public void handleTextMessage(WebSocketSession session, TextMessage message) {
//        // Assuming the received message is in JSON format, deserialize it to Message object
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            Message receivedMessage = objectMapper.readValue(message.getPayload(), Message.class);
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//            String timestamp = sdf.format(new Date());
//            String msid = "MSID-" + timestamp;
//            receivedMessage.setMsid(msid);
//            receivedMessage.setStatus("delivered");
//            receivedMessage.setDateCreated(new Date());
//
//            // Save the receivedMessage to the MongoDB collection
//            messageService.saveMessage(receivedMessage);
//
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//    }

    String getPid1(WebSocketSession session) {
        // Lookup sender pet ID from session
        return null;
    }


    private String getPid2(WebSocketSession session) {
        return null;
    }

//    @Bean
//    public MyWebSocketHandler myWebSocketHandler(MessageService messageService) {
//        return new MyWebSocketHandler(messageService);
//    }


}


