package by.antonov.ya_studio_finance_bot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import static by.antonov.ya_studio_finance_bot.util.Constants.*;

@Service
@PropertySource("application.properties")
public class MessageService {

    @Autowired
    ObjectMapper objectMapper;
    private final CommandSwitcher commandSwitcher;
    private final DeleteMassagesService deleteMassagesService;

    @Autowired
    public MessageService(CommandSwitcher commandSwitcher, DeleteMassagesService deleteMassagesService) {
        this.commandSwitcher = commandSwitcher;
        this.deleteMassagesService = deleteMassagesService;
    }

    @Value("${chat.id}")
    String[] chatIds;

    String previousCommand = "";

    public SendMessage onUpdateReceived(Update update) {

        KeyboardFactory keyboardFactory = new KeyboardFactory();
        SendMessage sendMessage = new SendMessage();

        if (update != null) {
            Message message = update.getMessage();
            CallbackQuery callbackQuery = update.getCallbackQuery();

            //Если СООБЩЕНИЕ != 0  И  ИМЕЕТ ТЕКСТ  И  ВЕРНЫЙ ЧАТ-id
            if (message != null && message.hasText() && isChatIdCorrect(String.valueOf(message.getChatId()), chatIds)) {
                sendMessage.setChatId(String.valueOf(message.getChatId()));
                String messageText = message.getText();

                commandSwitcher.switchHandlerCommand(keyboardFactory, sendMessage, messageText);
            //ИНАЧЕ ЕСЛИ   СООБЩЕНИЕ ОТ КЛАВИАТУРЫ  И  ВЕРНЫЙ ЧАТ-id
            } else if (callbackQuery != null && isChatIdCorrect(String.valueOf(callbackQuery.getMessage().getChatId()),chatIds)) {

                sendMessage.setChatId(String.valueOf(callbackQuery.getMessage().getChatId()));
                String messageText = callbackQuery.getData();

                previousCommand = callbackQuery.getData();
                commandSwitcher.switchHandlerCommand(keyboardFactory, sendMessage, messageText);
            }

            if (isCommandAction(previousCommand) && message != null) {
                deleteMassagesService.deleteMessages(String.valueOf(message.getChatId()), message.getMessageId());
                commandSwitcher.switchCommandExecutor(previousCommand, message.getText());
                commandSwitcher.switchHandlerCommand(keyboardFactory, sendMessage, BALANCE_C);
            }

            if (message != null) {
                previousCommand = message.getText();
            }
        }

        return sendMessage;
    }

    //Проверка id-шников чатов разрешенных чатов
    private boolean isChatIdCorrect(String currentChatId, String[] chatIdFromProps) {

        return chatIdFromProps[0].equals(currentChatId) || chatIdFromProps[1].equals(currentChatId) || chatIdFromProps[2].equals(currentChatId);
    }

    //Проверка предыдущей команды на корректность
    private boolean isCommandAction(String curCommand) {
        return curCommand.equals(PLUS_SAVINGS_C) || curCommand.equals(MINUS_SAVINGS_C)
                || curCommand.equals(BORROW_C) || curCommand.equals(LEND_C);
    }
}
