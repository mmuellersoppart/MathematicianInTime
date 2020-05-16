//Marlon Mueller-Soppart
//20200222
//ob - All the types of lines
package org.openjfx;

public enum LineTypes {
    /*
     * DIALOGUE: no special action taken, just goes to next line
     * ANSWER: Specifies the user is answering
     * SCENE: Loads character in a different page with a different script
     * STATS: Changes characters status (health and/or score)
     * ITEM: Gives user an item for their inventory
     * SKILL: A new skill has been unlocked
     * LOCATION: A new location has been unlocked
     * CHECK: Verifies the answer and determines what is gained
     * UPDATE_NAME: Takes user answer and changes player name
     */
    DIALOGUE,
    ANSWER,
    SCENE,
    STATS,
    ITEM,
    SKILL,
    LOCATION,
    CHECK,
    DAMAGE,

    UPDATE_NAME,
    UPDATE_CHARACTERTYPE,
}
