package com.blackcj.customkeyboard.BCAClient;

    import java.util.ArrayList;
    import java.util.List;

    import com.blackcj.customkeyboard.BCAClient.MutasiItemResponse;
    import com.blackcj.customkeyboard.MutasiItem;
    import com.google.gson.annotations.Expose;
    import com.google.gson.annotations.SerializedName;

public class MutasiResponse {

    @SerializedName("StartDate")
    @Expose
    private String startDate;
    @SerializedName("EndDate")
    @Expose
    private String endDate;
    @SerializedName("Currency")
    @Expose
    private String currency;
    @SerializedName("StartBalance")
    @Expose
    private String startBalance;
    @SerializedName("Data")
    @Expose
    private ArrayList<MutasiItemResponse> data = null;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getStartBalance() {
        return startBalance;
    }

    public void setStartBalance(String startBalance) {
        this.startBalance = startBalance;
    }

    public ArrayList<MutasiItemResponse> getData() {
        return data;
    }

    public void setData(ArrayList<MutasiItemResponse> data) {
        this.data = data;
    }

}
