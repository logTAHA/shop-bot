package org.example;

import org.example.bot.Bot;
import org.example.config.BotConfig;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    static void main() {
        BotConfig config = BotConfig.getInstance();

        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new Bot(config.getToken(), config.getUsername()));
            System.out.println("Bot started!");
        } catch (Exception e) {
            // TODO: Add error to log
        }
    }
}
