package by.antonov.ya_studio_finance_bot.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

import static by.antonov.ya_studio_finance_bot.util.Constants.*;

public class KeyboardFactory {

    public SendMessage insertKeyboard(SendMessage sendMessage) {

        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> firstRow = new ArrayList<>();
        List<InlineKeyboardButton> secondRow = new ArrayList<>();
        List<InlineKeyboardButton> thirdRow = new ArrayList<>();


        InlineKeyboardButton buttonHelp = new InlineKeyboardButton();
        InlineKeyboardButton buttonPlusSavings = new InlineKeyboardButton();
        InlineKeyboardButton buttonBorrow = new InlineKeyboardButton();

        InlineKeyboardButton buttonSettings = new InlineKeyboardButton();
        InlineKeyboardButton buttonMinusSavings = new InlineKeyboardButton();
        InlineKeyboardButton buttonLend = new InlineKeyboardButton();

        InlineKeyboardButton buttonBalance = new InlineKeyboardButton();


        buttonHelp.setText(HELP);
        buttonHelp.setCallbackData(HELP_C);

        buttonPlusSavings.setText(PLUS_SAVINGS);
        buttonPlusSavings.setCallbackData(PLUS_SAVINGS_C);

        buttonBorrow.setText(BORROW);
        buttonBorrow.setCallbackData(BORROW_C);

        buttonSettings.setText(SETTINGS);
        buttonSettings.setCallbackData(SETTINGS_C);

        buttonMinusSavings.setText(MINUS_SAVINGS);
        buttonMinusSavings.setCallbackData(MINUS_SAVINGS_C);

        buttonLend.setText(LEND);
        buttonLend.setCallbackData(LEND_C);

        buttonBalance.setText(BALANCE);
        buttonBalance.setCallbackData(BALANCE_C);

        firstRow.add(buttonHelp);
        firstRow.add(buttonPlusSavings);
        firstRow.add(buttonBorrow);

        secondRow.add(buttonSettings);
        secondRow.add(buttonMinusSavings);
        secondRow.add(buttonLend);

        thirdRow.add(buttonBalance);

        rowList.add(firstRow);
        rowList.add(secondRow);
        rowList.add(thirdRow);

        keyboardMarkup.setKeyboard(rowList);

        sendMessage.setReplyMarkup(keyboardMarkup);

        return sendMessage;
    }

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
