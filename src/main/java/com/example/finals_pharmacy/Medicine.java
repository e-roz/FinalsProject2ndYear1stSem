package com.example.finals_pharmacy;
public class Medicine {
    private String name;
    private String id;
    private String brandName;
    private String quantity;
    private String price;

    private Double Quantity;

    public Medicine(String id, String brandName, String name,  String price, String quantity){
        this.id = id;
        this.brandName = brandName;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    public Medicine(String quantity){
        this.quantity = quantity;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setId(String id){
        this.id = id;
    }
    public void setQuantity(String quantity){
        this.quantity = quantity;
    }
    public void setPrice(String price){
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public String getPrice() {
        return price;
    }
    public String getQuantity() {
        return quantity;
    }
    public String getId() {
        return id;
    }
    public void setBrandName(String newValue){
        this.brandName = brandName;
    }
    public String getBrandName(){
        return brandName;
    }
}
