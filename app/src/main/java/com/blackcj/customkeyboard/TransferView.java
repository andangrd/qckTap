package com.blackcj.customkeyboard;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by mitrais on 8/26/17.
 */



public class TransferView extends FrameLayout {
    private LayoutInflater layoutInflater;
    private StackNav stackNav;
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;
    private Button mButton5;
    private Button mButton6;
    private Button mButton7;
    private Button mButton8;
    private Button mButton9;
    private Button mButton0;
    private Button mButtonDelete;
    private Button mButtonNext;
    private Button CurrentButton;

    // Modules
    TextView EditTextAccountNumber;
    TextView EditTextAmountTransfer;
    TextView ActiveTextView;
    TextView InactiveTextView;
    InputConnection inputConnection;


    // The activity (or some parent or controller) must give us
    // a reference to the current EditText's InputConnection
    public void setInputConnection(InputConnection ic) {
        this.inputConnection = ic;
    }

    public TransferView (StackNav _stackNav) {
        super(_stackNav.getInputMethodService().getApplicationContext());
        this.stackNav = _stackNav;

        inflate();
        bindViews();
    }

    private void inflate() {
        Context context = this.stackNav.getInputMethodService().getApplicationContext();
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.transfer_view, this, true);
    }

    public void bindViews () {
        EditTextAccountNumber = (TextView) findViewById(R.id.edit_text_account_number);
        EditTextAmountTransfer = (TextView) findViewById(R.id.edit_amount_transfer);
        ActiveTextView = EditTextAccountNumber;

        ImageButton backButton = (ImageButton) findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stackNav.popView();
            }
        });

        EditTextAccountNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActiveField(EditTextAccountNumber, EditTextAmountTransfer);
            }
        });

        EditTextAmountTransfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActiveField(EditTextAmountTransfer, EditTextAccountNumber);
            }
        });

        mButton1 = (Button) findViewById(R.id.button_1);
        mButton2 = (Button) findViewById(R.id.button_2);
        mButton3 = (Button) findViewById(R.id.button_3);
        mButton4 = (Button) findViewById(R.id.button_4);
        mButton5 = (Button) findViewById(R.id.button_5);
        mButton6 = (Button) findViewById(R.id.button_6);
        mButton7 = (Button) findViewById(R.id.button_7);
        mButton8 = (Button) findViewById(R.id.button_8);
        mButton9 = (Button) findViewById(R.id.button_9);
        mButton0 = (Button) findViewById(R.id.button_0);
        mButtonDelete = (Button) findViewById(R.id.button_delete);
        mButtonNext = (Button) findViewById(R.id.button_next);

        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CurrentButton = mButton1;
                setValueOfText();
            }
        });

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CurrentButton = mButton2;
                setValueOfText();
            }
        });
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CurrentButton = mButton3;
                setValueOfText();
            }
        });
        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CurrentButton = mButton4;
                setValueOfText();
            }
        });
        mButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CurrentButton = mButton5;
                setValueOfText();
            }
        });
        mButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CurrentButton = mButton6;
                setValueOfText();
            }
        });
        mButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CurrentButton = mButton7;
                setValueOfText();
            }
        });
        mButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CurrentButton = mButton8;
                setValueOfText();
            }
        });
        mButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CurrentButton = mButton9;
                setValueOfText();
            }
        });
        mButton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CurrentButton = mButton0;
                setValueOfText();
            }
        });
        mButtonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CurrentButton = mButtonDelete;
                String str = ActiveTextView.getText().toString();
                deleteChar(str);
            }
        });
        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CurrentButton = mButtonNext;
                if(ActiveTextView == EditTextAccountNumber){
                    setActiveField(EditTextAmountTransfer, EditTextAccountNumber);
                } else {
                    // go fire the transfer api
                }

            }
        });
    }

    private void setValueOfText () {
        String currentValue = ActiveTextView.getText().toString();
        String additionalValue = CurrentButton.getText().toString();

        ActiveTextView.setText(currentValue+additionalValue);
    }

    private void setActiveField(TextView activeField, TextView inactiveField) {
        ActiveTextView = activeField;
        InactiveTextView = inactiveField;
        ActiveTextView.setBackgroundResource(R.drawable.active_field);
        InactiveTextView.setBackgroundResource(0);
    }

    private void deleteChar (String str) {
        if (str != null && str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }
        ActiveTextView.setText(str);
    }
}
