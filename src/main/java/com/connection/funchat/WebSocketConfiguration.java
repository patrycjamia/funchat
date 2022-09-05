package com.connection.funchat;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration extends AbstractWebSocketMessageBrokerConfigurer  {
	
        @Override
	public void configureMessageBroker(MessageBrokerRegistry confi) {
		confi.enableSimpleBroker("/chat");
		confi.setApplicationDestinationPrefixes("/app");
	}

        @Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/chat-messaging").withSockJS();
		
	}

}
