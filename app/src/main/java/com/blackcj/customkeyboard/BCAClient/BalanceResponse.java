package com.blackcj.customkeyboard.BCAClient;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BalanceResponse {

    @SerializedName("AccountNumber")
    @Expose
    private String accountNumber;
    @SerializedName("Currency")
    @Expose
    private String currency;
    @SerializedName("Balance")
    @Expose
    private String balance;
    @SerializedName("AvailableBalance")
    @Expose
    private String availableBalance;
    @SerializedName("FloatAmount")
    @Expose
    private String floatAmount;
    @SerializedName("HoldAmount")
    @Expose
    private String holdAmount;
    @SerializedName("Plafon")
    @Expose
    private String plafon;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(String availableBalance) {
        this.availableBalance = availableBalance;
    }

    public String getFloatAmount() {
        return floatAmount;
    }

    public void setFloatAmount(String floatAmount) {
        this.floatAmount = floatAmount;
    }

    public String getHoldAmount() {
        return holdAmount;
    }

    public void setHoldAmount(String holdAmount) {
        this.holdAmount = holdAmount;
    }

    public String getPlafon() {
        return plafon;
    }

    public void setPlafon(String plafon) {
        this.plafon = plafon;
    }

}