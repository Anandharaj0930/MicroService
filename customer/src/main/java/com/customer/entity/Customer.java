package com.customer.entity;

import com.customer.types.Adderess;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String productName;
    private String orderCode;
    private String prize;
    @Embedded
    private Adderess address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
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
        return "Customer{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", orderCode='" + orderCode + '\'' +
                ", prize='" + prize + '\'' +
                ", address=" + address +
                '}';
    }
}
