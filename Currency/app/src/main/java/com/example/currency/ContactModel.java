package com.example.currency;

public class ContactModel {
    String name;
    String currencyName;
    String acronymCurrency;
    int symbol;
    double rate;

    public ContactModel(String name, String currencyName, String acronymCurrency, int symbol, double rate) {
        this.name = name;
        this.currencyName = currencyName;
        this.acronymCurrency = acronymCurrency;
        this.symbol = symbol;
        this.rate = rate;
    }

    public String getAcronymCurrency() {
        return acronymCurrency;
    }

    public void setAcronymCurrency(String acronymCurrency) {
        this.acronymCurrency = acronymCurrency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public int getSymbol() {
        return symbol;
    }

    public void setSymbol(int symbol) {
        this.symbol = symbol;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
