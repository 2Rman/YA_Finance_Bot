package by.antonov.ya_studio_finance_bot.commands;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import static by.antonov.ya_studio_finance_bot.util.Constants.HELP_M;

public class HelpCommand implements Command{
    @Override
    public void execute(SendMessage sendMessage) {
        sendMessage.setText(HELP_M);
    }
}
