package me.suski;

public class Vehicle {

    private String type;
    private String name;
    private int weight;

    public Vehicle(String type, String name, int weight) {
        this.type = type;
        this.name = name;
        this.weight = weight;
    }

    public void move(int speed) {
        System.out.println("Vehicle moved with speed of " + speed);
    }
}
