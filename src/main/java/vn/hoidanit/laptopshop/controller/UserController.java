package vn.hoidanit.laptopshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import vn.hoidanit.laptopshop.domain.User;
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

    @RequestMapping("/admin/user")
    public String getUserPage(Model model) {

        model.addAttribute("newUser", new User());

        return "admin/user/create";
    }

    @RequestMapping(value = "/admin/user/create1", method = RequestMethod.POST)
    public String createUserPage(Model model, @ModelAttribute("newUser") User thebinh3) {
        System.out.println("run here: " + thebinh3);
        return "hello";
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        String test = this.userService.handleHello();
        model.addAttribute("thebinh", test);
        model.addAttribute("thebinh2", "đây là nguyễn thế bình");
        return "hello";
    }

}
