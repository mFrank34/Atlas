package main.resources.java.view;

import main.resources.java.controller.HelloController;

public class JavaBridge {

    private final HelloController controller;

    public JavaBridge(HelloController controller) {
        this.controller = controller;
    }

    // JS → Java
    public void sayHello(String message) {
        controller.onButtonClicked(message);
    }
}
