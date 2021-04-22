package com.shine.controller;

import com.shine.model.vo.Result;
import com.shine.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaleController {
    @Autowired
    private SaleService saleService;

    @GetMapping("/sale")
    Result getPage(@RequestParam int page,@RequestParam int limit){
        return saleService.getPage(page,limit);
    }

    @GetMapping("/sortAna")
    Result anaBySort(@RequestParam byte id, @RequestParam String startTime,@RequestParam String endTime){

            return saleService.anaBySort(id,startTime,endTime);


    }
    @GetMapping("/regionAna")
    Result regionAna(@RequestParam byte id, @RequestParam String startTime,@RequestParam String endTime){
        return saleService.anaByRegion(id,startTime,endTime);
    }

}
