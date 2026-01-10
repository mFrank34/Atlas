package service;

public class CharacterService {
    public void loadCharacters() {
        System.out.println("Loading characters...");
    }

    public void saveCharacter(String characterJson) {
        System.out.println("Saving character: " + characterJson);
    }
}
