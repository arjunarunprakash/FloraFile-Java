package ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// MainFrame is a child of JFrame, represents opening window made for GUI components
public class MainFrame extends JFrame {

    private Color offWhiteColour = new Color(245,242,208);
    private JPanel upperTile;
    private JLabel label;

    // EFFECTS: creates new JFrame this, sets title, sets exit behavior, 
    // sets this dimensions, centers this, adds custom logo to this, 
    // sets background colour to custom white colour
    public  MainFrame() {
        try {
        this.setTitle("UBC Flora File");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,500);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        ImageIcon logo = new ImageIcon("logo.png");
        this.setIconImage(logo.getImage());
        this.getContentPane().setBackground(offWhiteColour);
        upperPanel();
        this.add(upperTile);
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



}