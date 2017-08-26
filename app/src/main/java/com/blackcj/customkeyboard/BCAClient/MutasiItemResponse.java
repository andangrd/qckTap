package com.blackcj.customkeyboard.BCAClient;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MutasiItemResponse {

    @SerializedName("TransactionDate")
    @Expose
    private String transactionDate;
    @SerializedName("BranchCode")
    @Expose
    private String branchCode;
    @SerializedName("TransactionType")
    @Expose
    private String transactionType;
    @SerializedName("TransactionAmount")
    @Expose
    private String transactionAmount;
    @SerializedName("TransactionName")
    @Expose
    private String transactionName;
    @SerializedName("Trailer")
    @Expose
    private String trailer;

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

}