package me.suski;

public class Door {
    private int knobs;
    private int width;
    private int height;
    private String color;

    public Door(int knobs, int width, int height, String color) {
        this.knobs = knobs;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void open() {
        System.out.println("Opening the door ");
    }

    public void close() {
        System.out.println("Closing the door");
    }

    public int getKnobs() {
        return knobs;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getColor() {
        return color;
    }
}
