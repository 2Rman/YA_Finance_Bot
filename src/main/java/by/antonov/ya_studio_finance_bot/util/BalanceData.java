package by.antonov.ya_studio_finance_bot.util;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class BalanceData {

    private String chatId;
    private String savings;
    private String debt;
    private String balance;

    @Override
    public String toString() {
        return  "Накопления:\t" + savings +
                "\nДолг:\t" + debt +
                "\n\nБаланс:\t" + balance;
    }
}
