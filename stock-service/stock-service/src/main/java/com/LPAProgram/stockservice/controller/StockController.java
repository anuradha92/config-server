package com.LPAProgram.stockservice.controller;

import com.LPAProgram.stockservice.VO.ResponseTemplateVO;
import com.LPAProgram.stockservice.entity.Stock;
import com.LPAProgram.stockservice.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stocks")
@Slf4j
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping("/")
    public Stock saveStock(@RequestBody Stock stock) {
        log.info("Inside saveStock of StockController");
        return stockService.saveStock(stock);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getMedicineStockWithUser(@PathVariable("id") Long medicineId) {
        log.info("Inside getMedicineStockWithUser of StockController");
        return stockService.getMedicineStockWithUser(medicineId);
    }


}
