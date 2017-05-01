package com.example.heather.countriesfinalproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * ResultActivity class sets up the widgets from the activity_result.xml to the variables created in this class in the onCreate() method.
 * Also in the onCreate() method the bundle is being unpacked from the intent that tells the UI what info to display and the asynch task
 * is called. Before the async call the country to be searched is 'normalized' so that it will successfully work with the API call.
 * There is also a button listener that calls the finish method. The finish() method is what goes back to MainActivity class and calls
 * the onActivityResult() method there. Last thing the onCreate() method does is create a toast message. updateCountryData() method grabs
 * the information from the API call and displays the information the user defined in MainActivity and lastly creates a toast message.
 * normalizeCountry() gets rid of any whitespace before and after the search term then if there is any white space between the words
 * then replace it with a '?' to work with the API call.
 *
 * @author Heather Carlson
 * @version 1.0
 * @since 4/29/2017
 */
public class ResultActivity extends AppCompatActivity {

    TextView tvName, tvCapital, tvAltSPelling, tvRegion, tvPopulation, tvTimeZone;

    Button buttonBack;
    Country countryData;
    String countryToGet, srcUrl, correctString;
    boolean capital, altSpelling, region, population, timeZone, flag;
    WebView webViewFlag;

    /**
     *
     * @param savedInstanceState
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        webViewFlag = (WebView) findViewById(R.id.webViewFlag);
        tvName = (TextView) findViewById(R.id.textViewCName);
        tvCapital = (TextView) findViewById(R.id.textViewCCapital);
        tvAltSPelling = (TextView) findViewById(R.id.textViewCAltSpelling);
        tvRegion = (TextView) findViewById(R.id.textViewCRegion);
        tvPopulation = (TextView) findViewById(R.id.textViewCPopulation);
        tvTimeZone = (TextView) findViewById(R.id.textViewCTimeZone);


        Bundle extras = getIntent().getExtras();
        capital = extras.getBoolean("Capital");
        altSpelling = extras.getBoolean("Alt Spelling");
        region = extras.getBoolean("Region");
        population = extras.getBoolean("Population");
        timeZone = extras.getBoolean("Time Zone");
        flag = extras.getBoolean("Flag");

        countryToGet = extras.getSerializable("Country").toString();
        correctString = normalizeCountry(countryToGet);
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

    /**
     *
     */
    public void finish() {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        super.finish();
    }

    /**
     *
     * @param countryData
     */
    public void updateCountryData(Country countryData) {
        this.countryData = countryData;

        tvName.setText(" " + countryToGet);

        if (flag) {
            srcUrl = countryData.getUrl();
            webViewFlag.loadUrl(srcUrl);
            webViewFlag.setInitialScale(1);
            webViewFlag.getSettings().setLoadWithOverviewMode(true);
            webViewFlag.getSettings().setUseWideViewPort(true);

        }

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



        Toast toast=Toast.makeText(getApplicationContext(), "Updated country data",Toast.LENGTH_LONG );
        toast.show();
    }

    /**
     *
     * @param country
     * @return
     */
    public String normalizeCountry(String country){
        String string = country.trim();

        if (country.contains(" ")) {
            string = string.replace(" ","?");
        }
        return string;
    }



 }


