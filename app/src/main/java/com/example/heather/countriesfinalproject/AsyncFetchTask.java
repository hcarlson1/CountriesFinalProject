package com.example.heather.countriesfinalproject;

import android.os.AsyncTask;

/**
 * Created by hcarlson1 on 4/26/2017.
 */

public class AsyncFetchTask extends AsyncTask<ResultActivity, Void, Country> {


    ResultActivity resultActivity;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // do anything needed before the fetch begins
    }

    @Override
    protected Country doInBackground(ResultActivity... params) {
        /* If there's no country, there's nothing to look up. */
        if (params.length == 0) {
            return null;
        }
        resultActivity = params[0];    // country name should be the only string given
        CountryDataFetcher fetcher = new CountryDataFetcher();
        Country fetchedCountry = fetcher.fetchCountryData(resultActivity.correctString);
        return fetchedCountry;
    }

    @Override
    protected void onPostExecute(Country fetchedCountry) {
        // returns Country when fetched by doInBackground
        resultActivity.updateCountryData(fetchedCountry);
    }

}