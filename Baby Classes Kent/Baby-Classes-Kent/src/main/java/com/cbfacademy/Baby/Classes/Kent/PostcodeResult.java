package com.cbfacademy.Baby.Classes.Kent;

public class PostcodeResult {
    private String postcode;
    private Double longitude;
    private Double latitude;

    public PostcodeResult() {}

    public PostcodeResult(String postcode) {
        this.postcode = postcode;
    }

    public PostcodeResult(String postcode, Double latitude, Double longitude) {
        this.postcode = postcode;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getPostcode() { return postcode; }
    public void setPostcode(String postcode) { this.postcode = postcode; }
    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }
    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }

    @Override
    public String toString() {
        return "PostcodeResult{" +
                "postcode='" + postcode + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}



