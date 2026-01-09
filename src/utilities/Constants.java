package utilities;

import java.util.List;

public class Constants {
    public static final String SIGNATURE_KEY = "Atlas-Signature";
    public static final String EXPECTED_SIGNATURE = "ATLAS_V1";

    /**
     * Get all field labels from the D&D 5e Character Sheet
     */
    public static List<String> getAllFieldLabels() {
        return List.of(
                "CHARACTER NAME",
                "CLASS & LEVEL",
                "BACKGROUND",
                "PLAYER NAME",
                "RACE",
                "ALIGNMENT",
                "EXPERIENCE POINTS",
                "STRENGTH",
                "DEXTERITY",
                "CONSTITUTION",
                "INTELLIGENCE",
                "WISDOM",
                "CHARISMA",
                "ARMOR CLASS",
                "INITIATIVE",
                "SPEED",
                "HIT POINT MAXIMUM",
                "CURRENT HIT POINTS",
                "TEMPORARY HIT POINTS",
                "HIT DICE",
                "DEATH SAVES",
                "SUCCESSES",
                "FAILURES",
                "PROFICIENCY BONUS",
                "INSPIRATION",
                "PASSIVE WISDOM (PERCEPTION)",
                "STRENGTH SAVING THROW",
                "DEXTERITY SAVING THROW",
                "CONSTITUTION SAVING THROW",
                "INTELLIGENCE SAVING THROW",
                "WISDOM SAVING THROW",
                "CHARISMA SAVING THROW",
                "Acrobatics (Dex)",
                "Animal Handling (Wis)",
                "Arcana (Int)",
                "Athletics (Str)",
                "Deception (Cha)",
                "History (Int)",
                "Insight (Wis)",
                "Intimidation (Cha)",
                "Investigation (Int)",
                "Medicine (Wis)",
                "Nature (Int)",
                "Perception (Wis)",
                "Performance (Cha)",
                "Persuasion (Cha)",
                "Religion (Int)",
                "Sleight of Hand (Dex)",
                "Stealth (Dex)",
                "Survival (Wis)",
                "ATTACKS & SPELLCASTING",
                "NAME",
                "ATK BONUS",
                "DAMAGE/TYPE",
                "OTHER PROFICIENCIES & LANGUAGES",
                "EQUIPMENT",
                "CP",
                "SP",
                "EP",
                "GP",
                "PP",
                "PERSONALITY TRAITS",
                "IDEALS",
                "BONDS",
                "FLAWS",
                "FEATURES & TRAITS",
                "AGE",
                "HEIGHT",
                "WEIGHT",
                "EYES",
                "SKIN",
                "HAIR",
                "CHARACTER APPEARANCE",
                "CHARACTER BACKSTORY",
                "ALLIES & ORGANIZATIONS",
                "ADDITIONAL FEATURES & TRAITS",
                "TREASURE",
                "SYMBOL",
                "SPELLCASTING CLASS",
                "SPELLCASTING ABILITY",
                "SPELL SAVE DC",
                "SPELL ATTACK BONUS",
                "CANTRIPS",
                "SPELLS KNOWN",
                "SPELL NAME",
                "PREPARED",
                "SPELL LEVEL",
                "SLOTS TOTAL",
                "SLOTS EXPENDED"
        );
    }

    /**
     * private constructor to prevent initialization as nothing should create this class
     */
    private Constants() {
        throw new AssertionError("Cannot instantiate constants class");
    }
}