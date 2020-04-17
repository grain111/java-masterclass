package me.suski;

public class Switch {
    private Light light;
    private String color;

    public Switch(Light light, String color) {
        this.light = light;
        this.color = color;
    }

    public void press() {
        System.out.println("Pressing the switch");
        this.light.switchState();
    }

    public Light getLight() {
        return light;
    }

    public String getColor() {
        return color;
    }
}
