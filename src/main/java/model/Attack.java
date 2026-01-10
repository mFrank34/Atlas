package model;

/**
 * Represents an attack or weapon in D&D 5e
 */
public class Attack {
    private String name;
    private int attackBonus;
    private String damage;
    private String damageType;
    private String range;
    private String properties;
    private boolean proficient;
    private int criticalRange;

    /**
     * Default constructor
     */
    public Attack() {
        this.criticalRange = 20; // Natural 20 is default critical
    }

    /**
     * Constructor with basic parameters
     */
    public Attack(String name, int attackBonus, String damage, String damageType) {
        this.name = name;
        this.attackBonus = attackBonus;
        this.damage = damage;
        this.damageType = damageType;
        this.criticalRange = 20;
    }

    /**
     * Constructor with all parameters
     */
    public Attack(String name, int attackBonus, String damage, String damageType, String range, String properties, boolean proficient) {
        this.name = name;
        this.attackBonus = attackBonus;
        this.damage = damage;
        this.damageType = damageType;
        this.range = range;
        this.properties = properties;
        this.proficient = proficient;
        this.criticalRange = 20;
    }

    /**
     * Calculate total attack bonus with modifiers
     */
    public int calculateTotalAttackBonus(int abilityModifier, int proficiencyBonus) {
        if (proficient) {
            return attackBonus + abilityModifier + proficiencyBonus;
        }
        return attackBonus + abilityModifier;
    }

    /**
     * Check if a roll is a critical hit
     */
    public boolean isCriticalHit(int rollResult) {
        return rollResult >= criticalRange;
    }

    /**
     * Format attack for display
     */
    public String getAttackDescription() {
        StringBuilder desc = new StringBuilder();
        desc.append(name);
        desc.append(": +").append(attackBonus);
        desc.append(" to hit, ");
        desc.append(damage).append(" ");
        desc.append(damageType).append(" damage");

        if (range != null && !range.isEmpty()) {
            desc.append(", Range: ").append(range);
        }

        return desc.toString();
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttackBonus() {
        return attackBonus;
    }

    public void setAttackBonus(int attackBonus) {
        this.attackBonus = attackBonus;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public String getDamageType() {
        return damageType;
    }

    public void setDamageType(String damageType) {
        this.damageType = damageType;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public boolean isProficient() {
        return proficient;
    }

    public void setProficient(boolean proficient) {
        this.proficient = proficient;
    }

    public int getCriticalRange() {
        return criticalRange;
    }

    public void setCriticalRange(int criticalRange) {
        this.criticalRange = criticalRange;
    }

    @Override
    public String toString() {
        return getAttackDescription();
    }
}

