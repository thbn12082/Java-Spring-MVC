package vn.hoidanit.laptopshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import vn.hoidanit.laptopshop.service.UserService;

// @RestController
// public class UserController {
//     // làm sao để truy cập method này??? đóa là lí do cần GetMapping
//     // @Autowired
//     private UserService userService;

//      public UserController(UserService userService) {
//         this.userService = userService;
//      }

//     @GetMapping("/")
//     public String getHomePage() {
//         return this.userService.handleHello();
//     }

// }

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        String test = this.userService.handleHello();
        model.addAttribute("thebinh", test);
        model.addAttribute("thebinh2", "đây là nguyễn thế bình");
        return "hello";
    }
}
