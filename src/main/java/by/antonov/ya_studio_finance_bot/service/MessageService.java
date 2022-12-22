package by.antonov.ya_studio_finance_bot.service;

import by.antonov.ya_studio_finance_bot.commands.HelpCommand;
import by.antonov.ya_studio_finance_bot.commands.SettingsCommand;
import by.antonov.ya_studio_finance_bot.commands.StartCommand;
import by.antonov.ya_studio_finance_bot.commands.UnknownCommand;
import org.checkerframework.checker.units.qual.K;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import static by.antonov.ya_studio_finance_bot.util.Constants.*;

@Service
public class MessageService {

    public SendMessage onUpdateReceived(Update update) {

        KeyboardFactory keyboardFactory = new KeyboardFactory();
        SendMessage sendMessage = new SendMessage();

        if (update != null) {
            Message message = update.getMessage();

            sendMessage.setChatId(String.valueOf(message.getChatId()));

            if (message != null && message.hasText()) {
                String messageText = message.getText();

                switch (messageText) {
                    case START:
                        keyboardFactory.startButtons(sendMessage);
                        StartCommand startCommand = new StartCommand();
                        startCommand.execute(sendMessage);
                        break;
                    case HELP:
                        HelpCommand helpCommand = new HelpCommand();
                        helpCommand.execute(sendMessage);
                        break;
                    case SETTINGS:
                        SettingsCommand settingsCommand = new SettingsCommand();
                        settingsCommand.execute(sendMessage);
                        break;
                    default:
                        UnknownCommand unknownCommand = new UnknownCommand();
                        unknownCommand.execute(sendMessage);
                }
            }
        }
        return sendMessage;
    }
}
