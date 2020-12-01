package com.stock.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IStockRepository extends JpaRepository<Stock, Long> {

    Stock getByStockName(String name);
}
