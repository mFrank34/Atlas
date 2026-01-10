package main.resources.java.view;

import javafx.application.Platform;
import javafx.scene.web.WebEngine;

public class ApplicationBridge {

    private final WebEngine engine;

    public JavaBridge(WebEngine engine) {
        this.engine = engine;
    }

    // JavaScript → Java
    public void sayHello(String message) {
        System.out.println(message);

        // Java → JavaScript
        Platform.runLater(() ->
                engine.executeScript(
                        "updateText('Hello back from Java!')"
                )
        );
    }
}
