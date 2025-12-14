#ifndef STATS_H
#define STATS_H
#include <array>

/**
 * class for storing information around stat block
 */
class stats
{
private:
    int proficiency = 0;
    int passiveWisdom = 0;

    int strength = 0;
    int dexterity = 0;
    int constitution = 0;
    int intelligence = 0;
    int charisma = 0;

    int armor = 0;
    int initiative = 0;
    int speed = 0;

    int health = 0;
    int max_health = 0;
    int temp_hp = 0;

    std::array<int, 3> dsSuccess = {false, false, false};
    std::array<int, 3> dsFail = {false, false, false};

public:

};

#endif