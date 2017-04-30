package com.example.heather.countriesfinalproject;

import java.util.ArrayList;

/**
 * Created by hcarlson1 on 4/26/2017.
 */

public class Country {
    String name, capital, region, url;
    Long population;
    ArrayList<String> altSpelling = new ArrayList<>();
    ArrayList<String> timeZone = new ArrayList<>();

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

    public Country(String name, String capital, String region, Long population, ArrayList<String> altSpelling, ArrayList<String> timeZone) {
        this.name = name;
        this.capital = capital;
        this.region = region;
        this.population = population;
        this.altSpelling = altSpelling;
        this.timeZone = timeZone;
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


    public Country(String name, String capital, String region, String url, Long population, ArrayList<String> altSpelling, ArrayList<String> timeZone) {
        this.name = name;
        this.capital = capital;
        this.region = region;
        this.url = url;
        this.population = population;
        this.altSpelling = altSpelling;
        this.timeZone = timeZone;
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

    public ArrayList<String> getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(ArrayList<String> timeZone) {
        this.timeZone = timeZone;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

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
