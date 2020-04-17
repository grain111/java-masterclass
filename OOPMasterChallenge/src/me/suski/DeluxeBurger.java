package me.suski;

public class DeluxeBurger extends Hamburger{
    private Addition chips;
    private Addition drinks;

    public DeluxeBurger(double price, String rollType, String meat) {
        super(price, rollType, meat);
        chips = new Addition("chips", 0);
        drinks = new Addition("drink", 0);
    }

    @Override
    public double total() {
        System.out.println("Deluxe Burger with Chips and Drinks is " + getBasePrice());
        return getBasePrice();
    }

    @Override
    public void addLettuce() {
        System.out.println("This item is not available in Delux Burger");
    }

    @Override
    public void addTomato() {
        System.out.println("This item is not available in Delux Burger");
    }

    @Override
    public void addCarrot() {
        System.out.println("This item is not available in Delux Burger");
    }

    @Override
    public void addPickle() {
        System.out.println("This item is not available in Delux Burger");
    }
}
