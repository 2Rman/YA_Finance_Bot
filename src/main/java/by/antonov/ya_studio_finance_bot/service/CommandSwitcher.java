package by.antonov.ya_studio_finance_bot.service;

import by.antonov.ya_studio_finance_bot.executeCommands.*;
import by.antonov.ya_studio_finance_bot.util.BalanceData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import static by.antonov.ya_studio_finance_bot.util.Constants.*;

@Service
public class CommandSwitcher {

    BalanceData balanceData;
    DataLoadService dataLoadService;
    ExecuteCommand executeCommand;

    @Autowired
    public CommandSwitcher(DataLoadService dataLoadService, ExecuteCommand executeCommand) {

        this.dataLoadService = dataLoadService;
        this.balanceData = dataLoadService.loadInfo();
        this.executeCommand = executeCommand;
    }

    public void switchHandlerCommand(KeyboardFactory keyboardFactory, SendMessage sendMessage, String messageText) {

        switch (messageText) {
            case START:
                keyboardFactory.insertKeyboard(sendMessage);
                sendMessage.setText(START_M);
                break;
            case HELP_C:
                sendMessage.setText(HELP_M);
                break;
            case SETTINGS_C:
                sendMessage.setText(SETTINGS_M);
                break;
            case BALANCE_C:
                sendMessage.setText(balanceData.toString());
                keyboardFactory.insertKeyboard(sendMessage);
                break;
            case PLUS_SAVINGS_C:
                sendMessage.setText(PLUS_SAVINGS_M);
                break;
            case MINUS_SAVINGS_C:
                sendMessage.setText(MINUS_SAVINGS_M);
                break;
            case BORROW_C:
                sendMessage.setText(BORROW_M);
                break;
            case LEND_C:
                sendMessage.setText(LEND_M);
                break;
            default:
                break;
        }
    }

    /**TODO
     *  сделать валидацию вводимых данных */
    /**
     * Метод выполнения команды изменения сумм баланса
     * @param value значение, на которое необходимо изменить баланс, должен проходить валидацию
     */
    public void switchCommandExecutor(String command, String value) {
        switch (command) {
            case PLUS_SAVINGS_C:
                balanceData = executeCommand.plusSavings(balanceData, value);
                break;
            case MINUS_SAVINGS_C:
                executeCommand.minusSavings(balanceData, value);
                break;
            case BORROW_C:
                executeCommand.borrow(balanceData, value);
                break;
            case LEND_C:
                executeCommand.lend(balanceData, value);
                break;
            default:
                break;
        }
        dataLoadService.saveInfo();
    }
}
