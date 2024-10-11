package vn.hoidanit.laptopshop.controller;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.service.RoleService;
import vn.hoidanit.laptopshop.service.UploadService;
import vn.hoidanit.laptopshop.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
// đây là tầng xử lý yêu cầu web
public class UserController {
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final UploadService uploadService;
    private final RoleService roleService;

    public UserController(UserService userService, UploadService uploadService, PasswordEncoder passwordEncoder,
            RoleService roleService) {
        this.userService = userService;
        this.uploadService = uploadService;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    @GetMapping("/admin/user/create")
    public String getUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }
    // để hiển thị ra view bắt buộc phải dùng list để hứng chứ không return luôn đc
    // tại sao mà khi cả 2 request đều có url thế kia, tại sao không lỗi? vì khi kh
    // khai báo thì amwcj định là get => chúng khác nhau

    @PostMapping("/admin/user/create")
    public String createUserPage(Model model, @ModelAttribute("newUser") @Valid User thebinh3,
            BindingResult bindingResult,
            @RequestParam("thebinhFile") MultipartFile file) {
        // bắt vô User đây
        if (bindingResult.hasErrors()) {

            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                System.out.println(error.getObjectName() + "-" + error.getDefaultMessage());
            }

            return "/admin/user/create";
        } else {
            String hashPassword = this.passwordEncoder.encode(thebinh3.getPassword());

            String avatar = this.uploadService.handleUploadFile(file, "avatar");

            thebinh3.setPassword(hashPassword);
            thebinh3.setAvatar(avatar);
            thebinh3.setRole(this.userService.getRoleByName(thebinh3.getRole().getName()));
            this.userService.handleSaveUser(thebinh3);
            return "redirect:/admin/user";
        }

    }

    @GetMapping("/admin/user")
    public String tableUser(Model model) {
        List<User> users = this.userService.handleGetAllUser();
        model.addAttribute("users1", users);
        // System.out.println(">>>>>>check User <<<<<<<<: " + users);
        return "admin/user/show";
    }

    // @GetMapping("/")
    // public String getHomePage(Model model) {
    // String test = this.userService.handleHello();
    // // List<User> arrUsers = this.userService.handleGetAllUser();
    // List<User> arrUsers2 = this.userService.handleGetAllUserByNameAndEmail("",
    // "1@gmail.com");
    // model.addAttribute("thebinh", test);
    // model.addAttribute("thebinh2", "đây là nguyễn thế bình");
    // return "hello";
    // }

    @GetMapping("/admin/user/{id}")
    public String getUserDetailPage(Model model, @PathVariable Long id) {
        // model.addAttribute("newUser", new User());
        User user = this.userService.handleUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("id", id);
        System.out.println(">>>>>>>>>>>>>>>>>check path o day <<<<<<<<<<<<<<<" + id);
        return "admin/user/detail";
    }

    @GetMapping("/admin/user/update/{id}")
    public String updateUserPage(Model model, @PathVariable Long id) {
        model.addAttribute("id", id);
        User currentUser = this.userService.handleUserById(id);
        model.addAttribute("newUser", currentUser);
        return "admin/user/update";
    }

    @PostMapping("/admin/user/update")
    public String create(Model model, @ModelAttribute("newUser") User user) {
        User currentUser = this.userService.handleUserById(user.getId());
        if (currentUser != null) {
            currentUser.setAddress(user.getAddress());
            // currentUser.setEmail(user.getEmail());
            currentUser.setFullname(user.getFullname());
            currentUser.setPhone(user.getPhone());
            this.userService.handleSaveUser(currentUser);
        } else {
            this.userService.handleSaveUser(user);
        }
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/delete/{id}")
    public String delUser(Model model, @PathVariable Long id) {
        model.addAttribute("id", id);
        model.addAttribute("newUser", new User());
        return "/admin/user/delete";
    }

    @PostMapping("/admin/user/delete")
    public String del(Model model, @ModelAttribute("newUser") User user) {
        this.userService.handleDelUserById(user.getId());
        return "redirect:/admin/user";
    }

}
