package ui;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

@ExcludeFromJacocoGeneratedReport
public class Main {
    public static void main(String[] args) {
        try {
             new SplashScreen().displaySplash();
        } catch (Exception e) {
            System.out.println("Main function error" + e.getMessage());
        }

    }
}
