package by.antonov.ya_studio_finance_bot.commands;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public interface Command {

    void execute(SendMessage sendMessage);
}
