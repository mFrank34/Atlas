package model;

import java.util.ArrayList;
import java.util.List;

public class Character {
    // Basic Information
    private String characterName;
    private String playerName;
    private String characterClass;
    private int level;
    private String background;
    private String race;
    private String alignment;
    private int experiencePoints;

    // Ability Scores
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    // Combat Stats
    private int armorClass;
    private int initiative;
    private int speed;
    private int proficiencyBonus;
    private int hitPointMaximum;
    private int currentHitPoints;
    private int temporaryHitPoints;
    private String hitDice;
    private int inspiration;

    // Death Saves
    private int deathSaveSuccesses;
    private int deathSaveFailures;

    // Skills (proficiency)
    private boolean acrobaticsProficient;
    private boolean animalHandlingProficient;
    private boolean arcanaProficient;
    private boolean athleticsProficient;
    private boolean deceptionProficient;
    private boolean historyProficient;
    private boolean insightProficient;
    private boolean intimidationProficient;
    private boolean investigationProficient;
    private boolean medicineProficient;
    private boolean natureProficient;
    private boolean perceptionProficient;
    private boolean performanceProficient;
    private boolean persuasionProficient;
    private boolean religionProficient;
    private boolean sleightOfHandProficient;
    private boolean stealthProficient;
    private boolean survivalProficient;

    // Saving Throw Proficiencies
    private boolean strengthSaveProficient;
    private boolean dexteritySaveProficient;
    private boolean constitutionSaveProficient;
    private boolean intelligenceSaveProficient;
    private boolean wisdomSaveProficient;
    private boolean charismaSaveProficient;

    // Character Details
    private int passivePerception;
    private List<String> languages;
    private List<String> otherProficiencies;
    private List<Attack> attacks;
    private List<String> equipment;
    private String personalityTraits;
    private String ideals;
    private String bonds;
    private String flaws;
    private List<String> featuresAndTraits;

    // Appearance
    private int age;
    private String height;
    private String weight;
    private String eyes;
    private String skin;
    private String hair;
    private String characterAppearance;
    private String backstory;

    // Currency
    private int copperPieces;
    private int silverPieces;
    private int electrumPieces;
    private int goldPieces;
    private int platinumPieces;

    // Spellcasting
    private String spellcastingClass;
    private String spellcastingAbility;
    private int spellSaveDC;
    private int spellAttackBonus;
    private List<Spell> cantrips;
    private List<Spell> spellsKnown;
    private int[] spellSlotsTotal;
    private int[] spellSlotsExpended;

