package sparkles.events.listeners;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import sparkles.controllers.ReadyController;

import javax.security.auth.login.LoginException;

public class ReadyListener implements EventListener {
    /*public static void main(String[] args)
            throws LoginException {
        JDA jda = JDABuilder.createDefault(args[0])
                .addEventListeners(new ReadyListener()).build();
    }*/
    private static ReadyController rc;

    public ReadyListener(ReadyController rc) {
        this.rc=rc;
    }

    @Override
    public void onEvent(GenericEvent event) {
        if(event instanceof ReadyEvent)
            System.out.println("API is ready!");
    }
}