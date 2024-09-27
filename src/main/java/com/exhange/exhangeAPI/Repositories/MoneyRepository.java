package com.exhange.exhangeAPI.Repositories;

import com.exhange.exhangeAPI.Entity.MoneyEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class MoneyRepository {

    public String URL = "https://v6.exchangerate-api.com/v6/051afafda370a485425c93d3/latest/USD";

    public List<MoneyEntity> getAllMoneys() {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> response = restTemplate.getForObject(URL, Map.class);
        List<MoneyEntity> moneyEntities = new ArrayList<>();

        if (response != null && response.containsKey("conversion_rates")) {
            Map<String, Object> rates = (Map<String, Object>) response.get("conversion_rates");

            for (Map.Entry<String, Object> entry : rates.entrySet()) {
                Number rate = (Number) entry.getValue();
                moneyEntities.add(new MoneyEntity(entry.getKey(), rate.floatValue()));
            }
        }
        return moneyEntities;
    }


    public MoneyEntity getMoneyByName(String moneyName) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> response = restTemplate.getForObject(URL, Map.class);

        if (response != null && response.containsKey("conversion_rates")) {
            Map<String, Object> rates = (Map<String, Object>) response.get("conversion_rates");

            if (rates.containsKey(moneyName)) {
                Number rate = (Number) rates.get(moneyName);
                return new MoneyEntity(moneyName, rate.floatValue());
            }
        }
        return null;
    }


}
