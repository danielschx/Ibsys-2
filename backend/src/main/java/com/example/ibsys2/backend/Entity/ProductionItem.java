package com.example.ibsys2.backend.Entity;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductionItem {
    public int id;
    private int article;
    private int quantity;
    private int sequenceNumer;
    private String Name;
    private ArrayList<String> informations;

    public ProductionItem(int article, String name, int quantity, ArrayList<String> informations) {
        this.article = article;
        this.quantity = quantity;
        this.Name = name;
        this.informations = informations;
    }

    // Standardkonstruktor, Getter und Setter

    @JsonProperty("article")
    public int getArticle() {
        return article;
    }

    @JsonProperty("article")
    public void setArticle(int article) {
        this.article = article;
    }

    @JsonProperty("quantity")
    public int getQuantity() {
        return quantity;
    }

    @JsonProperty("quantity")
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumer = sequenceNumber;
    }

    public int getSequenceNumer() {
        return sequenceNumer;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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
