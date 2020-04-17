package me.suski;

public class Main {

    public static void main(String[] args) {

        Dimensions dimensions = new Dimensions(20, 20,
                5);
        Case theCase = new Case("220B", "Dell",
                "240", dimensions);
        Monitor theMonitor = new Monitor("27inch beast",
                "Acer", 27,
                new Resolution(2540, 1440));
        Motherboard theMotherboard = new Motherboard("BJ-200",
                "Asus", 4, 6,
                "v2.44");
        PC thePC = new PC(theCase, theMonitor, theMotherboard);

        thePC.powerUp();

        Door door = new Door(1, 100, 210, "blue");
        Texture niceTex = new Texture(1, 5);
        Walls walls = new Walls(4, niceTex, "wood");
        Windows windows = new Windows(150, 150, 5);
        Light chandelier = new Light(5000, 5, "white");
        Switch lightSwitch = new Switch(chandelier, "pink");
        Kitchen kitchen = new Kitchen(door, walls, windows, lightSwitch, thePC);

        kitchen.turnOnPC();
        kitchen.getWindows().open(6);
        kitchen.getWindows().open(2);
        kitchen.getDoor().open();
        kitchen.getWindows().closeAll();
        kitchen.getLightSwitch().press();
        kitchen.getLightSwitch().press();

        kitchen.getWindows().open(2);
        kitchen.getDoor().open();
        kitchen.sealTheRoom();
    }
}
