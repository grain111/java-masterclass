package me.suski;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Player player = new Player("Bartek",
                                    10,
                                    "sword",
                                    500);
        System.out.println(player.write().toString());
        List savedStatus = player.write();
        player.read(savedStatus);
        System.out.println(player);
        System.out.println("=============");
        Player player1 = new Player();
        player1.read(savedStatus);
        System.out.println(player1);
        System.out.println("=============");
        savedStatus.set(1, "200");
        player1.read(savedStatus);
        System.out.println(player1);
        System.out.println("=============");
        Monster monster = new Monster("Helmut",
                600,
                20,
                true);
        List<String> savedMonster = monster.write();
        ISaveable monster1 = new Monster();
        monster1.read(savedMonster);
        System.out.println(monster1);
        System.out.println("=============");
        savedMonster.set(3, "false");
        monster1.read(savedMonster);
        ((Monster) monster1).scare();
        System.out.println(monster1);

    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }
}
