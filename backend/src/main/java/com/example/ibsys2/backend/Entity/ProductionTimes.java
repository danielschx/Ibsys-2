package com.example.ibsys2.backend.Entity;

public class ProductionTimes {
    public int productId;
    public int quantity;
    public int durationPerUnit;

    public ProductionTimes(int productId, int quantity, int durationPerUnit) {
        this.productId = productId;
        this.quantity = quantity;
        this.durationPerUnit = durationPerUnit;
    }

    public int getProductId() {
        return this.productId;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public int getDurationPerUnit() {
        return this.durationPerUnit;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDurationPerUnit(int durationPerUnit) {
        this.durationPerUnit = durationPerUnit;
    }
}
