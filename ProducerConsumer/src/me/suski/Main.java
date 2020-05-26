package me.suski;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static me.suski.Main.EOF;
import static me.suski.ThreadColor.*;

public class Main {
    public static final String EOF = "EOF";

    public static void main(String[] args) {

        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<>(6);


        ExecutorService executorService = Executors.newFixedThreadPool(4);
        MyProducer producer = new MyProducer(buffer, ANSI_RED);
        MyConsumer consumer1 = new MyConsumer(buffer, ANSI_PURPLE);
        MyConsumer consumer2 = new MyConsumer(buffer, ANSI_CYAN);

        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ANSI_BLUE + "I'm being printed from callable class");
                return "This is a callable result";
            }
        });

        try {
            System.out.println(future.get());
        } catch (ExecutionException | InterruptedException e) {
            System.out.println("Something went wrong");
        }

        executorService.shutdown();
    }
}

class MyProducer implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;
    ReentrantLock bufferLock;

    public MyProducer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] nums = {
                "1",
                "2",
                "3",
                "4",
                "5"
        };

        for (String num :
                nums) {
            try {
                System.out.println(color + "Adding..." + num);
                buffer.put(num);
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting...");
        try {
            buffer.put(EOF);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}

class MyConsumer implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (buffer) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    if (buffer.peek().equals(EOF)) {
                        System.out.println(color + "Exiting");
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.take());
                    }
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }

        }
    }
}
