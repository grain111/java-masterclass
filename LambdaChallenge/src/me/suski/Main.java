package me.suski;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        System.out.println("--------------");
        System.out.println("Challenge 1");
        System.out.println("--------------");

        Runnable r1 = () -> {
            String myString = "Let's split this up into array";
            String[] parts = myString.split(" ");
            for (String part :
                    parts) {
                System.out.println(part);
            }
        };
        r1.run();

        System.out.println("\n--------------");
        System.out.println("Challenge 2 and 3");
        System.out.println("--------------");

        Function<String, String> r2 = source -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 != 0) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };
        System.out.println(r2.apply("1234567890"));

        System.out.println("\n--------------");
        System.out.println("Challenge 4 and 5");
        System.out.println("--------------");

        System.out.println(everySecondCharacter(r2, "1234567890"));

        System.out.println("\n--------------");
        System.out.println("Challenge 6 and 7");
        System.out.println("--------------");

        Supplier<String> iLoveJava = () -> "I love Java!";
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);

        System.out.println("\n--------------");
        System.out.println("Challenge 9, 10 and 11");
        System.out.println("--------------");

        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );
        topNames2015.stream()
                .map(name -> name.substring(0, 1).toUpperCase() +
                        name.substring(1))
                .sorted()
                .forEach(System.out::println);

        System.out.println("\n--------------");
        System.out.println("Challenge 12");
        System.out.println("--------------");


//        Map<String, Integer> firstLetterCount = new HashMap<>();
//        for (String name :
//                topNames2015) {
//            String firstLetter = name.substring(0, 1).toUpperCase();
//            int cv = 1;
//
//            if (firstLetterCount.containsKey(firstLetter)) {
//                cv = firstLetterCount.get(firstLetter);
//                cv++;
//            }
//            firstLetterCount.put(firstLetter, cv);
//        }
//        System.out.println(firstLetterCount);

        Map<String, Long> firstLetterCount =  topNames2015.stream()
                .collect(Collectors.groupingBy(
                        name -> name.substring(0, 1).toUpperCase(),
                        Collectors.counting()));

        System.out.println("Number of names beginning with A is: " + firstLetterCount.get("A"));
        System.out.println(firstLetterCount);

        System.out.println("\n--------------");
        System.out.println("Challenge 14");
        System.out.println("--------------");

        topNames2015.stream()
                .map(name -> name.substring(0, 1).toUpperCase() +
                        name.substring(1))
                .peek(System.out::println)
                .sorted()
                .findFirst();


    }

    public static String everySecondCharacter(Function<String, String> func, String str) {
        return func.apply(str);
    }
}
