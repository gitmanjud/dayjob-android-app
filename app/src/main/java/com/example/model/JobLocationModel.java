package com.example.model;

public class JobLocationModel {

    private String country;
    private String state;
    private String dist;
    private String tq;
    private String region;
    private String locDesc;
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getDist() {
        return dist;
    }
    public void setDist(String dist) {
        this.dist = dist;
    }
    public String getTq() {
        return tq;
    }
    public void setTq(String tq) {
        this.tq = tq;
    }
    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public String getLocDesc() {
        return locDesc;
    }
    public void setLocDesc(String locDesc) {
        this.locDesc = locDesc;
    }
    @Override
    public String toString() {
        return "JobLocationModel [country=" + country + ", state=" + state + ", dist=" + dist + ", tq=" + tq
                + ", region=" + region + ", locDesc=" + locDesc + "]";
    }

}
