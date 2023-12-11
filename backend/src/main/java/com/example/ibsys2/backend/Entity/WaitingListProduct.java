package com.example.ibsys2.backend.Entity;

import java.util.ArrayList;

public class WaitingListProduct {
    private int productId;
    private int waitlistQuantity;
    private int inWorkQuantity;

    public WaitingListProduct(int productId, int waitlistQuantity, int inWorkQuantity) {
        this.productId = productId;
        this.waitlistQuantity = waitlistQuantity;
        this.inWorkQuantity = inWorkQuantity;
    }

    public int getProductId() {
        return productId;
    }

    public int getInWorkQuantity() {
        return inWorkQuantity;
    }

     public int getWaitlistQuantity() {
        return waitlistQuantity;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setInWorkQuantity(int inWorkQuantity) {
        this.inWorkQuantity = inWorkQuantity;
    }

    public void setWaitlistQuantity(int waitListQuantity) {
        this.waitlistQuantity = waitlistQuantity;
    }

    public static int GetWaitingListQuantity(int productId, ArrayList<WaitingListProduct> waitingListProducts) {

        for (WaitingListProduct waitingListProduct : waitingListProducts) {
            if (waitingListProduct.getProductId() == productId) {
                return waitingListProduct.getWaitlistQuantity();
            }
        }
        return 0;
    }

    public static int GetInWorkQuantity(int productId, ArrayList<WaitingListProduct> waitingListProducts) {

        for (WaitingListProduct waitingListProduct : waitingListProducts) {
            if (waitingListProduct.getProductId() == productId) {
                return waitingListProduct.getInWorkQuantity();
            }
        }
        return 0;
    }   
}
