package com.example.heather.countriesfinalproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Heather on 4/20/2017.
 */

public class SecondActivity extends AppCompatActivity {

    TextView tvName, tvCapital, tvAltSPelling, tvRegion, tvPopulation, tvTimeZone, tvFlag;
    Button buttonBack;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvName = (TextView) findViewById(R.id.textViewCName);
        tvCapital = (TextView) findViewById(R.id.textViewCCapital);
        tvAltSPelling = (TextView) findViewById(R.id.textViewCAltSpelling);
        tvRegion = (TextView) findViewById(R.id.textViewCRegion);
        tvPopulation = (TextView) findViewById(R.id.textViewCPopulation);
        tvTimeZone = (TextView) findViewById(R.id.textViewCTimeZone);
        tvFlag = (TextView) findViewById(R.id.textViewcFlag);

        buttonBack = (Button) findViewById(R.id.buttonBack);


    }
}