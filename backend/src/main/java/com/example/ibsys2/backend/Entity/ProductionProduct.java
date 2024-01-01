package com.example.ibsys2.backend.Entity;

import java.util.ArrayList;

public class ProductionProduct {
    int id;
    String name;
    int product1Consumption;
    int product2Consumption;
    int product3Consumption;
    int stock;
    int waitingListQuantity;
    int inProductionQuantity;
    int reserveStock;
    ArrayList<String> informations = new ArrayList<String>();

    public ProductionProduct(int Id, String Name, int p1, int p2, int p3, int stock) {
        this.id = Id;
        this.name = Name;
        this.product1Consumption = p1;
        this.product2Consumption = p2;
        this.product3Consumption = p3;
        this.stock = stock;
        this.waitingListQuantity = 0;
        this.inProductionQuantity = 0;
        this.reserveStock = 50;
    }

    // Write getter for productConsumptions
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getProduct1Consumption() {
        return product1Consumption;
    }

    public int getProduct2Consumption() {
        return product2Consumption;
    }

    public int getProduct3Consumption() {
        return product3Consumption;
    }

    public int getStock() {
        return stock;
    }

    public int getWaitingListQuantity() {
        return waitingListQuantity;
    }

    public int getInProductionQuantity() {
        return inProductionQuantity;
    }

    // Write setter for Quantity
    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setWaitingListQuantity(int waitingListQuantity) {
        this.waitingListQuantity = waitingListQuantity;
    }

    public void setInProductionQuantity(int inProductionQuantity) {
        this.inProductionQuantity = inProductionQuantity;
    }

    public int getReserveStock() {
        return reserveStock;
    }

    public void setReserveStock(int reserveStock) {
        this.reserveStock = reserveStock;
    }

    public ArrayList<String> getInformations() {
        return informations;
    }

    public void setInformations(ArrayList<String> informations) {
        this.informations = informations;
    }

    public void addInformation(String information) {
        this.informations.add(information);
    }
}

