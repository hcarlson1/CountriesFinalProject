package com.example.heather.countriesfinalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    TextView tvName, tvCapital, tvAltSPelling, tvRegion, tvPopulation, tvTimeZone, tvFlag;
    Button buttonBack;
    Country countryData;
    String countryToGet;


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

        Bundle extras = getIntent().getExtras();
        countryToGet = extras.getSerializable("Country").toString();
        new AsyncFetchTask().execute(this);

        Toast toast=Toast.makeText(getApplicationContext(), "Requested: " + countryToGet ,Toast.LENGTH_LONG );
        toast.show();

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
        tvName.setText(" " + countryData.getName());
        tvCapital.setText(countryData.getCapital());
        tvRegion.setText(countryData.getRegion());
        //tvTimeZone.setText(countryData.getTimezone());
        tvPopulation.setText(countryData.getPopulation().toString());
        tvAltSPelling.setText(countryData.altSpelling.get(0) + " || " + countryData.altSpelling.get(1));


        Toast toast=Toast.makeText(getApplicationContext(), "Updated country data",Toast.LENGTH_LONG );
        toast.show();
    }
 }


