package com.example.heather.countriesfinalproject;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

/**
 * CountryDataFetcher class does the API call with the country the user defined in MainActivity
 * and was normalized in ResultActivity. The data from the API is set to local variables that are
 * later used to create a Country object using it's constructor.
 *
 * @author Tom Gibbons, Heather Carlson
 * @version 1.0
 * @since 4/29/2017
 */

public class CountryDataFetcher {
    /**
     * This method makes the call to the API using the normalized search term from ResultActivity to
     * get the data about the country. First the URL of the API is set to a local variable (URL) that
     * is then used to create another local variable of InputStream type that will open a stream for the
     * API information from the URL to be able to be received. The stream that is returned is used to call
     * getStringFromInputStream() in order to convert the results from  stream type to a string. Then the
     * data is set to local variables that are used to create a Country object that will later be used to
     * set the UI fields for users to see the information they requested. Some of the API information is
     * returned as an array so those need to be recorded into a local array.
     *
     * @param countryName - user defined normalized country name to be used in the API call
     * @return fetchedCountry - The country data from the API call as a Country object
     */
    public Country fetchCountryData(String countryName) {
        try {
            String jsonStr;
            URL chargerURL =  new URL("https://restcountries.eu/rest/v2/name/"+countryName);
            InputStream stream = chargerURL.openStream();
            jsonStr = getStringFromInputStream(stream);
            // see this website for details === http://www.androidhive.info/2012/01/android-json-parsing-tutorial/
            JSONArray jsonArr = new JSONArray(jsonStr);
            JSONObject jsonCountry = jsonArr.getJSONObject(0);
            String capital = jsonCountry.getString("capital");
            String region = jsonCountry.getString("region");
            Long population = Long.parseLong( jsonCountry.getString("population"));
            String flag = jsonCountry.getString("flag");
            JSONArray timeZone = jsonCountry.getJSONArray("timezones");
            ArrayList<String> timeZoneData = new ArrayList<String>(); //Need to translate the JSON Array into a ArrayList for Country Constructor
            if (timeZone != null) {
                for (int i = 0; i < timeZone.length(); i++) {
                    timeZoneData.add(timeZone.getString(i));
                }
            }

            JSONArray altSpelling = jsonCountry.getJSONArray("altSpellings");
            ArrayList<String> altSpellingData = new ArrayList<String>(); //Need to translate the JSON Array into a ArrayList for Country Constructor
            if (altSpelling != null) {
                for (int i = 0; i < altSpelling.length(); i++) {
                    altSpellingData.add(altSpelling.getString(i));
                }
            }

            Country fetchedCountry = new Country(countryName, capital, region, flag, population, altSpellingData, timeZoneData);

            return fetchedCountry;        // return result to activity
        }  catch (Exception e) {
            Log.v("CIS3334","fetchCountryData error " + e.getMessage());
            return(new Country());
        }
    }

    // convert InputStream to String

    /**
     * This is called from fetchCountryData() using the InputStream from the API call. It will convert the
     * stream into a String so that the information can be set to variables and array that can be displayed
     * to the user in ResultActivity. First it creates some local variables (BufferedReader, StringBuilder,
     * and String types) that are used to convert the stream into String type. The String with the converted
     * data is returned to the fetchCountryData() that is then used to link the data to the local variables
     * that is sent to AsyncFetchTask.
     *
     * @param is - stream of information from the APi call that will converted to a String type
     * @return sb - String converted from the data from the stream
     */
    private static String getStringFromInputStream(InputStream is) {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }


}
