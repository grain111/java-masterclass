package me.suski;

public class Texture {

    private int color;
    private int texture;

    public Texture(int color, int texture) {
        this.color = color;
        this.texture = texture;
    }

    public int getColor() {
        return color;
    }

    public int getTexture() {
        return texture;
    }
}
