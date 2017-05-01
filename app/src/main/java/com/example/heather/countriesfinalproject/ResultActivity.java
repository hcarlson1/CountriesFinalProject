package com.example.heather.countriesfinalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



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
     * onCreate() method links the variables created in this class to the widget ID
     * in the activity_result.xml file. The Bundle of extras from the intent that called
     * this activity are unpacked and assigned to the local boolean variables so the UI
     * displays the correct information the user requested. Then there is a method call
     * to normalizeCountry() so the country requested will be successful with the API
     * call. With the search term normalized, there is the creation of an AsyncFetchTask()
     * object and the method execute() is called. Then there is the creation of a toast
     * message and a listener for the button which calls the finish() method that will
     * go back to the MainActivity.
     *
     * @param savedInstanceState - standard onCreate() parameter
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
     * This is called in the button listener in the onCreate() method. This creates an
     * intent and sets the result code along with the intent data so the onActivityResult()
     * method in the MainActivity class will run successfully.
     */
    public void finish() {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        super.finish();
    }

    /**
     * Takes in the data from the Async call to the API and displays it in the UI in
     * activity_result depending on the users selection of info. The only information
     * that will always be displayed is the searched country. Otherwise every other
     * possible piece of information that can be displayed is first checked if the user
     * selected it to be displayed in MainActivity. Those settings were sent over in the
     * intent and unpacked in the onCreate() and were set to local variables which are being
     * used in this method. Some of the information is returned as an array from the API call
     * and so there are checks to see if more information from the arrays can be displayed.
     * Lastly a toast message is created to tell the user that information has been updated.
     *
     * @param countryData - The data from the Async API call to get the info about the searched country
     */
    public void updateCountryData(Country countryData) {
        this.countryData = countryData;

        tvName.setText(" " + countryToGet);

        if (flag) {
            srcUrl = countryData.getFlagUrl();
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
     * Takes in the country to be searched and 'normalizes' it so it is successful with the
     * API call. First it sets the country to a local variable and trims off any white space
     * before and after the string. Then the local variable is checked if it contains any other
     * spaces and if it does then they are replaced with '?' so the country can be searched
     * successfully using the API. The local variable is returned.
     *
     * @param country - the country to be searched defined in MainActivity
     * @return string - the country to be searched is 'normalized' to work successfully with the API
     */
    public String normalizeCountry(String country){
        String string = country.trim();

        if (string.contains(" ")) {
            string = string.replace(" ","?");
        }
        return string;
    }



 }


