package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
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
    private int num;

    public Card() {
        this.id = 0;
        this.name = "no_name";
        this.type = "N/A";
        this.desc = "None";
        this.atk = "?";
        this.def = "?";
        this.level = 1;
        this.race = "N/A";
        this.attribute = "N/A";
        this.num = 0;
    }

    public Card(int id, String name, String type, String desc, String atk, String def, int level, String race, String attribute) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.desc = desc;
        this.atk = atk;
        this.def = def;
        this.level = level;
        this.race = race;
        this.attribute = attribute;
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

    public int getNum() {
        return this.num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String toString() {
        return name + "\nCard ID: " + id + "\nAttribute: " + attribute + "\tLevel: " + level + "\nMonster Type: " + race
                + "\nCard Type: "
                + type + "\nATK " + atk + "\tDEF " + def + "\n" + desc;
    }

}
