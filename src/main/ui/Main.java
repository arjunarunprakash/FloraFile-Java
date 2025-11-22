package ui;

import javax.swing.SwingUtilities;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

@ExcludeFromJacocoGeneratedReport
public class Main {
    public static void main(String[] args) {
        try {
            SplashScreen splash = new SplashScreen();
            splash.displaySplash();

            SwingUtilities.invokeLater(() -> {
                new MainFrame();
            });

        } catch (Exception e) {
            System.out.println("Main function error" + e.getMessage());
        }

    }
}
