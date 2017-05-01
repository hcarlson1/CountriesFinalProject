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
 * Created by hcarlson1 on 4/26/2017.
 */

public class CountryDataFetcher {
    /**
     *
     * @param countryName
     * @return
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
            Long population = Long.parseLong( jsonCountry.getString("population") );
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
     *
     * @param is
     * @return
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
