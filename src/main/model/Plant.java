package model;

import org.json.JSONObject;

import persistence.Writable;

// Represents a Plant having a common name, species name, location, date, and observation
public class Plant implements Writable {
    private String commonName; // common name of plant
    private String speciesName; // species name of plant
    private String ubcLocation; // Location of plant on UBC
    private int dateAdded; // Listed date found - YYYYMMDD format
    private String observation; // Observations
    private static int entryCounter = 0; //Counts total number of entries in application
    private int plantId;
    private String noDetail = "No Details";

    /*
     * REQUIRES: name that has a non-zero length
     * and date entered in correct YYYYMMDD format
     * EFFECTS: commonName is set to name; dateFound is set to date; plant id is
     * unique positive integer.
     * speciesName, ubcLocation, and observations are set to default values
     */
    public Plant(String name, int date) {
        this.commonName = name;
        this.dateAdded = date;
        this.speciesName = noDetail;
        this.ubcLocation = noDetail;
        this.observation = noDetail;
        entryCounter++;
        this.plantId = entryCounter;

    }

    /*
     * REQUIRES: name that has a non-zero length,
     * and date entered in correct YYYYMMDD format,
     * plantid is unique and valid parameter.
     * EFFECTS: constructs plant where all fields are manually set based on
     * parameters
     */
    public Plant(String name, int date, String ubcL, String specName, String obs,
            int plantId) {
        this.commonName = name;
        this.dateAdded = date;
        this.speciesName = specName;
        this.ubcLocation = ubcL;
        this.observation = obs;
        this.plantId = plantId;
    }

    public String getCommonName() {
        return commonName;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public String getUbcLocation() {
        return ubcLocation;
    }

    public int getDateAdded() {
        return dateAdded;
    }

    public String getObservations() {
        return observation;
    }

    public int getPlantId() {
        return plantId;
    }

    /*
     * REQUIRES: name must have length greater than 0
     * MODIFIES: this
     * EFFECTS: common name of the plant in this entry
     */
    public String setCommonName(String name) {
        return this.commonName = name;
    }

    /*
     * REQUIRES: name must have length greater than 0
     * MODIFIES: this
     * EFFECTS: species name of the plant in this entry
     */
    public void setSpeciesName(String name) {
        this.speciesName = name;
    }

    /*
     * REQUIRES: valid number option between 1-4
     * MODIFIES: this
     * EFFECTS: ubcLocation of the plant in this entry
     */
    public void setUbcLocation(int number) {
        switch (number) {
            case 1:
                this.ubcLocation = "Main Mall";
                break;

            case 2:
                this.ubcLocation = "University Blvd";
                break;

            case 3:
                this.ubcLocation = "West Mall";
                break;

            case 4:
                this.ubcLocation = "East Mall";
                break;

            default:
                this.ubcLocation = "No Details";
                break;
        }

    }

    /*
     * REQUIRES: observations must have length greater than 0
     * MODIFIES: this
     * EFFECTS: common name of the plant in this entry
     */
    public String setObservations(String observations) {
        return this.observation = observations;

    }

    // EFFECTS: resets plantId count to 0
    public static void resetPlantIDCount() {
        entryCounter = 0;
    }

    // EFFECTS: returns this as JSON Object
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("commonName", commonName);
        json.put("dateAdded", dateAdded);
        json.put("ubcLocation", ubcLocation);
        json.put("speciesName", speciesName);
        json.put("observations", observation);
        json.put("plantId", plantId);
        json.put("entryCounter", entryCounter);
        return json;
    }

    // EFFECT: simple getter method to return the current entryCounter value
    public int getEntryCounter() {
        return entryCounter;
    }
    
    //REQUIRES: positve integer as count
    //MODIFIES: this
    //EFFECT: sets the entryCounter static field variable to given integer
    public static void setEntryCounter(int count) {
        Plant.entryCounter = count;
    }
}
