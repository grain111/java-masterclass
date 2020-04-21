package me.suski;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        LinkedList<String> placesToVist = new LinkedList<>();

        addInOrder(placesToVist, "Sydney");
        addInOrder(placesToVist, "Sydney");
        addInOrder(placesToVist, "Melbourne");
        addInOrder(placesToVist, "Lublin");
        addInOrder(placesToVist, "Warsaw");
        addInOrder(placesToVist, "Wroclaw");
        addInOrder(placesToVist, "Poznan");
        addInOrder(placesToVist, "London");
        addInOrder(placesToVist, "New York");
        addInOrder(placesToVist, "Berlin");

        printList(placesToVist);

        placesToVist.add(1, "Barcelona");
        printList(placesToVist);

        placesToVist.remove(4);
        printList(placesToVist);

        visit(placesToVist);


    }

    private static void printList(LinkedList<String> linkedList) {
        Iterator<String> i = linkedList.iterator();
        while (i.hasNext()) {
            System.out.println("Now visiting " + i.next());
        }
        System.out.println("======================");
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newCity) {
        ListIterator<String> i = linkedList.listIterator();

        while (i.hasNext()) {
            int comparison = i.next().compareTo(newCity);
            if(comparison == 0) {
                // equal, do not add
                System.out.println(newCity + " is already included.");
                return false;
            } else if (comparison > 0) {
                // new city should appear before
                i.previous();
                i.add(newCity);
                return true;
            } else if (comparison < 0) {
                continue;
            }
        }
        i.add(newCity);
        return true;
    }

    public static void visit(LinkedList cities) {
        Scanner s = new Scanner(System.in);
        boolean q = false;
        boolean goingForward = true;
        ListIterator<String> i = cities.listIterator();

        if (cities.isEmpty()) {
            System.out.println("No cities in itinerary");
            return;
        } else {
            System.out.println("Now visiting " + i.next());
            printMenu();

            while (!q) {
                int action = s.nextInt();
                s.nextLine();

                switch (action) {
                    case 0:
                        System.out.println("Holiday over");
                        q = true;
                        break;
                    case 1:
                        if (!goingForward) {
                            if (i.hasNext()) {
                                i.next();
                                goingForward = true;
                            }
                        }
                        if (i.hasNext()) {
                            System.out.println("Now visiting " + i.next());
                        } else {
                            goingForward = false;
                            System.out.println("Reach the end of the list");
                        }
                        break;
                    case 2:
                        if (goingForward) {
                            if (i.hasPrevious()) {
                                i.previous();
                                goingForward = false;
                            }
                        }
                        if (i.hasPrevious()) {
                            System.out.println("Now visiting " + i.previous());
                        } else {
                            System.out.println("We are at the start of the list");
                            goingForward = true;
                        }
                        break;
                    case 3:
                        printMenu();
                        break;
                }
            }
        }
    }

    public static void printMenu() {
        System.out.println("Available actions: ");
        System.out.println("0 - quit");
        System.out.println("1 - go to next city");
        System.out.println("2 - go to previous city");
        System.out.println("3 - print menu");
    }
}
