package by.antonov.ya_studio_finance_bot.service;

import by.antonov.ya_studio_finance_bot.util.BalanceData;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

import static by.antonov.ya_studio_finance_bot.util.Constants.DATA_FILE;

@Service
public class DataLoadService {

    ObjectMapper objectMapper;
    BalanceData balanceData;

    @Autowired
    public DataLoadService(ObjectMapper objectMapper, BalanceData balanceData) {
        this.objectMapper = objectMapper;
        this.balanceData = balanceData;
    }

    public BalanceData loadInfo() {

        try {
            balanceData = objectMapper.readValue(new File(DATA_FILE), BalanceData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return balanceData;
    }

    public void saveInfo() {

        try {
            objectMapper.writeValue(new File(DATA_FILE), balanceData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
