package com.stock.entity;

import javax.persistence.*;

@Entity
@Table(name = "MICRO_STOCK")
public class Stock {

    @Id
    @GeneratedValue
    @Column(name = "MI_ID")
    private Long id;

    @Column(name = "MI_STOCK_NAME")
    private String stockName;

    @Column(name = "MI_PRICE")
    private String price;

    @Column(name = "MI_OWNER")
    private String owner;

    @Transient
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", stockName='" + stockName + '\'' +
                ", price='" + price + '\'' +
                ", owner='" + owner + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
