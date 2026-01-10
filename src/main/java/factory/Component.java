package main.resources.java.factory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Factory class for creating reusable UI components
 * Eliminates code duplication and provides consistent styling
 */
public class Component {

    // Default styling constants
    public static final Color BORDER_COLOR = Color.GRAY;
    public static final Font LABEL_FONT = new Font("Arial", Font.BOLD, 14);
    public static final Font VALUE_FONT = new Font("Arial", Font.BOLD, 20);
    public static final Font MODIFIER_FONT = new Font("Arial", Font.PLAIN, 16);
    public static final int DEFAULT_MARGIN = 10;

    /**
     * Create a labeled text field pair
     */
    public static JPanel createLabeledTextField(String label, JTextField textField) {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.add(new JLabel(label), BorderLayout.WEST);
        panel.add(textField, BorderLayout.CENTER);
        return panel;
    }

    /**
     * Create a standard text field
     */
    public static JTextField createTextField() {
        return new JTextField();
    }

    /**
     * Create a text field with initial value
     */
    public static JTextField createTextField(String initialValue) {
        return new JTextField(initialValue);
    }

    /**
     * Create a centered text field
     */
    public static JTextField createCenteredTextField() {
        JTextField field = new JTextField();
        field.setHorizontalAlignment(JTextField.CENTER);
        return field;
    }

    /**
     * Create a centered text field with initial value
     */
    public static JTextField createCenteredTextField(String initialValue) {
        JTextField field = new JTextField(initialValue);
        field.setHorizontalAlignment(JTextField.CENTER);
        return field;
    }

    /**
     * Create an ability score panel (used for STR, DEX, CON, etc.)
     */
    public static JPanel createAbilityScorePanel(String name, JTextField scoreField, JLabel modLabel) {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createLineBorder(BORDER_COLOR));

        JLabel nameLabel = new JLabel(name, SwingConstants.CENTER);
        nameLabel.setFont(LABEL_FONT);
        panel.add(nameLabel, BorderLayout.NORTH);

        scoreField.setHorizontalAlignment(JTextField.CENTER);
        scoreField.setFont(VALUE_FONT);
        panel.add(scoreField, BorderLayout.CENTER);

        modLabel.setHorizontalAlignment(SwingConstants.CENTER);
        modLabel.setFont(MODIFIER_FONT);
        panel.add(modLabel, BorderLayout.SOUTH);

