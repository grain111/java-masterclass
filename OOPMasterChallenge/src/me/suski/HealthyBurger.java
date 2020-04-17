package me.suski;

public class HealthyBurger extends Hamburger {
    private Addition grass;
    private Addition onion;

    public HealthyBurger(double price, String rollType) {
        super(price, rollType, "soy");
    }

    @Override
    public double total() {
        double sumExtra = 0;
        if (grass != null) {
            sumExtra += grass.getPrice();
            grass.show();
        }
        if (onion != null) {
            sumExtra += onion.getPrice();
            onion.show();
        }
        sumExtra += super.total();
        return sumExtra;
    }

    public void addGrass() {
        this.grass = new Addition("Grass", 5);
        System.out.println("Added grass to your burger");
    }

    public void addOnion() {
        this.onion = new Addition("Onion", 1);
        System.out.println("Added onion to your burger");
    }
}
