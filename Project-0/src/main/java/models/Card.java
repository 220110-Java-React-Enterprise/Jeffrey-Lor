package models;

public class Card {

    private int id;
    private String name;
    private String type;
    private String desc;
    private int atk;
    private int def;
    private int level;
    private String race;
    private String attribute;

    public String toString() {
        //Add check for Monster/Spell/Trap
        return name + "\nAttribute: " + attribute + "\tLevel: " + level + "\nMonster Type: " + race + "\nCard Type: " + type + "\nATK " + atk + "\tDEF " + def + "\n" + desc;
    }

}
