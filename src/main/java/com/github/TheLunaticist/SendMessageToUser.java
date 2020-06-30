package com.github.TheLunaticist;

import java.util.Optional;

import org.javacord.api.event.message.reaction.ReactionAddEvent;
import org.javacord.api.listener.message.reaction.ReactionAddListener;
import org.javacord.api.entity.user.User;

import org.javacord.api.entity.message.Message;

public class SendMessageToUser implements ReactionAddListener {

	public void onReactionAdd(ReactionAddEvent event) {
		
		Optional<Message> optionalMessage;
		User user;
		long messageID;
		
		optionalMessage = event.getMessage();
		
		if(optionalMessage.isPresent() == true) {
			messageID = optionalMessage.get().getId();
		}	else {
			return;
		}
		
		if(messageID == Main.supportRequestMessageID) {
			user = event.getUser();
			user.sendMessage("Hello " + user.getDiscriminatedName());
		}
	}
}
