package by.antonov.ya_studio_finance_bot.executeCommands;

import by.antonov.ya_studio_finance_bot.util.BalanceData;
import org.springframework.stereotype.Service;

@Service
public class ExecuteCommand {

    public BalanceData plusSavings(BalanceData balanceData, String value) {
        balanceData.setSavings(String.valueOf(Double.parseDouble(balanceData.getSavings()) + Double.parseDouble(value)));
        balanceData.setBalance(String.valueOf(Double.parseDouble(balanceData.getSavings()) + Double.parseDouble(balanceData.getDebt())));
        return balanceData;
    }

    public BalanceData minusSavings(BalanceData balanceData, String value) {
        balanceData.setSavings(String.valueOf(Double.parseDouble(balanceData.getSavings()) - Double.parseDouble(value)));
        balanceData.setBalance(String.valueOf(Double.parseDouble(balanceData.getSavings()) + Double.parseDouble(balanceData.getDebt())));
        return balanceData;
    }

    public BalanceData borrow(BalanceData balanceData, String value) {
        balanceData.setDebt(String.valueOf(Double.parseDouble(balanceData.getDebt()) + Double.parseDouble(value)));
        balanceData.setBalance(String.valueOf(Double.parseDouble(balanceData.getSavings()) + Double.parseDouble(balanceData.getDebt())));
        return balanceData;
    }

    public BalanceData lend(BalanceData balanceData, String value) {
        balanceData.setDebt(String.valueOf(Double.parseDouble(balanceData.getDebt()) - Double.parseDouble(value)));
        balanceData.setBalance(String.valueOf(Double.parseDouble(balanceData.getSavings()) + Double.parseDouble(balanceData.getDebt())));
        return balanceData;
    }
}
