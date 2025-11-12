package persistence;

import model.Plant;
import model.Folder;
import org.junit.jupiter.api.Test;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExcludeFromJacocoGeneratedReport
// Referenced from the JsonSerialization Demo
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyFolder() {
        try {
            Folder f = new Folder();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyFolder.json");
            writer.open();
            writer.write(f);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyFolder.json");
            f = reader.read();
            assertEquals(0, f.folderSize());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralFolder() {
        try {
            Folder f = new Folder();
            f.addPlant(new Plant("Red Rose", "25-12-2025 12:00:00", "No Details", "No Details", "No Details", 1));
            f.addPlant(new Plant("Sunflower", "26-01-2026 00:00:01", "Main Mall", "No Details", "No Details", 2));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralFolder.json");
            writer.open();
            writer.write(f);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralFolder.json");
            f = reader.read();
            List<Plant> folder = f.getFolder();
            assertEquals(2, folder.size());
            checkPlant("Red Rose", "25-12-2025 12:00:00", "No Details", "No Details",
                    "No Details", 1, folder.get(0));
            checkPlant("Sunflower", "26-01-2026 00:00:01", "Main Mall", "No Details",
                    "No Details", 2, folder.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
