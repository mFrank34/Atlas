package launcher;

import main.resources.java.view.JavaBridge;
import controller.ApplicationController;
import model.Application;

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
     * code the connects the application main.resources.java.controller to the main.resources.java.model and main.resources.java.view
     */
    private static void initializeApplication() {
        System.out.println("Application system Starting...");

        // generate main.resources.java.model
        Application model = new Application();
        System.out.println("Generated Application Model...");

        // generate main.resources.java.view
        JavaBridge view = new JavaBridge();
        System.out.println("Generated Application View...");

        // Create Constructor for project
        ApplicationController controller = new ApplicationController(model, view);
        System.out.println("Created Application Controller...");

        // Set controller into main.resources.java.view
        System.out.println("Application Running...");
    }
}