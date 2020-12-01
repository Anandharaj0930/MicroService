package com.stock.core;

import com.stock.entity.IStockRepository;
import com.stock.entity.Stock;
import com.stock.exception.StockCreateException;
import com.stock.exception.StockGetException;
import com.stock.types.GetStockResponse;
import com.stock.types.StockRequest;
import com.stock.types.StockResponse;
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
        try {
           Stock stock = stockRepository.getByStockName(name);
            response.setOwner(stock.getOwner());
            response.setPrice(stock.getPrice());
            response.setStockName(stock.getStockName());
            response.setType(stock.getType());
            response.setStatusCode(String.valueOf(HttpStatus.OK.value()));
            response.setStatusMsg(HttpStatus.OK.getReasonPhrase());
        } catch (Exception e) {
            throw new StockGetException();
        }
        return response;
    }

    @Override
    public List<GetStockResponse> getAllStock() {
        List<GetStockResponse> responseList = new ArrayList<>();
        try {
           List<Stock>  stockList = stockRepository.findAll();
            stockList.stream().forEach(stock -> {
                GetStockResponse response = new GetStockResponse();
                response.setOwner(stock.getOwner());
                response.setPrice(stock.getPrice());
                response.setStockName(stock.getStockName());
                response.setType(stock.getType());

            });
        } catch (Exception e) {
            throw new StockGetException();
        }
        return response;
    }

    private Stock buildStockEntity(StockRequest request) {
        Stock entity = new Stock();
        entity.setOwner(request.getOwner());
        entity.setPrice(request.getPrice());
        entity.setStockName(request.getStockName());
        return entity;
    }


}
