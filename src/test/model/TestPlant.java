package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPlant {
    private Plant testPlant;

    @BeforeEach
    void runBefore() {
        testPlant = new Plant("Meadow Foxtail", 20251009);

    }

    @Test
    void testPlantConstructor() {
        assertEquals("Meadow Foxtail", testPlant.getCommonName());
        assertEquals(20251009, testPlant.getDateAdded());
        assertEquals("No Details", testPlant.getSpeciesName());
        assertEquals("No Details", testPlant.getObservations());
        assertEquals("No Details", testPlant.getUBCLocation());
        assertEquals(1, testPlant.getPlantId());
    }

    @Test
    void testSetCommonName() {
        testPlant.setCommonName("Nightshade");
        assertEquals("Nightshade", testPlant.getCommonName());
    }

    @Test
    void testSetSpeciesName() {
        testPlant.setSpeciesName("Alopecurus myosuroides");
        assertEquals("Alopecurus myosuroides", testPlant.getSpeciesName());
    }

    @Test
    void testSetUBCLocation() {
        testPlant.setUBCLocation(1);
        assertEquals("Main Mall", testPlant.getUBCLocation());
        testPlant.setUBCLocation(2);
        assertEquals("University Blvd", testPlant.getUBCLocation());
        testPlant.setUBCLocation(3);
        assertEquals("West Mall", testPlant.getUBCLocation());
        testPlant.setUBCLocation(4);
        assertEquals("East Mall", testPlant.getUBCLocation());
        testPlant.setUBCLocation(7);
        assertEquals("No Details", testPlant.getUBCLocation());
    }

    @Test
    void testSetObservation() {
        testPlant.setObservations("Found among other invasive plants");
        assertEquals("Found among other invasive plants", testPlant.getObservations());
    }
}
