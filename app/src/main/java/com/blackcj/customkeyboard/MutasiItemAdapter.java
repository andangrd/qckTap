package com.blackcj.customkeyboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.blackcj.customkeyboard.BCAClient.MutasiItemResponse;

import java.util.ArrayList;

/**
 * Created by mitrais on 8/26/17.
 */

public class MutasiItemAdapter extends ArrayAdapter<MutasiItemResponse> {
    private Context mContext;
    public MutasiItemAdapter(Context context, ArrayList<MutasiItemResponse> items) {
        super(context, 0, items);
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        MutasiItemResponse item = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.mutasi_listview, parent, false);
        }
        // Lookup view for data population
        TextView namaText = (TextView) convertView.findViewById(R.id.nama_text);
        TextView dateText = (TextView) convertView.findViewById(R.id.date_text);
        TextView amountText = (TextView) convertView.findViewById(R.id.amount_text);

        // Populate the data into the template view using the data object
        namaText.setText(item.getTrailer());
        dateText.setText(item.getTransactionDate());
        float balance = Float.parseFloat(item.getTransactionAmount());

        if(item.getTransactionType().equals("D")) {
            amountText.setText("-".concat(Util.getBalance(balance, "IDR")));
            amountText.setTextColor(mContext.getResources().getColor(R.color.pomegranate));
        } else {
            amountText.setText("+".concat(Util.getBalance(balance, "IDR")));
            amountText.setTextColor(mContext.getResources().getColor(R.color.greenSea));
        }

        // Return the completed view to render on screen
        return convertView;
    }
}