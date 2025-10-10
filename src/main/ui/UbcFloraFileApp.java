package ui;

import java.util.ArrayList;
import java.util.Scanner;

import model.Plant;

// Represents the console UI and keeps track of all plants added
public class UbcFloraFileApp {
    private ArrayList<Plant> folder = new ArrayList<>(); // A Folder containing all the Plants added
    private Scanner userInput = new Scanner(System.in); // A way to see user input
    private Boolean onlineApp; // A way to control app runtime

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
        String name = userInput.next();
        System.out.println("Please enter the date you found the plant (YYYYMMDD)");
        int date = userInput.nextInt();
        Plant entry = new Plant(name, date);
        folder.add(entry);

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
        if (folder.isEmpty()) {
            System.out.println("Error! Your Folder is empty! Add entry.");
        } else {
            System.out.println("You have " + viewFolderSize() + " entries in your folder!");

            for (Plant entry : folder) {
                System.out.println(entry.getPlantId() + " " + entry.getCommonName());
            }
        }

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
        Plant plant = folder.get(entry);
        System.out.print("You have selected: " + plant.getCommonName());
        modificationMessage();
        int input = userInput.nextInt();
        entryModifier (input, plant);

    }
    /*
     * EFFECTS: Helper for modification System Print
     */
    public void modificationMessage() {
        System.out.println(", what would you like to do?");
        System.out.println("[1] Modify Common Name");
        System.out.println("[2] Modify Species Name");
        System.out.println("[3] Modify Location");
        System.out.println("[4] Modify Observation");
        System.out.println("[5] Delete Entry");
    }

    /*
     * EFFECTS: helper for location system print
     */
    public void locationMessage() {
        System.out.println("Please select your location using the number");
        System.out.println("[1] Main Mall");
        System.out.println("[2] University Blvd");
        System.out.println("[3] West Mall");
        System.out.println("[4] East Mall");
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
                System.out.println("Please type the Common Name");
                userInput.nextLine();
                String commonName = userInput.nextLine();
                plant.setCommonName(commonName);
                System.out.println("Common Name has been Updated!");
                break;
            case 2:
                System.out.println("Please type the species name");
                userInput.nextLine();
                String speciesName = userInput.nextLine();
                plant.setSpeciesName(speciesName);
                System.out.print("Species Name has been Updated!");
                break;
            case 3:
                locationMessage();
                userInput.nextInt();
                int ubcLocation = userInput.nextInt();
                plant.setUbcLocation(ubcLocation);
                System.out.println("Location has been Updated!");
                break;
            case 4:
                System.out.println("Please type your Observations");
                userInput.nextLine();
                String observations = userInput.nextLine();
                plant.setObservations(observations);
                System.out.println("Observations has been Updated!");
                break;
            case 5:
                deleteEntry(plant.getPlantId());
                System.out.println("This entry has been deleted!");
                break;
        }
    }

    /*
     * REQUIRES: valid entryNumber
     * MODIFIES: Folder
     * EFFECTS: deletes entry from Folder, and presents updated Folder
     */
    public void deleteEntry(int entry) {
        folder.remove(entry);

    }

    /*
     * MODIFIES: this
     * EFFECTS: finds total size of Folder
     */
    public int viewFolderSize() {
        return folder.size();
    }

    public void presentFolderSize(){
        System.out.println ("Your folder has " + viewFolderSize() + " entries");
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
                presentFolderSize();
                break;
            case 4:
                this.onlineApp = false;
                break;

            default:
                System.out.println("Please enter valid number");
                break;
        }

    }

}
