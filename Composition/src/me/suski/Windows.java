package me.suski;

public class Windows {

    private int width;
    private int height;
    private int count;

    public Windows(int width, int height, int count) {
        this.width = width;
        this.height = height;
        this.count = count;
    }

    public void open(int num) {
        if (num <= 0) {
            System.out.println("Invalid number");
        } else if (num < count) {
            System.out.println("Opening window number " + num);
        } else {
            System.out.println("Woow, I don't have that many windows!");
        }
    }

    public void closeAll() {
        System.out.println("Closing all windows");
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getCount() {
        return count;
    }
}
