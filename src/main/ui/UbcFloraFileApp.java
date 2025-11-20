package ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import model.Folder;
import model.Plant;
import persistence.JsonReader;
import persistence.JsonWriter;
import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

// Represents the console UI and keeps track of all plants added
@ExcludeFromJacocoGeneratedReport
public class UbcFloraFileApp implements PersistenceInterface {
    private Scanner userInput = new Scanner(System.in); // A way to see user input
    private Boolean onlineApp; // A way to control app runtime
    private Folder cabinetFolder = new Folder();
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    /*
     * EFFECTS: initializes the application by setting onlineApp = true;
     * starts the application; displays menu too user;
     */
    public UbcFloraFileApp() {
        jsonWriter = new JsonWriter(PersistenceInterface.JSON_STORE);
        jsonReader = new JsonReader(PersistenceInterface.JSON_STORE);
        this.onlineApp = true;
        while (onlineApp) {
            displayUserMenu();
            selector(this.userInput.nextInt());
            userInput.nextLine();
        }
    }

    /*
     * EFFECTS: Presents the user with options to take;
     * Welcomes user to App;
     * Displays options for User to input newEntry;
     * Displays options for User to view & edit Folder;
     * Display options for User to delete items in Folder;
     * Display option for User to see total size of Folder;
     */
    public void displayUserMenu() {
        System.out.println();
        System.out.println("Welcome to the UBC FloraFile");
        System.out.println("\t1. Add a Entry");
        System.out.println("\t2. View, edit, or delete an Entry");
        System.out.println("\t3. View total number of plants");
        System.out.println("\t4. save current entries to file");
        System.out.println("\t5. load previously saved entries");
        System.out.println("\t6. Exit");
        System.out.print("Please select one of the following options: ");

    }

    /*
     * REQUIRES: valid choice from User
     * MODIFIES: this
     * EFFECTS: chooses the correct method to execute
     */
    public void selector(int userInput) {
        switch (userInput) {
            case 1:
                newEntry();
                break;
            case 2:
                viewFolder();
                break;
            case 3:
                System.out.println(
                        "\n-----You have " + "[" + cabinetFolder.folderSize() + "]" + " entries in your folder!-----");
                break;
            case 4:
                saveFolder();
                break;
            case 5:
                loadFolder();
                break;
            case 6:
                exitApp();
                break;
            default:
                System.out.println("Please enter valid number");
                break;
        }
    }

    /*
     * REQUIRES: name must have length greater than 0;
     * date in valid YYYYMMDD format
     * MODIFIES: this
     * EFFECTS: creates and adds new Plant to Folder
     */
    public void newEntry() {
        System.out.println("Please enter the Common Name of the plant");
        userInput.nextLine();
        String name = userInput.nextLine();
        Plant entry = new Plant(name);
        cabinetFolder.addPlant(entry);

        System.out.println("-----Your entry has been successfully added-----");

    }

    /*
     * MODIFIES: this
     * EFFECTS: display the entry number, common name, and dateAdded of plants in
     * the Folder;
     * instruct user to select a entry number
     * give user option to return to Menu
     * if empty, prompt user to add new entries
     */
    public void viewFolder() {
        if (cabinetFolder.isFolderEmpty()) {
            System.out.println("\nError! Your Folder is empty! Add entry.");
        } else {
            System.out.println();
            System.out.println(
                    "-----You have " + "[" + cabinetFolder.folderSize() + "]" + " entries in your folder!-----");

            for (Plant entry : cabinetFolder.getFolder()) {
                System.out.println("\t( " + entry.getPlantId() + " ) " + " " + entry.getFormattedDateTime() + " " + entry.getCommonName());
            }
            deleteOrEditMessage();
            String entry = userInput.next();

            if (entry.equalsIgnoreCase("y")) {
                System.out.println("Please select the plant you wish to edit/delete using its plant ID");
                int plantId = userInput.nextInt();
                selectEntry(plantId);
            }

        }

    }

    // EFFECT: helper to ask if user would like to edit or delete entry
    public void deleteOrEditMessage() {
        System.out.println();
        System.out.println("Do you want to edit/delete a entry?");
        System.out.println("\t y -> Yes");
        System.out.println("\t n -> No");
    }

    /*
     * REQUIRES: valid entryNumber
     * MODIFIES: Folder
     * EFFECTS: allows user to modify a specific Plant's
     * SpeciesName, location, and observations within Folder;
     */
    public void selectEntry(int entry) {
        Plant plant = cabinetFolder.getPlantByPlantId(entry);
        System.out.println("You have selected: ");
        System.out.println();
        System.out.println("\tEntry #: " + entry);
        System.out.println("\tDate Added: " + plant.getFormattedDateTime());
        System.out.println("\tCommon Name: " + plant.getCommonName());
        System.out.println("\tSpecies Name: " + plant.getSpeciesName());
        System.out.println("\tFound at: " + plant.getUbcLocation());
        System.out.println("\tObservations: " + plant.getObservations());
        modificationMessage();
        int input = userInput.nextInt();
        entryModifier(input, plant);

    }

