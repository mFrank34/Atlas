#ifndef CHARACTER_H
#define CHARACTER_H

#include <string>

/**
 * Class for holding the base items for character sheet
 */
class Character
{
private:

    int c_level = 0;
    std::string c_name;
    std::string c_class;
    std::string c_background;
    std::string c_race;
    std::string c_alignment;
    int age = 0;
    double height = 0.0;
    double weight = 0.0;
    std::string c_eyes;
    std::string c_skin;
    std::string c_hair;
    std::string c_personality;
    std::string c_ideas;
    std::string c_bonds;
    std::string c_flaws;

public:



};

#endif