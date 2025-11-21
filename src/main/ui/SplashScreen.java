package ui;

import java.awt.*;
import javax.swing.*;

// A simple splash screen showing the user the app logo before entering app
public class SplashScreen extends JWindow {

    private int duration;

    // EFFECTS: Constructs splashscreen instance that lasts for specified duration
    public SplashScreen(int duration) {
        this.duration = duration;
    }
    
    // EFFECTS: sets up JPanel for window then displays Image for specified duration
    public void displaySplash() {
         JPanel content = (JPanel) getContentPane();
        content.setBackground(Color.white);

        int width = 450;
        int height = 300;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - width) / 2;
        int y = (screen.height - height) / 2;
        setBounds(x, y, width, height);

        JLabel label = new JLabel(new ImageIcon(new ImageIcon("data/Images/AppLogo.png").getImage()
                .getScaledInstance(450, 300, Image.SCALE_SMOOTH)));
        content.add(label, BorderLayout.CENTER);

        setVisible(true);
        
        try { 
            Thread.sleep(duration); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        setVisible(false);
        dispose();
    }

    
}
