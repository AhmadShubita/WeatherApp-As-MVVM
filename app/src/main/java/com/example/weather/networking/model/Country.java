package com.example.weather.networking.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;


public class Country implements Serializable {

    @Expose
    @SerializedName("name")
    private String name;

    @Expose
    @SerializedName("alpha2Code")
    private String countryCode;

    @Expose
    @SerializedName("capital")
    private String capital;

    @Expose
    @SerializedName("region")
    private String region;

    @Expose
    @SerializedName("nativeName")
    private String nativeName;

    @Expose
    @SerializedName("population")
    private Long population;

    @Expose
    @SerializedName("latlng")
    private ArrayList<String> latLng;

    private boolean selected = false;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
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

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public ArrayList<String> getLatLng() {
        return latLng;
    }

    public void setLatLng(ArrayList<String> latLng) {
        this.latLng = latLng;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isSelected() {
        return selected;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Country country = (Country) object;
        if (name != null ? !name.equals(country.name) : country.name != null) return false;
        if (countryCode != null ? !countryCode.equals(country.countryCode) : country.countryCode != null) return false;
        if (capital != null ? !capital.equals(country.capital) : country.capital != null) return false;
        if (population != null ? !population.equals(country.population) : country.population != null) return false;
        if (nativeName != null ? !nativeName.equals(country.nativeName) : country.nativeName != null) return false;
        return region != null ? !region.equals(country.region) : country.region != null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (countryCode != null ? countryCode.hashCode() : 0);
        result = 31 * result + (capital != null ? capital.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (nativeName != null ? nativeName.hashCode() : 0);
        result = 31 * result + (population != null ? population.hashCode() : 0);
        return result;
    }


}