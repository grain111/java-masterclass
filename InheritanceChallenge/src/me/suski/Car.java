package me.suski;

public class Car extends Vehicle {
    private int doors;
    private int wheels;
    private String color;

    public Car() {
        this("Default", 0, 0, 0,
                "transparent");
    }

    public Car(String name, int weight,
               int doors, int wheels, String color) {
        super("Car", name, weight);
        this.doors = doors;
        this.wheels = wheels;
        this.color = color;
    }

    private void changeGear() {
        System.out.println("Gear changed");
    }

    private void handSteering() {
        System.out.println("Grab the wheel");
    }

    @Override
    public void move(int speed) {
        handSteering();
        changeGear();
        super.move(speed);
    }

}
