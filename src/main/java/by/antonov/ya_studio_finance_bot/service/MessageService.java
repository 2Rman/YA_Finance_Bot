package by.antonov.ya_studio_finance_bot.service;

import by.antonov.ya_studio_finance_bot.commands.*;
import by.antonov.ya_studio_finance_bot.config.BalanceData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.checkerframework.checker.units.qual.K;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import static by.antonov.ya_studio_finance_bot.util.Constants.*;

@Service
public class MessageService {

    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    BalanceData balanceData;
    @Autowired
    DataLoadService dataLoadService;

    public SendMessage onUpdateReceived(Update update) {

        KeyboardFactory keyboardFactory = new KeyboardFactory();
        SendMessage sendMessage = new SendMessage();

        if (update != null) {
            Message message = update.getMessage();

            sendMessage.setChatId(String.valueOf(message.getChatId()));
            balanceData = dataLoadService.getBalanceData();

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
                    case BALANCE:
//                        BalanceCommand balanceCommand = new BalanceCommand();
//                        balanceCommand.execute(sendMessage);
                        sendMessage.setText(balanceData.toString());
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
