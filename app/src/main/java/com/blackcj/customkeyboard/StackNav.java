package com.blackcj.customkeyboard;

import android.content.Context;
import android.inputmethodservice.InputMethodService;
import android.view.View;

import java.util.Stack;

/**
 * Created by mitrais on 8/26/17.
 */

public class StackNav {
    private InputMethodService inputMethodService;
    private Stack<View> stackView;

    public StackNav(InputMethodService service, View firstView) {
        inputMethodService = service;
        stackView = new Stack<View>();
        stackView.push(firstView);
    }

    public InputMethodService getInputMethodService() {
        return inputMethodService;
    }

    public void pushView(View view) {
        this.inputMethodService.setInputView(view);
        stackView.push(view);
    }

    public void popView() {
        View poppedView;

        if(stackView.size() > 1) {
            stackView.pop();
        }

        poppedView = stackView.peek();
        this.inputMethodService.setInputView(poppedView);
    }
}
