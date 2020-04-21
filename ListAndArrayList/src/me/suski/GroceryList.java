package me.suski;

import java.util.ArrayList;

public class GroceryList {
    private ArrayList<String> groceryList = new ArrayList<String>();

    public ArrayList<String> getGroceryList() {
        return groceryList;
    }

    public void addGroceryItem(String item) {
        groceryList.add(item);
    }

    public void printGroceryList() {
        System.out.println("You have " + groceryList.size() +
                " items in your grocery list.");

        for(int i=0; i<groceryList.size(); i++) {
            System.out.println((i+1) + ". " + groceryList.get(i));
        }
    }

    public void modifyGroceryItem(String item, String newItem) {
        int pos = findItem(item);
        if (pos >= 0){
            modifyGroceryItem(pos, newItem);
        }
    }

    private void modifyGroceryItem(int i, String item) {
        groceryList.set(i, item);
        System.out.println("Grocery item " + (i + 1) + " has been modified.");
    }

    public void removeGroceryItem(String item) {
        int pos = findItem(item);
        if (pos >= 0){
            removeGroceryItem(pos);
        }
    }

    private void removeGroceryItem(int pos) {
        groceryList.remove(pos);
    }

    private int findItem(String searchItem) {
        return  groceryList.indexOf(searchItem);
    }

    public boolean onFile(String searchItem) {
        int pos = findItem(searchItem);
        if (pos >= 0) {
            return true;
        } else {
            return false;
        }
    }
}
