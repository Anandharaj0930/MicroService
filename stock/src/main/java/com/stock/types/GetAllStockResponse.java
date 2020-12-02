package com.stock.types;

import java.util.List;

public class GetAllStockResponse {

    private List<GetStockResponse> stockList;

    private Status staus;

    public List<GetStockResponse> getStockList() {
        return stockList;
    }

    public void setStockList(List<GetStockResponse> stockList) {
        this.stockList = stockList;
    }

    public Status getStaus() {
        return staus;
    }

    public void setStaus(Status staus) {
        this.staus = staus;
    }

    @Override
    public String toString() {
        return "GetAllStockResponse{" +
                "stockList=" + stockList +
                ", staus=" + staus +
                '}';
    }
}
