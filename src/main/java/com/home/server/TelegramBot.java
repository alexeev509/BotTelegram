package com.home.server;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.logging.Level;

public class TelegramBot extends TelegramLongPollingBot {


    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();
        sendMsg(update.getMessage().getChatId().toString(), message);
    }

    public String getBotUsername() {
        return "BotKrasacheg";
    }

    public String getBotToken() {
        return "BotToken";
    }

    public synchronized void sendMsg(String chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
           // log.log(Level.SEVERE, "Exception: ", e.toString());
        }
    }

}
