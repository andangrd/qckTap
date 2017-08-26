package com.blackcj.customkeyboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.EditText;

/**
 * Created by mitrais on 8/26/17.
 */



public class TransferView extends FrameLayout {
    private LayoutInflater layoutInflater;
    private StackNav stackNav;

    // Modules
    EditText EditTextAccountNumber;
    EditText EditTextAmountTransfer;

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
        EditTextAccountNumber = (EditText) findViewById(R.id.edit_text_account_number);
        EditTextAmountTransfer = (EditText) findViewById(R.id.edit_amount_transfer);
    }
}
