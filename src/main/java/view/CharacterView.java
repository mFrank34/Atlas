package view;

import main.resources.java.model.Character;
import main.resources.java.model.Attack;
import main.resources.java.model.Spell;
import main.resources.java.factory.Component;
import main.resources.java.factory.Panel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Refactored Character Sheet View using factories
 */
public class CharacterView extends JFrame {

    // Basic Info
    private JTextField[] basicInfoFields;

    // Ability Scores
    private JTextField[] abilityScoreFields;
    private JLabel[] abilityModLabels;

    // Combat Stats
    private JTextField[] combatStatsFields;

    // Skills
    private JCheckBox[] skillProficiencies;
    private JLabel[] skillModifiers;
    private final String[] skillNames = {
            "Acrobatics (Dex)", "Animal Handling (Wis)", "Arcana (Int)",
            "Athletics (Str)", "Deception (Cha)", "History (Int)",
            "Insight (Wis)", "Intimidation (Cha)", "Investigation (Int)",
            "Medicine (Wis)", "Nature (Int)", "Perception (Wis)",
            "Performance (Cha)", "Persuasion (Cha)", "Religion (Int)",
            "Sleight of Hand (Dex)", "Stealth (Dex)", "Survival (Wis)"
    };

    // Saving Throws
    private JCheckBox[] savingThrowProficiencies;
    private JLabel[] savingThrowModifiers;

    // Tables
    private JTable attacksTable;
    private DefaultTableModel attacksTableModel;
    private JTable spellsTable;
    private DefaultTableModel spellsTableModel;

    // Personality
    private JTextArea[] personalityTextAreas;
    private JTextArea txtFeatures;
    private JTextArea txtEquipment;

    // Currency
    private JTextField[] currencyFields;

    // Spellcasting
    private JTextField[] spellcastingFields;
    private JTextField[] spellSlotsTotalFields;
    private JTextField[] spellSlotsUsedFields;

    public CharacterView() {
        setTitle("D&D 5e Character Sheet");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        initializeComponents();

        // Tabs
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Character", createCharacterPanel());
        tabbedPane.addTab("Combat & Skills", createCombatSkillsPanel());
        tabbedPane.addTab("Spells", createSpellsPanel());
        tabbedPane.addTab("Equipment", createEquipmentPanel());
        tabbedPane.addTab("Personality", createPersonalityPanel());

        add(tabbedPane, BorderLayout.CENTER);

        setSize(1000, 800);
        setLocationRelativeTo(null);
    }

    /** Initialize all components using main.resources.java.factory methods */
    private void initializeComponents() {
        // Basic Info
        basicInfoFields = new JTextField[8];
        for (int i = 0; i < 8; i++) basicInfoFields[i] = Component.createTextField();

        // Ability Scores
        abilityScoreFields = new JTextField[6];
        abilityModLabels = new JLabel[6];
        for (int i = 0; i < 6; i++) {
            abilityScoreFields[i] = Component.createTextField();
            abilityModLabels[i] = Component.createLabel("+0");
        }

        // Combat Stats
        combatStatsFields = new JTextField[10];
        for (int i = 0; i < 10; i++) combatStatsFields[i] = Component.createTextField();

        // Skills
        skillProficiencies = new JCheckBox[18];
        skillModifiers = new JLabel[18];
        for (int i = 0; i < 18; i++) {
            skillProficiencies[i] = Component.createCheckBox();
            skillModifiers[i] = Component.createLabel("+0");
        }

        // Saving Throws
        savingThrowProficiencies = new JCheckBox[6];
        savingThrowModifiers = new JLabel[6];
        for (int i = 0; i < 6; i++) {
            savingThrowProficiencies[i] = Component.createCheckBox();
            savingThrowModifiers[i] = Component.createLabel("+0");
        }

        // Personality
        personalityTextAreas = new JTextArea[4];
        for (int i = 0; i < 4; i++) personalityTextAreas[i] = Component.createTextArea(5, 20);

        txtFeatures = Component.createTextArea(5, 20);
        txtEquipment = Component.createTextArea(10, 40);

        // Currency
        currencyFields = new JTextField[5];
        for (int i = 0; i < 5; i++) currencyFields[i] = Component.createTextField("0");

        // Spellcasting
        spellcastingFields = new JTextField[4];
        for (int i = 0; i < 4; i++) spellcastingFields[i] = Component.createTextField();

        spellSlotsTotalFields = new JTextField[9];
        spellSlotsUsedFields = new JTextField[9];
        for (int i = 0; i < 9; i++) {
            spellSlotsTotalFields[i] = Component.createCenteredTextField("0");
            spellSlotsUsedFields[i] = Component.createCenteredTextField("0");
        }

        // Tables
        attacksTableModel = new DefaultTableModel();
        spellsTableModel = new DefaultTableModel();
    }

