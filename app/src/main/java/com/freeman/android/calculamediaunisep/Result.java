package com.freeman.android.calculamediaunisep;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        TextView result = (TextView) findViewById(R.id.Result_Text_View);
        Intent intent = getIntent();

        Bundle params = intent.getExtras();

        if(params != null) {
            result.setText(params.getString("message"));
        }
    }
}