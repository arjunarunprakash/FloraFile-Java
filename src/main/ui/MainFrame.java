package ui;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionListener;

import model.Folder;
import persistence.JsonReader;
import persistence.JsonWriter;

// MainFrame is a child of JFrame, represents opening window made for GUI components
public class MainFrame extends JFrame implements PersistenceInterface {

    // Constants and Field Objects
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private Folder plantsFolder = new Folder();

    private JMenuBar menuBar;
    private DashboardPanel dashboard;

    // Icons
    private ImageIcon iconQuestion;
    private ImageIcon iconError;
    private ImageIcon iconInfo;
    private ImageIcon iconAppLogo;

    // Colours and Fonts
    private final Color woodColor = new Color(233, 175, 108);
    private final Color darkWood = new Color(91, 50, 16);
    private final Color darkBrownText = new Color(68, 35, 20);
    private final Color hoverColor = new Color(216, 66, 39);
    private final Color hoverTextColor = Color.WHITE;
    private final Font pixelFont = new Font("Dialog", Font.BOLD, 14);
    private final Font headerFont = new Font("Dialog", Font.BOLD, 16);

    // EFFECTS: creates new JFrame this, sets title, sets exit behavior,
    // sets this dimensions, centers this, adds custom logo to this,
    // sets background colour to custom white colour
    public MainFrame() {
        try {

            loadIcons();
            setMainFrameSettings();
            initLookAndFeel();
            initializeMenuBar();

            BackgroundImagePanel bgPanel = new BackgroundImagePanel("data/Images/backgroundImage2.png");
            bgPanel.setLayout(new BorderLayout());

            dashboard = new DashboardPanel(plantsFolder);
            bgPanel.add(dashboard, BorderLayout.CENTER);

            this.setContentPane(bgPanel);

            jsonWriter = new JsonWriter(PersistenceInterface.JSON_STORE);
            jsonReader = new JsonReader(PersistenceInterface.JSON_STORE);

            this.setVisible(true);
            loadFolderOnStartup();
        } catch (Exception e) {
            System.out.println("MainFrame error");
        }

    }

    // MODIFIES: this
    // EFFECTS: initializes all relevant of the JFrames settings including:
    // Title, Close Operation, Size, LocationRelativeToScreen, Layout,
    // and IconImage.
    public void setMainFrameSettings() {
        this.setTitle("UBC Flora File");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setSize(800, 500);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setIconImage(iconAppLogo.getImage());
        handleClose();
    }

    // MODIFIES: this
    // EFFECTS: asks user if they want to save before exiting
    public void handleClose() {
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                exitApp();
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: adds BackgroundImagePanel object to background of this. Constructs
    // and adds dashboard into
    // background panel
    public void initializeBackgroundPanel() {
        BackgroundImagePanel bgPanel = new BackgroundImagePanel("data/Images/backgroundImage2.png");
        bgPanel.setLayout(new BorderLayout());

        dashboard = new DashboardPanel(plantsFolder);
        bgPanel.add(dashboard, BorderLayout.CENTER);

        this.setContentPane(bgPanel);
    }

    // EFFECTS: Loads Images and Icons for dialog boxes
    private void loadIcons() {
        iconQuestion = scaleIcon("data/Images/DialogBox Logos/QuestionMark.png");
        iconError = scaleIcon("data/Images/DialogBox Logos/ErrorLogo.png");
        iconInfo = scaleIcon("data/Images/DialogBox Logos/Information.png");
        iconAppLogo = scaleIcon("data/Images/AppLogo.png");

    }

    // EFFECTS: Helper to scale the icons to 64x64
    private ImageIcon scaleIcon(String path) {
        return new ImageIcon(new ImageIcon(path).getImage()
                .getScaledInstance(64, 64, Image.SCALE_SMOOTH));
    }

    // EFFECTS: Sets up the UI Manager to use CrossPlatform settings and exceutes
    // functions
    // to initialize the style of Dialog boxes, MenuBar, and MenuItems
    private void initLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            stylizeMenuBar();
            stylizeDialogueBoxes();
        } catch (Exception e) {
            System.out.println("StyleInti Error " + e.getMessage());
            e.printStackTrace();
        }

    }


    // MODIFIES: this
    // EFFECTS: creates menubar on top of frame to allow user to save and load files
    public void initializeMenuBar() {
        // new JMenuBar Object
        menuBar = new JMenuBar();
        menuBar.setOpaque(true);

        // new JMenu Object with stylized borders
        JMenu file = new JMenu("File");
        file.setOpaque(true);
        file.setBorder(new EmptyBorder(5, 15, 5, 15));

        menuBar.add(file);

        // create and setup all JMenuItem Objects
        file.add(createCustomMenuItem("Save Progress", e -> saveFolder()));
        file.add(createCustomMenuItem("Load Progress", e -> loadFolder()));
        file.add(createCustomMenuItem("Save and Exit", e -> exitApp()));

        this.setJMenuBar(menuBar);

    }

    // EFFECT: Helper to reduce repetition when adding new menu Items
    private JMenuItem createCustomMenuItem(String text, ActionListener action) {
        JMenuItem item = new JMenuItem(text);
        item.setOpaque(true);
        item.setBorder(new EmptyBorder(10, 10, 10, 10));
        item.addActionListener(action);
        return item;
    }

    // EFFECT: Ask user if they would like loadFolder when application starts
    public void loadFolderOnStartup() {
        int chosenOption = JOptionPane.showConfirmDialog(
                this,
                "Would you like to load your last save?",
                "Welcome Back!",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                iconQuestion);

        switch (chosenOption) {
            case JOptionPane.YES_OPTION:
                loadFolder();
                break;
            case JOptionPane.NO_OPTION:
                // do nothing, close dialog box
                break;
        }
    }


    // Referenced from the JsonSerialization Demo
    // https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    // MODIFIES: this, dashboard
    // EFFECTS: loads Folder from file
    public void loadFolder() {
        try {
            plantsFolder = jsonReader.read();
            dashboard.setPlantsFolder(plantsFolder);

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
            this.plantsFolder = dashboard.getPlantsFolder();
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
                System.exit(0);
                break;
            case JOptionPane.NO_OPTION:
                System.exit(0);
                break;
            case JOptionPane.CANCEL_OPTION:
                // do nothing, just close dialog box
                break;
        }

    }

    // EFFECTS: helper for handle close that prints EventLog to console
    public void printLog() {
        
    }

    // MODIFIES: JOptionPane
    // EFFECT: changes JOptionPane settings to be a consistent style
    public void stylizeDialogueBoxes() {

        UIManager.put("OptionPane.background", woodColor);
        UIManager.put("Panel.background", woodColor);
        UIManager.put("OptionPane.messageForeground", darkBrownText);
        UIManager.put("OptionPane.messageFont", headerFont);
        UIManager.put("Button.background", Color.WHITE);
        UIManager.put("Button.foreground", darkBrownText);
    }

    // MODIFIES: JMenuBar, JMenu, and JMenuItem
    // EFFECT: changes JMenuBar settings to be a consistent style
    public void stylizeMenuBar() {

        UIManager.put("MenuBar.background", woodColor);
        UIManager.put("MenuBar.opaque", true);
        UIManager.put("MenuBar.border", BorderFactory.createMatteBorder(0, 0, 2, 0, darkWood));

        UIManager.put("Menu.background", woodColor);
        UIManager.put("Menu.foreground", darkBrownText);
        UIManager.put("Menu.opaque", true);
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