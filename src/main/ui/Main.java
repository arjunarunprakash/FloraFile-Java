package ui;

import javax.swing.SwingUtilities;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

@ExcludeFromJacocoGeneratedReport
public class Main {
    public static void main(String[] args) {
      //  new UbcFloraFileApp();
      SwingUtilities.invokeLater(new Runnable() {

        @Override
        public void run(){
          MainWindow main = new MainWindow();
          main.show();
        }
    });
}}
