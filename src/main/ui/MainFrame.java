package ui;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;
import java.awt.*;

import model.Folder;
import persistence.JsonReader;
import persistence.JsonWriter;

// MainFrame is a child of JFrame, represents opening window made for GUI components
public class MainFrame extends JFrame implements PersistenceInterface {

    private JPanel upperTile;
    private JLabel label;
    private JMenuBar menuBar;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private Folder plantsFolder = new Folder();

    // EFFECTS: creates new JFrame this, sets title, sets exit behavior,
    // sets this dimensions, centers this, adds custom logo to this,
    // sets background colour to custom white colour
    public MainFrame() {
        try {
            
            jsonWriter = new JsonWriter(PersistenceInterface.JSON_STORE);
            jsonReader = new JsonReader(PersistenceInterface.JSON_STORE);
            this.setTitle("UBC Flora File");
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            this.setSize(800, 500);
            this.setLocationRelativeTo(null);
            this.setLayout(new BorderLayout());
            ImageIcon logo = new ImageIcon("logo.png");
            this.setIconImage(logo.getImage());
            BackgroundImagePanel bg = new BackgroundImagePanel("data/Images/backgroundImage2.png");
            this.setContentPane(bg);
            menuBar = new JMenuBar();
            // this.getContentPane().setBackground(offWhiteColour);
            // upperPanel();
            // this.add(upperTile);
            this.setVisible(true);
        } catch (Exception e) {
            System.out.println("MainFrame error");
        }

    }

    // MODIFIES: this
    // EFFECTS: initializes all relevant of the JFrames settings including:
    //          Title, Close Operation, Size, LocationRelativeToScreen, Layout,
    //          IconImage, and ContentPane
    // MODIFIES: this
    // EFFECTS: added a upper panel to the mainframe of light green color
    public void setMainFrameSettings(){

    }
    
    public void upperPanel() {
        upperPanelLabel();
        upperTile = new JPanel();
        upperTile.setBackground(new Color(0xC3FDB8));
        upperTile.setBounds(0, 0, 800, 62);
        upperTile.add(label);

    }

    // MODIFIES: this
    // EFFECTS: added pictures and text to the upperTile
    public void upperPanelLabel() {
        label = new JLabel("What will you file today?");
        label.setForeground(new Color(30, 42, 86));
        label.setFont(new Font("Brush Script MT", Font.ITALIC, 25));

    }

    // MODIFIES: this
    // EFFECTS: creates menubar on top of frame to allow user to save and load files
    public void initializeMenuBar() {

        JMenu file = new JMenu("File");
        JMenuItem saveFile = new JMenuItem("Save Progress");
        JMenuItem loadFile = new JMenuItem("Load Progress");
        JMenuItem Exit = new JMenuItem("Save and Exit");

        menuBar.add(file);

        file.add(saveFile);
        file.add(loadFile);
        file.add(Exit);

        saveFile.addActionListener(e -> saveFolder());
        loadFile.addActionListener(e -> loadFolder());
        Exit.addActionListener(e -> exitApp());

    }

    // Referenced from the JsonSerialization Demo
    // https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    // MODIFIES: this
    // EFFECTS: loads Folder from file
    void loadFolder() {
        try {
            plantsFolder = jsonReader.read();

            JOptionPane.showMessageDialog(this, "Successfully loaded your catalog to:\n" + JSON_STORE,
            "Load Successful",
            JOptionPane.INFORMATION_MESSAGE);
            System.out.println("\n-----Sucessfully Loaded your saved catalog from " + JSON_STORE + " -----");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                this,
                "Unable to load from file:\n" + JSON_STORE,
                "Load Failed",
                JOptionPane.ERROR_MESSAGE
        );
        }
    }

    // Referenced from the JsonSerialization Demo
    // https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    // MODIFIES: ./data/folder.json
    // EFFECTS: saves the Folder to file
   void saveFolder() {
    try {
        jsonWriter.open();
        jsonWriter.write(plantsFolder);
        jsonWriter.close();

        JOptionPane.showMessageDialog(
                this,   
                "Successfully saved your catalog to:\n" + JSON_STORE,
                "Save Successful",
                JOptionPane.INFORMATION_MESSAGE
        );

    } catch (FileNotFoundException e) {

        JOptionPane.showMessageDialog(
                this,
                "Unable to write to file:\n" + JSON_STORE,
                "Save Failed",
                JOptionPane.ERROR_MESSAGE
        );
    }
}

    // Referenced from the JsonSerialization Demo
    // https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    // MODIFIES: this
    // EFFECTS: gives user option to save application, then exits
    void exitApp() {
       int chosenOption = JOptionPane.showConfirmDialog(
                this,
                "Would you like to save before exit?",
                "Save?",
                JOptionPane.YES_NO_CANCEL_OPTION
        );

        switch (chosenOption) {
            case JOptionPane.YES_OPTION:
                saveFolder();
                break;
            case JOptionPane.NO_OPTION:
                System.exit(0);
                break;
            case JOptionPane.CANCEL_OPTION:
            // do nothing, just close dialog box
                break;
        }

    }

}