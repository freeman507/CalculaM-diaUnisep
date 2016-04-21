package com.freeman.android.calculamediaunisep;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by freeman on 21/04/2016.
 */
public class Hide implements View.OnFocusChangeListener {

    private Context context;
    private EditText notaG1EditText;

    public Hide(Context context, EditText notaG1EditText) {
        this.context = context;
        this.notaG1EditText = notaG1EditText;
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if(!hasFocus){

            InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(notaG1EditText.getWindowToken(), 0);
        }
    }
}