    /** Character Tab */
    private JPanel createCharacterPanel() {
        JPanel panel = Component.createPanelWithMargin(new BorderLayout(10, 10));
        panel.add(Panel.createBasicInfoPanel(basicInfoFields), BorderLayout.NORTH);
        panel.add(Panel.createAbilityScoresPanel(abilityScoreFields, abilityModLabels), BorderLayout.CENTER);
        return panel;
    }

    /** Combat & Skills Tab */
    private JPanel createCombatSkillsPanel() {
        JPanel panel = Component.createPanelWithMargin(new BorderLayout(10, 10));
        panel.add(Panel.createCombatStatsPanel(combatStatsFields), BorderLayout.NORTH);

        JPanel skillsAndSaves = new JPanel(new GridLayout(1, 2, 10, 10));
        skillsAndSaves.add(Panel.createSavingThrowsPanel(savingThrowProficiencies, savingThrowModifiers));

        JPanel skillsPanel = Panel.createSkillsPanel(skillProficiencies, skillModifiers, skillNames);
        skillsAndSaves.add(new JScrollPane(skillsPanel));

        panel.add(skillsAndSaves, BorderLayout.CENTER);

        // Attacks table
        String[] attackColumns = {"Name", "Attack Bonus", "Damage", "Type", "Range"};
        attacksTable = Component.createTable(attackColumns, attacksTableModel);
        JPanel attacksPanel = Component.createTablePanel("Attacks & Weapons", attacksTable, 150, "Add Attack", "Remove Attack");
        panel.add(attacksPanel, BorderLayout.SOUTH);

        return panel;
    }

    /** Spells Tab */
    private JPanel createSpellsPanel() {
        JPanel panel = Component.createPanelWithMargin(new BorderLayout(10, 10));
        panel.add(Panel.createSpellcastingInfoPanel(spellcastingFields), BorderLayout.NORTH);
        panel.add(Component.createSpellSlotsPanel(spellSlotsTotalFields, spellSlotsUsedFields), BorderLayout.CENTER);

        String[] spellColumns = {"Name", "Level", "School", "Casting Time", "Range", "Prepared", "Ritual", "Concentration"};
        spellsTable = Component.createTable(spellColumns, spellsTableModel);
        spellsTableModel = new DefaultTableModel(spellColumns, 0) {
            @Override
            public Class<?> getColumnClass(int column) {
                return column >= 5 ? Boolean.class : String.class;
            }
        };
        spellsTable.setModel(spellsTableModel);

        JPanel spellsTablePanel = Component.createTablePanel("Spells Known", spellsTable, 300, "Add Spell", "Remove Spell");
        panel.add(spellsTablePanel, BorderLayout.SOUTH);

        return panel;
    }

    /** Equipment Tab */
    private JPanel createEquipmentPanel() {
        JPanel panel = Component.createPanelWithMargin(new BorderLayout(10, 10));
        panel.add(Component.createCurrencyPanel(currencyFields), BorderLayout.NORTH);
        panel.add(Component.createTitledTextArea("Equipment & Gear", txtEquipment, 10, 40), BorderLayout.CENTER);
        return panel;
    }

    /** Personality Tab */
    private JPanel createPersonalityPanel() {
        JPanel panel = Component.createPanelWithMargin(new GridLayout(3, 2, 10, 10));
        panel.add(Panel.createPersonalityPanel(personalityTextAreas));
        panel.add(Component.createTitledTextArea("Features & Traits", txtFeatures, 10, 40));
        return panel;
    }

