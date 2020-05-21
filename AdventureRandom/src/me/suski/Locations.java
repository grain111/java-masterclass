package me.suski;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();
    private static Map<Integer, IndexRecord> index = new LinkedHashMap<>();
    private static RandomAccessFile ra;

    public static void main(String[] args) throws IOException {


        try (RandomAccessFile rao = new RandomAccessFile("locations_rand.dat", "rwd")) {
            rao.writeInt(locations.size());
            int indexSize = locations.size() * 3 * Integer.BYTES;
            int locStart = (int) (indexSize + rao.getFilePointer() + Integer.BYTES);
            rao.writeInt(locStart);

            long indexStart = rao.getFilePointer();

            int startPointer = locStart;
            rao.seek(startPointer);

            for (Location loc : locations.values()) {
                rao.writeInt(loc.getLocationID());
                rao.writeUTF(loc.getDescription());
                StringBuilder b = new StringBuilder();
                for (String dir : loc.getExits().keySet()) {
                    if (!dir.equalsIgnoreCase("Q")) {
                        b.append(dir);
                        b.append(",");
                        b.append(loc.getExits().get(dir));
                        b.append(",");
                    }
                }
                rao.writeUTF(b.toString());
                IndexRecord record = new IndexRecord(startPointer,
                        (int) (rao.getFilePointer() - startPointer));
                index.put(loc.getLocationID(), record);

                startPointer = (int) rao.getFilePointer();
            }

            rao.seek(indexStart);
            for (Integer locID : index.keySet()) {
                rao.writeInt(locID);
                rao.writeInt(index.get(locID).getStartByte());
                rao.writeInt(index.get(locID).getLength());
            }



        }
    }

    static {

        try {

            ra = new RandomAccessFile("locations_rand.dat", "rwd");
            int numLocs = ra.readInt();
            long locStartPoint = ra.readInt();

            while (ra.getFilePointer() < locStartPoint) {
                int locID = ra.readInt();
                int locStart = ra.readInt();
                int locLen = ra.readInt();

                IndexRecord record = new IndexRecord(locStart, locLen);
                index.put(locID, record);
            }

        } catch (IOException e) {
            System.out.println("IOException in static initializer: " + e.getLocalizedMessage());
        }


    }

    public Location getLocation(int locID) throws IOException {

        IndexRecord record = index.get(locID);
        ra.seek(record.getStartByte());
        int id = ra.readInt();
        String desc = ra.readUTF();
        String exits = ra.readUTF();
        String[] exitPart = new String(exits).split(",");

        Location location = new Location(id, desc, null);

        if (locID != 0) {
            for (int i=0; i<exitPart.length; i++) {
                System.out.println("exitPart = " + exitPart[i]);
                System.out.println("exitPart = " + exitPart[i+1]);
                String dir = exitPart[i];
                int dest = Integer.parseInt(exitPart[++i]);
                location.addExit(dir, dest);
            }
        }

        return location;
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

    public void close() throws IOException {
        ra.close();
    }
}
