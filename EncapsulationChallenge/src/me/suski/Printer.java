package me.suski;

public class Printer {
    private int tonerLevel;
    private int pagesPrinted = 0;
    private boolean isDuplex;

    public Printer(int tonerLevel, boolean isDuplex) {
        if (tonerLevel < 0) {
            this.tonerLevel = 0;
        } else if (tonerLevel > 100) {
            this.tonerLevel = 100;
        } else {
            this.tonerLevel = tonerLevel;
        }

        this.isDuplex = isDuplex;
    }

    public void fillUpToner(int amount) {
        amount = amount < 0 ? 0 : amount;
        this.tonerLevel += amount;
        this.tonerLevel = this.tonerLevel > 100 ? 100 : this.tonerLevel;
        System.out.println("Printed toner filled up to " + this.tonerLevel + "%.");
    }

    public void printPage(boolean duplexMode) {
        if (duplexMode) {
            if (isDuplex) {
                System.out.println("Printing in duplex mode.");
            } else {
                System.out.println("Duplex mode is unavailable in this printer. Exiting.");
                return;
            }
        }
        if (tonerLevel > 0) {
            pagesPrinted++;
            tonerLevel--;
            System.out.println("A page has been printed. Current number of printed pages is " +
                    pagesPrinted + " and toner level is at " + tonerLevel + "%");
        } else {
            System.out.println("Not enough toner. Pleas fill up.");
        }
    }
}
