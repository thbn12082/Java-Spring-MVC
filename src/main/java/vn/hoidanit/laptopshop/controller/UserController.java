package vn.hoidanit.laptopshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import vn.hoidanit.laptopshop.service.UserService;

@RestController
public class UserController {
    // làm sao để truy cập method này??? đóa là lí do cần GetMapping

    private UserService userService;

    @GetMapping("/")
    public String getHomePage() {
        return "hello from controller";
    }

}
