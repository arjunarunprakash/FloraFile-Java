package persistence;

import model.Plant;

import static org.junit.jupiter.api.Assertions.*;

public class JsonTest {
    protected void checkPlant(String commonName, int dateAdded, 
    String ubcLocation, String speciesName, String observation, int plantId, Plant plant) {
        assertEquals(commonName, plant.getCommonName());
        assertEquals(dateAdded, plant.getDateAdded());
        assertEquals(ubcLocation, plant.getUbcLocation());
        assertEquals(speciesName, plant.getSpeciesName());
        assertEquals(observation, plant.getObservations());
        assertEquals(plantId, plant.getPlantId());
    }
}
