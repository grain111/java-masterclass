package me.suski;

public class Main {

    public static void main(String[] args) {

//        int count = 0;
//        while(count != 5) {
//            System.out.println("(while) Count is " + count);
//            count ++;
//        }
//
//        for(int i=0; i<5; i++){
//            System.out.println("(for) Count is " + i);
//        }
//
//        count = 0;
//        do {
//            System.out.println("(do) Count is " + count);
//            count++;
//        } while(count != 5);

        int number = 4;
        int finish = 20;
        int count = 0;

        while(number <= finish) {
            number++;
            if (!isEvenNumber(number)) {
                continue;
            }

            count++;
            System.out.println("Even number " + number);
            if (count == 5) {
                break;
            }
        }
        System.out.println("Count is " + count);

    }

    public static boolean isEvenNumber(int num) {
        return num > 0 && num % 2 == 0;
    }
}
