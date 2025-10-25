package persistence;

import model.Plant;
import model.Folder;
import org.junit.jupiter.api.Test;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;

@ExcludeFromJacocoGeneratedReport
// Referenced from the JsonSerialization Demo
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyFolder() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyFolder.json");
        try {
            Folder f = reader.read();
            assertEquals(0, f.folderSize());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralFolder() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralFolder.json");
        try {
            Folder f = reader.read();
            List<Plant> plants = f.getFolder();
            assertEquals(2, plants.size());
            assertEquals(2, Plant.getEntryCounter());
            checkPlant("Red Rose", 20250607, "No Details", "No Details",
                    "No Details", 1, plants.get(0));
            checkPlant("Sunflower", 20250809, "Main Mall", "No Details",
                    "No Details", 2, plants.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

}
