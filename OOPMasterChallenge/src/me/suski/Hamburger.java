package me.suski;

public class Hamburger {
    private double price;
    private String rollType;
    private String meat;
    private Addition lettuce;
    private Addition tomato;
    private Addition carrot;
    private Addition pickle;

    public Hamburger(double price, String rollType, String meat) {
        this.price = price;
        this.rollType = rollType;
        this.meat = meat;
    }

    public double total() {
        double sumExtra = 0;
        if (lettuce != null) {
            sumExtra += lettuce.getPrice();
            lettuce.show();
        }
        if (tomato != null) {
            sumExtra += tomato.getPrice();
            tomato.show();
        }
        if (carrot != null) {
            sumExtra += carrot.getPrice();
            carrot.show();
        }
        if (pickle != null) {
            sumExtra += pickle.getPrice();
            pickle.show();
        }
        sumExtra += price;
        System.out.println("Total price is " + sumExtra);
        return sumExtra;
    }

    public double getBasePrice() {
        return price;
    }

    public void addLettuce() {
        this.lettuce = new Addition("Lettuce", 2);
        System.out.println("Added lettuce to your burger");
    }

    public void addTomato() {
        this.tomato = new Addition("Tomato", 2);
        System.out.println("Added tomato to your burger");
    }

    public void addCarrot() {
        this.carrot = new Addition("Carrot", 2);
        System.out.println("Added carrot to your burger");
    }

    public void addPickle() {
        this.pickle = new Addition("Pickle", 2);
        System.out.println("Added pickle to your burger");
    }
}
