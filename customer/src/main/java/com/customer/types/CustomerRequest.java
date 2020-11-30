package com.customer.types;

public class CustomerRequest {
    private String name;
    private String productName;
    private String prize;
    private Adderess address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public Adderess getAddress() {
        return address;
    }

    public void setAddress(Adderess address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CustomerRequest{" +
                "name='" + name + '\'' +
                ", productName='" + productName + '\'' +
                ", prize='" + prize + '\'' +
                ", address=" + address +
                '}';
    }
}
