package com.example.heather.countriesfinalproject;

import java.util.ArrayList;

/**
 *
 *
 * @author Tom Gibbons, Heather Carlson
 * @version 1.0
 * @since 4/29/2017
 */

public class Country {
    String name, capital, region, url;
    Long population;
    ArrayList<String> altSpelling = new ArrayList<>();
    ArrayList<String> timeZone = new ArrayList<>();

    /**
     *
     */
    public Country() {

    }

    /**
     *
     * @param name
     * @param capital
     * @param population
     */
    public Country(String name, String capital, Long population) {
        this.name = name;
        this.capital = capital;
        this.population = population;
    }

    /**
     *
     * @param name
     */
    public Country(String name) {
        this.name = name;
    }

    /**
     *
     * @param name
     * @param capital
     * @param region
     * @param population
     * @param altSpelling
     * @param timeZone
     */
    public Country(String name, String capital, String region, Long population, ArrayList<String> altSpelling, ArrayList<String> timeZone) {
        this.name = name;
        this.capital = capital;
        this.region = region;
        this.population = population;
        this.altSpelling = altSpelling;
        this.timeZone = timeZone;
    }

    /**
     *
     * @param name
     * @param capital
     * @param region
     * @param population
     */
    public Country(String name, String capital, String region, Long population) {
        this.name = name;
        this.capital = capital;
        this.region = region;
        this.population = population;
    }

    /**
     *
     * @param name
     * @param capital
     * @param region
     * @param population
     * @param altSpelling
     */
    public Country(String name, String capital, String region, Long population, ArrayList<String> altSpelling) {
        this.name = name;
        this.capital = capital;
        this.region = region;
        this.population = population;
        this.altSpelling = altSpelling;
    }

    /**
     *
     * @param name
     * @param capital
     * @param region
     * @param url
     * @param population
     * @param altSpelling
     * @param timeZone
     */
    public Country(String name, String capital, String region, String url, Long population, ArrayList<String> altSpelling, ArrayList<String> timeZone) {
        this.name = name;
        this.capital = capital;
        this.region = region;
        this.url = url;
        this.population = population;
        this.altSpelling = altSpelling;
        this.timeZone = timeZone;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getCapital() {
        return capital;
    }

    /**
     *
     * @param capital
     */
    public void setCapital(String capital) {
        this.capital = capital;
    }

    /**
     *
     * @return
     */
    public String getRegion() {
        return region;
    }
    /**
     *
     * @param region
     */
    public void setRegion(String region) {
        this.region = region;
    }
    /**
     *
     * @return
     */
    public ArrayList<String> getTimeZone() {
        return timeZone;
    }
    /**
     *
     * @param timeZone
     */
    public void setTimeZone(ArrayList<String> timeZone) {
        this.timeZone = timeZone;
    }
    /**
     *
     * @return
     */
    public ArrayList<String> getAltSpelling() {
        return altSpelling;
    }
    /**
     *
     * @param altSpelling
     */
    public void setAltSpelling(ArrayList<String> altSpelling) {
        this.altSpelling = altSpelling;
    }
    /**
     *
     * @return
     */
    public Long getPopulation() {
        return population;
    }
    /**
     *
     * @param population
     */
    public void setPopulation(Long population) {
        this.population = population;
    }
    /**
     *
     * @return
     */
    public String getUrl() {
        return url;
    }
    /**
     *
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return
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
