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

    private EditText notaG1EditText;
    private EditText notaG2EditText;
    private EditText segChamG1EditText;
    private EditText segChamG2EditText;
    private EditText substutivaG1EditText;
    private EditText substutivaG2EditText;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Captura os campos de texto da Activity
        notaG1EditText = (EditText) findViewById(R.id.NotaG1_Edit_View);
        notaG2EditText = (EditText) findViewById(R.id.NotaG2_Edit_View);
        segChamG1EditText = (EditText) findViewById(R.id.SegundaChamadaG1_Edit_View);
        segChamG2EditText = (EditText) findViewById(R.id.SegundaChamadaG2_Edit_View);
        substutivaG1EditText = (EditText) findViewById(R.id.SubstutivaG1_Edit_View);
        substutivaG2EditText = (EditText) findViewById(R.id.SubstutivaG2_Edit_View);

        //Adiciona os ouvintes para o teclado
        context = getApplicationContext();
        notaG1EditText.setOnFocusChangeListener(new Hide(context, notaG1EditText));
        notaG2EditText.setOnFocusChangeListener(new Hide(context, notaG2EditText));
        segChamG1EditText.setOnFocusChangeListener(new Hide(context, segChamG1EditText));
        segChamG2EditText.setOnFocusChangeListener(new Hide(context, segChamG2EditText));
        substutivaG1EditText.setOnFocusChangeListener(new Hide(context, substutivaG1EditText));
        substutivaG2EditText.setOnFocusChangeListener(new Hide(context, substutivaG2EditText));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void onClickBtnResult(View view) {
        Intent intent = new Intent(getApplicationContext(), Result.class);

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
