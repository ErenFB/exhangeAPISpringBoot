package com.exhange.exhangeAPI.Entity;

public class MoneyEntity {

    public String moneyName;
    public Number moneyAmount;

    public MoneyEntity(String moneyName, Number moneyAmount) {
        this.moneyName = moneyName;
        this.moneyAmount = moneyAmount;
    }

    public String getMoneyName() {
        return moneyName;
    }

    public void setMoneyName(String moneyName) {
        this.moneyName = moneyName;
    }

    public Number getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(Number moneyAmount) {
        this.moneyAmount = moneyAmount;
    }


}
