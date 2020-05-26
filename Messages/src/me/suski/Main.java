package me.suski;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Message message = new Message();
        (new Thread(new Writer(message))).start();
        (new Thread(new Reader(message))).start();
    }
}

class Reader implements Runnable {
    private Message message;

    public Reader(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        Random random = new Random();

        for(String latestMessage = message.read();
        !latestMessage.equals("Finished");
        latestMessage = message.read()) {

            System.out.println(latestMessage);

            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class Writer implements Runnable {

    private Message message;

    public Writer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String[] messages = {
                "Humpty Dumpty sat on a wall",
                "Humpty Dumpty had a great fall",
                "All the king's horses and all the king's man",
                "Couldn't put Humpty together again"
        };

        Random random = new Random();

        for (String message :
                messages) {
            this.message.write(message);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        message.write("Finished");
    }
}

class Message {
    private String message;
    private boolean empty = true;

    synchronized String read() {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        empty = true;
        notifyAll();
        return message;
    }

    synchronized void write(String message) {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        empty = false;
        this.message = message;
        notifyAll();
    }
}
