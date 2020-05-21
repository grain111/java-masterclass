package me.suski;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Locations locations = new Locations();

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);




        int loc = 64;
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
