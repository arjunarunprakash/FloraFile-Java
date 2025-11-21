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
    private ImageIcon iconQuestion = new ImageIcon(new ImageIcon("data/Images/DialogBox Logos/QuestionMark.png")
            .getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH));
    private ImageIcon iconError = new ImageIcon(new ImageIcon("data/Images/DialogBox Logos/ErrorLogo.png").getImage()
            .getScaledInstance(64, 64, Image.SCALE_SMOOTH));
    private ImageIcon iconInfo = new ImageIcon(new ImageIcon("data/Images/DialogBox Logos/Information.png").getImage()
            .getScaledInstance(64, 64, Image.SCALE_SMOOTH));

    private Color woodColor = new Color(233, 175, 108);
    private Color darkWood = new Color(91, 50, 16);
    private Color darkBrownText = new Color(68, 35, 20);
    private Color hoverColor = new Color(216, 66, 39);
    private Color hoverTextColor = Color.WHITE;
    private Font pixelFont = new Font("Dialog", Font.BOLD, 14);

    // EFFECTS: creates new JFrame this, sets title, sets exit behavior,
    // sets this dimensions, centers this, adds custom logo to this,
    // sets background colour to custom white colour
    public MainFrame() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            
            setMainFrameSettings();
            stylizeMenuBar();
            stylizeDialogueBoxes();

            jsonWriter = new JsonWriter(PersistenceInterface.JSON_STORE);
            jsonReader = new JsonReader(PersistenceInterface.JSON_STORE);

            menuBar = new JMenuBar();
            initializeMenuBar();
            this.setJMenuBar(menuBar);

            this.setVisible(true);
        } catch (Exception e) {
            System.out.println("MainFrame error");
        }

    }

    // MODIFIES: this
    // EFFECTS: initializes all relevant of the JFrames settings including:
    // Title, Close Operation, Size, LocationRelativeToScreen, Layout,
    // IconImage, and ContentPane
    // MODIFIES: this
    // EFFECTS: added a upper panel to the mainframe of light green color
    public void setMainFrameSettings() {
        this.setTitle("UBC Flora File");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setSize(800, 500);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        ImageIcon logo = new ImageIcon("logo.png");
        this.setIconImage(logo.getImage());
        BackgroundImagePanel bg = new BackgroundImagePanel("data/Images/backgroundImage2.png");
        this.setContentPane(bg);
        // this.getContentPane().setBackground(offWhiteColour);
        // upperPanel();
        // this.add(upperTile);

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
    public void loadFolder() {
        try {
            plantsFolder = jsonReader.read();

            JOptionPane.showMessageDialog(this, "Successfully loaded your catalog to:\n" + JSON_STORE,
                    "Load Successful",
                    JOptionPane.INFORMATION_MESSAGE,
                    iconInfo);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Unable to load from file:\n" + JSON_STORE,
                    "Load Failed",
                    JOptionPane.ERROR_MESSAGE,
                    iconError);
        }
    }

    // Referenced from the JsonSerialization Demo
    // https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    // MODIFIES: ./data/folder.json
    // EFFECTS: saves the Folder to file
    public void saveFolder() {
        try {
            jsonWriter.open();
            jsonWriter.write(plantsFolder);
            jsonWriter.close();

            JOptionPane.showMessageDialog(
                    this,
                    "Successfully saved your catalog to:\n" + JSON_STORE,
                    "Save Successful",
                    JOptionPane.INFORMATION_MESSAGE,
                    iconInfo);

        } catch (FileNotFoundException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Unable to write to file:\n" + JSON_STORE,
                    "Save Failed",
                    JOptionPane.ERROR_MESSAGE,
                    iconError);
        }
    }

    // Referenced from the JsonSerialization Demo
    // https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    // MODIFIES: this
    // EFFECTS: gives user option to save application, then exits
    public void exitApp() {
        int chosenOption = JOptionPane.showConfirmDialog(
                this,
                "Would you like to save before exit?",
                "Save?",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                iconQuestion);

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

    // MODIFIES: JOptionPane
    // EFFECT: changes JOptionPane settings to be a consistent style
    public void stylizeDialogueBoxes() {
        Font pixelFontBiggerSize = new Font("Dialog", Font.BOLD, 16);

        UIManager.put("OptionPane.background", woodColor);
        UIManager.put("Panel.background", woodColor);

        UIManager.put("OptionPane.messageForeground", darkBrownText);
        UIManager.put("OptionPane.messageFont", pixelFontBiggerSize);
        UIManager.put("Button.background", Color.WHITE);
    }

    // MODIFIES: JMenuBar, JMenu, and JMenuItem
    // EFFECT: changes JMenuBar settings to be a consistent style
    public void stylizeMenuBar() {

        UIManager.put("MenuBar.background", woodColor);
        UIManager.put("MenuBar.border", BorderFactory.createMatteBorder(0, 0, 2, 0, darkWood));

        UIManager.put("Menu.background", woodColor);
        UIManager.put("Menu.foreground", darkBrownText);
        UIManager.put("Menu.font", pixelFont);
        UIManager.put("Menu.selectionBackground", hoverColor);
        UIManager.put("Menu.selectionForeground", hoverTextColor);
        UIManager.put("Menu.borderPainted", false);

        UIManager.put("MenuItem.background", woodColor);
        UIManager.put("MenuItem.foreground", darkBrownText);
        UIManager.put("MenuItem.font", pixelFont);
        UIManager.put("MenuItem.selectionBackground", hoverColor);
        UIManager.put("MenuItem.selectionForeground", hoverTextColor);
        UIManager.put("MenuItem.borderPainted", false);

        UIManager.put("PopupMenu.border", BorderFactory.createLineBorder(darkWood, 3));
    }

}