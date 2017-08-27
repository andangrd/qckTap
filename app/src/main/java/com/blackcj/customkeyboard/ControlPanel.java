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

import de.hdodenhof.circleimageview.CircleImageView;

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

    private void changeNameAndAvatar(Boolean noRek1) {
        Context context = this.stackNav.getInputMethodService().getApplicationContext();
        TextView namaText = (TextView) findViewById(R.id.nama_title);
        CircleImageView image = (CircleImageView) findViewById(R.id.profile_image);

        String nama = namaText.getText().toString();
        if(!noRek1) {
            namaText.setText("Pevita Pearce");
            image.setImageResource(R.drawable.ava_pevita);
        } else {
            image.setImageResource(R.drawable.ava_chelsea);
            namaText.setText("Chelsea Islan");
        }
    }

    private void copyText() {
        TextView namaText = (TextView) findViewById(R.id.nama_title);
        String resultMsg = "BCA ".concat(APIClient.getNoRekString()).concat("\na/n ").concat(namaText.getText().toString());

        InputConnection textConnection = stackNav.getInputMethodService().getCurrentInputConnection();
        textConnection.commitText(resultMsg, 0);
    }

    private void bindViews() {
        changeNameAndAvatar(APIClient.getNoRek());
        saldoText = (TextView) findViewById(R.id.saldo_value);
        saldoText.setOnClickListener(new View.OnClickListener() {
            private int countTap = 0;
            @Override
            public void onClick(View v) {
                if(countTap % 2 == 0) {
                    APIClient.switchNoRek();
                    Context context = stackNav.getInputMethodService().getApplicationContext();
                    CharSequence text = "Switched Account";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                countTap++;
            }
        });

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
                copyText();
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
