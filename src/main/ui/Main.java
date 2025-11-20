package ui;

import javax.swing.SwingUtilities;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

@ExcludeFromJacocoGeneratedReport
public class Main {
    public static void main(String[] args) {
        try {
            SwingUtilities.invokeLater(() -> {
                new MainFrame();
            });
            // javax.swing.SwingUtilities.invokeLater(() -> {
            // JFrame myFrame = new JFrame();
            // myFrame.setTitle("UBC Flora File");
            // myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // myFrame.setSize(800,500);
            // myFrame.setLocationRelativeTo(null);
            // myFrame.setVisible(true);

        } catch (Exception e) {
            System.out.println("Main function error");
        }

    }
}
