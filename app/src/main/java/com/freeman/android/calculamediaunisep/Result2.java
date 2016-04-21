package com.freeman.android.calculamediaunisep;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Result2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result2);

        TextView textViewMedia = (TextView) findViewById(R.id.media_Text_View);
        TextView textViewSituation = (TextView) findViewById(R.id.situation_Text_View);
        TextView textViewSubs = (TextView) findViewById(R.id.subs_Text_Vew);
        Intent intent = getIntent();

        Bundle params = intent.getExtras();

        if(params != null) {
            textViewMedia.setText(params.getString("media"));
            textViewSituation.setText(params.getString("situation"));
            textViewSubs.setText(params.getString("subs"));
        }
    }
}
