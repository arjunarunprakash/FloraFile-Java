package ui;

import java.awt.*;
import javax.swing.*;

// A simple splash screen showing the user the app logo before entering app
public class SplashScreen extends JWindow {

    private Timer timer;
    private JLabel logoLabel;
    private JLabel textLabel;

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
    private void startAnimation() {
        timer = new Timer(20, e -> {
            int currentY = logoLabel.getY();
            int targetY = 60; // Stop higher up to leave room for text

            if (currentY > targetY) {
                logoLabel.setLocation(logoLabel.getX(), currentY - 2);
            } else {
                // Pause for a moment so user can read text, then close
                timer.stop();
                closeAfterDelay();
            }
        });
        timer.start();
    }

    // MODIFIES: this
    // EFFECTS: adds text label to panel
    public void addTextLabel(JPanel c) {
        String text = "Welcome to UBC FloraFile! \n We will set you up in just a sec!";
        textLabel = new JLabel(text);
        textLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        textLabel.setForeground(new Color(68, 35, 20)); 
        textLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        textLabel.setBounds(0, 220, 450, 60); 
        c.add(textLabel);
    }

    // MODIFIES: this
    // EFFECTS: adds logo label to panel
    public void addLogoLabel(JPanel c) {
        ImageIcon icon = new ImageIcon("data/Images/AppLogo.png");
        Image img = icon.getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH);
        logoLabel = new JLabel(new ImageIcon(img));
        
        logoLabel.setBounds(155, 180, 140, 140); 
        c.add(logoLabel);
    }

    // MODIFIES: this
    // EFFECTS: ends animation and closes window
    private void closeAfterDelay() {
        Timer pause = new Timer(1000, e -> {
            dispose();
            new MainFrame();
        });
        pause.setRepeats(false);
        pause.start();
    }
}



    


