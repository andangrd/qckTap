package com.blackcj.customkeyboard;

import android.content.Context;
import android.inputmethodservice.InputMethodService;
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
    private LayoutInflater layoutInflater;
    private StackNav stackNav;

    // Modules
    Button mutasiButton;
    Button transferButton;
    TextView saldoText;

    private MutasiView mutasiView;
    private TransferView transferView;

    public ControlPanel (StackNav _stackNav) {
        super(_stackNav.getInputMethodService().getApplicationContext());
        this.stackNav = _stackNav;

        inflate();
        bindViews();
        callApi();
    }

    private void callApi() {
        // Panggil API mas havit
        saldoText.setText("IDR. 200.000.000");
    }

    private void inflate() {
        Context context = this.stackNav.getInputMethodService().getApplicationContext();
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.control_panel, this, true);
    }

    private void bindViews() {

        mutasiButton = (Button) findViewById(R.id.mutasi_button);
        mutasiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stackNav.pushView(new MutasiView(stackNav));
            }
        });

        Button backButton = (Button) findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stackNav.popView();
            }
        });

        transferButton = (Button) findViewById(R.id.transfer_button);
        transferButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stackNav.pushView(new TransferView(stackNav));
            }
        });

        saldoText = (TextView) findViewById(R.id.saldo_value);
    }
}
