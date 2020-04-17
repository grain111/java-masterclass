package me.suski;

public class PC  {
    private Case theCase;
    private Monitor monitor;
    private Motherboard motherboard;

    public PC(Case theCase, Monitor monitor, Motherboard motherboard) {
        this.theCase = theCase;
        this.monitor = monitor;
        this.motherboard = motherboard;
    }

    public void powerUp() {
        this.theCase.preesPowerButton();
        drawLogo();
    }

    private void drawLogo() {
        this.monitor.drawPixelAt(1200, 300, "yellow");
    }
}
