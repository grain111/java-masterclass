package me.suski;

import java.util.*;

public class StockList {
    private final Map<String, StockItem> inStockList;
    private final Map<String, Integer> reservedList;

    public StockList() {
        this.inStockList = new LinkedHashMap<>();
        this.reservedList = new HashMap<>();
    }

    public int addStock(StockItem item) {
        if (item != null) {
            StockItem inStock = inStockList.getOrDefault(item.getName(), item);
            if (inStock != item) {
                item.adjustStock(inStock.quantityInStock());
            }
            inStockList.put(item.getName(), item);
            return item.quantityInStock();
        }
        return 0;
    }

    private int getAvailableStock(String name) {
        StockItem item = inStockList.getOrDefault(name, null);
        int itemsReserved = reservedList.getOrDefault(name, 0);
        if (item != null) {
            return item.quantityInStock() - itemsReserved;
        }
        return 0;
    }


    public int reserveItem(String name, int quantity) {
        int itemsInStock = getAvailableStock(name);
        if (itemsInStock >= quantity) {
            int newQuantity = reservedList.getOrDefault(name, 0) + quantity;
            reservedList.put(name, newQuantity);
            return quantity;
        }
        return 0;
    }

    public int unreserveItem(String name, int quantity) {
        int itemsReserved = reservedList.getOrDefault(name, 0);
        if (itemsReserved >= quantity) {
            int newAmount = itemsReserved - quantity;
            reservedList.put(name, newAmount);
            if (newAmount == 0) {
                reservedList.remove(name);
            }
            return quantity;
        }
        return 0;
    }

    public int sellStock(String item, int quantity) {
        StockItem inStock = inStockList.getOrDefault(item, null);

        if (inStock != null &&
                inStock.quantityInStock() >= quantity &&
                quantity > 0) {
            inStock.adjustStock(-quantity);
            unreserveItem(item, quantity);
            return quantity;
        }
        return 0;
    }

    public StockItem get(String name) {
        return inStockList.get(name);
    }

    public Map<String, Double> priceList() {
        Map<String, Double> prices = new LinkedHashMap<>();

        for (Map.Entry<String, StockItem> item : inStockList.entrySet()) {
            prices.put(item.getKey(), item.getValue().getPrice());
        }

        return Collections.unmodifiableMap(prices);
    }

    public Map<String, StockItem> items() {
        return Collections.unmodifiableMap(inStockList);
    }

    public Map<String, Integer> itemsReserved() {
        return Collections.unmodifiableMap(reservedList);
    }

    public void printReserved() {
        System.out.println("Reserved items: ");
        for (Map.Entry<String, Integer> item: reservedList.entrySet()) {
            System.out.println(item.getKey() + ": " + item.getValue());
        }
    }

    @Override
    public String toString() {
        String s = "\nStock inStockList\n";
        double totalCost = 0d;
        for (Map.Entry<String, StockItem> item : inStockList.entrySet()) {
            StockItem stockItem = item.getValue();

            double itemValue = stockItem.getPrice() * stockItem.quantityInStock();
            s += stockItem + ". There are " + stockItem.quantityInStock() +
                    " in stock. Value of items: " + String.format("%.2f", itemValue) + "\n";
            totalCost += itemValue;

        }
        return s + "Total stock value: " + String.format("%.2f", totalCost);
    }
}
