package ui;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import model.Folder;

// Represents the 2 main panels making up the home screen of the app
public class DashboardPanel extends JPanel {
    private Folder plantsFolder;
    private CardLayout cardLayout;
    private JPanel leftCardPanel;
    private JList<String> plantList;
    
    // Form Fields
    private JTextField nameField;
    private JTextField speciesField;
    private JComboBox<String> locationBox;
    private JTextArea obsArea;

    // Colours and font
    private final Color woodColor = new Color(233, 175, 108);
    private final Color darkWood = new Color(91, 50, 16);
    private final Font pixelFont = new Font("Dialog", Font.BOLD, 14);
    private ImageIcon iconAdd; 

    // EFFECTS: constructor to initialize panels and fields
    public DashboardPanel(Folder folder){
        this.plantsFolder = folder;
        this.iconAdd = new ImageIcon(new ImageIcon("data/Images/NewEntryLogo.png")
                .getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH));

        initializeSettings();
        initializeLayout();
        refreshList();
    }

    // MODIFIES: this
    // EFFECTS: initializes and styles settings of container panel to ensure the background image can be seen
    public void initializeSettings() {
        this.setLayout(new GridLayout(1, 2, 20, 20)); 
        this.setBorder(new EmptyBorder(30, 30, 30, 30)); 
        this.setOpaque(false); 
    }

    // MODIFIES: this
    // EFFECTS: add a left and right panel to current panel
    public void initializeLayout() {
        this.add(createLeftPanel());
        this.add(createRightPanel());
    }

    // MODIFIES: this
    // EFFECTS: specifies and creates the left panel, passed in initialize layout
    public JPanel createLeftPanel(){
        return null;
    }

    // MODIFIES: this
    // EFFECTS: creates the Form to be displayed when left panel is clicked, to submit new entries
    public JPanel createFormPanel(){
        return null; //stub
    }

    // MODIFES: this
    // EFFECTS: adds labels for each off the fields, then adds the relevant text fields to each label
    public void addFieldsToForm (JPanel p) {

    }

    // MODIFIES: this
    // EFFECTS: adds a button that will allow the user to save or cancel their entry
    public void addButtonsToForm(){

    }

    // MODIFIES: this, plantsFolder
    // EFFECTS: gathers data from text field and combobox and passes it to plant model to create a new entry
    //          also will have to clear all the text fields
    public void submitForm(){
    
    }

    // MODIFES: this
    // EFFECTS: refreshs the left panel to include a list of all entries in the plantFolder;
    //          can be used after new entry is added or after file has been loaded
    public void refreshList(){

    }

    public JPanel createRightPanel() {
        return null;
    }




}
