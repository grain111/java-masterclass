package me.suski;

public class Main {

    public static void main(String[] args) {

//        int value = 3;
//        if (value ==1) {
//            System.out.println("Value was 1");
//        } else if (value == 2) {
//            System.out.println("Value was 2");
//        } else {
//            System.out.println("Was not 1 or 2");
//        }

        int switchValue = 4;
        switch(switchValue){
            case 1:
                System.out.println("value was 1");
                System.out.println("one");
                break;

            case 2:
                System.out.println("Value was 2");
                break;

            case 3: case 4: case 5:
                System.out.println("Was 3, 4 or 5");
                break;

            default:
                System.out.println("Was not 1 - 5");
                break;
        }

        char charVal = 'D';
        switch(charVal) {

            case 'A':
                System.out.println("It was an A");
                break;

            case 'B':
                System.out.println("It was an B");
                break;

            case 'C':
                System.out.println("It was an C");
                break;

            case 'D':
                System.out.println("It was an D");
                break;

            case 'E':
                System.out.println("It was an E");
                break;

            default:
                System.out.println("Not found");
                break;
        }

        String month = "June";
        switch(month.toLowerCase()) {
            case "january":
                System.out.println("Jan");
                break;

            case "june":
                System.out.println("Jun");
                break;
        }
    }
}
