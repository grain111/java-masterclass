package me.suski;

public class Main {

    public static void main(String[] args) {
        Hamburger burger = new Hamburger(5, "corn", "beaf");
        burger.addCarrot();
        burger.addLettuce();
        burger.addPickle();
        System.out.println("Classic burger is " + burger.total());
        System.out.println("**********************");
        HealthyBurger hBurger = new HealthyBurger(10, "rye");
        hBurger.addGrass();
        hBurger.addCarrot();
        System.out.println("Healthy burger price is " + hBurger.total());
        System.out.println("**********************");
        DeluxeBurger dBurger = new DeluxeBurger(15, "white", "chicken");
        dBurger.addCarrot();
        dBurger.total();


    }
}
