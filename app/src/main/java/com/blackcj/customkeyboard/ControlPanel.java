package com.blackcj.customkeyboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by mitrais on 8/26/17.
 */

public class ControlPanel extends FrameLayout {

    private Context mContext;
    private LayoutInflater layoutInflater;

    // Modules
    Button mutasiButton;
    TextView saldoText;

    public ControlPanel (Context context) {
        super(context);
        this.mContext = context;
        inflate();
        bindViews();

        callApi();
    }

    private void callApi() {
        // Panggil API mas havit
        saldoText.setText("IDR. 200.000.000");
    }

    private void inflate() {
        layoutInflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.control_panel, this, true);
    }

    private void bindViews() {

        mutasiButton = (Button) findViewById(R.id.button);
        mutasiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence text = "Hello toast!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(mContext, text, duration);
                toast.show();
            }
        });

        saldoText = (TextView) findViewById(R.id.saldo_value);
    }
}
