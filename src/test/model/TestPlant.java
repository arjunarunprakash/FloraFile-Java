package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

@ExcludeFromJacocoGeneratedReport
public class TestPlant {
    private Plant testPlant;
    private Plant testOverLoadedPlant;

    @BeforeEach
    void runBefore() {
        Plant.resetPlantIDCount();
        testPlant = new Plant("Meadow Foxtail", 20251009);
        testOverLoadedPlant = new Plant("Red Rose", 20250607, "Main Mall", "Rosa", "vibrant red", 2 );
    }

    @Test
    void testPlantConstructor() {
        assertEquals("Meadow Foxtail", testPlant.getCommonName());
        assertEquals(20251009, testPlant.getDateAdded());
        assertEquals("No Details", testPlant.getSpeciesName());
        assertEquals("No Details", testPlant.getObservations());
        assertEquals("No Details", testPlant.getUbcLocation());
        assertEquals(1, testPlant.getPlantId());
    }

    @Test
    void testOverloadedPlantConstructor() {

        assertEquals("Red Rose", testOverLoadedPlant.getCommonName());
        assertEquals(20250607, testOverLoadedPlant.getDateAdded());
        assertEquals("Rosa", testOverLoadedPlant.getSpeciesName());
        assertEquals("vibrant red", testOverLoadedPlant.getObservations());
        assertEquals("Main Mall", testOverLoadedPlant.getUbcLocation());
        assertEquals(2, testOverLoadedPlant.getPlantId());
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
    void testSetUbcLocation() {
        testPlant.setUbcLocation(1);
        assertEquals("Main Mall", testPlant.getUbcLocation());
        testPlant.setUbcLocation(2);
        assertEquals("University Blvd", testPlant.getUbcLocation());
        testPlant.setUbcLocation(3);
        assertEquals("West Mall", testPlant.getUbcLocation());
        testPlant.setUbcLocation(4);
        assertEquals("East Mall", testPlant.getUbcLocation());
        testPlant.setUbcLocation(7);
        assertEquals("No Details", testPlant.getUbcLocation());
    }

    @Test
    void testSetObservation() {
        testPlant.setObservations("Found among other invasive plants");
        assertEquals("Found among other invasive plants", testPlant.getObservations());
    }
}
