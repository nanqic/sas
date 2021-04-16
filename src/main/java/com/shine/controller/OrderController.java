package com.shine.controller;

import com.shine.model.Order;
import com.shine.model.vo.Result;
import com.shine.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/order")
@RestController
public class OrderController {
    @Autowired
    private OrderService service;

    @GetMapping
    Result all(@RequestParam int page,@RequestParam int limit){
        return service.getPage(page,limit);
    }
    @PostMapping
    Result add(@RequestBody Order order){
        return service.add(order);
    }

}
