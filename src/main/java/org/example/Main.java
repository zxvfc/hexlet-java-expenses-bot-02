package org.example;

import java.io.IOException;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) throws TelegramApiException, IOException {
        System.out.println("Application starting!");
        DummyServer.startServer();
        TelegramBot telegramBot = new TelegramBot();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);

        System.out.println("Starting bot with token: " + telegramBot.getBotToken());
        telegramBotsApi.registerBot(telegramBot);
    }
}