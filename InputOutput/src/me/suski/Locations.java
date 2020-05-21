package me.suski;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {

        try (ObjectOutputStream locFile = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream("locations.dat")))) {
            for (Location loc : locations.values()) {
                locFile.writeObject(loc);
            }
        }




//        try (DataOutputStream locFile = new DataOutputStream(
//                new BufferedOutputStream(
//                        new FileOutputStream("locations.dat")))){
//
//            for (Location loc : locations.values()) {
//                locFile.writeInt(loc.getLocationID());
//                locFile.writeUTF(loc.getDescription());
//                System.out.println("Writing location: " + loc.getLocationID() +
//                        ": " + loc.getDescription());
//                System.out.println("Writing " + (loc.getExits().size() - 1) + " exits");
//                locFile.writeInt(loc.getExits().size() - 1);
//                for (String dir : loc.getExits().keySet()) {
//                    if (!dir.equalsIgnoreCase("Q")) {
//                        System.out.println("\t\t" + dir + ", " + loc.getExits().get(dir));
//                        locFile.writeUTF(dir);
//                        locFile.writeInt(loc.getExits().get(dir));
//                    }
//
//                }
//            }
//
//        }


//        try (BufferedWriter locFile = new BufferedWriter(new FileWriter("locations.txt"));
//             BufferedWriter dirFile = new BufferedWriter(new FileWriter("directions.txt"))) {
//            for (Location location : locations.values()) {
//                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
//                for (String dir : location.getExits().keySet()) {
//                    if(!dir.equalsIgnoreCase("Q")) {
//                        dirFile.write(location.getLocationID() + "," + dir + "," + location.getExits().get(dir) + "\n");
//                    }
//                }
//            }
//        }
    }

    static {

        try (ObjectInputStream locFile = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream("locations.dat")
                )
        )) {
            boolean eof = false;
            while (!eof) {
                try {
                    Location loc = (Location) locFile.readObject();
                    System.out.println("Read location: " + loc.getLocationID() + ": " + loc.getDescription());
                    System.out.println("Found " + loc.getExits().size() + " exits");

                    locations.put(loc.getLocationID(), loc);
                } catch (IOException e) {
                    eof = true;
                }
            }
        } catch (InvalidClassException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



//        try (DataInputStream locFile = new DataInputStream(
//                new BufferedInputStream(
//                        new FileInputStream("locations.dat")
//                )
//        )) {
//
//            boolean eof = false;
//
//            while (!eof) {
//                try {
//                    Map<String, Integer> exits = new LinkedHashMap<>();
//                    int locID = locFile.readInt();
//                    String desc = locFile.readUTF();
//                    int numExits = locFile.readInt();
//                    System.out.println("Read location " + locID + ": " + desc);
//                    System.out.println("Found " + numExits + " exits");
//                    for (int i=0; i<numExits; i++) {
//                        String dir = locFile.readUTF();
//                        int dest = locFile.readInt();
//                        exits.put(dir, dest);
//                        System.out.println("\t\t" + dir + ": " + desc);
//                    }
//                    locations.put(locID, new Location(locID, desc, exits));
//
//                } catch (EOFException e) {
//                    eof = true;
//                }
//
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }




//        try (BufferedReader locFile = new BufferedReader(new FileReader("locations_big.txt"))) {
//
//            String input;
//            while ((input = locFile.readLine()) != null) {
//                String[] data = input.split(",");
//                int loc = Integer.parseInt(data[0]);
//                String desc = data[1];
//                System.out.println("Imported loc: " + loc + ": " + desc);
//                Map<String, Integer> tempExit = new HashMap<>();
//                locations.put(loc, new Location(loc, desc, tempExit));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try (BufferedReader dirFile =  new BufferedReader(new FileReader("directions_big.txt"))) {
//
//            String input;
//            while ((input = dirFile.readLine()) != null) {
//                String[] data = input.split(",");
//                int loc = Integer.parseInt(data[0]);
//                String dir = data[1];
//                int destination = Integer.parseInt(data[2]);
//                System.out.println(loc + ": " + dir + ": " + destination);
//                Location location = locations.get(loc);
//                location.addExit(dir, destination);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();

    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
