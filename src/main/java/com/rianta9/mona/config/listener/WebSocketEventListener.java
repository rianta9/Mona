//////////////////////////////////////////////////////
//
// * Code For Fun *_^
//
//////////////////////////////////////////////////////
package com.rianta9.mona.config.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.rianta9.mona.model.ChatMessage;
import com.rianta9.mona.model.enums.MessageType;

/**
 * This class is used for ...
 * 
 * @project Mona
 * @author rianta9
 * @date_created 17 thg 9, 2021
 * @version 1.0
 * @see
 */

@Component
public class WebSocketEventListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketEventListener.class);

	@Autowired
	private SimpMessageSendingOperations sendingOperation;

	@EventListener
	public void handleWebSocketConnectListener(final SessionConnectedEvent event) {
		LOGGER.info("We have a new connection.");
	}

	@EventListener
	public void handleWebSocketDisconnectListener(final SessionDisconnectEvent event) {
		final StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

		final String userName = (String) headerAccessor.getSessionAttributes().get("username");

		final ChatMessage chatMessage = ChatMessage.builder()
				.messageType(MessageType.DISCONECT)
				.sender(userName)
				.build();
		sendingOperation.convertAndSend("/topic/public", chatMessage);
	}
}
