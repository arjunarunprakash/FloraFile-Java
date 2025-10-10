package model;

// Represents a Plant having a common name, species name, location, date, and observation
public class Plant {
    private String commonName; // common name of plant
    private String speciesName; // species name of plant
    private String ubcLocation; // Location of plant on UBC
    private int dateAdded; // Listed date found - YYYYMMDD format
    private String observation; // Observations
    private static int nextPlantId = 0; // track id of next plant
    private int plantId;

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
        String noDetail = "No Details";
        this.speciesName = noDetail;
        this.ubcLocation = noDetail;
        this.observation = noDetail;
        this.plantId = nextPlantId++;

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
}
