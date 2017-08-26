package com.blackcj.customkeyboard;

import android.content.Context;
import android.inputmethodservice.InputMethodService;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mitrais on 8/26/17.
 */

public class MutasiView extends FrameLayout {
    private LayoutInflater layoutInflater;
    private StackNav stackNav;
    private List<String> mutasiData;

    // Modules

    // View

    public MutasiView(StackNav _stackNav) {
        super(_stackNav.getInputMethodService().getApplicationContext());
        this.stackNav = _stackNav;

        // Init
        inflate();
        bindViews();
        callApi();
    }

    private void callApi() {

        mutasiData = new ArrayList<String>();
        mutasiData.add("Havit - IDR. 100.000");
        mutasiData.add("Andang - IDR. 200.000");
        mutasiData.add("Abaka82 - IDR. 500.000");
        mutasiData.add("Yoga - IDR. 9.000.000");
        Context context = stackNav.getInputMethodService().getApplicationContext();
        ArrayAdapter adapter = new ArrayAdapter<String>(context, R.layout.mutasi_listview, mutasiData);

        ListView listView = (ListView) findViewById(R.id.mutasi_list);
        listView.setAdapter(adapter);
    }

    private void inflate() {
        Context context = this.stackNav.getInputMethodService().getApplicationContext();
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.mutasi, this, true);
    }

    private void bindViews() {
        Button backButton = (Button) findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stackNav.popView();
            }
        });
    }
}
