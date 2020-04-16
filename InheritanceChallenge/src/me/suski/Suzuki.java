package me.suski;

public class Suzuki extends Car {

    private boolean hasAirCon;
    private int engineSize;

    public Suzuki(int weight, int doors, String color,
                  boolean hasAirCon, int engineSize) {
        super("Suzuki", weight, doors, 4, color);
        this.hasAirCon = hasAirCon;
        this.engineSize = engineSize;
    }

    public void jump(int height, int speed) {
        System.out.println("Suzuki jumped so high to " + height);
        super.move(speed);
    }
}
