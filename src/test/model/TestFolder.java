package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestFolder {

    private Folder testFolder;
    private Plant testPlant1 = new Plant("Red Rose", 20241023);
    private Plant testPlant2 = new Plant("Sunflower", 20250118);
    private Plant testPlant3 = new Plant("Salmon Berry", 20250326);

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
        testFolder.addPlant(testPlant1);
        testFolder.addPlant(testPlant2);
        testFolder.addPlant(testPlant3);
        testFolder.sortListByDateAdded();
        assertEquals(testPlant3, testFolder.getPlant(0));
        assertEquals(testPlant2, testFolder.getPlant(1));
        assertEquals(testPlant1, testFolder.getPlant(2));
    }

    @Test
    void testSortListByPlantId() {
        testFolder.addPlant(testPlant1);
        testFolder.addPlant(testPlant2);
        testFolder.addPlant(testPlant3);
        testFolder.sortListByDateAdded();
        assertEquals(testPlant3, testFolder.getPlant(0));
        assertEquals(testPlant2, testFolder.getPlant(1));
        assertEquals(testPlant1, testFolder.getPlant(2));
        testFolder.sortListByPlantId();
        assertEquals(testPlant1, testFolder.getPlant(0));
        assertEquals(testPlant2, testFolder.getPlant(1));
        assertEquals(testPlant3, testFolder.getPlant(2));
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
}
