package me.suski;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        locations.put(0, new Location(0, "You are sitting in front of the computer learning Java", null));

        Map<String, Integer> tempExit = new HashMap<>();
        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building", tempExit));


        tempExit = new HashMap<>();
        tempExit.put("N", 5);
        tempExit.put("X", 6);
        locations.put(2, new Location(2, "You are at the top of a hill", tempExit));


        tempExit = new HashMap<>();
        tempExit.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building, a well for a small spring", tempExit));


        tempExit = new HashMap<>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locations.put(4, new Location(4, "You are in a valley beside a stream", tempExit));


        tempExit = new HashMap<>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        locations.put(5, new Location(5, "You are in the forest", tempExit));



        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
//            tempExit.remove("S");
            if (loc == 0) {
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
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
                    loc = exits.get(dir);
                } else {
                    System.out.println("You cannot go in this direction");
                }
            } else {
                System.out.println("Invalid command");
            }
        }

    }

    public static String parseCmd(String cmd) {
        String[] directions = "east west south north quit".split(" ");
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
