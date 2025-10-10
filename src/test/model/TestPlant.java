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
        assertEquals("No details", testPlant.getSpeciesName());
        assertEquals("No details", testPlant.getObservations());
        assertEquals("No details", testPlant.getUBCLocation());
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
        testPlant.setUBCLocation(5);
        assertEquals("Ponderosa", testPlant.getUBCLocation());
    }

    @Test
    void testSetObservation() {
        testPlant.setObservations("Found among other invasive plants");
        assertEquals("Found among other invasive plants", testPlant.getObservations());
    }
}
