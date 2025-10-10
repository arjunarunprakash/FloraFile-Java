package model;

// Represents a Plant having a common name, species name, location, date, and observation
public class Plant {
    private String commonName;      // common name of plant
    private String speciesName;     // species name of plant
    private String ubcLocation;     // Location of plant on UBC
    private int dateAdded;          // Listed date found - YYYYMMDD format
    private String observation;     // Observations

   /*
    * REQUIRES: name that has a non-zero length
    *           and date entered in correct YYYYMMDD format
    * EFFECTS: commonName is set to name; dateFound is set to date;
    * speciesName, ubcLocation, and observations are set to default values
    */
    public Plant(String name, int date) {

    }

    public String getCommonName() {
        return commonName;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public String getUBCLocation() {
        return ubcLocation;
    }

    public int getDateAdded() {
        return dateAdded;
    }

    public String getObservations() {
        return observation;
    }

   /*
     * REQUIRES: name must have length greater than 0
     * MODIFIES: this
     * EFFECTS: common name of the plant in this entry
     */ 
    public String setCommonName(String name) {

    }

    /*
     * REQUIRES: name must have length greater than 0
     * MODIFIES: this
     * EFFECTS: species name of the plant in this entry
     */ 
    public String setSpeciesName(String name) {

    }

    /*
     * REQUIRES: valid number option between !!!
     * MODIFIES: this
     * EFFECTS: ubcLocation of the plant in this entry
     */ 
    public String setUBCLocation(int number) {

    }

    /*
     * REQUIRES: observations must have length greater than 0
     * MODIFIES: this
     * EFFECTS: common name of the plant in this entry
     */ 
    public String setObservations(String observations) {

    }
}
