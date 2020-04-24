package me.suski;

import java.util.ArrayList;
import java.util.List;

public class Monster implements ISaveable {
    private String name;
    private int hp;
    private int scarines;
    private boolean fuzzy;

    public Monster() {
        this("default", 0, 0, false);
    }

    public Monster(String name, int hp, int scariness, boolean fuzzy) {
        this.name = name;
        this.hp = hp;
        this.scarines = scariness;
        this.fuzzy = fuzzy;
    }

    public void scare() {
        System.out.println("Making scary noises!");
    }

    @Override
    public List<String> write() {
        List<String> save = new ArrayList<>();
        save.add(name);
        save.add(Integer.toString(hp));
        save.add(Integer.toString(scarines));
        save.add(Boolean.toString(fuzzy));
        return save;
    }

    @Override
    public void read(List<String> save) {
        this.name = save.get(0);
        this.hp = Integer.parseInt(save.get(1));
        this.scarines = Integer.parseInt(save.get(2));
        this.fuzzy = Boolean.parseBoolean(save.get(3));
    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", scarines=" + scarines +
                (this.fuzzy ? ", fuzzy" : ", not fuzzy") +
                '}';
    }
}
