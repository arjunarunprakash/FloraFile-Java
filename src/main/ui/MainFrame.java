package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

// MainFrame is a child of JFrame, represents opening window made for GUI components
public class MainFrame extends JFrame implements PersistenceInterface {

    private Color offWhiteColour = new Color(245,242,208);
    private JPanel upperTile;
    private JLabel label;
    private JMenuBar menuBar;

    // EFFECTS: creates new JFrame this, sets title, sets exit behavior, 
    // sets this dimensions, centers this, adds custom logo to this, 
    // sets background colour to custom white colour
    public  MainFrame() {
        try {
        this.setTitle("UBC Flora File");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,500);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        ImageIcon logo = new ImageIcon("logo.png");
        this.setIconImage(logo.getImage());
        BackgroundImagePanel bg = new BackgroundImagePanel("data/Images/backgroundImage2.png");
        this.setContentPane(bg);
        //this.getContentPane().setBackground(offWhiteColour);
        //upperPanel();
        //this.add(upperTile);
        this.setVisible(true);
        } catch (Exception e) {
            System.out.println("MainFrame error");
        }

    }

    // MODIFIES: this
    // EFFECTS: added a upper panel to the mainframe of light green color
    public void upperPanel() {
        upperPanelLabel();
        upperTile = new JPanel();
        upperTile.setBackground(new Color(0xC3FDB8));
        upperTile.setBounds(0,0,800,62);
        upperTile.add(label);

    }

    // MODIFIES: this
    // EFFECTS: added pictures and text to the upperTile
    public void upperPanelLabel() {
        label = new JLabel("What will you file today?");
        label.setForeground(new Color (30,42,86));
        label.setFont(new Font("Brush Script MT", Font.ITALIC, 25));

    }

    // MODIFIES: this
    // EFFECTS: creates menubar on top of frame to allow user to save and load files
    public void initializeMenuBar(){
        menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem saveFile = new JMenuItem("Save Progress");
        JMenuItem loadFile = new JMenuItem("Load Progress");
        JMenuItem saveAndExit = new JMenuItem("Save and Exit");

        file.add(saveFile);
        file.add(loadFile);
        file.add(saveAndExit);

        saveFile.addActionListener (e -> saveFolder());
        loadFile.addActionListener (e -> loadFolder());
        saveAndExit.addActionListener(e -> exitApp());

    }
    
    // Referenced from the JsonSerialization Demo
    // https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    // MODIFIES: this
    // EFFECTS: loads Folder from file
    void loadFolder(){

    }

    // Referenced from the JsonSerialization Demo
    // https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    // MODIFIES: ./data/folder.json
    // EFFECTS: saves the Folder to file
    void saveFolder(){

    }

    // Referenced from the JsonSerialization Demo
    // https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    // MODIFIES: this
    // EFFECTS: gives user to save application, then exits
    void exitApp(){

    }



}