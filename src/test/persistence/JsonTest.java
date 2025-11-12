package persistence;

import model.Plant;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

@ExcludeFromJacocoGeneratedReport
// Referenced from the JsonSerialization Demo
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
public class JsonTest {
    protected void checkPlant(String commonName, String dateFormatted,
            String ubcLocation, String speciesName, String observation, int plantId, Plant plant) {
        assertEquals(commonName, plant.getCommonName());
        assertEquals(dateFormatted, plant.getFormattedDateTime());
        assertEquals(ubcLocation, plant.getUbcLocation());
        assertEquals(speciesName, plant.getSpeciesName());
        assertEquals(observation, plant.getObservations());
        assertEquals(plantId, plant.getPlantId());
        assertEquals(LocalDateTime.parse(dateFormatted, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")), 
        plant.getDateTimeAdded());
    }
}
