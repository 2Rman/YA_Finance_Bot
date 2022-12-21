package by.antonov.ya_studio_finance_bot.commands;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import static util.Constants.SETTINGS_M;

public class SettingsCommand implements Command{
    @Override
    public void execute(SendMessage sendMessage) {
        sendMessage.setText(SETTINGS_M);
    }
}
