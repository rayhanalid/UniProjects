package com.PATCH.PetDatingApp.configuration;//package com.PATCH.PetDatingApp.configuration;//package com.PATCH.PetDatingApp.configuration;


import com.PATCH.PetDatingApp.repository.MessageRepository;
import com.PATCH.PetDatingApp.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.support.ExecutorSubscribableChannel;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.*;
import com.PATCH.PetDatingApp.websocket.MyWebSocketHandler;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final MessageService messageService;
    private final MessageRepository messageRepository;

    public WebSocketConfig(MessageService messageService, MessageRepository messageRepository) {
        this.messageService = messageService;
        this.messageRepository = messageRepository;

    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(WebSocketHandler(), "/ws").setAllowedOrigins("*");
    }

    @Bean
    public MyWebSocketHandler WebSocketHandler() {
        return new MyWebSocketHandler(messageService, messageRepository, template());
    }


    @Bean
    public WebSocketHandler myHandler() {
        return new MyWebSocketHandler(messageService, messageRepository, template());
    }
    @Bean
    public SimpMessagingTemplate template() {
        return new SimpMessagingTemplate(clientInboundChannel());
    }

    @Bean
    public MessageChannel clientInboundChannel() {
        return new ExecutorSubscribableChannel();
    }



}
