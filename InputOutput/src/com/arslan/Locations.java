package com.arslan;

import java.io.*;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        // following code is for serializing and storing objects as data.
        try (ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("locations.dat")))) {
            for (Location location: locations.values()) {
                locFile.writeObject(location);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }




// following code is for writing data to a file in binary output stream.Not so much readable.
//        try (DataOutputStream locFile = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("locations.dat")))) {
//            for (Location location : locations.values()) {
//                locFile.writeInt(location.getLocationID());
//                locFile.writeUTF(location.getDescription());
//                System.out.println("Writing location " + location.getLocationID() + " : " + location.getDescription());
//                System.out.println("Writing " + (location.getExits().size() - 1) + " exits.");
//                locFile.writeInt(location.getExits().size() - 1);
//                for (String direction : location.getExits().keySet()) {
//                    if (!direction.equalsIgnoreCase("Q")) {
//                        System.out.println("\t\t" + direction + "," + location.getExits().get(direction));
//                        locFile.writeUTF(direction);
//                        locFile.writeInt(location.getExits().get(direction));
//                    }
//                }
//            }
//        }

// following code is for writing data to a file in human readable form . aka in characters.
//        try (BufferedWriter locFile = new BufferedWriter(new FileWriter("locations.txt"));
//             BufferedWriter dirFile = new BufferedWriter(new FileWriter("directions.txt"))) {
//            for (Location location : locations.values()) {
//                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
//                for (String direction : location.getExits().keySet()) {
//                    if (!direction.equalsIgnoreCase("Q")) {
//                        dirFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
//                    }
//                }
//            }
//        }
    }

    static {
        //following code is for reading objects stored as objects written using ObjectOutputStream.
        try (ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))) {
            boolean eof = false;
            while (!eof) {
                try {
                    Location location = (Location) locFile.readObject();
                    System.out.println("Read location: " + location.getLocationID() + " : " + location.getDescription());
                    System.out.println("Found: " + location.getExits().size() + " exits");
                    locations.put(location.getLocationID(), location);
                } catch (EOFException e) {
                    eof = true;
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }



// following code is for reading data from a binary file which was written using DataOutputStream.
//        try (DataInputStream locFile = new DataInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))) {
//            boolean eof = false;
//            while (!eof) {
//                try {
//                    Map<String, Integer> exits = new LinkedHashMap<>();
//                    int locID = locFile.readInt();
//                    String description = locFile.readUTF();
//                    int numExits = locFile.readInt();
//                    System.out.println("Read location " + locID + " : " + description);
//                    System.out.println("Found " + numExits + " exits");
//                    for (int i = 0; i < numExits; i++) {
//                        String direction = locFile.readUTF();
//                        int destination = locFile.readInt();
//                        exits.put(direction, destination);
//                        System.out.println("\t\t" + direction + "," + destination);
//                    }
//                    locations.put(locID, new Location(locID, description, exits));
//                } catch (EOFException e) {
//                    eof = true;
//                }
//            }
//        } catch (IOException io) {
//            System.out.println("IO Exception");
//        }


        // following method is used for reading text(characters) from a file.
//        try (BufferedReader locFile = new BufferedReader(new FileReader("locations.txt"))) {
//            String input;
//            while ((input = locFile.readLine()) != null) {
//                String[] data = input.split(",");
//                int loc = Integer.parseInt(data[0]);
//                String description = data[1];
//                Map<String, Integer> tempExit = new HashMap<>();
//                System.out.println("Imported loc: " + loc + ": " + description);
//                locations.put(loc, new Location(loc, description, tempExit));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try (BufferedReader dirFile = new BufferedReader(new FileReader("directions.txt"))) {
//            String input;
//            while ((input = dirFile.readLine()) != null) {
//                String[] data = input.split(",");
//                int loc = Integer.parseInt(data[0]);
//                String direction = data[1];
//                int destination = Integer.parseInt(data[2]);
//
//                System.out.println(loc + ": " + direction + ": " + destination);
//                Location location = locations.get(loc);
//                location.addExit(direction, destination);
//
//            }
//        } catch (IOException e) {
//            e.printStackTrace();


//            Map<String, Integer> tempExit;
//            locations.put(0, new Location(0, "You are sitting in front of a computer learning Java", null));
//
//            tempExit = new HashMap<>();
//            tempExit.put("W", 2);
//            tempExit.put("E", 3);
//            tempExit.put("S", 4);
//            tempExit.put("N", 5);
//            locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building", tempExit));
//
//            tempExit = new HashMap<>();
//            tempExit.put("N", 5);
//            locations.put(2, new Location(2, "You are at the top of a hill", tempExit));
//
//            tempExit = new HashMap<>();
//            tempExit.put("W", 1);
//            locations.put(3, new Location(3, "You are inside a building, a well house for a small spring", tempExit));
//
//            tempExit = new HashMap<>();
//            tempExit.put("N", 1);
//            tempExit.put("W", 2);
//            locations.put(4, new Location(4, "You are in a valley beside a stream", tempExit));
//
//            tempExit = new HashMap<>();
//            tempExit.put("S", 1);
//            tempExit.put("W", 2);
//            locations.put(5, new Location(5, "You are in the forest", tempExit));
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
