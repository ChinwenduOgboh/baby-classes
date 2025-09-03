
package com.cbfacademy.Baby.Classes.Kent;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service

public class GeoLocatorService {

    private final RestTemplate restTemplate;

    public GeoLocatorService() {
        this.restTemplate = new RestTemplate();
    }

    // Call Postcodes.io API to get latitude and longitude for a given postcode
    public PostcodeResponse lookupPostcode(String postcode) {
        try {
            // Remove all spaces to match Postcodes.io format
            String formattedPostcode = postcode.replaceAll("\\s+", "");
            String url = "https://api.postcodes.io/postcodes/" + formattedPostcode;
            return restTemplate.getForObject(url, PostcodeResponse.class);

        } catch (HttpClientErrorException.NotFound e) {
            // Handle 404 Postcode Not Found specifically
            throw new IllegalArgumentException("Postcode not found: " + postcode);
        }
    }
}
