package me.suski;

import static me.suski.ThreadColor.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(ANSI_PURPLE + "Hello from the main thread.");
        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");
        anotherThread.start();

        new Thread() {
            @Override
            public void run() {
                System.out.println(ANSI_GREEN + "Hello from the anonymous class thread");
            }
        }.start();

        Thread myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ANSI_RED + "Hello from anonymous implementation of run()");

                try {
                    anotherThread.join();
                    System.out.println(ANSI_RED + "AnotherThread terminated or timed out, running again");
                } catch (InterruptedException e) {
                    System.out.println(ANSI_RED + "Interrupted by another thread");
                }
            }
        });

        myRunnableThread.start();
//        anotherThread.interrupt();

        System.out.println(ANSI_PURPLE + "Hello again from the main thread.");

    }
}
