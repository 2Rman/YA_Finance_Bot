package by.antonov.ya_studio_finance_bot.commands;

import by.antonov.ya_studio_finance_bot.config.BalanceData;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class BalanceCommand implements Command{

    @Autowired
    BalanceData balanceData;

    @Override
    public void execute(SendMessage sendMessage) {
        sendMessage.setText(balanceData.toString());
    }
}
