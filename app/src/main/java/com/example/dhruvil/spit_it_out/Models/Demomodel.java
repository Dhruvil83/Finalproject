package com.example.dhruvil.spit_it_out.Models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public  class Demomodel {


    @Expose
    @SerializedName("success_data")
    private String to;
    @Expose
    @SerializedName("status")
    private String token;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
