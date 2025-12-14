#ifndef SKILLS_H
#define SKILLS_H

#include <vector>
#include <string>

/**
 * Ability for different stats in relation
 */
enum class Ability {
    Strength,
    Dexterity,
    Constitution,
    Intelligence,
    Wisdom,
    Charisma
};

/**
 * Element for a skill with it
 * with different types include
 */
struct Skill {
    std::string name;
    Ability ability;
    int modifier;
    bool isProficient;
};

/**
 * Manager for Skill
 */
class Skills
{
private:
    std::vector<Skill> skills;
public:
    /**
     * generates list of skills for use for displaying
     * @param strength stat block
     * @param dexterity stat block
     * @param constitution stat block
     * @param intelligence stat block
     * @param wisdom stat block
     * @param Charisma stat block
     */
    skills(int strength, int dexterity, int constitution,
           int intelligence, int wisdom, int Charisma);

    /**
     * returns the map of skills
     * @return returns the map of skills
     */
    std::vector<Skill>& getSkills();

    ~Skills() = default;
};

#endif