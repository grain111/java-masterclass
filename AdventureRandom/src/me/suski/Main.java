package me.suski;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Locations locations = new Locations();

    public static void main(String[] args) throws IOException {

        Scanner s = new Scanner(System.in);




        Location currentLoc = locations.getLocation(1);
        while (true) {
            System.out.println(currentLoc.getDescription());
            if (currentLoc.getLocationID() == 0) {
                break;
            }

            Map<String, Integer> exits = currentLoc.getExits();
            System.out.print("Available exits are ");
            for (String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();
            String cmd = s.nextLine().toLowerCase();
            String dir = parseCmd(cmd);
            if (dir != null) {
                dir = dir.toUpperCase();
                if (exits.containsKey(dir)) {
                    currentLoc = locations.getLocation(currentLoc.getExits().get(dir));
                } else {
                    System.out.println("You cannot go in this direction");
                }
            } else {
                System.out.println("Invalid command");
            }
        }

        locations.close();

    }

    public static String parseCmd(String cmd) {
        String[] directions = "east west south north quit u ns sw nw se".split(" ");
        for (String word : cmd.split(" ")) {
            for (String dir : directions) {
                if (dir.equals(word) || dir.substring(0, 1).equals(word)) {
                    return dir.substring(0, 1);
                }
            }
        }
        return null;
    }
}