    // Constructor
    public Character() {
        attacks = new ArrayList<>();
        spellsKnown = new ArrayList<>();
        cantrips = new ArrayList<>();
        equipment = new ArrayList<>();
        featuresAndTraits = new ArrayList<>();
        languages = new ArrayList<>();
        otherProficiencies = new ArrayList<>();
        spellSlotsTotal = new int[9];
        spellSlotsExpended = new int[9];
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getProficiencyBonus() {
        return proficiencyBonus;
    }

    public void setProficiencyBonus(int proficiencyBonus) {
        this.proficiencyBonus = proficiencyBonus;
    }

    public int getHitPointMaximum() {
        return hitPointMaximum;
    }

    public void setHitPointMaximum(int hitPointMaximum) {
        this.hitPointMaximum = hitPointMaximum;
    }

    public int getCurrentHitPoints() {
        return currentHitPoints;
    }

    public void setCurrentHitPoints(int currentHitPoints) {
        this.currentHitPoints = currentHitPoints;
    }

    public int getTemporaryHitPoints() {
        return temporaryHitPoints;
    }

    public void setTemporaryHitPoints(int temporaryHitPoints) {
        this.temporaryHitPoints = temporaryHitPoints;
    }

    public String getHitDice() {
        return hitDice;
    }

    public void setHitDice(String hitDice) {
        this.hitDice = hitDice;
    }

    public int getInspiration() {
        return inspiration;
    }

    public void setInspiration(int inspiration) {
        this.inspiration = inspiration;
    }

    public int getDeathSaveSuccesses() {
        return deathSaveSuccesses;
    }

    public void setDeathSaveSuccesses(int deathSaveSuccesses) {
        this.deathSaveSuccesses = deathSaveSuccesses;
    }

    public int getDeathSaveFailures() {
        return deathSaveFailures;
    }

    public void setDeathSaveFailures(int deathSaveFailures) {
        this.deathSaveFailures = deathSaveFailures;
    }

    public boolean isAcrobaticsProficient() {
        return acrobaticsProficient;
    }

    public void setAcrobaticsProficient(boolean acrobaticsProficient) {
        this.acrobaticsProficient = acrobaticsProficient;
    }

    public boolean isAnimalHandlingProficient() {
        return animalHandlingProficient;
    }

    public void setAnimalHandlingProficient(boolean animalHandlingProficient) {
        this.animalHandlingProficient = animalHandlingProficient;
    }

    public boolean isArcanaProficient() {
        return arcanaProficient;
    }

    public void setArcanaProficient(boolean arcanaProficient) {
        this.arcanaProficient = arcanaProficient;
    }

    public boolean isAthleticsProficient() {
        return athleticsProficient;
    }

    public void setAthleticsProficient(boolean athleticsProficient) {
        this.athleticsProficient = athleticsProficient;
    }

    public boolean isDeceptionProficient() {
        return deceptionProficient;
    }

    public void setDeceptionProficient(boolean deceptionProficient) {
        this.deceptionProficient = deceptionProficient;
    }

    public boolean isHistoryProficient() {
        return historyProficient;
    }

    public void setHistoryProficient(boolean historyProficient) {
        this.historyProficient = historyProficient;
    }

    public boolean isInsightProficient() {
        return insightProficient;
    }

    public void setInsightProficient(boolean insightProficient) {
        this.insightProficient = insightProficient;
    }

    public boolean isIntimidationProficient() {
        return intimidationProficient;
    }

    public void setIntimidationProficient(boolean intimidationProficient) {
        this.intimidationProficient = intimidationProficient;
    }

    public boolean isInvestigationProficient() {
        return investigationProficient;
    }

    public void setInvestigationProficient(boolean investigationProficient) {
        this.investigationProficient = investigationProficient;
    }

    public boolean isMedicineProficient() {
        return medicineProficient;
    }

    public void setMedicineProficient(boolean medicineProficient) {
        this.medicineProficient = medicineProficient;
    }

    public boolean isNatureProficient() {
        return natureProficient;
    }

    public void setNatureProficient(boolean natureProficient) {
        this.natureProficient = natureProficient;
    }

    public boolean isPerceptionProficient() {
        return perceptionProficient;
    }

    public void setPerceptionProficient(boolean perceptionProficient) {
        this.perceptionProficient = perceptionProficient;
    }

    public boolean isPerformanceProficient() {
        return performanceProficient;
    }

    public void setPerformanceProficient(boolean performanceProficient) {
        this.performanceProficient = performanceProficient;
    }

    public boolean isPersuasionProficient() {
        return persuasionProficient;
    }

    public void setPersuasionProficient(boolean persuasionProficient) {
        this.persuasionProficient = persuasionProficient;
    }

    public boolean isReligionProficient() {
        return religionProficient;
    }

    public void setReligionProficient(boolean religionProficient) {
        this.religionProficient = religionProficient;
    }

    public boolean isSleightOfHandProficient() {
        return sleightOfHandProficient;
    }

    public void setSleightOfHandProficient(boolean sleightOfHandProficient) {
        this.sleightOfHandProficient = sleightOfHandProficient;
    }

    public boolean isStealthProficient() {
        return stealthProficient;
    }

    public void setStealthProficient(boolean stealthProficient) {
        this.stealthProficient = stealthProficient;
    }

    public boolean isSurvivalProficient() {
        return survivalProficient;
    }

    public void setSurvivalProficient(boolean survivalProficient) {
        this.survivalProficient = survivalProficient;
    }

    public boolean isStrengthSaveProficient() {
        return strengthSaveProficient;
    }

    public void setStrengthSaveProficient(boolean strengthSaveProficient) {
        this.strengthSaveProficient = strengthSaveProficient;
    }

    public boolean isDexteritySaveProficient() {
        return dexteritySaveProficient;
    }

    public void setDexteritySaveProficient(boolean dexteritySaveProficient) {
        this.dexteritySaveProficient = dexteritySaveProficient;
    }

    public boolean isConstitutionSaveProficient() {
        return constitutionSaveProficient;
    }

    public void setConstitutionSaveProficient(boolean constitutionSaveProficient) {
        this.constitutionSaveProficient = constitutionSaveProficient;
    }

    public boolean isIntelligenceSaveProficient() {
        return intelligenceSaveProficient;
    }

    public void setIntelligenceSaveProficient(boolean intelligenceSaveProficient) {
        this.intelligenceSaveProficient = intelligenceSaveProficient;
    }

    public boolean isWisdomSaveProficient() {
        return wisdomSaveProficient;
    }

    public void setWisdomSaveProficient(boolean wisdomSaveProficient) {
        this.wisdomSaveProficient = wisdomSaveProficient;
    }

    public boolean isCharismaSaveProficient() {
        return charismaSaveProficient;
    }

    public void setCharismaSaveProficient(boolean charismaSaveProficient) {
        this.charismaSaveProficient = charismaSaveProficient;
    }

    public int getPassivePerception() {
        return passivePerception;
    }

    public void setPassivePerception(int passivePerception) {
        this.passivePerception = passivePerception;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<String> getOtherProficiencies() {
        return otherProficiencies;
    }

    public void setOtherProficiencies(List<String> otherProficiencies) {
        this.otherProficiencies = otherProficiencies;
    }

    public List<Attack> getAttacks() {
        return attacks;
    }

    public void setAttacks(List<Attack> attacks) {
        this.attacks = attacks;
    }

    public List<String> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<String> equipment) {
        this.equipment = equipment;
    }

    public String getPersonalityTraits() {
        return personalityTraits;
    }

    public void setPersonalityTraits(String personalityTraits) {
        this.personalityTraits = personalityTraits;
    }

    public String getIdeals() {
        return ideals;
    }

    public void setIdeals(String ideals) {
        this.ideals = ideals;
    }

    public String getBonds() {
        return bonds;
    }

    public void setBonds(String bonds) {
        this.bonds = bonds;
    }

    public String getFlaws() {
        return flaws;
    }

    public void setFlaws(String flaws) {
        this.flaws = flaws;
    }

    public List<String> getFeaturesAndTraits() {
        return featuresAndTraits;
    }

    public void setFeaturesAndTraits(List<String> featuresAndTraits) {
        this.featuresAndTraits = featuresAndTraits;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getEyes() {
        return eyes;
    }

    public void setEyes(String eyes) {
        this.eyes = eyes;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    public String getCharacterAppearance() {
        return characterAppearance;
    }

    public void setCharacterAppearance(String characterAppearance) {
        this.characterAppearance = characterAppearance;
    }

    public String getBackstory() {
        return backstory;
    }

    public void setBackstory(String backstory) {
        this.backstory = backstory;
    }

    public int getCopperPieces() {
        return copperPieces;
    }

    public void setCopperPieces(int copperPieces) {
        this.copperPieces = copperPieces;
    }

    public int getSilverPieces() {
        return silverPieces;
    }

    public void setSilverPieces(int silverPieces) {
        this.silverPieces = silverPieces;
    }

    public int getElectrumPieces() {
        return electrumPieces;
    }

    public void setElectrumPieces(int electrumPieces) {
        this.electrumPieces = electrumPieces;
    }

    public int getGoldPieces() {
        return goldPieces;
    }

    public void setGoldPieces(int goldPieces) {
        this.goldPieces = goldPieces;
    }

    public int getPlatinumPieces() {
        return platinumPieces;
    }

    public void setPlatinumPieces(int platinumPieces) {
        this.platinumPieces = platinumPieces;
    }

    public String getSpellcastingClass() {
        return spellcastingClass;
    }

    public void setSpellcastingClass(String spellcastingClass) {
        this.spellcastingClass = spellcastingClass;
    }

    public String getSpellcastingAbility() {
        return spellcastingAbility;
    }

    public void setSpellcastingAbility(String spellcastingAbility) {
        this.spellcastingAbility = spellcastingAbility;
    }

    public int getSpellSaveDC() {
        return spellSaveDC;
    }

    public void setSpellSaveDC(int spellSaveDC) {
        this.spellSaveDC = spellSaveDC;
    }

    public int getSpellAttackBonus() {
        return spellAttackBonus;
    }

    public void setSpellAttackBonus(int spellAttackBonus) {
        this.spellAttackBonus = spellAttackBonus;
    }

    public List<Spell> getCantrips() {
        return cantrips;
    }

    public void setCantrips(List<Spell> cantrips) {
        this.cantrips = cantrips;
    }

    public List<Spell> getSpellsKnown() {
        return spellsKnown;
    }

    public void setSpellsKnown(List<Spell> spellsKnown) {
        this.spellsKnown = spellsKnown;
    }

    public int[] getSpellSlotsTotal() {
        return spellSlotsTotal;
    }

    public void setSpellSlotsTotal(int[] spellSlotsTotal) {
        this.spellSlotsTotal = spellSlotsTotal;
    }

    public int[] getSpellSlotsExpended() {
        return spellSlotsExpended;
    }

    public void setSpellSlotsExpended(int[] spellSlotsExpended) {
        this.spellSlotsExpended = spellSlotsExpended;
    }
}
