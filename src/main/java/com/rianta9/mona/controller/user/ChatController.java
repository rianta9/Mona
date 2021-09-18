//////////////////////////////////////////////////////
//
// * Code For Fun *_^
//
//////////////////////////////////////////////////////
package com.rianta9.mona.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rianta9.mona.model.ChatMessage;
import com.rianta9.mona.security.UserContext;

/**
 * This class is used for ...
 * @project Mona
 * @author rianta9
 * @date_created 17 thg 9, 2021
 * @version 1.0
 * @see 
 */
@Controller
public class ChatController {
	@Autowired
	private UserContext userContext;
	
	@MessageMapping("/chat.send")
	@SendTo("/topic/public")
	public ChatMessage sendMessage(@Payload final ChatMessage chatMessage) {
		
		return chatMessage;	
	}
	
	@MessageMapping("/chat.newUser")
	@SendTo("/topic/public")
	public ChatMessage newUser(@Payload final ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		return chatMessage;	
	}
	
	@RequestMapping("/")
	public String chat() {
		return "/index.html";
	}
}
