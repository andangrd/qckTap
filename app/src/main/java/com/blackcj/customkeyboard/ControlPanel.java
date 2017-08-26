package com.blackcj.customkeyboard;

import android.content.Context;
import android.inputmethodservice.InputMethodService;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blackcj.customkeyboard.BCAClient.APIClient;
import com.blackcj.customkeyboard.BCAClient.BalanceResponse;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

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

    // Response from API
    BalanceResponse balanceResponse;

    private MutasiView mutasiView;
    private TransferView transferView;

    public ControlPanel (StackNav _stackNav) {
        super(_stackNav.getInputMethodService().getApplicationContext());
        this.stackNav = _stackNav;

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
        try {
            APIClient client = new APIClient();

            this.balanceResponse = client.getBalance().get(0);
            updateUI();
        } catch(IOException ioEx) {

        }
    }

    private void updateUI() {
        float balance = Float.parseFloat(balanceResponse.getAvailableBalance());
        TextView balanceText = (TextView) findViewById(R.id.saldo_value);
        balanceText.setText(Util.getBalance(balance, balanceResponse.getCurrency()));

        TextView noRekText = (TextView) findViewById(R.id.no_rekening);
        noRekText.setText(balanceResponse.getAccountNumber());
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

        // Info rekening dst
        LinearLayout shareSection = (LinearLayout) findViewById(R.id.share_section);
        shareSection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputConnection textConnection = stackNav.getInputMethodService().getCurrentInputConnection();
                textConnection.commitText("234328483243\n a/n Yoga Muda", 0);
            }
        });
        ImageButton backButton = (ImageButton) findViewById(R.id.back_button);
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
