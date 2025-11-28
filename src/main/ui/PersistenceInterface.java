package ui;

// outlines all persistence behavior necessary for UI intergration (console UI & GUI)
public interface PersistenceInterface {
    public static final String JSON_STORE = "./data/folder.json";

    // Referenced from the JsonSerialization Demo
    // https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    // MODIFIES: this
    // EFFECTS: loads Folder from file
    void loadFolder();

    // Referenced from the JsonSerialization Demo
    // https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    // MODIFIES: ./data/folder.json
    // EFFECTS: saves the Folder to file
    void saveFolder();

    // Referenced from the JsonSerialization Demo
    // https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    // MODIFIES: this
    // EFFECTS: gives user to save application, then exits
    void exitApp();

}
