package me.suski;

public class Main {

    public static void main(String[] args) {


        Dog dog = new Dog("Yorkie");
        dog.breathe();
        dog.eat();

        Parrot bird = new Parrot("Polly");
        bird.breathe();
        bird.eat();
        bird.fly();

        Penguin penguin = new Penguin("John");
        penguin.breathe();
        penguin.eat();
        penguin.fly();
    }
}
