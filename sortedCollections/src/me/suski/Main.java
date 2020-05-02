package me.suski;

import java.util.Map;

public class Main {

    private static StockList stockLIst = new StockList();

    public static void main(String[] args) {


        StockItem temp = new StockItem("bread", 0.86, 5);
        stockLIst.addStock(temp);

        temp = new StockItem("cake", 1.1, 5);
        stockLIst.addStock(temp);

        temp = new StockItem("car", 12.5, 5);
        stockLIst.addStock(temp);

        temp = new StockItem("chair", 62.0, 5);
        stockLIst.addStock(temp);

        temp = new StockItem("cup", 0.5, 2);
        stockLIst.addStock(temp);
        temp = new StockItem("cup", 0.45, 3);
        stockLIst.addStock(temp);

        temp = new StockItem("door", 72.95, 5);
        stockLIst.addStock(temp);

        temp = new StockItem("juice", 2.5, 5);
        stockLIst.addStock(temp);

        temp = new StockItem("phone", 96.99, 5);
        stockLIst.addStock(temp);

        temp = new StockItem("towel", 2.4, 5);
        stockLIst.addStock(temp);

        temp = new StockItem("vase", 8.76, 5);
        stockLIst.addStock(temp);

        System.out.println(stockLIst);

        System.out.println("================");

        for (String s : stockLIst.items().keySet()) {
            System.out.println(s);
        }

        Basket basket = new Basket("Bartek");
        Basket basket2 = new Basket("Bran");
        addToBasket(basket, "car", 1);
        addToBasket(basket2, "car", 1);
//        System.out.println(basket);

        addToBasket(basket, "car", 1);
        System.out.println(basket);

        removeFromBasket(basket, "car", 2);
        System.out.println(basket);

        addToBasket(basket, "car", 6);
        addToBasket(basket, "spanner", 1);
        System.out.println(basket);

        addToBasket(basket, "juice", 1);
        addToBasket(basket, "cup", 1);
        addToBasket(basket, "bread", 1);
        addToBasket(basket, "car", 1);
        System.out.println(basket);

        System.out.println(stockLIst);
        stockLIst.printReserved();
        checkout(basket);
        stockLIst.printReserved();
        checkout(basket2);
        stockLIst.printReserved();
        System.out.println(basket);
        System.out.println(stockLIst);


//        for (Map.Entry<String, Double> price : stockLIst.priceList().entrySet()) {
//            System.out.println(price.getKey() + " costs " + price.getValue());
//        }

    }

    public static int addToBasket(Basket basket, String itemName, int quantity) {
        if (stockLIst.reserveItem(itemName, quantity) == quantity) {
            basket.addToBasket(stockLIst.get(itemName), quantity);
            return quantity;
        }
        return 0;
    }

    public static int removeFromBasket(Basket basket, String itemName, int quantity) {
        StockItem item = stockLIst.items().getOrDefault(itemName, null);
        if (item != null) {
            int amountInBasket = basket.items().get(item);
            System.out.println("amount" + amountInBasket);
            if (amountInBasket >= quantity) {

                int res = basket.removeFromBasket(item, quantity);
                if (res > 0) {
                    return stockLIst.unreserveItem(itemName, quantity);
                }
            }
        }
        return 0;
    }

    public static void checkout(Basket basket) {
        for (Map.Entry<StockItem, Integer> itemInBasket : basket.items().entrySet()) {
            stockLIst.sellStock(itemInBasket.getKey().getName(), itemInBasket.getValue());
        }
        basket.clear();
    }

//    public static int sellItem(Basket basket, String item, int quantity) {
//        StockItem stockItem =   stockLIst.get(item);
//        if (stockItem == null) {
//            System.out.println("We don't sell " + item);
//            return 0;
//        }
//
//        if (stockLIst.sellStock(item, quantity) != 0) {
//            basket.addToBasket(stockItem, quantity);
//            return quantity;
//        }
//        return 0;
//    }
}
