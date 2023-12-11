package com.example.ibsys2.backend.Entity;
    
import java.util.ArrayList;

public class ProductionPlanEntity {
    public int periode;
    public int product1Consumption;
    public int product2Consumption;
    public int product3Consumption;

    // constructor
    public ProductionPlanEntity(int periode, int product1Consumption, int product2Consumption, int product3Consumption) {
        this.periode = periode;
        this.product1Consumption = product1Consumption;
        this.product2Consumption = product2Consumption;
        this.product3Consumption = product3Consumption;
    }

    public int getPeriode() {
        return periode;
    }

    public void setPeriode(int periode) {
        this.periode = periode;
    }

    public int getProduct1Consumption() {
        return product1Consumption;
    }

    public void setProduct1Consumption(int product1Consumption) {
        this.product1Consumption = product1Consumption;
    }

    public int getProduct2Consumption() {
        return product2Consumption;
    }

    public void setProduct2Consumption(int product2Consumption) {
        this.product2Consumption = product2Consumption;
    }

    public int getProduct3Consumption() {
        return product3Consumption;
    }

    public void setProduct3Consumption(int product3Consumption) {
        this.product3Consumption = product3Consumption;
    }

    // create method getForecast
    public static ArrayList<ProductionPlanEntity> getForecast() {
        ArrayList<ProductionPlanEntity> productionPlanEntities = new ArrayList<ProductionPlanEntity>();
        productionPlanEntities.add(new ProductionPlanEntity(1, 200, 150, 100));
        productionPlanEntities.add(new ProductionPlanEntity(2, 200, 150, 100));
        productionPlanEntities.add(new ProductionPlanEntity(3, 250, 150, 250));
        productionPlanEntities.add(new ProductionPlanEntity(4, 250, 150, 150));
        return productionPlanEntities;
    }

    public static ArrayList<Integer> calcNeedsForWeek(Product product, ArrayList<ProductionPlanEntity> productionPlanEntity) {
        ArrayList<Integer> needs = new ArrayList<>();
        for (ProductionPlanEntity f : productionPlanEntity) {
            needs.add(f.product1Consumption * product.product1Consumption
                    + f.product2Consumption * product.product2Consumption
                    + f.product3Consumption * product.product3Consumption);
        }
        return needs;
    }
}
