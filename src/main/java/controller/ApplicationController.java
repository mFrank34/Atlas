package controller;

public class ApplicationController {

    private String theme = "dark";

    public void onPageLoaded(String pageName) {
        System.out.println("Loaded page: " + pageName);
    }

    public void setTheme(String theme) {
        this.theme = theme;
        System.out.println("Theme set to " + theme);
    }

    public String getTheme() {
        return theme;
    }
}
