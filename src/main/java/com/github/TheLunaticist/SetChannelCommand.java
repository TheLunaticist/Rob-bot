package com.github.TheLunaticist;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;
import org.javacord.api.entity.message.Message;

import org.javacord.api.entity.channel.TextChannel;

import com.github.TheLunaticist.Main;

public class SetChannelCommand implements MessageCreateListener {
	
	final String prefix = "$";
	final String empty = " ";
	final String body = "setHome";
	
	
	public void onMessageCreate(MessageCreateEvent event) {
		Message message = event.getMessage();
		String messageContent = message.getContent();
		
		TextChannel channel = message.getChannel();
		CompletableFuture<Message> futureMessage;
		
		if(messageContent.equals(prefix + empty + body)) {
			futureMessage = channel.sendMessage("Hier kannst du dich für ein Support-ticket regestrieren. Reagiere einfach mit einem grühnen Haken auf diese Nachricht.");
			
			try {
				Message infoMessage = futureMessage.get();
				infoMessage.addReaction(Main.confirmationEmoji);
				Main.supportRequestMessageID = infoMessage.getId();
			}	catch(InterruptedException e){
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
