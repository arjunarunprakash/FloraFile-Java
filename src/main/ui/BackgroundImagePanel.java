package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

// a constantly run background panel containing a background image 
public class BackgroundImagePanel extends JPanel {

    private Image backgroundImage;

    //EFFECTS: sets backgroundImage to specified image location
    public BackgroundImagePanel(String bg) {
        backgroundImage = new ImageIcon(bg).getImage();
    }

    // MODIFIES: this
    // EFFECTS: draws image onto panel
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
    

}
