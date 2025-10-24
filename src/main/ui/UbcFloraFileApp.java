package ui;

import java.util.Scanner;

import model.Folder;
import model.Plant;

// Represents the console UI and keeps track of all plants added
public class UbcFloraFileApp {
    private Scanner userInput = new Scanner(System.in); // A way to see user input
    private Boolean onlineApp; // A way to control app runtime
    private Folder cabinetFolder = new Folder();

    /*
     * EFFECTS: initializes the application by setting onlineApp = true;
     * starts the application; displays menu too user;
     */
    public UbcFloraFileApp() {
        this.onlineApp = true;
        while (onlineApp) {
            userMenu();
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
    public void userMenu() {
        System.out.println();
        System.out.println("Welcome to the UBC FloraFile");
        System.out.println("1. Add a Entry");
        System.out.println("2. View, edit, or delete an Entry");
        System.out.println("3. View total number of plants");
        System.out.println("4. Exit");
        System.out.print("Please select one of the following option: ");

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
        System.out.println("Please enter the date you found the plant (YYYYMMDD)");
        int date = userInput.nextInt();
        Plant entry = new Plant(name, date);
        cabinetFolder.addPlant(entry);

        System.out.println("Your entry has been successfully added");

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
            System.out.println("Error! Your Folder is empty! Add entry.");
        } else {
            System.out.println();
            System.out.println("You have " + cabinetFolder.folderSize() + " entries in your folder!");

            for (Plant entry : cabinetFolder.getFolder()) {
                System.out.println("( " + entry.getPlantId() + " ) " + entry.getCommonName());
            }
        }

        System.out.println();
        System.out.println("Do you want to edit/delete a entry?");
        System.out.println("[1] Yes");
        System.out.println("[2] No");
        int entry = userInput.nextInt();

        if (entry == 1) {
            System.out.println("Please select the plant you wish to edit/delete using its plant ID");
            int plantId = userInput.nextInt();
            selectEntry(plantId);
        }

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
        System.out.println("Entry #: " + entry);
        System.out.println("Date Added: " + plant.getDateAdded());
        System.out.println("Common Name: " + plant.getCommonName());
        System.out.println("Species Name: " + plant.getSpeciesName());
        System.out.println("Found at: " + plant.getUbcLocation());
        System.out.println("Observations: " + plant.getObservations());
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
                System.out.println("\nYour folder has " + cabinetFolder.folderSize() + " entries");
                break;
            case 4:
                this.onlineApp = false;
                break;

            default:
                System.out.println("Please enter valid number");
                break;
        }

    }

    /*
     * EFFECTS: Helper for modification System Print
     */
    public void modificationMessage() {
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println("[1] Modify Common Name");
        System.out.println("[2] Modify Species Name");
        System.out.println("[3] Modify Location");
        System.out.println("[4] Modify Observation");
        System.out.println("[5] Delete Entry");
        System.out.println("[6] Go Back to Menu");
    }

    /*
     * EFFECTS: helper for location system print
     */
    public void locationMessage() {
        System.out.println();
        System.out.println("Please select your location using the number");
        System.out.println("[1] Main Mall");
        System.out.println("[2] University Blvd");
        System.out.println("[3] West Mall");
        System.out.println("[4] East Mall");
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
        System.out.println("Common Name has been Updated!");
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
        System.out.print("Species Name has been Updated!");
    }

    /*
     * REQURIES: valid plant object
     * MODIFIES: plant
     * EFFECTS: helper for ubcLocation modification
     */
    public void ubcLocationModifier(Plant plant) {
        locationMessage();
        userInput.nextInt();
        int ubcLocation = userInput.nextInt();
        plant.setUbcLocation(ubcLocation);
        System.out.println("Location has been Updated!");
    }

    /*
     * REQURIES: valid plant object
     * MODIFIES: plant
     * EFFECTS: helper for observation modification
     */
    public void observationModifier(Plant plant) {
        System.out.println("Please type your Observations");
        userInput.nextLine();
        String observations = userInput.nextLine();
        plant.setObservations(observations);
        System.out.println("Observations has been Updated!");
    }

}
