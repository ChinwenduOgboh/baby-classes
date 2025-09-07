package com.cbfacademy.Baby.Classes.Kent;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
@DisplayName("Baby Classes Kent Application Tests")
class BabyClassesKentApplicationTests {

    @Autowired
    private BabyClassService service;
    public PostcodeResult postcode;

    @MockitoBean
    private BabyClassRepository repository;
    
    private BabyClassEntity musicClass;
    private BabyClassEntity artClass;

    @BeforeEach
    void setUp() {
        musicClass = new BabyClassEntity();
        musicClass.setId(UUID.randomUUID());
        musicClass.setName("Music Fun");
        musicClass.setPostcode("ME14 5");
        musicClass.setMinAgeMonths(0);
        musicClass.setMaxAgeMonths(12);
        musicClass.setType(BabyClassEntity.ClassType.music);

        artClass = new BabyClassEntity();
        artClass.setId(UUID.randomUUID());
        artClass.setName("Art Time");
        artClass.setPostcode("ME14 6");
        artClass.setMinAgeMonths(5);
        artClass.setMaxAgeMonths(10);
        artClass.setType(BabyClassEntity.ClassType.art);

        when(repository.findAll()).thenReturn(Arrays.asList(musicClass, artClass));
        when(repository.findById(musicClass.getId())).thenReturn(Optional.of(musicClass));
        when(repository.findById(UUID.randomUUID())).thenReturn(Optional.empty());
        when(repository.findByType(BabyClassEntity.ClassType.music))
            .thenReturn(Collections.singletonList(musicClass));
        when(repository.findByMinAgeMonthsLessThanEqualAndMaxAgeMonthsGreaterThanEqual(10, 10)).thenReturn(Arrays.asList(musicClass, artClass));
        when(repository.findByPostcodeContains("TN3")).thenReturn(Arrays.asList(musicClass, artClass));
    }

    @Test
    @DisplayName("Get class by ID - not found")
    void testsGetByIdNotFound() {
        assertThrows(NoSuchElementException.class, () -> {
            service.getClassById(UUID.randomUUID()).orElseThrow();
        });
    }

    @Test
    @DisplayName("Get class by ID - found")
    void testsGetByIdFound() {
        Optional<BabyClassEntity> result = service.getClassById(musicClass.getId());
        assertTrue(result.isPresent(), "Class should be found by ID");
        assertEquals("Music Fun", result.get().getName());
    }

    
    @Test
    @DisplayName("Get all classes")
    void testGetAllClasses() {
        List<BabyClassEntity> allClasses = service.getAllClasses();
        assertEquals(2, allClasses.size(), "Should return all seeded classes");
        assertTrue(allClasses.contains(musicClass));
        assertTrue(allClasses.contains(artClass));
    }

    @Test
    @DisplayName("Delete class by ID")
    void testDeleteClassById() {
        UUID idToDelete = musicClass.getId();
        service.deleteClass(idToDelete);
        verify(repository, times(1)).deleteById(idToDelete);
    }

    @Test
    @DisplayName("Retrieve classes by type")
    void testGetByType() {
        List<BabyClassEntity> classes = service.getClassesByType(BabyClassEntity.ClassType.music);
        assertEquals(1, classes.size(), "Should return only music classes");
        assertEquals(BabyClassEntity.ClassType.music, classes.get(0).getType());
    }

    @Test
    @DisplayName("Retrieve classes by age")
    void testGetByAge() {
        List<BabyClassEntity> classes = service.getClassesByAge(10);
        assertFalse(classes.isEmpty(), "Should return classes suitable for age 10");
        for (BabyClassEntity c : classes) {
            assertTrue(c.getMinAgeMonths() <= 10 && c.getMaxAgeMonths() >= 10,
                       "Class should include the specified age");
        }
    }
}
