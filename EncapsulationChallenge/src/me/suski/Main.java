package me.suski;

public class Main {

    public static void main(String[] args) {

        Printer hp = new Printer(75, true);
        hp.printPage(true);

        Printer canon = new Printer(75, false);
        canon.printPage(true);

        Printer brother = new Printer(1, true);
        brother.printPage(true);
        brother.printPage(true);
        brother.fillUpToner(1000);
        brother.printPage(false);

    }
}
