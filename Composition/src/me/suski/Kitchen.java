package me.suski;

public class Kitchen {

    private Door door;
    private Walls walls;
    private Windows windows;
    private Switch lightSwitch;
    private PC PC;

    public Kitchen(Door door, Walls walls, Windows windows, Switch lightSwitch, me.suski.PC PC) {
        this.door = door;
        this.walls = walls;
        this.windows = windows;
        this.lightSwitch = lightSwitch;
        this.PC = PC;
    }

    public void turnOnPC() {
        System.out.println("Starting the PC");
        this.PC.powerUp();
    }

    public void sealTheRoom() {
        this.door.close();
        this.windows.closeAll();
    }

    public Door getDoor() {
        return door;
    }

    public Walls getWalls() {
        return walls;
    }

    public Windows getWindows() {
        return windows;
    }

    public Switch getLightSwitch() {
        return lightSwitch;
    }

    private me.suski.PC getPC() {
        return PC;
    }
}
