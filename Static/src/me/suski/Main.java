package me.suski;

public class Main {

    public static int multiplier = 7;

    public static void main(String[] args) {

//        StaticTest instance1 = new StaticTest("1st");
//        System.out.println(instance1.getName() +
//                " is instance number " + StaticTest.getNumInstances());
//
//        StaticTest instance2 = new StaticTest("2nd");
//        System.out.println(instance2.getName() +
//                " is instance number " + StaticTest.getNumInstances());
//
//        StaticTest instance3 = new StaticTest("2nd");
//        System.out.println(instance3.getName() +
//                " is instance number " + StaticTest.getNumInstances());

        int ans = multiply(6);
        System.out.println(ans);
        System.out.println(multiplier);
    }

    public static int multiply(int num) {
        return num * multiplier;
    }
}
