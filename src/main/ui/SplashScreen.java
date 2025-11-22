package ui;

import java.awt.*;
import javax.swing.*;

// A simple splash screen showing the user the app logo before entering app
public class SplashScreen extends JWindow {

    private int timer;
    private JLabel label;

    // EFFECTS: Constructor, creates instance of SplashScreen
    public SplashScreen() {
    }

    // EFFECTS: sets up JWindow by configuring settings then excutes startAnimation
    public void displaySplash() {
        JPanel content = (JPanel) getContentPane();
        content.setBackground(new Color(233, 175, 108)); 
        content.setLayout(null);

        // 1. Setup Window
        int w = 450;
        int h = 300;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screen.width - w) / 2, (screen.height - h) / 2, w, h);

        
        addTextLabel(content);

        addLogoLabel(content);

        setVisible(true);
        startAnimation();
    }

    // MODIFIES: this
    // EFFECTS: moves logo upwards until it hits y = 60
    public void startAnimation() {

    }

    // MODIFIES: this
    // EFFECTS: adds text label to panel
    public void addTextLabel(JPanel c) {

    }

    // MODIFIES: this
    // EFFECTS: adds logo label to panel
    public void addLogoLabel(JPanel c) {

    }

    // MODIFIES: this
    // EFFECTS: ends animation and closes window
    public void close() {

    }



    

}
