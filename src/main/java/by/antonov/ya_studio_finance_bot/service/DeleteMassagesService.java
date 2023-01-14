package by.antonov.ya_studio_finance_bot.service;

import by.antonov.ya_studio_finance_bot.YaStudioFinanceBotApplication;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;

@Service
public class DeleteMassagesService {

    public void deleteMessages(String chatId, int messageId) {

        for (int i = messageId; i > 0; i--) {
                DeleteMessage deleteMessage = new DeleteMessage(chatId, i);
        }
    }
}
