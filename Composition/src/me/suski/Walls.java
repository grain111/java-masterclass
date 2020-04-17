package me.suski;

public class Walls {

    private int count;
    private Texture texture;
    private String material;

    public Walls(int count, Texture texture, String material) {
        this.count = count;
        this.texture = texture;
        this.material = material;
    }

    public int getCount() {
        return count;
    }

    public Texture getTexture() {
        return texture;
    }

    public String getMaterial() {
        return material;
    }
}
