package vn.hoidanit.laptopshop.controller;

import java.util.List;

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
import vn.hoidanit.laptopshop.repository.UserRepository;
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
// đây là tầng xử lý yêu cầu web
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/admin/user/create") // get
    public String getUserPage(Model model) {

        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }
    // để hiển thị ra view bắt buộc phải dùng list để hứng chứ không return luôn đc
    // tại sao mà khi cả 2 request đều có url thế kia, tại sao không lỗi? vì khi kh
    // khai báo thì amwcj định là get => chúng khác nhau

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createUserPage(Model model, @ModelAttribute("newUser") User thebinh3) {
        System.out.println("run here: " + thebinh3);
        this.userService.handleSaveUser(thebinh3);
        return "redirect:/admin/user";
    }

    @RequestMapping("/admin/user")
    public String tableUser(Model model) {
        List<User> users = this.userService.handleGetAllUser();
        model.addAttribute("users1", users);
        // System.out.println(">>>>>>check User <<<<<<<<: " + users);
        return "admin/user/tableUser";
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        String test = this.userService.handleHello();
        // List<User> arrUsers = this.userService.handleGetAllUser();
        List<User> arrUsers2 = this.userService.handleGetAllUserByNameAndEmail("", "1@gmail.com");
        model.addAttribute("thebinh", test);
        model.addAttribute("thebinh2", "đây là nguyễn thế bình");
        return "hello";
    }

}
