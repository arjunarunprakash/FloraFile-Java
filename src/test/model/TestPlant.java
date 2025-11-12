package model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

@ExcludeFromJacocoGeneratedReport
public class TestPlant {
    private Plant testPlant;
    private Plant testOverLoadedPlant;
    private LocalDateTime dateAndTime;

    @BeforeEach
    void runBefore() {
        this.dateAndTime = LocalDateTime.of(2025, 12, 25, 12, 0, 0);
        Plant.resetPlantIDCount();
        testPlant = new Plant("Meadow Foxtail");
        testOverLoadedPlant = new Plant("Red Rose", "Main Mall", "Rosa", "vibrant red", 2);
    }

    @Test
    void testPlantConstructor() {
        assertEquals("Meadow Foxtail", testPlant.getCommonName());
        assertEquals(dateAndTime, testPlant.getDateTimeAdded());
        assertEquals("25-12-2025 12:00:00", testPlant.getFormattedDateTime());
        assertEquals("No Details", testPlant.getSpeciesName());
        assertEquals("No Details", testPlant.getObservations());
        assertEquals("No Details", testPlant.getUbcLocation());
        assertEquals(1, testPlant.getPlantId());
    }

    @Test
    void testOverloadedPlantConstructor() {

        assertEquals("Red Rose", testOverLoadedPlant.getCommonName());
        assertEquals(20250607, testOverLoadedPlant.getDateTimeAdded());
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

    @Test
    void testSetEntryCounter() {
        assertEquals(1, Plant.getEntryCounter());
        Plant.setEntryCounter(36);
        assertEquals(36, Plant.getEntryCounter());
    }

    @Test
    void testSetEntryCounterMultipleTimes() {
        assertEquals(1, Plant.getEntryCounter());
        Plant.setEntryCounter(36);
        assertEquals(36, Plant.getEntryCounter());
        Plant.setEntryCounter(42);
        assertEquals(42, Plant.getEntryCounter());
        Plant updatedTestPlant = new Plant("Blackberry");
        assertEquals(43, updatedTestPlant.getPlantId());
    }

  
}
