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
    View transferView;

    // View
    private MutasiView mutasiView;

    public ControlPanel (StackNav _stackNav) {
        super(_stackNav.getInputMethodService().getApplicationContext());
        this.stackNav = _stackNav;

        // Init
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

//        View transferViewA = this.transferView;
//
//        transferButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //mInputMethodService.setInputView(this.transferView);
//                CharSequence text = "Hello toast!";
//                int duration = Toast.LENGTH_SHORT;
//
//                Toast toast = Toast.makeText(mContext, text, duration);
//                toast.show();
//            }
//        });

        saldoText = (TextView) findViewById(R.id.saldo_value);
    }
}
