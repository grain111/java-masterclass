package me.suski;

public class Addition {
    private String name;
    private double price;

    public Addition(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void show() {
        System.out.println("Ingredient name: " + name + ", Price: " + price);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
