package newbot;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class newOne extends ListenerAdapter {

	
	private static JDA jda;
	private static String tag ;

	public static void main(String[] args) throws LoginException {

		jda = JDABuilder.createDefault("ODEwMzg3NTgzOTA4OTcwNTE4.YCi6QA.-Wd86WdU6oF6T-7q6jIpasZOr-4").build();
		jda.addEventListener(new newOne());
		jda.getPresence().setStatus(OnlineStatus.ONLINE);

	}

	@Override
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) 
	{
		
		tag = event.getMessage().getContentDisplay();

		if (tag.equalsIgnoreCase("!hello"))
		{
			MessageBuilder builder = new MessageBuilder();
			builder.append("\nPlease format your code using the following format:\n");
			builder.append("\\`\\`\\`java\n");
			builder.append("//your code");
			builder.append("\n\\`\\`\\`");
			builder.append("\n Which will result in a code block such as :");
			builder.appendCodeBlock("int x = 3;\nSystem.out.println(x);", "java");
			event.getChannel().sendMessage(builder.build()).queue();

		}

	}
}