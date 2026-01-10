package service;

public class ThemeService {

    private String currentTheme = "dark";

    public void setTheme(String theme) {
        if (!theme.equals("light") && !theme.equals("dark")) {
            return;
        }

        currentTheme = theme;
        System.out.println("Theme set to: " + theme);
    }

    public String getTheme() {
        return currentTheme;
    }
}
