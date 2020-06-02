package me.suski;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        System.out.println("----------------");
        System.out.println("Challenge 1");
        System.out.println("----------------");

        String challenge1 = "I want a bike.";
        System.out.println(challenge1 + " = " +
                challenge1.matches("I want a bike."));

        System.out.println("\n----------------");
        System.out.println("Challenge 2");
        System.out.println("----------------");

        String challenge2 = "I want a ball.";
//        String pattern2 = "I want a b[ia][kl][el].";
        String pattern2 = "I want a (bike|ball).";
        System.out.println(challenge1 + " = " +
                challenge1.matches(pattern2));
        System.out.println(challenge2 + " = " +
                challenge1.matches(pattern2));

        System.out.println("\n----------------");
        System.out.println("Challenge 3");
        System.out.println("----------------");

        Pattern pat1 = Pattern.compile(pattern2);
        Matcher matcher1 = pat1.matcher(challenge1);
        Matcher matcher2 = pat1.matcher(challenge2);

        System.out.println(challenge1 + " = " +
                matcher1.matches());
        System.out.println(challenge2 + " = " +
                matcher2.matches());

        System.out.println("\n----------------");
        System.out.println("Challenge 4");
        System.out.println("----------------");

        String challenge4 = "Replace  all blanks with underscores.";
        System.out.println(challenge4.replaceAll("\\s+", "_"));

        System.out.println("\n----------------");
        System.out.println("Challenge 5");
        System.out.println("----------------");

        String challenge5 = "aaabccccccccdddefffg";
        System.out.println(challenge5 + " = " +
                challenge5.matches("\\w+"));
        System.out.println(challenge5 + " = " +
                challenge5.matches("a{3}bc{8}d{3}ef{3}g"));
        System.out.println(challenge5 + " = " +
                challenge5.matches("a+bc+d+ef+g"));
        System.out.println(challenge5 + " = " +
                challenge5.matches("[a-h]*"));

        System.out.println("\n----------------");
        System.out.println("Challenge 6");
        System.out.println("----------------");

        System.out.println(challenge5 + " = " +
                challenge5.matches("^a{3}bc{8}d{3}ef{3}g$"));

        System.out.println("\n----------------");
        System.out.println("Challenge 7");
        System.out.println("----------------");

        String pattern7 = "^[a-zA-Z]+\\.[0-9]+";
        System.out.println("abcd.135" + " = " +
                "abcd.135".matches(pattern7));
        System.out.println("kjisl.22" + " = " +
                "kjisl.22".matches(pattern7));
        System.out.println("f5.12a" + " = " +
                "f5.12a".matches(pattern7));

        System.out.println("\n----------------");
        System.out.println("Challenge 8");
        System.out.println("----------------");

        String challenge8 = "abcd.135uvqz.7tzik.999";

        Pattern pattern8 = Pattern.compile("([a-zA-Z]+)\\.([0-9]+)");
        Matcher matcher8 = pattern8.matcher(challenge8);

        int counter = 0;
        System.out.println("Looking at string: " + challenge8);
        while (matcher8.find()) {
            counter++;
            System.out.printf("%d. %s found at {%d, %d}%n",
                    counter, matcher8.group(2), matcher8.start(), matcher8.end());
        }

        System.out.println("\n----------------");
        System.out.println("Challenge 9");
        System.out.println("----------------");

        String challenge9 = "abcd.135\tuvqz.7\ttzik.999\n";

        Pattern pattern9 = Pattern.compile("([a-zA-Z]+)\\.([0-9]+)\\s");
        Matcher matcher9 = pattern9.matcher(challenge9);

        counter = 0;
        System.out.println("Looking at string: " + challenge9);
        while (matcher9.find()) {
            counter++;
            System.out.printf("%d. %s found at {%d, %d}%n",
                    counter, matcher9.group(2), matcher9.start(), matcher9.end());
        }

        System.out.println("\n----------------");
        System.out.println("Challenge 10");
        System.out.println("----------------");

        String challenge10 = "abcd.135\tuvqz.7\ttzik.999\n";

        Pattern pattern10 = Pattern.compile("([a-zA-Z]+)\\.([0-9]+)\\s");
        Matcher matcher10 = pattern10.matcher(challenge10);

        counter = 0;
        System.out.println("Looking at string: " + challenge10);
        while (matcher10.find()) {
            counter++;
            System.out.printf("%d. %s found at {%d, %d}%n",
                    counter, matcher10.group(2), matcher10.start(2), matcher10.end(2)-1);
        }

        System.out.println("\n----------------");
        System.out.println("Challenge 11");
        System.out.println("----------------");

        String challenge11 = "{0, 2}, {0, 5}, {1, 3}, {2, 4}";
//        Pattern pattern11 = Pattern.compile("\\{(.+?)\\}");
        Pattern pattern11 = Pattern.compile("\\{(\\d+(, )\\d+)\\}");
        Matcher matcher11 = pattern11.matcher(challenge11);

        while (matcher11.find()) {
            System.out.println(matcher11.group(1));
        }

        System.out.println("\n----------------");
        System.out.println("Challenge 12");
        System.out.println("----------------");

        String challenge12 = "11111";
        System.out.println(challenge12 + " = " +
                challenge12.matches("^\\d{5}$"));

        System.out.println("\n----------------");
        System.out.println("Challenge 13");
        System.out.println("----------------");

        String challenge13 = "11111-1111";
        System.out.println(challenge13 + " = " +
                challenge13.matches("^\\d{5}\\-\\d{4}$"));

        System.out.println("\n----------------");
        System.out.println("Challenge 14");
        System.out.println("----------------");

        String challenge14 = "11111-1111-1111";

        String pattern14 = "^\\d{5}(\\-\\d{4})??$";
        System.out.println(challenge13 + " = " +
                challenge13.matches(pattern14));
        System.out.println(challenge12 + " = " +
                challenge12.matches(pattern14));
        System.out.println(challenge14 + " = " +
                challenge14.matches(pattern14));

    }
}
