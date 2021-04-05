package com.shine.controller;

import com.shine.model.User;
import com.shine.service.UserService;
import com.shine.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping
    Result getList(@RequestParam int page, @RequestParam int limit) {
        return service.getPage(page, limit);
    }

    @PostMapping
    Result addUser(@RequestBody User user) {
        return service.add(user);
    }

    @PatchMapping
    Result update(@RequestBody User user) {
        return service.update(user);
    }

    @DeleteMapping
    Result delete(@RequestParam int id) {
        return service.updateById(id);
    }
    @DeleteMapping("/list")
    Result deleteByIds(@RequestParam List<Integer> ids){
        return service.updateByIds(ids);
    }

}
