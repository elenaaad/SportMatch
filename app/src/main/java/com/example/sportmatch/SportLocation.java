package com.example.sportmatch;

public class SportLocation
{
    private String locationName;
    private static int id=0;
    private int locationId;
    private int number;
    private float ratingScore;
    private String streetName;

    public SportLocation(String locationName, int number, float ratingScore, String streetName)
    {
        this.locationName = locationName;
        id++;
        this.locationId =id;
        this.number = number;
        this.ratingScore = ratingScore;
        this.streetName = streetName;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public float getRatingScore() {
        return ratingScore;
    }

    public void setRatingScore(float ratingScore) {
        this.ratingScore = ratingScore;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
}
