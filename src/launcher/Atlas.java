package launcher;

import controller.ApplicationController;
import model.Application;
import view.ApplicationView;

import javax.swing.*;

public class Atlas {

    /**
     * runs the application
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                initializeApplication();
            }
        });
    }

    /**
     * code the connects the application controller to the model and view
     */
    private static void initializeApplication() {
        System.out.println("Application system Starting...");

        // generate model
        Application model = new Application();
        System.out.println("Generated Application Model...");

        // generate view
        ApplicationView view = new ApplicationView();
        System.out.println("Generated Application View...");

        // Create Constructor for project
        ApplicationController controller = new ApplicationController(model, view);
        System.out.println("Created Application Controller...");

        // Set controller into view
        view.setVisible(true);
        System.out.println("Application Running...");
    }
}