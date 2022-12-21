package by.antonov.ya_studio_finance_bot.commands;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import static util.Constants.DONT_KNOW_M;

public class UnknownCommand implements Command{
    @Override
    public void execute(SendMessage sendMessage) {
        sendMessage.setText(DONT_KNOW_M);
    }
}
