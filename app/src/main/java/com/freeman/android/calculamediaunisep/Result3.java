package com.freeman.android.calculamediaunisep;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Result3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result3);

        TextView textViewFinalMedia = (TextView) findViewById(R.id.Final_Media_Text_View);
        TextView textViewFinalResult = (TextView) findViewById(R.id.Final_Result_Text_View);
        Intent intent = getIntent();

        Bundle params = intent.getExtras();

        if(params != null) {
            textViewFinalMedia.setText(params.getString("media"));
            textViewFinalResult.setText(params.getString("situation"));
        }
    }
}
