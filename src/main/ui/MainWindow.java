package ui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

// Main JFrame Window for GUI
public class MainWindow {

    private JFrame window;   

    // EFFECTS: creates new JFrame, sets title, sets exit behavior, 
    // sets window dimensions, centers window, adds custom logo to window
    public  MainWindow() {
        window = new JFrame();
        window.setTitle("UBC Flora File");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800,500);
        window.setLocationRelativeTo(null);
        ImageIcon logo = new ImageIcon("logo.png");

    }

    // MODIFIES: this
    // EFFECT: makes window visible
    public void show(){
        window.setVisible(true);
    }

    

}
