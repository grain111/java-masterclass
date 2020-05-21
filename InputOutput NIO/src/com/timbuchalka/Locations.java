package com.timbuchalka;

import javax.swing.table.TableRowSorter;
import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * Created by timbuchalka on 2/04/2016.
 */
public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<Integer, Location>();

    public static void main(String[] args) throws IOException {

// //JAVA NIO WRITING USING BUFFERED OBJECT WRITER

        Path locPath = FileSystems.getDefault().getPath("locations.dat");

        try (ObjectOutputStream locFile = new ObjectOutputStream(
                new BufferedOutputStream(Files.newOutputStream(locPath)))) {

            for (Location location : locations.values()) {
                locFile.writeObject(location);
            }
        }



// //JAVA NIO WRITING USING BUFFERED WRITER
//        Path locPath = FileSystems.getDefault().getPath("locations_big.txt");
//        Path dirPath = FileSystems.getDefault().getPath("directions_big.txt");
//
//        try (BufferedWriter locFile = Files.newBufferedWriter(locPath);
//             BufferedWriter dirFile = Files.newBufferedWriter(dirPath)) {
//
//            for (Location location : locations.values()) {
//                locFile.write(location.getLocationID() + "," +
//                        location.getDescription() + "\n");
//                for (String direction : location.getExits().keySet()) {
//                    if (direction.equalsIgnoreCase("Q")) {
//                        continue;
//                    }
//                    dirFile.write(location.getLocationID() + "," +
//                            direction + "," +
//                            location.getExits().get(direction) + "\n");
//                }
//            }
//        } catch (IOException e) {
//            System.out.println("IOException: " + e.getMessage());
//        }

    }

    static {

// //JAVA NIO READING USING BUFFERED OBJECT READER

        Path locPath = FileSystems.getDefault().getPath("locations.dat");

        try (ObjectInputStream locFile = new ObjectInputStream(
                new BufferedInputStream(Files.newInputStream(locPath)))) {

            boolean eof = false;

            while (!eof) {
                try {
                    Location location = (Location) locFile.readObject();
                    locations.put(location.getLocationID(), location);
                } catch (EOFException e) {
                    eof = true;
                } catch (InvalidClassException e) {
                    System.out.println("Invalid class " + e.getMessage());
                } catch (ClassNotFoundException e) {
                    System.out.println("Class not found " + e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



// //JAVA NIO READING USING BUFFERED READER

//        Path locPath = FileSystems.getDefault().getPath("locations_big.txt");
//        Path dirPath = FileSystems.getDefault().getPath("directions_big.txt");
//
//        try (Scanner s = new Scanner(Files.newBufferedReader(locPath)))  {
//
//            s.useDelimiter(",");
//
//            while (s.hasNextLine()) {
//                int loc = s.nextInt();
//                s.skip(s.delimiter());
//                String desc = s.nextLine();
//                System.out.println("Imported location: " + loc + ": " + desc);
//                locations.put(loc, new Location(loc, desc, null));
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try (BufferedReader dirFile = Files.newBufferedReader(dirPath)) {
//
//            String input;
//
//            while ((input = dirFile.readLine()) != null) {
//
//                String[] data = input.split(",");
//                int loc = Integer.parseInt(data[0]);
//                String dir = data[1];
//                int dest = Integer.parseInt(data[2]);
//                System.out.println(loc + ": " + dir + ": " + dest);
//                Location location = locations.get(loc);
//                location.addExit(dir, dest);
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
