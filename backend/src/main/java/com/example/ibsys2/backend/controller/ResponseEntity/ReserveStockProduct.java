package com.example.ibsys2.backend.controller.ResponseEntity;

import java.util.ArrayList;

public class ReserveStockProduct {
    public int productId;
    public int reserveStock;

    public ReserveStockProduct(int productId, int reserveStock) {
        this.productId = productId;
        this.reserveStock = reserveStock;
    }

    public int getProductId() {
        return productId;
    }

    public int getReserveStock() {
        return reserveStock;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setReserveStock(int reserveStock) {
        this.reserveStock = reserveStock;
    }

    public static int GetReserveStock(int productId, ArrayList<ReserveStockProduct> reserveStocks) {

        for (ReserveStockProduct reserveStock : reserveStocks) {
            if (reserveStock.getProductId() == productId) {
                return reserveStock.getReserveStock();
            }
        }
        return 0;
    }
}
