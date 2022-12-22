package by.antonov.ya_studio_finance_bot.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class BalanceData {

    @JsonIgnore
    private Long chatId;
    private Long savings;
    private Long debt;
    private Long balance;

    @Override
    public String toString() {
        return  "Накопления:\t" + savings +
                "\nДолги:\t" + debt +
                "\nБаланс:\t" + balance;
    }
}
