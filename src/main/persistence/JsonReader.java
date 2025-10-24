package persistence;

import model.Plant;
import model.Folder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import org.json.*;

// Represents a reader that reads folder from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {

    }

    // EFFECTS: reads folder from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Folder read() throws IOException {
        return null;
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        return "";
    }

    // EFFECTS: parses folder from JSON object and returns it
    private Folder parseFolder(JSONObject jsonObject) {
        return null;
    }

    // MODIFIES: folder
    // EFFECTS: parses plant from JSON object and adds them to folder
    private void addPlant(Folder f, JSONObject jsonObject) {
    }

    // MODIFIES: folder
    // EFFECTS: parses plants from JSON object and adds it to folder
    private void addPlants(Folder f, JSONObject jsonObject) {
    }

}
