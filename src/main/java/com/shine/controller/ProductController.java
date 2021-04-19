package com.shine.controller;

import com.shine.model.Product;
import com.shine.model.vo.AddProdVO;
import com.shine.model.vo.DelProdVO;
import com.shine.service.ProductService;
import com.shine.model.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequestMapping("/product")
@RestController
public class ProductController {
    @Autowired
    ProductService service;

    @PostMapping
    Result add(@RequestParam String name, @RequestParam int price,
               @RequestParam byte sortId, @RequestParam String describe,
               @RequestParam MultipartFile file) throws IOException {
        Product product = new Product();
        product.withName(name).withPrice(price).withSortId(sortId).withDescribes(describe);
        return service.add(product, file);
    }

    @GetMapping
    Result getPage(@RequestParam int page, @RequestParam int limit) {
        return service.getPage(page, limit);
    }

    @DeleteMapping
    Result delete(@RequestParam int pid, @RequestParam String path) {
        return service.delete(pid, path);
    }

    @PutMapping
    Result update(@RequestParam int pid,
                  @RequestParam String name, @RequestParam int price,
                  @RequestParam byte sortId, @RequestParam String describe,
                  @RequestParam(required = false) MultipartFile file) throws IOException {
        Product product = new Product();
        product.withPid(pid).withName(name).withPrice(price).withSortId(sortId).withDescribes(describe);
        return service.update(product, file);
    }

    @PatchMapping
    Result switchOnSale(@RequestParam int pid, @RequestParam Boolean onSale) {
        return service.switchOnSale(pid, onSale);
    }

    @DeleteMapping("/list")
    Result deleteList(@RequestBody DelProdVO vo) {

        return service.deleteList(vo);
    }
}
