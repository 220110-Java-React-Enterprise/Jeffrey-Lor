package models;

public class Card {

    private int id;
    private String name;
    private String type;
    private String desc;
    private String atk;
    private String def;
    private int level;
    private String race;
    private String attribute;

    public Card() {
        this.id = 0;
        this.name = "no_name";
        this.type = "Blank Card";
        this.desc = "This card is blank.";
        this.atk = "?";
        this.def = "?";
        this.level = 12;
        this.race = "God";
        this.attribute = "Fire";
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAtk() {
        return this.atk;
    }

    public void setAtk(String atk) {
        this.atk = atk;
    }

    public String getDef() {
        return this.def;
    }

    public void setDef(String def) {
        this.def = def;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getRace() {
        return this.race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getAttribute() {
        return this.attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public void printCard() {
        System.out.printf("%-40.40s%n", name);
        System.out.printf("%-20.20s %20.20s%n", "Attribute: " + attribute, "Level: " + level);
        System.out.printf("%-40.40s%n", "Monster Race: " + race);
        System.out.printf("%-40.40s%n", type);
        System.out.printf("%-20.20s %20.20s%n", "ATK " + atk, "DEF " + def);
        System.out.printf("%s%n", desc);
    }

    public String toString() {
        return name + "\nAttribute: " + attribute + "\tLevel: " + level + "\nMonster Type: " + race + "\nCard Type: "
                + type + "\nATK " + atk + "\tDEF " + def + "\n" + desc;
    }

}
