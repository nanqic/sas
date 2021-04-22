package com.shine.controller;

import com.shine.model.Region;
import com.shine.model.Sort;
import com.shine.model.vo.Result;
import com.shine.service.RegionService;
import com.shine.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/region")
@RestController
public class RegionController {
    @Autowired
    RegionService service;
    @PostMapping
    Result add(@RequestParam String name){
        return service.add(name);
    }
    @GetMapping
    Result findAll(@RequestParam int page, @RequestParam int limit){
        return service.findAll(page,limit);
    }
    @PutMapping
    Result updateOne(@RequestBody Region region){return service.updateOne(region);}
    @DeleteMapping
    Result deleteOne(@RequestParam byte rid){return service.deleteOne(rid);}
}
