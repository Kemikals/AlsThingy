package com.products;

public abstract class Product {

    String name;
    String manufacture;
    public static final int STORE_PRODUCTS = 2;


    public Product() {

    }

    public Product(String name, String manufacture) {
        this.name = name;
        this.manufacture = manufacture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    
    public void print() {

        System.out.println("Product :\nName : "+name+"\nManufacture :"+manufacture);

    }

}
