package me.suski;

public class Light {
    private int power;
    private int bulbs;
    private String color;
    private boolean isOn;

    public Light(int power, int bulbs, String color) {
        this.power = power;
        this.bulbs = bulbs;
        this.color = color;
        this.isOn = false;
    }

    public void switchState() {
        this.isOn = this.isOn == true ? false : true;
        System.out.println("The light is " +
                (isOn ? "on" : "off"));
    }

    public int getPower() {
        return power;
    }

    public int getBulbs() {
        return bulbs;
    }

    public String getColor() {
        return color;
    }
}