    /*
     * REQUIRES: valid positive integer and plant
     * MODIFIES: plant
     * EFFECTS: allows user to modify a specific Plant's
     * SpeciesName, location, and observations within Folder;
     */
    public void entryModifier(int input, Plant plant) {
        switch (input) {
            case 1:
                commonNameModifier(plant);
                break;
            case 2:
                speciesNameModifier(plant);
                break;
            case 3:
                ubcLocationModifier(plant);
                break;
            case 4:
                observationModifier(plant);
                break;
            case 5:
                cabinetFolder.removeByPlantId(plant.getPlantId());
                System.out.println("This entry has been deleted!");
                break;
            default:
                break;
        }
    }

    /*
     * EFFECTS: Helper for modification System Print
     */
    public void modificationMessage() {
        System.out.println("\nWhat would you like to do?");
        System.out.println("\t[1] Modify Common Name");
        System.out.println("\t[2] Modify Species Name");
        System.out.println("\t[3] Modify Location");
        System.out.println("\t[4] Modify Observation");
        System.out.println("\t[5] Delete Entry");
        System.out.println("\t[6] Go Back to Menu");
    }

    /*
     * EFFECTS: helper for location system print
     */
    public void locationMessage() {
        System.out.println();
        System.out.println("Please select your location using the number");
        System.out.println("\t[1] Main Mall");
        System.out.println("\t[2] University Blvd");
        System.out.println("\t[3] West Mall");
        System.out.println("\t[4] East Mall");
    }

    /*
     * REQURIES: valid plant object
     * MODIFIES: plant
     * EFFECTS: helper for common name modification
     */
    public void commonNameModifier(Plant plant) {
        System.out.println("Please type the Common Name");
        userInput.nextLine();
        String commonName = userInput.nextLine();
        plant.setCommonName(commonName);
        System.out.println("\n-----Common Name has been Updated!-----");
    }

    /*
     * REQURIES: valid plant object
     * MODIFIES: plant
     * EFFECTS: helper for species name modification
     */
    public void speciesNameModifier(Plant plant) {
        System.out.println("Please type the species name");
        userInput.nextLine();
        String speciesName = userInput.nextLine();
        plant.setSpeciesName(speciesName);
        System.out.print("\n-----Species Name has been Updated!-----");
    }

    /*
     * REQURIES: valid plant object
     * MODIFIES: plant
     * EFFECTS: helper for ubcLocation modification
     */
    public void ubcLocationModifier(Plant plant) {
        locationMessage();
        int ubcLocation = userInput.nextInt();
        plant.setUbcLocation(ubcLocation);
        System.out.println("-----Location has been Updated!-----");
    }

    /*
     * REQURIES: valid plant object
     * MODIFIES: plant
     * EFFECTS: helper for observation modification
     */
    public void observationModifier(Plant plant) {
        System.out.println("Please type your Observations");
        String observations = userInput.next();
        plant.setObservations(observations);
        System.out.println("-----Observations has been Updated!-----");
    }

    // Referenced from the JsonSerialization Demo
    // https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    // EFFECTS: saves the Folder to file
    private void saveFolder() {
        try {
            jsonWriter.open();
            jsonWriter.write(cabinetFolder);
            jsonWriter.close();
            System.out.println("\n-----Sucessfully Saved your catalog to " + JSON_STORE + " -----");
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }

    }

    // Referenced from the JsonSerialization Demo
    // https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    // MODIFIES: this
    // EFFECTS: loads Folder from file
    private void loadFolder() {
        try {
            cabinetFolder = jsonReader.read();
            System.out.println("\n-----Sucessfully Loaded your saved catalog from " + JSON_STORE + " -----");
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }

    }

    // Referenced from the JsonSerialization Demo
    // https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    // MODIFIES: this
    // EFFECTS: gives user to save application, then exits
    private void exitApp() {
        System.out.println("\n Would you like to save your progress?");
        System.out.println("\t y -> yes, save progress");
        System.out.println("\t n -> no, exit now");
        String input = userInput.next();
        switch (input) {
            case "y":
                saveFolder();
                break;
            case "n":
                this.onlineApp = false;
                break;
            default:
                System.out.println("Error, please enter valid input");
                break;
        }

    }

}
