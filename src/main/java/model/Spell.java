package main.resources.java.model;

/**
 * Represents a spell in D&D 5e
 */
public class Spell {
    private String name;
    private int level;
    private String school;
    private String castingTime;
    private String range;
    private String components;
    private String duration;
    private String description;
    private boolean prepared;
    private boolean ritual;
    private boolean concentration;

    /**
     * Default constructor
     */
    public Spell() {
        this.prepared = false;
        this.ritual = false;
        this.concentration = false;
    }

    /**
     * Constructor with basic parameters
     */
    public Spell(String name, int level) {
        this.name = name;
        this.level = level;
        this.prepared = false;
        this.ritual = false;
        this.concentration = false;
    }

    /**
     * Constructor with common parameters
     */
    public Spell(String name, int level, String school, String castingTime, String range, String duration) {
        this.name = name;
        this.level = level;
        this.school = school;
        this.castingTime = castingTime;
        this.range = range;
        this.duration = duration;
        this.prepared = false;
        this.ritual = false;
        this.concentration = false;
    }

    /**
     * Constructor with all parameters
     */
    public Spell(String name, int level, String school, String castingTime, String range, String components, String duration, String description, boolean ritual, boolean concentration) {
        this.name = name;
        this.level = level;
        this.school = school;
        this.castingTime = castingTime;
        this.range = range;
        this.components = components;
        this.duration = duration;
        this.description = description;
        this.prepared = false;
        this.ritual = ritual;
        this.concentration = concentration;
    }

    /**
     * Check if this is a cantrip
     */
    public boolean isCantrip() {
        return level == 0;
    }

    /**
     * Get spell level as a string
     */
    public String getLevelString() {
        if (level == 0) {
            return "Cantrip";
        }
        return level + getOrdinalSuffix(level) + " level";
    }

    /**
     * Helper method to get ordinal suffix
     */
    private String getOrdinalSuffix(int number) {
        if (number >= 11 && number <= 13) {
            return "th";
        }
        switch (number % 10) {
            case 1:
                return "st";
            case 2:
                return "nd";
            case 3:
                return "rd";
            default:
                return "th";
        }
    }

    /**
     * Format spell for display
     */
    public String getSpellDescription() {
        StringBuilder desc = new StringBuilder();
        desc.append(name);

        if (level == 0) {
            desc.append(" (Cantrip)");
        } else {
            desc.append(" (").append(getLevelString()).append(")");
        }

        if (school != null && !school.isEmpty()) {
            desc.append(" - ").append(school);
        }

        if (ritual) {
            desc.append(" [Ritual]");
        }

        if (concentration) {
            desc.append(" [Concentration]");
        }

        return desc.toString();
    }

    /**
     * Get full spell details
     */
    public String getFullDescription() {
        StringBuilder full = new StringBuilder();
        full.append(getSpellDescription()).append("\n");

        if (castingTime != null) {
            full.append("Casting Time: ").append(castingTime).append("\n");
        }

        if (range != null) {
            full.append("Range: ").append(range).append("\n");
        }

        if (components != null) {
            full.append("Components: ").append(components).append("\n");
        }

        if (duration != null) {
            full.append("Duration: ").append(duration).append("\n");
        }

        if (description != null) {
            full.append("\n").append(description);
        }

        return full.toString();
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getCastingTime() {
        return castingTime;
    }

    public void setCastingTime(String castingTime) {
        this.castingTime = castingTime;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getComponents() {
        return components;
    }

    public void setComponents(String components) {
        this.components = components;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPrepared() {
        return prepared;
    }

    public void setPrepared(boolean prepared) {
        this.prepared = prepared;
    }

    public boolean isRitual() {
        return ritual;
    }

    public void setRitual(boolean ritual) {
        this.ritual = ritual;
    }

    public boolean isConcentration() {
        return concentration;
    }

    public void setConcentration(boolean concentration) {
        this.concentration = concentration;
    }

    @Override
    public String toString() {
        return getSpellDescription();
    }
}