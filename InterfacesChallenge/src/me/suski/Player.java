package me.suski;

import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable {
    private String name;
    private int hp;
    private String weapon;
    private int gold;

    public Player() {
        this("default", 0, "default", 0);
    }

    public Player(String name, int hp, String weapon, int gold) {
        this.name = name;
        this.hp = hp;
        this.weapon = weapon;
        this.gold = gold;
    }

    public void fight() {
        System.out.println("I am fighting a monster!");
    }

    @Override
    public List<String> write() {
        List<String> save = new ArrayList<>();
        save.add(name);
        save.add(Integer.toString(hp));
        save.add(weapon);
        save.add(Integer.toString(gold));
        return save;
    }

    @Override
    public void read(List<String> save) {
        this.name = save.get(0);
        this.hp = Integer.parseInt(save.get(1));
        this.weapon = save.get(2);
        this.gold = Integer.parseInt(save.get(3));
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", weapon='" + weapon + '\'' +
                ", gold=" + gold +
                '}';
    }
}
