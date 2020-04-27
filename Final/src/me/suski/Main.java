package me.suski;

public class Main {

    public static void main(String[] args) {

//        SomeClass one = new SomeClass("one");
//        SomeClass two = new SomeClass("two");
//        SomeClass three = new SomeClass("three");
//
//        System.out.println(one.getInstanceNumber());
//        System.out.println(two.getInstanceNumber());
//        System.out.println(three.getInstanceNumber());
//
//        System.out.println(Math.PI);
//
//
//        int pw = 1234;
//        Password pass = new ExtendedPassword(pw);
//        pass.storePassword();
//        pass.letMeIn(222);
//        pass.letMeIn(1);
//        pass.letMeIn(6555);
//        pass.letMeIn(0);
//        pass.letMeIn(1234);

        System.out.println("Main method called");
        SIBTest test = new SIBTest();
        test.someMethod();
        System.out.println("Owner is " + SIBTest.owner);
    }
}
