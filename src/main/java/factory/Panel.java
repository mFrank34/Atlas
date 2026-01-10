package main.resources.java.factory;


import javax.swing.*;
import java.awt.*;

/**
 * Factory for creating complex multi-field panels
 */
public class Panel {

    /**
     * Create a basic info panel (Character Name, Class, Level, etc.)
     */
    public static JPanel createBasicInfoPanel(JTextField[] fields) {
        String[] labels = {"Character Name:", "Player Name:", "Class:", "Level:", "Race:", "Background:", "Alignment:", "Experience:"};

        JPanel panel = main.resources.java.factory.Component.createTitledPanel("Basic Information", new GridLayout(4, 4, 10, 10));

        for (int i = 0; i < labels.length; i++) {
            panel.add(new JLabel(labels[i]));
            panel.add(fields[i]);
        }

        return panel;
    }

    /**
     * Create an ability scores panel with all 6 abilities
     */
    public static JPanel createAbilityScoresPanel(JTextField[] scoreFields, JLabel[] modLabels) {
        String[] abilityNames = {"STR", "DEX", "CON", "INT", "WIS", "CHA"};

        JPanel panel = main.resources.java.factory.Component.createTitledPanel("Ability Scores", new GridLayout(1, 6, 10, 10));

        for (int i = 0; i < 6; i++) {
            panel.add(main.resources.java.factory.Component.createAbilityScorePanel(abilityNames[i], scoreFields[i], modLabels[i]));
        }

        return panel;
    }

    /**
     * Create a combat stats panel
     */
    public static JPanel createCombatStatsPanel(JTextField[] fields) {
        String[] labels = {"Armor Class:", "Initiative:", "Speed:", "Prof Bonus:", "Inspiration:", "HP Max:", "HP Current:", "HP Temp:", "Hit Dice:", "Passive Perception:"};

        JPanel panel = main.resources.java.factory.Component.createTitledPanel("Combat Stats", new GridLayout(2, 10, 10, 10));

        for (int i = 0; i < labels.length; i++) {
            panel.add(new JLabel(labels[i]));
            panel.add(fields[i]);
        }

        return panel;
    }

    /**
     * Create a skills panel with all 18 skills
     */
    public static JPanel createSkillsPanel(JCheckBox[] checkboxes, JLabel[] modifiers, String[] skillNames) {
        JPanel panel = main.resources.java.factory.Component.createTitledPanel("Skills", new GridLayout(skillNames.length, 1, 5, 5));

        for (int i = 0; i < skillNames.length; i++) {
            panel.add(main.resources.java.factory.Component.createSkillRow(checkboxes[i], modifiers[i], skillNames[i]));
        }

        return panel;
    }

    /**
     * Create a saving throws panel
     */
    public static JPanel createSavingThrowsPanel(JCheckBox[] checkboxes, JLabel[] modifiers) {
        String[] saveNames = {"Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma"};

        JPanel panel = main.resources.java.factory.Component.createTitledPanel("Saving Throws", new GridLayout(7, 1, 5, 5));

        for (int i = 0; i < 6; i++) {
            panel.add(main.resources.java.factory.Component.createSavingThrowRow(checkboxes[i], modifiers[i], saveNames[i]));
        }

        return panel;
    }

    /**
     * Create a personality panel (Traits, Ideals, Bonds, Flaws)
     */
    public static JPanel createPersonalityPanel(JTextArea[] textAreas) {
        String[] titles = {"Personality Traits", "Ideals", "Bonds", "Flaws"};

        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (int i = 0; i < 4; i++) {
            panel.add(main.resources.java.factory.Component.createTitledTextArea(titles[i], textAreas[i], 5, 20));
        }

        return panel;
    }

    /**
     * Create spellcasting info panel
     */
    public static JPanel createSpellcastingInfoPanel(JTextField[] fields) {
        String[] labels = {"Spellcasting Class:", "Spellcasting Ability:", "Spell Save DC:", "Spell Attack Bonus:"};

        JPanel panel = main.resources.java.factory.Component.createTitledPanel("Spellcasting", new GridLayout(2, 4, 10, 10));

        for (int i = 0; i < labels.length; i++) {
            panel.add(new JLabel(labels[i]));
            panel.add(fields[i]);
        }

        return panel;
    }
}