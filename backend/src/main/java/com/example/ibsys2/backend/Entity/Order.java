package com.example.ibsys2.backend.Entity;

import java.util.ArrayList;
import java.util.HashMap;

public class Order {
    int id;
    int productId;
    int quantity;
    int daysAfterToday;

    // create consutructor
    public Order(int id, int productId, int quantity, int daysAfterToday) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.daysAfterToday = daysAfterToday;
    }

    public static HashMap<Integer, Integer> updateStockHistoryByOrders(Product product, ArrayList<Order> orders) {
        // add orders to stock History
        for (Order o : orders) {
            if (o.productId == product.getId()) {
                if (o.daysAfterToday < 0) {
                    o.daysAfterToday = 0;
                }
                for (int i = o.daysAfterToday; i < 28; i++) {
                    product.stockHistory.put(i, product.stockHistory.get(i) + o.quantity);
                }
            }
        }

        return product.stockHistory;
    }

    public int getId() {
        return this.id;
    }

    public int getProductId() {
        return this.productId;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public int getDaysAfterToday() {
        return this.daysAfterToday;
    }
}