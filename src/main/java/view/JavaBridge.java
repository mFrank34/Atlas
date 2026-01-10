package view;

import controller.ApplicationController;
import controller.CharacterController;
import service.ThemeService;

public class JavaBridge {
    private ThemeService themeService;

    // controllers for application
    private ApplicationController appController;
    private CharacterController charController;

    public JavaBridge(ApplicationController appController, CharacterController charController) {
        this.appController = appController;
        this.charController = charController;
    }

    public JavaBridge() {
        themeService = new ThemeService();
    }

    public void onPageLoaded() {
        System.out.println("Atlas UI Loaded");
    }

    public void setTheme(String theme) {
        themeService.setTheme(theme);
    }

    public String getTheme() {
        return themeService.getTheme();
    }

}
