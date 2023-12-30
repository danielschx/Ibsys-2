package com.example.ibsys2.backend.controller.ResponseEntity;

public class ProductInfo {
    private int productId;
    private String name;
    private int stock;
    private int waitingListQuantity;
    private int ordersInWorkQuantity;

    public ProductInfo(int productId, String name, int stock, int waitingListQuantity, int ordersInWorkQuantity) {
        this.productId = productId;
        this.name = name;
        this.stock = stock;
        this.waitingListQuantity = waitingListQuantity;
        this.ordersInWorkQuantity = ordersInWorkQuantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getWaitingListQuantity() {
        return waitingListQuantity;
    }

    public void setWaitingListQuantity(int waitingListQuantity) {
        this.waitingListQuantity = waitingListQuantity;
    }

    public int getOrdersInWorkQuantity() {
        return ordersInWorkQuantity;
    }

    public void setOrdersInWorkQuantity(int ordersInWorkQuantity) {
        this.ordersInWorkQuantity = ordersInWorkQuantity;
    }
}
