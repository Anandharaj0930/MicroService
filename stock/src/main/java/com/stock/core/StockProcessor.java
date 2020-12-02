package com.stock.core;

import com.stock.entity.IStockRepository;
import com.stock.entity.Stock;
import com.stock.exception.StockCreateException;
import com.stock.exception.StockGetException;
import com.stock.types.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockProcessor implements IStockProcessor {

    @Autowired
    private IStockRepository stockRepository;

    @Override
    public StockResponse createStock(StockRequest request) {
        StockResponse response = new StockResponse();
        try {
            Stock stock = buildStockEntity(request);
            stockRepository.save(stock);
            response.setStatusCode(HttpStatus.OK.value());
            response.setDescription(HttpStatus.OK.getReasonPhrase());
        } catch (Exception e) {
            throw new StockCreateException();
        }


        return response;
    }

    @Override
    public GetStockResponse getStockByName(String name) {
        GetStockResponse response = new GetStockResponse();
        Status status = buildSuccessStatus();
        try {
            Stock stock = stockRepository.getByStockName(name);
            response.setOwner(stock.getOwner());
            response.setPrice(stock.getPrice());
            response.setStockName(stock.getStockName());
            response.setType(stock.getType());
            response.setStatus(status);
        } catch (Exception e) {
            throw new StockGetException();
        }
        return response;
    }

    @Override
    public GetAllStockResponse getAllStock() {
        GetAllStockResponse response = null;
        List<GetStockResponse> responseList = new ArrayList<>();
        try {
            List<Stock> stockList = stockRepository.findAll();
            stockList.stream().forEach(stock -> {
                GetStockResponse res = new GetStockResponse();
                res.setOwner(stock.getOwner());
                res.setPrice(stock.getPrice());
                res.setStockName(stock.getStockName());
                res.setType(stock.getType());
                responseList.add(res);
            });
        } catch (Exception e) {
            throw new StockGetException();
        }
        Status status = buildSuccessStatus();
        response.setStockList(responseList);
        response.setStaus(status);
        return response;
    }

    private Stock buildStockEntity(StockRequest request) {
        Stock entity = new Stock();
        entity.setOwner(request.getOwner());
        entity.setPrice(request.getPrice());
        entity.setStockName(request.getStockName());
        entity.setType(request.getType());
        return entity;
    }

    Status buildSuccessStatus() {
        Status status = new Status();
        status.setStatusCode(String.valueOf(HttpStatus.OK.value()));
        status.setStatusMsg(HttpStatus.OK.getReasonPhrase());
        return status;
    }


}
