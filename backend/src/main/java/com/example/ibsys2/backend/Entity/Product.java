package com.example.ibsys2.backend.Entity;


import java.util.ArrayList;
import java.util.HashMap;

public class Product {

    int id;
    String name;
    int deliverytime;
    int variance;
    int product1Consumption;
    int product2Consumption;
    int product3Consumption;
    int discountQuantity;
    HashMap<Integer, Integer> stockHistory;
    public int productId;

    // create constructor
    public Product(int id, String name, int discountQuantity, int deliverytime, int variance,
            int product1Consumption, int product2Consumption, int product3Consumption, int stock) {
        this.id = id;
        this.name = name;
        this.discountQuantity = discountQuantity;
        this.deliverytime = deliverytime;
        this.variance = variance;
        this.product1Consumption = product1Consumption;
        this.product2Consumption = product2Consumption;
        this.product3Consumption = product3Consumption;
        this.stockHistory = new HashMap<Integer, Integer>();

        for (int i = 0; i < 28; i++) {
            stockHistory.put(i, stock);
        }
    }

    public static HashMap<Integer, Integer> updateStockHistoryByForecast(Product product,
            ArrayList<ProductionPlanEntity> productionPlanEntity) {
        ArrayList<Integer> needsforWeek = ProductionPlanEntity.calcNeedsForWeek(product, productionPlanEntity);
        // iterate over products.StockHistory and remove needs for each day from stock
        // value
        for (int i = 0; i < needsforWeek.size(); i++) {

            int amount = 0;
            if (needsforWeek.get(i) != 0) {
                amount = needsforWeek.get(i) / 5;
            }
            for (int j = 0; j < 5; j++) {

                // update the stock history foreach key, that is higher than the acutal i*5+j
                for (int k = i * 5 + j; k < 28; k++) {
                    product.stockHistory.put(k, product.stockHistory.get(k) - amount);
                }
            }
        }
        return product.stockHistory;
    }

    public int getId() {
        return this.id;
    }

    public int getDeliveryTime() {
        return this.deliverytime + this.variance;
    }

    public int getStock() {
        return this.stockHistory.get(0);
    }

    public String getQuantity() {
        return null;
    }

    public String getProductId() {
        return null;
    }

    public String getName() {
        return this.name;
    }
}
