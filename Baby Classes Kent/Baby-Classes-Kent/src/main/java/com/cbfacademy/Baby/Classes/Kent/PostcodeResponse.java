package com.cbfacademy.Baby.Classes.Kent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostcodeResponse {
    private int status;
    private Result result;

    // Getters and setters
    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }
    public Result getResult() { return result; }
    public void setResult(Result result) { this.result = result; }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Result {
        private String postcode;
        private Double longitude;
        private Double latitude;

        // Getters and setters
        public String getPostcode() { return postcode; }
        public void setPostcode(String postcode) { this.postcode = postcode; }
        public Double getLongitude() { return longitude; }
        public void setLongitude(Double longitude) { this.longitude = longitude; }
        public Double getLatitude() { return latitude; }
        public void setLatitude(Double latitude) { this.latitude = latitude; }
    }
}
