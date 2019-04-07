package com.example.android.elec491scooterapp;

import org.json.JSONObject;

public class Customer {
    private String username, password, name, surname, emailAddr,phoneNum,accessToken;
    private Number balance;
    private float latitude,longitude;

    public Customer(JSONObject res)
    {
        /** default client values from the JSON */
        try
        {
            username = res.get("username").toString();
            password = res.get("password").toString();
            name = res.get("name").toString();
            surname = res.get("surname").toString();
            emailAddr = res.get("emailAddr").toString();
            phoneNum = res.get("phoneNum").toString();
            accessToken = "?access_token=" + res.get("id").toString();
            latitude = Float.parseFloat(res.get("latitude").toString());
            longitude = Float.parseFloat(res.get("longitude").toString());
            balance = Double.parseDouble(res.get("balance").toString());

        }
        catch (Throwable t)
        {
            System.out.println(t);
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmailAddr() {
        return emailAddr;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public Number getBalance() {
        return balance;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

}
