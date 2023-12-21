package com.example.ibsys2.backend.Entity;

public class SetupTimes {

    public int productId;
    public int setupTime;
    public int setupQunatity;

    public SetupTimes(int productId, int setupTime, int setupQunatity) {
        this.productId = productId;
        this.setupTime = setupTime;
        this.setupQunatity = setupQunatity;
    }

    public int getProductId() {
        return this.productId;
    }

    public int getSetupTime() {
        return this.setupTime;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setSetupTime(int setupTime) {
        this.setupTime = setupTime;
    }

    public int getSetupQunatity() {
        return setupQunatity;
    }

    public void setSetupQunatity(int setupQunatity) {
        this.setupQunatity = setupQunatity;
    }
}
