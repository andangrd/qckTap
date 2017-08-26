package com.blackcj.customkeyboard.BCAClient;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TransferResponse {

    @SerializedName("TransactionID")
    @Expose
    private String transactionId;
    @SerializedName("TransactionDate")
    @Expose
    private String transactionDate;
    @SerializedName("ReferenceID")
    @Expose
    private String referenceId;
    @SerializedName("Status")
    @Expose
    private String status;

    @SerializedName("Receipt")
    @Expose
    private String receipt;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.status = receipt;
    }
}
