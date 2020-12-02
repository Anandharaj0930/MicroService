package com.stock.core;

import com.stock.types.GetAllStockResponse;
import com.stock.types.GetStockResponse;
import com.stock.types.StockRequest;
import com.stock.types.StockResponse;

import java.util.List;

public interface IStockProcessor {

    StockResponse createStock(StockRequest request);

    GetStockResponse getStockByName(String name);

    GetAllStockResponse getAllStock();
}
