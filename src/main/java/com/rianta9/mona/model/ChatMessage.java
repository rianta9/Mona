//////////////////////////////////////////////////////
//
// * Code For Fun *_^
//
//////////////////////////////////////////////////////
package com.rianta9.mona.model;

import com.rianta9.mona.model.enums.MessageType;

import lombok.Builder;
import lombok.Getter;

/**
 * This class is used for ...
 * @project Mona
 * @author rianta9
 * @date_created 17 thg 9, 2021
 * @version 1.0
 * @see 
 */
@Builder
@Getter
public class ChatMessage {

	private MessageType messageType;
	
	private String content;
	
	private String sender;
	
	private String time;
}
