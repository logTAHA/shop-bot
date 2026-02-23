package org.example.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BotConfig {
    private static final BotConfig instance = new BotConfig();

    private String token;
    private String username;
    private String adminChatId;

    private BotConfig() {
        loadProperties();
    }

    public static BotConfig getInstance() {
        return instance;
    }

    private void loadProperties() {
        Properties properties = new Properties();
        // read config.properties
        try(InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                // TODO: Add error to log
                return;
            }

            properties.load(input);
            this.token = properties.getProperty("bot.token");
            this.username = properties.getProperty("bot.username");
            this.adminChatId = properties.getProperty("bot.admin.chatId");
        } catch (IOException e) {
            // TODO: Add error to log
        }
    }

    public String getToken() {
        return token;
    }

    public String getUsername() {
        return username;
    }

    public String getAdminChatId() {
        return adminChatId;
    }
}
