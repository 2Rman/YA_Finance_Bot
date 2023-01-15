package by.antonov.ya_studio_finance_bot.util;

public class Constants {

//    ------------BUTTON TEXT---------------  //
    public static final String START = "/start";
    public static final String HELP = "Помощь";
    public static final String SETTINGS = "Настройки";
    public static final String PLUS_SAVINGS = "+ в копилку";
    public static final String MINUS_SAVINGS = "- из копилки";
    public static final String BORROW = "Взять в студии";
    public static final String LEND = "Дать студии";
    public static final String BALANCE = "БАЛАНС";


//    ------------COMMANDS---------------  //
    public static final String HELP_C = "/help";
    public static final String SETTINGS_C = "/settings";
    public static final String PLUS_SAVINGS_C = "/plus_savings";
    public static final String MINUS_SAVINGS_C = "/minus_savings";
    public static final String BORROW_C = "/borrow";
    public static final String LEND_C = "/lend";
    public static final String BALANCE_C = "/balance";

//    ------------MESSAGES-----------------//
    public static final String START_M = "Привет!";
    public static final String DONT_KNOW_M = "Я не знаю такой команды.";
    public static final String SETTINGS_M = "Здесь будут мои настройки.";
    public static final String PLUS_SAVINGS_M = "Сколько положить?";
    public static final String MINUS_SAVINGS_M = "Сколько снять?";
    public static final String BORROW_M = "Сколько одолжить?";
    public static final String LEND_M = "Сколько дать в долг?";
    public static final String BALANCE_M = "Текущий баланс";
    public static final String HELP_M = "\n                          >Версия 1.0.2<" +
            "\n" +
            "\n\t\"Накопления\" - какая сумма сейчас в студии реально." +
            "\n\t\"Долг\" - кто сколько кому должен. Если сумма со знаком \"-\" это значит, что студия нам должна, " +
            "если без знака (т.е. положительная) - значит мы должны студии." +
            "\n\t\"Баланс\" - показывает сколько будет денег в студии с учетом долгов." +
            "\n" +
            "\n\tКнопка \"+ в копилку\" - добавить в \"Накопления\"." +
            "\n\tКнопка \"- из копилки\" - отнять из суммы в \"Накоплениях\"." +
            "\n\tКнопка \"Взять в студии\" - взять в долг у студии. Сумма \"Долг\" изменится в положительную сторону," +
            " а \"Накопления\" уменьшится." +
            "\n\tКнопка \"Дать студии\" - дать в долг студии. Сумма \"Долг\" изменится в отрицательную сторону." +
            "\n" +
            "\n\"Настройки\" - в разработке. Пока неясно насколько они вообще нужны...";
//    -------------PATHS----------------- //
    public static final String DATA_FILE = "/home/user/ya_bot/data.json";
//    public static final String DATA_FILE = "d:/ENGINEERING/JAVA/YAStudioFinanceBot/src/main/resources/data.json";
}
