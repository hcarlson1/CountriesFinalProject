package com.example.heather.countriesfinalproject;

import java.util.ArrayList;

/**
 * Created by hcarlson1 on 4/26/2017.
 */

public class Country {
    String name, capital, region, timeZone;
    Long population;
    ArrayList<String> altSpelling = new ArrayList<>();

    public Country() {

    }
    public Country(String name, String capital, Long population) {
        this.name = name;
        this.capital = capital;
        this.population = population;
    }


    public Country(String name) {
        this.name = name;
    }

    public Country(String name, String capital, String region, String timeZone, Long population) {
        this.name = name;
        this.capital = capital;
        this.region = region;
        this.timeZone = timeZone;
        this.population = population;
    }

    public Country(String name, String capital, String region, Long population) {
        this.name = name;
        this.capital = capital;
        this.region = region;
        this.population = population;
    }

    public Country(String name, String capital, String region, Long population, ArrayList<String> altSpelling) {
        this.name = name;
        this.capital = capital;
        this.region = region;
        this.population = population;
        this.altSpelling = altSpelling;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTimezone() {
        return timeZone;
    }

    public void setTimezone(String timezone) {
        this.timeZone = timezone;
    }

    public ArrayList<String> getAltSpelling() {
        return altSpelling;
    }

    public void setAltSpelling(ArrayList<String> altSpelling) {
        this.altSpelling = altSpelling;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", region='" + region + '\'' +
                ", timezone='" + timeZone + '\'' +
                //", altSpelling='" + altSpelling.get(0) + '\'' +
                ", population=" + population +
                '}';
    }
}
