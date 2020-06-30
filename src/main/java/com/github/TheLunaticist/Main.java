package com.github.TheLunaticist;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

import com.github.TheLunaticist.SetChannelCommand;

public class Main {
	
	static long supportChannelID;
	static long supportRequestMessageID;
	
	static String confirmationEmoji = "✅";
	
	public static void main(String[] args) {

		if(args.length < 1) {
			System.out.println("You need to enter a bot token.");
			System.exit(0);
		}
	
		DiscordApi api = new DiscordApiBuilder().setToken(args[0]).login().join();
		System.out.println("Logged in");		
									
		api.addMessageCreateListener(new SetChannelCommand());
		api.addReactionAddListener(new SendMessageToUser());
	}
}
