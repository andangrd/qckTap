package com.blackcj.customkeyboard;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ListView;

import com.blackcj.customkeyboard.BCAClient.APIClient;
import com.blackcj.customkeyboard.BCAClient.MutasiItemResponse;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by mitrais on 8/26/17.
 */

public class MutasiView extends FrameLayout {
    private LayoutInflater layoutInflater;
    private StackNav stackNav;

    // Modules

    // View

    public MutasiView(StackNav _stackNav) {
        super(_stackNav.getInputMethodService().getApplicationContext());
        this.stackNav = _stackNav;

        // Init
        inflate();
        bindViews();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                callApi();
            }
        }, 500);
    }

    private void callApi() {
        APIClient client = new APIClient();
        try {
            ArrayList<MutasiItemResponse> items = client.getMutasi().getData();
            Context context = stackNav.getInputMethodService().getApplicationContext();
            MutasiItemAdapter adapter = new MutasiItemAdapter(context, items);
            ListView listView = (ListView) findViewById(R.id.mutasi_list);
            listView.setAdapter(adapter);
        } catch(IOException ioEx) {
            Log.d("error", ioEx.getMessage());
        }
    }

    private void inflate() {
        Context context = this.stackNav.getInputMethodService().getApplicationContext();
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.mutasi, this, true);
    }

    private void bindViews() {
        ImageButton backButton = (ImageButton) findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stackNav.popView();
            }
        });
    }
}