        return panel;
    }

    /**
     * Create a skill row with checkbox and modifier
     */
    public static JPanel createSkillRow(JCheckBox proficiencyCheckbox, JLabel modifierLabel, String skillName) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        modifierLabel.setPreferredSize(new Dimension(40, 20));
        panel.add(proficiencyCheckbox);
        panel.add(modifierLabel);
        panel.add(new JLabel(skillName));
        return panel;
    }

    /**
     * Create a saving throw row with checkbox and modifier
     */
    public static JPanel createSavingThrowRow(JCheckBox proficiencyCheckbox, JLabel modifierLabel, String saveName) {
        return createSkillRow(proficiencyCheckbox, modifierLabel, saveName);
    }

    /**
     * Create a titled panel with border
     */
    public static JPanel createTitledPanel(String title, LayoutManager layout) {
        JPanel panel = new JPanel(layout);
        panel.setBorder(BorderFactory.createTitledBorder(title));
        return panel;
    }

    /**
     * Create a titled panel with default FlowLayout
     */
    public static JPanel createTitledPanel(String title) {
        return createTitledPanel(title, new FlowLayout());
    }

    /**
     * Create a panel with empty border (margins)
     */
    public static JPanel createPanelWithMargin(LayoutManager layout, int margin) {
        JPanel panel = new JPanel(layout);
        panel.setBorder(BorderFactory.createEmptyBorder(margin, margin, margin, margin));
        return panel;
    }

    /**
     * Create a panel with default margins
     */
    public static JPanel createPanelWithMargin(LayoutManager layout) {
        return createPanelWithMargin(layout, DEFAULT_MARGIN);
    }

    /**
     * Create a text area with scroll pane
     */
    public static JScrollPane createScrollableTextArea(JTextArea textArea, int rows, int cols) {
        textArea.setRows(rows);
        textArea.setColumns(cols);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        return new JScrollPane(textArea);
    }

    /**
     * Create a standard text area
     */
    public static JTextArea createTextArea(int rows, int cols) {
        JTextArea textArea = new JTextArea(rows, cols);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        return textArea;
    }

    /**
     * Create a table with specified columns
     */
    public static JTable createTable(String[] columnNames, DefaultTableModel model) {
        model.setColumnIdentifiers(columnNames);
        return new JTable(model);
    }

    /**
     * Create a table with scroll pane
     */
    public static JScrollPane createScrollableTable(JTable table, int preferredHeight) {
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(0, preferredHeight));
        return scrollPane;
    }

    /**
     * Create a table panel with add/remove buttons
     */
    public static JPanel createTablePanel(String title, JTable table, int tableHeight, String addButtonText, String removeButtonText) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(title));

        JScrollPane scrollPane = createScrollableTable(table, tableHeight);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnAdd = new JButton(addButtonText);
        JButton btnRemove = new JButton(removeButtonText);
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnRemove);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    /**
     * Create a grid of labeled text fields
     */
    public static JPanel createLabeledFieldGrid(String[] labels, JTextField[] fields, int rows, int cols) {
        JPanel panel = new JPanel(new GridLayout(rows, cols * 2, 10, 10));

        for (int i = 0; i < labels.length; i++) {
            panel.add(new JLabel(labels[i]));
            panel.add(fields[i]);
        }

        return panel;
    }

    /**
     * Create a currency panel (CP, SP, EP, GP, PP)
     */
    public static JPanel createCurrencyPanel(JTextField[] currencyFields) {
        String[] labels = {"CP:", "SP:", "EP:", "GP:", "PP:"};
        JPanel panel = createTitledPanel("Currency", new GridLayout(1, 10, 10, 10));

        for (int i = 0; i < 5; i++) {
            panel.add(new JLabel(labels[i]));
            panel.add(currencyFields[i]);
        }

        return panel;
    }

    /**
     * Create a spell slot panel for a specific level
     */
    public static JPanel createSpellSlotPanel(int level, JTextField totalField, JTextField usedField) {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.add(new JLabel("Level " + level, SwingConstants.CENTER), BorderLayout.NORTH);

        totalField.setHorizontalAlignment(JTextField.CENTER);
        usedField.setHorizontalAlignment(JTextField.CENTER);

        panel.add(totalField, BorderLayout.CENTER);
        panel.add(usedField, BorderLayout.SOUTH);

        return panel;
    }

    /**
     * Create a panel with multiple spell slot levels
     */
    public static JPanel createSpellSlotsPanel(JTextField[] totalFields, JTextField[] usedFields) {
        JPanel panel = createTitledPanel("Spell Slots", new GridLayout(1, 9, 5, 5));

        for (int i = 0; i < 9; i++) {
            panel.add(createSpellSlotPanel(i + 1, totalFields[i], usedFields[i]));
        }

        return panel;
    }

    /**
     * Create a button panel with multiple buttons
     */
    public static JPanel createButtonPanel(String... buttonLabels) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        for (String label : buttonLabels) {
            panel.add(new JButton(label));
        }

        return panel;
    }

    /**
     * Create a titled text area section
     */
    public static JPanel createTitledTextArea(String title, JTextArea textArea, int rows, int cols) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(title));

        textArea.setRows(rows);
        textArea.setColumns(cols);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        return panel;
    }

    /**
     * Format modifier with + or - sign
     */
    public static String formatModifier(int modifier) {
        return (modifier >= 0 ? "+" : "") + modifier;
    }

    /**
     * Create a standard label
     */
    public static JLabel createLabel(String text) {
        return new JLabel(text);
    }

    /**
     * Create a bold label
     */
    public static JLabel createBoldLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font(label.getFont().getName(), Font.BOLD, label.getFont().getSize()));
        return label;
    }

    /**
     * Create a centered label
     */
    public static JLabel createCenteredLabel(String text) {
        return new JLabel(text, SwingConstants.CENTER);
    }

    /**
     * Create a checkbox
     */
    public static JCheckBox createCheckBox() {
        return new JCheckBox();
    }

    /**
     * Create a checkbox with label
     */
    public static JCheckBox createCheckBox(String label) {
        return new JCheckBox(label);
    }
}