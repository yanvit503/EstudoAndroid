package com.saojose.estudoapi.Model;

public class Pais {
    private String Country;
    private String CountryCode;
    private String Province;
    private String City;
    private String CityCode;
    private String Lat;
    private String Lon;
    private float Confirmed;
    private float Deaths;
    private float Recovered;
    private float Active;
    private String Date;


    // Getter Methods

    public String getCountry() {
        return Country;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public String getProvince() {
        return Province;
    }

    public String getCity() {
        return City;
    }

    public String getCityCode() {
        return CityCode;
    }

    public String getLat() {
        return Lat;
    }

    public String getLon() {
        return Lon;
    }

    public float getConfirmed() {
        return Confirmed;
    }

    public float getDeaths() {
        return Deaths;
    }

    public float getRecovered() {
        return Recovered;
    }

    public float getActive() {
        return Active;
    }

    public String getDate() {
        return Date;
    }

    // Setter Methods

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public void setCountryCode(String CountryCode) {
        this.CountryCode = CountryCode;
    }

    public void setProvince(String Province) {
        this.Province = Province;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public void setCityCode(String CityCode) {
        this.CityCode = CityCode;
    }

    public void setLat(String Lat) {
        this.Lat = Lat;
    }

    public void setLon(String Lon) {
        this.Lon = Lon;
    }

    public void setConfirmed(float Confirmed) {
        this.Confirmed = Confirmed;
    }

    public void setDeaths(float Deaths) {
        this.Deaths = Deaths;
    }

    public void setRecovered(float Recovered) {
        this.Recovered = Recovered;
    }

    public void setActive(float Active) {
        this.Active = Active;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }
}