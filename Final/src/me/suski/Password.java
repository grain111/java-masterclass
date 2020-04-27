package me.suski;

public class Password {

    private static int key = 46854321;
    private final int encryptedPassword;

    public Password(int password) {
        this.encryptedPassword = encryptDecrypt(password);
    }

    private int encryptDecrypt(int pass) {
        return pass ^ key;
    }

    public final void storePassword() {
        System.out.println("Saving password as " +
                this.encryptedPassword);
    }

    public boolean letMeIn(int pass) {
        if (encryptDecrypt(pass) == this.encryptedPassword) {
            System.out.println("Welcome");
            return true;
        } else {
            System.out.println("Wrong password");
            return false;
        }
    }
}
