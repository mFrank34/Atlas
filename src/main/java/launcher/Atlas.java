package launcher;

import controller.ApplicationController;
import controller.CharacterController;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;
import view.JavaBridge;

import javax.swing.*;
import java.util.Objects;

public class Atlas {

    /**
     * runs the application
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                initialize();
            }
        });
    }

    /**
     * code the connects the application controller to the model and view
     * but due to using java with web it changes little
     */
    private static void initialize() {
        // ----- Swing window -----
        JFrame frame = new JFrame("Atlas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JFXPanel fxPanel = new JFXPanel();
        frame.add(fxPanel);

        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // ----- JavaFX thread -----
        Platform.runLater(() -> {

            // WebView + Engine
            WebView webView = new WebView();
            WebEngine engine = webView.getEngine();

            // Load HTML
            engine.load(
                    Objects.requireNonNull(
                            Atlas.class.getResource("/index.html")
                    ).toExternalForm()
            );

            // ----- MVC -----
            ApplicationController appController = new ApplicationController();
            CharacterController charController = new CharacterController();
            JavaBridge bridge = new JavaBridge(appController, charController);

            // Inject bridge AFTER page loads
            engine.documentProperty().addListener((obs, oldDoc, newDoc) -> {
                if (newDoc != null) {
                    JSObject window = (JSObject) engine.executeScript("window");
                    window.setMember("java", bridge);
                }
            });

            // Attach scene to Swing
            fxPanel.setScene(new Scene(webView));
        });
    }

}