package com.example.burgerfreakz;

public class Product {
    private int id;
    private String ProName, ProCode, ProPrice, proSize;


    public Product() {
    }

    public Product(int id, String proName, String proCode, String proPrice, String proSize) {
        this.id = id;
        ProName = proName;
        ProCode = proCode;
        ProPrice = proPrice;
        this.proSize = proSize;
    }

    public Product(String proName, String proCode, String proPrice, String proSize) {
        ProName = proName;
        ProCode = proCode;
        ProPrice = proPrice;
        this.proSize = proSize;
    }

    public int getId() {
        return id;
    }

    public String getProName() {
        return ProName;
    }

    public String getProCode() {
        return ProCode;
    }

    public String getProPrice() {
        return ProPrice;
    }

    public String getProSize() {
        return proSize;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProName(String proName) {
        ProName = proName;
    }

    public void setProCode(String proCode) {
        ProCode = proCode;
    }

    public void setProPrice(String proPrice) {
        ProPrice = proPrice;
    }

    public void setProSize(String proSize) {
        this.proSize = proSize;
    }
}