package com.shine.controller;

import com.shine.model.vo.AddStockVO;
import com.shine.model.vo.Result;
import com.shine.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/stock")
@RestController
public class StockController {
    @Autowired
    private StockService stockService;

    @GetMapping
    Result list(@RequestParam int page, @RequestParam int limit){

        return stockService.getPage(page, limit);
    }

    @PostMapping
    Result add(@RequestBody AddStockVO vo){
        return stockService.add(vo.getPid(),vo.getAmount(),vo.getRid());
    }

    @PatchMapping
    Result update(@RequestParam int id, @RequestParam int amount){

        return stockService.update(id,amount);
    }

    @GetMapping("/amount")
    Result getAmount(@RequestParam int pid){
        return stockService.getAmount(pid);
    }
}
