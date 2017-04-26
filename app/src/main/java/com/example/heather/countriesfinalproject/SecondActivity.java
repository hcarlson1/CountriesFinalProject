package com.example.heather.countriesfinalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Heather on 4/20/2017.
 */

public class SecondActivity extends AppCompatActivity {

    TextView tvName, tvCapital, tvAltSPelling, tvRegion, tvPopulation, tvTimeZone, tvFlag;
    Button buttonBack;
    Country countryData;


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

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
    }
    public void finish() {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        super.finish();
    }

    public void updateCountryData(Country countryData) {
        this.countryData = countryData;
        tvCapital.setText(countryData.getCapital());
        Toast toast=Toast.makeText(getApplicationContext(), "Updating country data",Toast.LENGTH_LONG );
        toast.show();
    }
}