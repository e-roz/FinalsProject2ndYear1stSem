package com.example.finals_pharmacy;
public class Medicine {
    private String name;
    private String id;
    private String brandName;
    private double quantity;
    private double price;

    public Medicine(String id, String brandName, String name,  double price, double quantity){
        this.id = id;
        this.brandName = brandName;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setId(String id){
        this.id = id;
    }
    public void setQuantity(double quantity){
        this.quantity = quantity;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public double getQuantity() {
        return quantity;
    }
    public String getId() {
        return id;
    }
    public void setBrandName(){
        this.brandName = brandName;
    }
    public String getBrandName(){
        return brandName;
    }
}
