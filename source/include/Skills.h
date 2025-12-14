#ifndef SKILLS_H
#define SKILLS_H

#include <string>

enum class Ability {
    Strength,
    Dexterity,
    Constitution,
    Intelligence,
    Wisdom,
    Charisma
};

struct Skill {
    std::string name;
    Ability ability;
    int modifier;
    bool isProficient;
};

class Skills
{
private:

public:

};

#endif