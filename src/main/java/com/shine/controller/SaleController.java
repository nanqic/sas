package com.shine.controller;

import com.shine.model.vo.Result;
import com.shine.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/sale")
@RestController
public class SaleController {
    @Autowired
    private SaleService saleService;

    @GetMapping
    Result getPage(@RequestParam int page,@RequestParam int limit){
        return saleService.getPage(page,limit);
    }

    @GetMapping("/ana")
    Result anaBySort(@RequestParam byte id, @RequestParam(required = true) String startTime,@RequestParam(required = true) String endTime){
        if(id>3){
             Integer sid = (id&0XFF)/10;
             id = (byte)(sid&0XFF);
            return saleService.anaBySort(id,startTime,endTime);
        }else {
            return saleService.anaByRegion(id,startTime,endTime);
        }
    }

}
