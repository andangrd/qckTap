package com.blackcj.customkeyboard;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by mitrais on 8/27/17.
 */

public class Util {
    public static String getBalance(float balance, String currency) {
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.ENGLISH);
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
        otherSymbols.setDecimalSeparator(',');
        otherSymbols.setGroupingSeparator('.');
        DecimalFormat df = new DecimalFormat("#,###,###,##0.00", otherSymbols);
        String balanceString = df.format(balance);

        return currency
            .toUpperCase()
            .concat(" ")
            .concat(balanceString);
    }
}
