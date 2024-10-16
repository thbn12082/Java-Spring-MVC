package vn.hoidanit.laptopshop.controller.client;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.domain.dto.RegisterDTO;
import vn.hoidanit.laptopshop.service.ProductService;
import vn.hoidanit.laptopshop.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class HomePageController {
    private final UserService userService;
    private final ProductService productService;
    private final PasswordEncoder passwordEncoder;

    public HomePageController(PasswordEncoder passwordEncoder, ProductService productService, UserService userService) {
        this.productService = productService;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/")
    public String getHomePage(Model model) {
        List<Product> prs = this.productService.fetchProduct();
        model.addAttribute("listProduct", prs);
        return "client/homepage/show";
    }

    @GetMapping("/register")
    public String getMethodName(Model model) {
        model.addAttribute("registerUser", new RegisterDTO());
        return "client/auth/register";
    }

    @PostMapping("/register")
    public String postMethodName(@ModelAttribute("registerUser") RegisterDTO registerDTO) {

        User user = this.userService.registerDTOtoUser(registerDTO);
        User check = this.userService.handleUserByEmail(user.getEmail());
        if (check == null) {
            String hashPassword = this.passwordEncoder.encode(user.getPassword());
            user.setPassword(hashPassword);
            user.setRole(this.userService.getRoleByName("USER"));
            System.out.println(this.userService.getRoleByName("USER"));
            this.userService.handleSaveUser(user);
            System.out.println("jhsdfggsjkhgfhjk");
            System.out.println(user);

            return "redirect:/login";
        } else {
            return null;
        }

    }

    @GetMapping("/login")
    public String getLogin(Model model) {

        return "client/auth/login";
    }

}
