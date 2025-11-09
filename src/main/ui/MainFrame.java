package ui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

// MainFrame is a child of JFrame, made for GUI components
public class MainFrame extends JFrame {

    private Color offWhiteColour = new Color(245,242,208);

    // EFFECTS: creates new JFrame this, sets title, sets exit behavior, 
    // sets this dimensions, centers this, adds custom logo to this, 
    // sets background colour to custom white colour
    public  MainFrame() {
        this.setTitle("UBC Flora File");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,500);
        this.setLocationRelativeTo(null);
        ImageIcon logo = new ImageIcon("logo.png");
        this.setIconImage(logo.getImage());
        this.getContentPane().setBackground(offWhiteColour);
        

    }

    // MODIFIES: this
    // EFFECT: makes this visible
    public void show(){
        this.setVisible(true);
    }

    

}
