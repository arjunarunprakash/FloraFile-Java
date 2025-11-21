package ui;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;

import model.Folder;
import model.Plant;

// Represents the 2 main panels making up the home screen of the app
public class DashboardPanel extends JPanel {
    private Folder plantsFolder;
    private CardLayout cardLayout;
    private JPanel leftCardPanel;
    private JList<String> plantList;
    private DefaultListModel<String> listModel;
    
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
    // EFFECTS: initializes settings of panel to ensure the background image can be seen
    public void initializeSettings() {
        this.setLayout(new GridLayout(1, 2, 20, 20));
        this.setBorder(new EmptyBorder(30, 30, 30, 30)); // Padding from edges
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
        cardLayout = new CardLayout();
        leftCardPanel = new JPanel(cardLayout);
        leftCardPanel.setOpaque(false);

        // Card 1: Big Button
        JButton addBtn = new JButton("New Entry");
        addBtn.setFont(new Font("Dialog", Font.BOLD, 24));
        addBtn.setIcon(iconAdd);
        addBtn.setVerticalTextPosition(SwingConstants.TOP);
        addBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        addBtn.addActionListener(e -> cardLayout.show(leftCardPanel, "FORM"));

        // Card 2: Form
        leftCardPanel.add(addBtn, "BUTTON");
        leftCardPanel.add(createFormPanel(), "FORM");

        return leftCardPanel;

    }

    // MODIFIES: this
    // EFFECTS: creates the Form to be displayed when left panel is clicked, to submit new entries
    public JPanel createFormPanel(){
        JPanel form = new JPanel(new GridLayout(0, 1, 5, 5));
        form.setBackground(woodColor); 
        form.setBorder(BorderFactory.createLineBorder(darkWood, 4)); 

        nameField = new JTextField();
        speciesField = new JTextField();
        locationBox = new JComboBox<>(new String[]{"1. Main Mall", "2. Univ. Blvd", "3. West Mall.", "4. East Mall"});
        obsArea = new JTextArea(3, 15);

        addFieldsToForm(form);
        addButtonsToForm(form);
        return form;
    }

    // MODIFES: this
    // EFFECTS: adds labels for each off the fields, then adds the relevant text fields to each label
    public void addFieldsToForm (JPanel p) {
        p.add(new JLabel("Common Name:"));
        p.add(nameField);
        p.add(new JLabel("Species Name:"));
        p.add(speciesField);
        p.add(new JLabel("Location:"));
        p.add(locationBox);
        p.add(new JLabel("Observations:"));
        p.add(new JScrollPane(obsArea));
    }

    // MODIFIES: this
    // EFFECTS: adds a button that will allow the user to save or cancel their entry
    public void addButtonsToForm(JPanel p){
        JButton save = new JButton("Save Entry");
        save.addActionListener(e -> submitForm());
        
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(e -> cardLayout.show(leftCardPanel, "BUTTON"));

        JPanel btnPanel = new JPanel();
        btnPanel.setOpaque(false);
        btnPanel.add(save);
        btnPanel.add(cancel);
        p.add(btnPanel);

    }

    // MODIFIES: this, plantsFolder
    // EFFECTS: gathers data from text field and combobox and passes it to plant model to create a new entry
    //          clears all the text fields after submission; if nameField is empty, does nothing
    public void submitForm(){
         if (nameField.getText().isEmpty()){
            return;
         } 

        Plant p = new Plant(nameField.getText());
        p.setSpeciesName(speciesField.getText());
        p.setUbcLocation(locationBox.getSelectedIndex() + 1);
        p.setObservations(obsArea.getText());

        plantsFolder.addPlant(p);
        refreshList();
        
        clearForm();
        cardLayout.show(leftCardPanel, "BUTTON");
    
    }

    // EFFECTS: helper to clear all form text fields
    public void clearForm(){
        nameField.setText(""); 
        speciesField.setText("");
        obsArea.setText("");
    }

    // MODIFES: this
    // EFFECTS: refreshs the left panel to include a list of all entries in the plantFolder;
    //          can be used after new entry is added or after file has been loaded
    public void refreshList(){
         listModel.clear();
        if (plantsFolder.isFolderEmpty()) {
            listModel.addElement("Nothing in your list! Lets file some plants!");
        } else {
            for (Plant p : plantsFolder.getFolder()) {
                listModel.addElement("(" + p.getPlantId() + ") " + p.getCommonName());
            }
        }

    }
    
    // MODIFIES: this
    // EFFECTS: specifies and creates the left panel, passed in initialize layout
    public JPanel createRightPanel(){
         JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(woodColor);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(darkWood, 4),
                BorderFactory.createTitledBorder("Current Collection")));

        listModel = new DefaultListModel<>();
        plantList = new JList<>(listModel);
        plantList.addListSelectionListener(this::handleSelection);
        
        panel.add(new JScrollPane(plantList), BorderLayout.CENTER);
        return panel;
    }
    
    // EFFECTS: Specifies functionality behavior of what happens when element in listModel is selected
    public void handleSelection(ListSelectionEvent e){

    }

    // EFFECTS: setter that loads plantFolder from Mainframe when loadFolder is used
    public void setPlantsFolder (Folder f) {
        this.plantsFolder = f;
        refreshList();
    }

    // EFFECTS: open dialog box with current plant information, where user is presented with options to edit or delete
    //          plant of focus
    public void popUpDetails(Plant p){

    }

    // EFFECTS: deletes plant from plantFolder, refreshes list
    public void deletePlan(Plant p) {

    }

    // MODIFIES: this, plantFolder
    // EFFECTS: 
    public void popUpEditDialog(Plant p){

    }

    // EFFECTS: passed by popUpEditDialog to update the plant values based on user input
    public void updatePlant(Plant p, JTextField name, JTextField species, JComboBox<String> location,
    JTextArea observerations) {

    }

    // EFFECTS: simple getter method for plantsFolder
    public Folder getPlantsFolder(){
        return plantsFolder;
    }




}
