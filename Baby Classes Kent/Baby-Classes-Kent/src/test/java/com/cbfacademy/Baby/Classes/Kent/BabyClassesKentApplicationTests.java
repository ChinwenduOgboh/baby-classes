package com.cbfacademy.Baby.Classes.Kent;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.TestReporter; 
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@DisplayName("Baby Classes Kent Application Tests")
class BabyclasseskentApplicationTests {

    @Autowired
    private BabyClassService service;

    @Test
    @DisplayName("reveal classes by location")
    void classesByProximity() {
        List<BabyClassEntity> classes = service.getByLocation("ME14 5");
        assertTrue(classes.size() >= 0);
    }

    @Test
    @DisplayName("get class by id not found")
    void testsGetByIdNotFound() {
        assertThrows(NoSuchElementException.class, () -> {
            service.getClassById(UUID.randomUUID()).orElseThrow();
        });
    }

    @Test
    @DisplayName("create class with missing fields")
    void testCreateClassMissingFields() {
        BabyClassEntity incompleteClass = new BabyClassEntity();
        incompleteClass.setPostcode("TN12 5");
        incompleteClass.setName("Test Class");
        // Missing other required fields
        assertThrows(Exception.class, () -> {
            service.createClass(incompleteClass);
        });
    }

    @Test
    @DisplayName("get all classes")
    void testGetAllClasses() {
        List<BabyClassEntity> allClasses = service.getAllClasses();
        assertTrue(allClasses.size() >= 0);
    }

    @Test
    @DisplayName("delete class by id")
    void testDeleteClassById() {
        UUID randomId = UUID.randomUUID();
        // Should not throw error even if ID does not exist
        service.deleteClass(randomId);
    }

    @Test
    @DisplayName("retrieve class by type")
    void testGetByType() {
        List<BabyClassEntity> classes = service.getClassesByType(BabyClassEntity.ClassType.music);
        assertTrue(classes.size() >= 0);
    }

    @Test
    @DisplayName("retrieve class by age group")
    void testGetByAge() {
        List<BabyClassEntity> classes = service.getClassesByAge(10);
        assertTrue(classes.size() >= 0);
    }
    @Test
    void classesByProximity(TestReporter testReporter) {
    List<BabyClassEntity> classes = service.getByLocation("ME14 5");
    testReporter.publishEntry("Found classes: " + classes.size());
}
}
