package com.example.heather.countriesfinalproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ResultActivity extends AppCompatActivity {

    TextView tvName, tvCapital, tvAltSPelling, tvRegion, tvPopulation, tvTimeZone;

    Button buttonBack;
    Country countryData;
    String countryToGet, srcUrl;
    ImageView ivFlag;
    boolean capital, altSpelling, region, population, timeZone, flag;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvName = (TextView) findViewById(R.id.textViewCName);
        tvCapital = (TextView) findViewById(R.id.textViewCCapital);
        tvAltSPelling = (TextView) findViewById(R.id.textViewCAltSpelling);
        tvRegion = (TextView) findViewById(R.id.textViewCRegion);
        tvPopulation = (TextView) findViewById(R.id.textViewCPopulation);
        tvTimeZone = (TextView) findViewById(R.id.textViewCTimeZone);
        ivFlag = (ImageView) findViewById(R.id.imageViewFlag);

        Bundle extras = getIntent().getExtras();
        capital = extras.getBoolean("Capital");
        altSpelling = extras.getBoolean("Alt Spelling");
        region = extras.getBoolean("Region");
        population = extras.getBoolean("Population");
        timeZone = extras.getBoolean("Time Zone");
        flag = extras.getBoolean("Flag");

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

        if (capital) { tvCapital.setText(countryData.getCapital()); }

        if (region) { tvRegion.setText(countryData.getRegion()); }

        if (population) { tvPopulation.setText(countryData.getPopulation().toString()); }

        if (timeZone) {
            if (countryData.timeZone.size() > 1) {
                tvTimeZone.setText(countryData.timeZone.get(0) + " || " + countryData.timeZone.get(1) + " + more.");
            } else {
                tvTimeZone.setText(countryData.timeZone.get(0)); }
        }

        if (altSpelling) {
            if (countryData.altSpelling.size() > 1) {
                tvAltSPelling.setText(countryData.altSpelling.get(0) + " || " + countryData.altSpelling.get(1) + " + more.");
            } else {
                tvAltSPelling.setText(countryData.altSpelling.get(0)); }
        }

        if (flag) {
            srcUrl = countryData.getUrl();
            //tvAltSPelling.setText(countryData.getUrl());
        }

        Toast toast=Toast.makeText(getApplicationContext(), "Updated country data",Toast.LENGTH_LONG );
        toast.show();
    }



 }


