package com.blackcj.customkeyboard;

import android.content.Context;
import android.inputmethodservice.InputMethodService;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.EditText;

/**
 * Created by mitrais on 8/26/17.
 */



public class TransferView extends FrameLayout {
    //dsad
    private Context mContext;
    private LayoutInflater layoutInflater;
    private InputMethodService mInputMethodService;
    private ControlPanel controlPanel;

    // Modules
    EditText EditTextName;

    public TransferView (Context context, InputMethodService inputMethodService) {
        super(context);
        this.mInputMethodService = inputMethodService;
        this.mContext = context;
        //this.controlPanel = controlPanel;

        inflate();
        bindViews();

        //callApi();
    }

    private void inflate() {
        layoutInflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.transfer_view, this, true);
    }

    public void bindViews () {
        EditTextName = (EditText) findViewById(R.id.EditTextName);
    }
}
