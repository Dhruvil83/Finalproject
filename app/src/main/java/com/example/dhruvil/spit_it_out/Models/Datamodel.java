package com.example.dhruvil.spit_it_out.Models;

public class Datamodel {
    private String type, url;

    public void setType(String type) {
        this.type = type;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    public Datamodel(String type, String url) {
        this.type = type;
        this.url = url;
    }
}
