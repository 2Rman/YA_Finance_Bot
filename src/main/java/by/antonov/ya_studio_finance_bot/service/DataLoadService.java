package by.antonov.ya_studio_finance_bot.service;

import by.antonov.ya_studio_finance_bot.config.BalanceData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

import static by.antonov.ya_studio_finance_bot.util.Constants.DATA_FILE;

@Component
@Service
public class DataLoadService {

    @Autowired
    BalanceData balanceData;
    @Autowired
    ObjectMapper objectMapper;

    public BalanceData getBalanceData() {

        try {
            balanceData = objectMapper.readValue(new File(DATA_FILE), BalanceData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return balanceData;
    }
}
