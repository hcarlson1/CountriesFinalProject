package com.example.heather.countriesfinalproject;

/**
 * Created by hcarlson1 on 4/26/2017.
 */

public class Country {
    String name, capital, region, timezone, altSpelling;
    Long population;

    public Country() {

    }

    public Country(String name, String capital, String region, String timezone, String altSpelling, Long population) {
        this.name = name;
        this.capital = capital;
        this.region = region;
        this.timezone = timezone;
        this.altSpelling = altSpelling;
        this.population = population;
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
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getAltSpelling() {
        return altSpelling;
    }

    public void setAltSpelling(String altSpelling) {
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
                ", timezone='" + timezone + '\'' +
                ", altSpelling='" + altSpelling + '\'' +
                ", population=" + population +
                '}';
    }
}
