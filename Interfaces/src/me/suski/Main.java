package me.suski;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        ITelephone timsPhone;
        timsPhone = new DeskPhone(123456787);
        timsPhone.powerOn();
        timsPhone.callPhone(123456787);
        timsPhone.answer();
        System.out.println("====================");
        timsPhone = new MobilePhone(25454);
        timsPhone.powerOn();
        timsPhone.callPhone(25454);
        timsPhone.answer();
    }
}
