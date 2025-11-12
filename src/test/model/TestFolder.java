package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;

@ExcludeFromJacocoGeneratedReport
public class TestFolder {

    private Folder testFolder;
    
    private ZoneId zone = ZoneId.systemDefault();

    private LocalDateTime fixedDateTime = LocalDateTime.of(2025, 12, 25, 12, 0, 0);
    private Instant fixedInstant = fixedDateTime.atZone(zone).toInstant();
    private Clock fixedClock = Clock.fixed(fixedInstant, zone);

    private LocalDateTime fixedDateTimeMinusSecond = LocalDateTime.of(2025, 12, 25, 11, 59, 59);
    private Instant fixedInstant2 = fixedDateTimeMinusSecond.atZone(zone).toInstant();
    private Clock fixedClock2 = Clock.fixed(fixedInstant2, zone);

    private LocalDateTime fixedDateTimeMinusMin = LocalDateTime.of(2025, 12, 25, 11, 59, 0);
    private Instant fixedInstant3 = fixedDateTimeMinusMin.atZone(zone).toInstant();
    private Clock fixedClock3 = Clock.fixed(fixedInstant3, zone);

    private LocalDateTime fixedDateTimeMinusDay = LocalDateTime.of(2025, 12, 24, 12, 0, 0);
    private Instant fixedInstant4 = fixedDateTimeMinusDay.atZone(zone).toInstant();
    private Clock fixedClock4 = Clock.fixed(fixedInstant4, zone);

    private LocalDateTime fixedDateTimeMinusMonth = LocalDateTime.of(2025, 11, 24, 12, 0, 0);
    private Instant fixedInstant5 = fixedDateTimeMinusMonth.atZone(zone).toInstant();
    private Clock fixedClock5 = Clock.fixed(fixedInstant5, zone);

    private LocalDateTime fixedDateTimeMinusYear = LocalDateTime.of(2024, 12, 24, 12, 0, 0);
    private Instant fixedInstant6 = fixedDateTimeMinusYear.atZone(zone).toInstant();
    private Clock fixedClock6 = Clock.fixed(fixedInstant6, zone);

    private Plant testPlant1 = new Plant("Red Rose", fixedClock);
    private Plant testPlant2 = new Plant("Sunflower", fixedClock2);
    private Plant testPlant3 = new Plant("Salmon Berry", fixedClock3);
    private Plant testPlant4 = new Plant("BlackBerry", fixedClock4);
    private Plant testPlant5 = new Plant("Japanese Maple", fixedClock5);
    private Plant testPlant6 = new Plant("Douglas Fir", fixedClock6);

    @BeforeEach
    void runBefore() {
        this.testFolder = new Folder();
        Plant.resetPlantIDCount();
    }

    @Test
    void testFolderConstructor() {
        assertTrue(testFolder.isFolderEmpty());
    }

    @Test
    void testAddOnePlant() {
        testFolder.addPlant(testPlant1);
        assertFalse(testFolder.isFolderEmpty());
        assertEquals(testPlant1, testFolder.getPlant(0));
    }

    @Test
    void testAddMultiplePlants() {
        testFolder.addPlant(testPlant1);
        testFolder.addPlant(testPlant2);
        testFolder.addPlant(testPlant3);
        assertFalse(testFolder.isFolderEmpty());
        assertEquals(testPlant1, testFolder.getPlant(0));
        assertEquals(testPlant2, testFolder.getPlant(1));
        assertEquals(testPlant3, testFolder.getPlant(2));
    }

    @Test
    void testRemovePlants() {
        testFolder.addPlant(testPlant1);
        testFolder.addPlant(testPlant2);
        testFolder.addPlant(testPlant3);
        testFolder.removePlant(0);
        assertFalse(testFolder.isFolderEmpty());
        assertEquals(testPlant2, testFolder.getPlant(0));
        assertEquals(testPlant3, testFolder.getPlant(1));
    }

    @Test
    void testRemoveMultiplePlants() {
        testFolder.addPlant(testPlant1);
        testFolder.addPlant(testPlant2);
        testFolder.addPlant(testPlant3);
        testFolder.removePlant(0);
        testFolder.removePlant(0);
        assertFalse(testFolder.isFolderEmpty());
        assertEquals(1, testFolder.folderSize());
        assertEquals(testPlant3, testFolder.getPlant(0));
    }

