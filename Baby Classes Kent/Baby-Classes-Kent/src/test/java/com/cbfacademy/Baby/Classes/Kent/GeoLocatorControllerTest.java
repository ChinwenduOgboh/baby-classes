package com.cbfacademy.Baby.Classes.Kent;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GeoLocatorControllerTest {

    @Mock
    private GeoLocatorService geocodingService;

    @Mock
    private BabyClassService babyClassService;

    @InjectMocks
    private GeoLocatorController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Get nearest classes by valid postcode")
    void testGetNearestClasses() {
        // Arrange
        String postcode = "TN23 1AA";
        PostcodeResponse.Result mockResult = new PostcodeResponse.Result();
        mockResult.setLatitude(51.0);
        mockResult.setLongitude(0.5);

        PostcodeResponse mockResponse = new PostcodeResponse();
        mockResponse.setStatus(200);
        mockResponse.setResult(mockResult);

        when(geocodingService.lookupPostcode(postcode)).thenReturn(mockResponse);

        BabyClassEntity babyClass = new BabyClassEntity();
        babyClass.setName("Test Class");
        babyClass.setLatitude(51.001);
        babyClass.setLongitude(0.502);
        babyClass.setMinAgeMonths(3);
        babyClass.setMaxAgeMonths(12);
        babyClass.setType(BabyClassEntity.ClassType.music);
        babyClass.setPostcode("TN23 1AB");
        babyClass.setAddress("1 Test Street");

        when(babyClassService.getAllClasses()).thenReturn(List.of(babyClass));

        // Act
        ResponseEntity<?> resp = controller.getNearestClasses(postcode);

        // Assert
        assertEquals(HttpStatus.OK, resp.getStatusCode());
        Map<String, Object> body = (Map<String, Object>) resp.getBody();
        assertNotNull(body);
        assertEquals(postcode, body.get("postcode"));

        List<Map<String, Object>> classes = (List<Map<String, Object>>) body.get("nearestClasses");
        assertNotNull(classes);
        assertEquals(1, classes.size());
        assertEquals("Test Class", classes.get(0).get("name"));
    }

    @Test
    @DisplayName("Return 400 when postcode is missing")
    void testGetNearestClassesMissingPostcode() {
        // Act
        ResponseEntity<?> resp = controller.getNearestClasses(null);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, resp.getStatusCode());
        Map<String, Object> body = (Map<String, Object>) resp.getBody();
        assertNotNull(body);
        assertTrue(body.containsKey("error"));
    }

    @Test
    @DisplayName("Return 404 when postcode is invalid")
    void testGetNearestClassesInvalidPostcode() {
        // Arrange
        String postcode = "INVALID";
        when(geocodingService.lookupPostcode(postcode))
                .thenThrow(new IllegalArgumentException("Postcode not found: " + postcode));

        // Act
        ResponseEntity<?> resp = controller.getNearestClasses(postcode);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, resp.getStatusCode());
        Map<String, Object> body = (Map<String, Object>) resp.getBody();
        assertNotNull(body);
        assertTrue(body.containsKey("error"));
        assertEquals(postcode, body.get("postcode"));
    }
}
