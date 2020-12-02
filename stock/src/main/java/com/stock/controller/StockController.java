package com.stock.controller;

import com.stock.core.IStockProcessor;
import com.stock.types.GetAllStockResponse;
import com.stock.types.GetStockResponse;
import com.stock.types.StockRequest;
import com.stock.types.StockResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private IStockProcessor stockProcessor;

    @PostMapping(value = "/create", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public StockResponse createStock(@RequestBody StockRequest request) {
        return stockProcessor.createStock(request);

    }

    @GetMapping(value = "/get/{name}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public GetStockResponse getStock(@PathVariable("name") String name) {
        return stockProcessor.getStockByName(name);

    }

    @GetMapping(value = "/all", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public GetAllStockResponse getAllStock() {
        return stockProcessor.getAllStock();

    }
}
