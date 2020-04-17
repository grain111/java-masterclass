package me.suski;

class Car {
    private boolean engine;
    private int cylinders;
    private String name;
    private int wheels;

    public Car(int cylinders, String name) {
        this.engine = true;
        this.cylinders = cylinders;
        this.name = name;
        this.wheels = 4;
    }

    public String startEngine() {
        return "class Car - engine started";
    }

    public String accelerate() {
        return "class Car - accelerate";
    }

    public String brake() {
        return "class Car - brake";
    }
}

class Suzuki extends Car {
    public Suzuki() {
        super(4, "Suzuki");
    }

    public String startEngine() {
        return "class Suzuki - engine started";
    }

    public String accelerate() {
        return "class Suzuki - accelerate";
    }

    public String brake() {
        return "class Suzuki - brake";
    }
}

class Mustang extends Car {
    public Mustang() {
        super(8, "Mustang");
    }

    public String startEngine() {
        return "class Mustang - engine started";
    }

    public String accelerate() {
        return "class Mustang - accelerate";
    }

    public String brake() {
        return "class Mustang - brake";
    }
}

class Toyota extends Car {
    public Toyota() {
        super(8, "Toyota");
    }

    public String startEngine() {
        return "class Toyota - engine started";
    }

    public String accelerate() {
        return "class Toyota - accelerate";
    }

    public String brake() {
        return "class Toyota - brake";
    }
}

public class Main {

    public static void main(String[] args) {

        Car toyota = new Toyota();
        System.out.println(toyota.startEngine());
    }
}
