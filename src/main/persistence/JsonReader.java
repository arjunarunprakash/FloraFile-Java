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
        this.source = source;
    }

    // EFFECTS: reads folder from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Folder read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseFolder(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses folder from JSON object and returns it
    private Folder parseFolder(JSONObject jsonObject) {
        Folder f = new Folder();
        addPlants(f, jsonObject);
        return f;
    }

    // MODIFIES: folder
    // EFFECTS: parses plant from JSON object and adds them to folder
    private void addPlants(Folder f, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("folder");
        for (Object json : jsonArray) {
            JSONObject nextPlant = (JSONObject) json;
            addPlant(f, nextPlant);
        }
    }

    // MODIFIES: folder
    // EFFECTS: parses plant from JSON object and adds it to folder
    private void addPlant(Folder f, JSONObject jsonObject) {
        String commonName = jsonObject.getString("commonName");
        int dateAdded = jsonObject.getInt("dateAdded");
        String ubcLocation = jsonObject.getString("ubcLocation");
        String speciesName = jsonObject.getString("speciesName");
        String observations = jsonObject.getString("observations");
        int plantId = jsonObject.getInt("plantId");

        Plant plant = new Plant(commonName, dateAdded, ubcLocation, speciesName, observations, plantId);
    }

}
