package com.freeman.android.calculamediaunisep;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Context context = getApplicationContext();
        final EditText notaG1EditText = (EditText) findViewById(R.id.NotaG1_Edit_View);
        assert notaG1EditText != null;
        notaG1EditText.setOnFocusChangeListener(new OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){

                    InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(notaG1EditText.getWindowToken(), 0);
                }
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void onClickBtnResult(View view) {
        Intent intent = new Intent(getApplicationContext(), Result.class);
        EditText notaG1EditText = (EditText) findViewById(R.id.NotaG1_Edit_View);
        EditText notaG2EditText = (EditText) findViewById(R.id.NotaG2_Edit_View);
        EditText segChamG1EditText = (EditText) findViewById(R.id.SegundaChamadaG1_Edit_View);
        EditText segChamG2EditText = (EditText) findViewById(R.id.SegundaChamadaG2_Edit_View);
        EditText substutivaG1EditText = (EditText) findViewById(R.id.SubstutivaG1_Edit_View);
        EditText substutivaG2EditText = (EditText) findViewById(R.id.SubstutivaG2_Edit_View);
        assert notaG1EditText != null;
        String notag1 = notaG1EditText.getText().toString();
        assert notaG2EditText != null;
        String notag2 = notaG2EditText.getText().toString();
        assert segChamG1EditText != null;
        String segChamG1 = segChamG1EditText.getText().toString();
        assert segChamG2EditText != null;
        String segChamG2 = segChamG2EditText.getText().toString();
        assert substutivaG1EditText != null;
        String substutivaG1 = substutivaG1EditText.getText().toString();
        assert substutivaG2EditText != null;
        String substutivaG2 = substutivaG2EditText.getText().toString();
        new Calculador(this,notag1,notag2,segChamG1,segChamG2,substutivaG1,substutivaG2).doStuff();
    }
}
