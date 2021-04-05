package com.shine.controller;

import com.shine.vo.CodeMsg;
import com.shine.vo.LoginVO;
import com.shine.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@RestController
public class LoginController {
    @Autowired
    private HttpSession session;
    @Value("${admin.user}")
    private String user;
    @Value("${admin.pass}")
    private String pass;

    @PostMapping("/login")
    Result doLogin(@RequestBody LoginVO vo) {
        if (vo.getUsername().equals(user) && vo.getPassword().equals(pass)) {
            session.setAttribute("user", vo.getUsername());
            System.out.println(session.getAttribute("user"));
            return Result.ok();
        }

        return Result.error(CodeMsg.REQUEST_ERROR);

    }

    @GetMapping("/logout")
    void doLogout() {
        session.removeAttribute("user");
    }
}
