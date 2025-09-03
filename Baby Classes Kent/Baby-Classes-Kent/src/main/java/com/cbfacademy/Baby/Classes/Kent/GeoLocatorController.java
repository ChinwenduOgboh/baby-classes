package com.cbfacademy.Baby.Classes.Kent;

import com.cbfacademy.BabyClassEntity.PostcodeResponse.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/baby-classes")
public class GeoLocatorController {

    private final GeoLocatorService geocodingService;
    private final BabyClassService babyClassService;

    public GeoLocatorController(GeoLocatorService geocodingService, BabyClassService babyClassService) {
        this.geocodingService = geocodingService;
        this.babyClassService = babyClassService;
    }

    @GetMapping({"/postcode", "/postcode/{postcode}"})
    public ResponseEntity<?> getNearestClasses(@PathVariable(required=false) String postcode) {
    PostcodeResponse postcodeResponse;
     if (postcode == null || postcode.trim().isEmpty()) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of(
                        "error", "Postcode must be provided"
                ));
    }
    try {
        postcodeResponse = geocodingService.lookupPostcode(postcode);
    } catch (IllegalArgumentException e ) {
        // If postcode is invalid, return 404
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of(
                        "error", "Postcode not found",
                        "postcode", postcode
                ));
    }

    Result result = postcodeResponse.getResult();
    double userLat = result.getLatitude();
    double userLon = result.getLongitude();

    List<Map<String, Object>> nearestClasses = babyClassService.getAllClasses().stream()
            .filter(bc -> bc.getLatitude() != null && bc.getLongitude() != null)
            .map(bc -> {
                Map<String, Object> m = new HashMap<>();
                m.put("name", bc.getName());
                m.put("type", bc.getType());
                m.put("ageRange", bc.getMinAgeMonths() + "-" + bc.getMaxAgeMonths() + " months");
                m.put("address", bc.getAddress());
                m.put("distanceKm", calculateDistance(userLat, userLon, bc.getLatitude(), bc.getLongitude()));
                return m;
            })
            .sorted(Comparator.comparingDouble(c -> (double) c.get("distanceKm")))
            .limit(5)
            .collect(Collectors.toList());

    return ResponseEntity.ok(Map.of(
            "postcode", postcode,
            "nearestClasses", nearestClasses
    ));
    }

    // Haversine formula
    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Earth radius in km
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return Math.round(R * c * 100.0) / 100.0;  // distance in km
    }
}

