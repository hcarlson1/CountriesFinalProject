package com.example.heather.countriesfinalproject;

import java.util.ArrayList;

/**
 * Country class is the variables that make up a Country object. It first creates the variables then the constructor.
 * First constructor is blank and the second one is the one with the variables being set from the parameters. Rest of
 * the class is filled with getters and setters for the variables from the constructor.
 *
 * @author Tom Gibbons, Heather Carlson
 * @version 1.0
 * @since 4/29/2017
 */

public class Country {
    String name, capital, region, flagUrl;
    Long population;
    ArrayList<String> altSpelling = new ArrayList<>();
    ArrayList<String> timeZone = new ArrayList<>();

    /**
     * Default blank constructor.
     */
    public Country() {

    }

    /**
     * Constructor that requires all of the variables.
     *
     * @param name - Name of the country searched
     * @param capital - Capital of the country searched
     * @param region - Region of the country searched
     * @param flagUrl - Flag URL of the country searched
     * @param population - Population of the country searched
     * @param altSpelling- Alternate Spelling of the country searched
     * @param timeZone - Time Zone of the country searched
     */
    public Country(String name, String capital, String region, String flagUrl, Long population, ArrayList<String> altSpelling, ArrayList<String> timeZone) {
        this.name = name;
        this.capital = capital;
        this.region = region;
        this.flagUrl = flagUrl;
        this.population = population;
        this.altSpelling = altSpelling;
        this.timeZone = timeZone;
    }

    /**
     * Getter for the name of the country searched
     * @return name - String name of the country searched
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name of the country searched
     * @param name - name of the country searched
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the capital of the country searched
     * @return capital - String of the capital of the country searched
     */
    public String getCapital() {
        return capital;
    }

    /**
     * Setter of the capital of the country searched
     * @param capital - String of the capital of the country searched
     */
    public void setCapital(String capital) {
        this.capital = capital;
    }

    /**
     * Getter of the region of the country searched
     * @return region - String of the region of the country searched
     */
    public String getRegion() {
        return region;
    }
    /**
     * Setter of the region of the country searched
     * @param region - String of the region of the country searched
     */
    public void setRegion(String region) {
        this.region = region;
    }
    /**
     * Getter of the time zone of the country searched
     * @return timezZone - ArrayList of Strings of the time zones of the country searched
     */
    public ArrayList<String> getTimeZone() {
        return timeZone;
    }
    /**
     * Setter of the time zone of the country searched
     * @param timeZone - ArrayList of Strings of the time zone of the country searched
     */
    public void setTimeZone(ArrayList<String> timeZone) {
        this.timeZone = timeZone;
    }
    /**
     * Getter of the Alternate Spelling of the country searched
     * @return altSPelling - ArrayList of STrings of the alternate spelling of the country searched
     */
    public ArrayList<String> getAltSpelling() {
        return altSpelling;
    }
    /**
     * Setter of the alternate spelling of the country searched
     * @param altSpelling - ArrayList of Strings of the alternate spelling of the country searched
     */
    public void setAltSpelling(ArrayList<String> altSpelling) {
        this.altSpelling = altSpelling;
    }
    /**
     * Getter of the population of the country searched
     * @return population - String of the population of the country searched
     */
    public Long getPopulation() {
        return population;
    }
    /**
     * Setter of the population of the country searched
     * @param population - String of the population of the country searched
     */
    public void setPopulation(Long population) {
        this.population = population;
    }
    /**
     * Getter of the flag url of the country searched
     * @return flagUrl - String of the url for the flag image of the country searched
     */
    public String getFlagUrl() {
        return flagUrl;
    }
    /**
     * Setter of the flag url of the country searched
     * @param flagUrl - String of the url for flag image of the country searched
     */
    public void setFlagUrl(String flagUrl) {
        this.flagUrl = flagUrl;
    }

    /**
     * toString() of the getters and setters
     * @return String - string of all of the variables 
     */
    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", region='" + region + '\'' +
                ", timezone='" + timeZone + '\'' +
                ", altSpelling='" + altSpelling.get(0) + '\'' +
                ", population=" + population +
                '}';
    }
}
