package sparkles.controllers;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sparkles.events.listeners.MessageListener;
import sparkles.events.listeners.ReadyListener;
import sparkles.utilities.Utilities;
import sparkles.watson.models.WatsonAssistant;

import javax.security.auth.login.LoginException;

public class DiscordBotController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DiscordBotController.class);
    public static void main(String[] args) {
        //WatsonAssistant wa = new WatsonAssistant();
        test();

        try {
            DiscordBotController.startBot();

        } catch (LoginException e) {
            throw new RuntimeException(e);
        }
    }

    private static void test() {

    }

    public static void startBot() throws LoginException {
        LOGGER.info("Comenzando creacion del bot");
        Utilities utils = new Utilities();
        JDA bot = JDABuilder.createDefault(utils.getResource("sparkles.token", "SparklesConfig.properties")).setActivity(Activity.playing("with some unicorns in the rainbow")).build();
        MessageController mc = new MessageController();
        ReadyController rc = new ReadyController();
        bot.addEventListener(new MessageListener(mc));
        bot.addEventListener(new ReadyListener(rc));
        LOGGER.info("Bot iniciado\n"+"Directorio: "+System.getProperty("user.dir")+"\nHome: "+System.getProperty("user.home"));
    }
}
