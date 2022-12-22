package by.antonov.ya_studio_finance_bot.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

import static by.antonov.ya_studio_finance_bot.util.Constants.*;

public class KeyboardFactory {

    public SendMessage startButtons(SendMessage sendMessage) {

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();

        sendMessage.setReplyMarkup(keyboardMarkup);

        keyboardMarkup.setSelective(true);
        keyboardMarkup.setResizeKeyboard(true);
        keyboardMarkup.setOneTimeKeyboard(false);

        //List of keyboard rows
        List<KeyboardRow> keyboard = new ArrayList<>();

        //First row
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        //Buttons adding
        keyboardFirstRow.add(HELP);
        keyboardFirstRow.add(PLUS_SAVINGS);
        keyboardFirstRow.add(BORROW);

        //SecondRow
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        //Buttons adding
        keyboardSecondRow.add(SETTINGS);
        keyboardSecondRow.add(MINUS_SAVINGS);
        keyboardSecondRow.add(LEND);

        //Third row
        KeyboardRow keyboardThirdRow = new KeyboardRow();
        //Button adding
        keyboardThirdRow.add(BALANCE);

        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);
        keyboard.add(keyboardThirdRow);

        keyboardMarkup.setKeyboard(keyboard);

        sendMessage.setReplyMarkup(keyboardMarkup);

        return sendMessage;

    }
}
