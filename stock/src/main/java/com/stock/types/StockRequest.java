package com.stock.types;


public class StockRequest {

    private String stockName;

    private String price;

    private String owner;

    private String type;
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
        return "StockRequest{" +
                "stockName='" + stockName + '\'' +
                ", price='" + price + '\'' +
                ", owner='" + owner + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
