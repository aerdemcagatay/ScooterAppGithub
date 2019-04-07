package com.example.android.elec491scooterapp;

import org.json.JSONObject;

import java.sql.Timestamp;
import java.util.Date;

public class Scooter {

    private Number remainingBattery;
    private float latitude,longitude;
    private boolean isLocked;
    private String usingCustomer;
    private Date sessionStartTime,sessionEndTime;


    public Scooter(JSONObject res)
    {
        /** default Scooter values from the JSON */
        try
        {
            remainingBattery = Double.parseDouble(res.get("remainingBattery").toString());
            latitude = Float.parseFloat(res.get("latitude").toString());
            longitude = Float.parseFloat(res.get("longitude").toString());
            usingCustomer = res.get("usingCustomer").toString();
            isLocked = res.getBoolean("isLocked");
            sessionStartTime = new Date();
            sessionEndTime = new Date();
        }
        catch (Throwable t)
        {
            System.out.println(t);
        }
    }


    public Number getRemainingBattery() {
        return remainingBattery;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public String getUsingCustomer() {
        return usingCustomer;
    }

    public Date getSessionStartTime() {
        return sessionStartTime;
    }

    public Date getSessionEndTime() {
        return sessionEndTime;
    }
}
