package com.example.heather.countriesfinalproject;

import android.os.AsyncTask;

/**
 * AsyncFetchTask conducts Async activities (onPreExecute(), doInBackground(), onPostExecute())
 * and extends AsyncTask. First this class creates a ResultActivity object to be used later in
 * the class. Nothing needs to be done before the API call and so onPreExecute() does nothing
 * extra from the default super.onPreExecute() command. In the doInBackground() is when the API
 * is called with the country that needs to be searched. After the API is called that data is
 * returned to the ResultActivity in onPostExecute().
 *
 * @author Tom Gibbons, Heather Carlson
 * @version 1.0
 * @since 4/29/2017
 */

public class AsyncFetchTask extends AsyncTask<ResultActivity, Void, Country> {

    ResultActivity resultActivity;

    /**
     * Method required to be an AsyncTask. This is where any thing needs to be done before the API
     * call is executed in doInbackground(). Nothing needs to be done in this application so it is
     * left with the default command super.onPreExecute() and the doInBackground() is called
     * automatically.
     */
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // do anything needed before the fetch begins
    }

    /**
     * Method required to be an AsyncTask. This is done in the background. The first thing this method
     * does is check if the params length is greater then 0 and if it isn't then the method returns null.
     * If it's greater than 0 then the method continues and grabs the element at index 0 in the array params[].
     * A CountryDataFetcher and a Country object is created and the CountryDataFetcher object is used to call
     * fetchCountryData() method. The parameters for that method call is the String from ResultActivity
     * that is the country the user wants searched and has been normalized to successfully work with the API.
     *
     * @param params - standard doInBackground() parameter
     * @return fetchedCountry - the data from the API call
     */
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

    /**
     * Method required to be an AsyncTask. This requires the data from the API call done in the doInBackground()
     * method. This information is used as the parameter to call the method updateCountryData() in ResultActivity.
     *
     * @param fetchedCountry - Data from the API call using the user defined country
     */
    @Override
    protected void onPostExecute(Country fetchedCountry) {
        // returns Country when fetched by doInBackground
        resultActivity.updateCountryData(fetchedCountry);
    }

}