    @Test
    void testSortListByDateAdded() {
        testFolder.addPlant(testPlant6);
        testFolder.addPlant(testPlant5);
        testFolder.addPlant(testPlant4);
        testFolder.addPlant(testPlant3);
        testFolder.addPlant(testPlant2);
        testFolder.addPlant(testPlant1);
        testFolder.sortListByDateAdded();
        assertEquals(testPlant1, testFolder.getPlant(0));
        assertEquals(testPlant2, testFolder.getPlant(1));
        assertEquals(testPlant3, testFolder.getPlant(2));
        assertEquals(testPlant4, testFolder.getPlant(3));
        assertEquals(testPlant5, testFolder.getPlant(4));
        assertEquals(testPlant6, testFolder.getPlant(5));
    }

    @Test
    void testSortListByPlantId() {
        testFolder.addPlant(testPlant6);
        testFolder.addPlant(testPlant5);
        testFolder.addPlant(testPlant4);
        testFolder.addPlant(testPlant3);
        testFolder.addPlant(testPlant2);
        testFolder.addPlant(testPlant1);
        testFolder.sortListByDateAdded();
        assertEquals(testPlant1, testFolder.getPlant(0));
        assertEquals(testPlant2, testFolder.getPlant(1));
        assertEquals(testPlant3, testFolder.getPlant(2));
        assertEquals(testPlant4, testFolder.getPlant(3));
        assertEquals(testPlant5, testFolder.getPlant(4));
        assertEquals(testPlant6, testFolder.getPlant(5));
        testFolder.sortListByPlantId();
        assertEquals(testPlant1, testFolder.getPlant(0));
        assertEquals(testPlant2, testFolder.getPlant(1));
        assertEquals(testPlant3, testFolder.getPlant(2));
        assertEquals(testPlant4, testFolder.getPlant(0));
        assertEquals(testPlant5, testFolder.getPlant(1));
        assertEquals(testPlant6, testFolder.getPlant(2));
    }

    @Test
    void testGetPlantByPlantId() {
        testFolder.addPlant(testPlant1);
        testFolder.addPlant(testPlant2);
        testFolder.addPlant(testPlant3);
        assertEquals(testPlant3, testFolder.getPlantByPlantId(3));
        assertEquals(testPlant2, testFolder.getPlantByPlantId(2));
        assertEquals(testPlant1, testFolder.getPlantByPlantId(1));
        assertEquals(null, testFolder.getPlantByPlantId(4));
    }

    @Test
    void testRemoveByPlantId() {
        testFolder.addPlant(testPlant1);
        testFolder.addPlant(testPlant2);
        testFolder.addPlant(testPlant3);
        assertEquals(1, testPlant1.getPlantId());
        assertEquals(2, testPlant2.getPlantId());
        assertEquals(3, testPlant3.getPlantId());
        testFolder.removeByPlantId(1);
        assertEquals(2, testFolder.folderSize());
        assertEquals(testPlant2, testFolder.getPlant(0));
        assertEquals(testPlant3, testFolder.getPlant(1));
        assertEquals(testPlant2, testFolder.getPlantByPlantId(2));
        assertEquals(testPlant3, testFolder.getPlantByPlantId(3));
    }

    @Test
    void testRemoveMultipleByPlantId() {
        testFolder.addPlant(testPlant1);
        testFolder.addPlant(testPlant2);
        testFolder.addPlant(testPlant3);
        testFolder.removeByPlantId(1);
        testFolder.removeByPlantId(2);
        assertEquals(1, testFolder.folderSize());
        assertEquals(testPlant3, testFolder.getPlant(0));
        assertEquals(testPlant3, testFolder.getPlantByPlantId(3));
    }

    @Test
    void testGetFolder() {
        ArrayList<Plant> testFolderField = new ArrayList<>();
        testFolderField.add(testPlant3);
        testFolder.addPlant(testPlant1);
        testFolder.addPlant(testPlant2);
        testFolder.addPlant(testPlant3);
        testFolder.removeByPlantId(1);
        testFolder.removeByPlantId(2);
        assertEquals(1, testFolder.folderSize());
        assertEquals(testFolderField, testFolder.getFolder());

    }
}
