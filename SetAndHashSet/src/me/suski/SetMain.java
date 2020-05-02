package me.suski;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMain {

    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for (int i=1; i<=100; i++) {
            squares.add(i * i);
            cubes.add(i * i *i);
        }

        System.out.println("There are " + squares.size() +
                " squares and  " + cubes.size() + " cubes");

        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);
        System.out.println("Union contains " + union.size() +
                " elements");

        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);

        System.out.println("Intersection contains " +
                intersection.size() + " elements");

        System.out.println("===================");

        for (int i: intersection) {
            System.out.println(i + " is a square of " + Math.sqrt(i) +
                    " and a cube of " + Math.cbrt(i));
        }

        System.out.println("===================");

        Set<String> words = new HashSet<>();
        String sentence = "one day in the year of the fox";
        String[] arrayWords = sentence.split(" ");
        words.addAll(Arrays.asList(arrayWords));

        for (String s: words) {
            System.out.println(s);
        }

        System.out.println("===================");

        Set<String> nature = new HashSet<>();
        Set<String> divine = new HashSet<>();

        String[] natureWords = "all nature is but unknown to thee".split(" ");
        nature.addAll(Arrays.asList(natureWords));
        String[] divineWords = "to err is human to forgive divine".split(" ");
        divine.addAll(Arrays.asList(divineWords));

        System.out.println("nature - divine is ");
        Set<String> diff1 = new HashSet<>(nature);
        diff1.removeAll(divine);
        System.out.println(diff1);

        System.out.println("divine - nature is ");
        Set<String> diff2 = new HashSet<>(divine);
        diff1.removeAll(nature);
        System.out.println(diff2);

        System.out.println("Symmetric difference");
        Set<String> unionSet = new HashSet<>(nature);
        unionSet.addAll(divine);
        Set<String> intersectionTest = new HashSet<>(nature);
        intersectionTest.retainAll(divine);
        unionSet.removeAll(intersectionTest);
        System.out.println(unionSet);

        System.out.println("===================");

        if (nature.containsAll(divine)) {
            System.out.println("Divine is subset of nature");
        }

        if (nature.containsAll(intersectionTest)) {
            System.out.println("Intersection is a subset of nature");
        }

        if (divine.containsAll(intersectionTest)) {
            System.out.println("Intersection is a subset of divine");
        }


    }
}