    /** Load a character into the main.resources.java.view */
    public void loadCharacter(Character character) {
        // Basic Info
        basicInfoFields[0].setText(character.getCharacterName());
        basicInfoFields[1].setText(character.getPlayerName());
        basicInfoFields[2].setText(character.getCharacterClass());
        basicInfoFields[3].setText(String.valueOf(character.getLevel()));
        basicInfoFields[4].setText(character.getRace());
        basicInfoFields[5].setText(character.getBackground());
        basicInfoFields[6].setText(character.getAlignment());
        basicInfoFields[7].setText(String.valueOf(character.getExperiencePoints()));

        // Ability Scores
        abilityScoreFields[0].setText(String.valueOf(character.getStrength()));
        abilityScoreFields[1].setText(String.valueOf(character.getDexterity()));
        abilityScoreFields[2].setText(String.valueOf(character.getConstitution()));
        abilityScoreFields[3].setText(String.valueOf(character.getIntelligence()));
        abilityScoreFields[4].setText(String.valueOf(character.getWisdom()));
        abilityScoreFields[5].setText(String.valueOf(character.getCharisma()));

        updateAbilityModifiers(character);

        // Combat Stats
        combatStatsFields[0].setText(String.valueOf(character.getArmorClass()));
        combatStatsFields[1].setText(String.valueOf(character.getInitiative()));
        combatStatsFields[2].setText(String.valueOf(character.getSpeed()));
        combatStatsFields[3].setText(String.valueOf(character.getProficiencyBonus()));
        combatStatsFields[4].setText(String.valueOf(character.getInspiration()));
        combatStatsFields[5].setText(String.valueOf(character.getHitPointMaximum()));
        combatStatsFields[6].setText(String.valueOf(character.getCurrentHitPoints()));
        combatStatsFields[7].setText(String.valueOf(character.getTemporaryHitPoints()));
        combatStatsFields[8].setText(character.getHitDice());
        combatStatsFields[9].setText(String.valueOf(character.getPassivePerception()));

        // Attacks
        attacksTableModel.setRowCount(0);
        for (Attack attack : character.getAttacks()) {
            attacksTableModel.addRow(new Object[]{
                    attack.getName(),
                    "+" + attack.getAttackBonus(),
                    attack.getDamage(),
                    attack.getDamageType(),
                    attack.getRange()
            });
        }

        // Spells
        spellsTableModel.setRowCount(0);
        for (Spell spell : character.getSpellsKnown()) {
            spellsTableModel.addRow(new Object[]{
                    spell.getName(),
                    spell.getLevel(),
                    spell.getSchool(),
                    spell.getCastingTime(),
                    spell.getRange(),
                    spell.isPrepared(),
                    spell.isRitual(),
                    spell.isConcentration()
            });
        }

        // Currency
        currencyFields[0].setText(String.valueOf(character.getCopperPieces()));
        currencyFields[1].setText(String.valueOf(character.getSilverPieces()));
        currencyFields[2].setText(String.valueOf(character.getElectrumPieces()));
        currencyFields[3].setText(String.valueOf(character.getGoldPieces()));
        currencyFields[4].setText(String.valueOf(character.getPlatinumPieces()));

        // Personality
        personalityTextAreas[0].setText(character.getPersonalityTraits());
        personalityTextAreas[1].setText(character.getIdeals());
        personalityTextAreas[2].setText(character.getBonds());
        personalityTextAreas[3].setText(character.getFlaws());

        // Equipment
        txtEquipment.setText(String.join("\n", character.getEquipment()));
        txtFeatures.setText(String.join("\n", character.getFeaturesAndTraits()));
    }

    /** Update ability modifiers */
    private void updateAbilityModifiers(Character character) {
        abilityModLabels[0].setText(Component.formatModifier(character.getStrength()));
        abilityModLabels[1].setText(Component.formatModifier(character.getDexterity()));
        abilityModLabels[2].setText(Component.formatModifier(character.getConstitution()));
        abilityModLabels[3].setText(Component.formatModifier(character.getIntelligence()));
        abilityModLabels[4].setText(Component.formatModifier(character.getWisdom()));
        abilityModLabels[5].setText(Component.formatModifier(character.getCharisma()));
    }

    /** Main for testing */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CharacterView view = new CharacterView();

            Character sampleChar = new Character();
            sampleChar.setCharacterName("Gandalf");
            sampleChar.setPlayerName("John");
            sampleChar.setCharacterClass("Wizard");
            sampleChar.setLevel(10);
            sampleChar.setRace("Human");
            sampleChar.setBackground("Sage");
            sampleChar.setAlignment("Neutral Good");
            sampleChar.setStrength(10);
            sampleChar.setDexterity(14);
            sampleChar.setConstitution(12);
            sampleChar.setIntelligence(18);
            sampleChar.setWisdom(16);
            sampleChar.setCharisma(14);
            sampleChar.setArmorClass(15);
            sampleChar.setHitPointMaximum(52);
            sampleChar.setCurrentHitPoints(52);
            sampleChar.setSpeed(30);
            sampleChar.setProficiencyBonus(4);

            Attack staff = new Attack("Quarterstaff", 2, "1d6", "Bludgeoning", "Melee", "Versatile", true);
            sampleChar.getAttacks().add(staff);

            Spell fireball = new Spell("Fireball", 3, "Evocation", "1 action", "150 feet", "8d6 fire damage");
            sampleChar.getSpellsKnown().add(fireball);

            view.loadCharacter(sampleChar);
            view.setVisible(true);
        });
    }
}
