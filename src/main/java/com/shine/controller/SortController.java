package com.shine.controller;

import com.shine.model.Sort;
import com.shine.model.vo.Result;
import com.shine.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/sort")
@RestController
public class SortController {
    @Autowired
    SortService service;
    @PostMapping
    Result add(@RequestParam String name){
        return service.add(name);
    }
    @GetMapping
    Result findAll(@RequestParam int page, @RequestParam int limit){
        return service.findAll(page,limit);
    }
    @PutMapping
    Result updateOne(@RequestBody Sort sort){return service.updateOne(sort);}

    @DeleteMapping
    Result deleteOne(@RequestParam byte sid){return service.deleteOne(sid);}
}
