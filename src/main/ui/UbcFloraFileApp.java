package ui;

import java.util.ArrayList;
import java.util.Scanner;

import model.Plant;

// Represents the console UI and keeps track of all plants added
public class UbcFloraFileApp {
private ArrayList<Plant> Folder = new ArrayList<>();  // A Folder containing all the Plants added
private Scanner userInput = new Scanner(System.in);   // A way to see user input
private Boolean onlineApp;                            // A way to control app runtime

/*
     * EFFECTS: initializes the application by setting onlineApp = true;
     *          starts the application; displays menu too user;
*/
public UbcFloraFileApp() {
    
}

/*
     * EFFECTS: Presents the user with options to take;
     *          Welcomes user to App;
     *          Displays options for User to input newEntry;
     *          Displays options for User to  view & edit Folder;
     *          Display options for User to delete items in Folder;
     *          Display option for User to see total size of Folder;
*/
public void userMenu() {

}

/*
     * REQUIRES: name must have length greater than 0;
     *           date in valid YYYYMMDD format
     * MODIFIES: this
     * EFFECTS: creates and adds new Plant to Folder
*/
public void newEntry(String name, int date) {

}

/*
     * MODIFIES: this
     * EFFECTS: display the entry number, common name, and dateAdded of plants in the Folder;
     *          instruct user to select a entry number
     *          give user option to return to Menu
     *          if empty, prompt user to add new entries
*/
public void viewFolder() {

}

/*
     * REQUIRES: valid entryNumber
     * MODIFIES: Folder
     * EFFECTS: allows user to modify a specific Plant's
     *          SpeciesName, location, and observations within Folder;
*/
public void selectEntry(int entry) {

}

/*
     * REQUIRES: valid entryNumber
     * MODIFIES: Folder
     * EFFECTS: deletes entry from Folder, and presents updated Folder
*/
public void deleteEntry(int entry) {

}

/*
     * MODIFIES: this
     * EFFECTS: finds total size of Folder
     */
public void viewFolderSize() {

}

}
