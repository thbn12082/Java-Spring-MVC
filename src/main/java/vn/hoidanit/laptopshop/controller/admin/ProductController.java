package vn.hoidanit.laptopshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.service.UploadService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ProductController {

    private final UploadService uploadService;

    public ProductController(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    @GetMapping("/admin/product")
    public String getProduct() {
        return "/admin/product/show";
    }

    @GetMapping("/admin/product/create")
    public String getNewProduct(Model model) {
        model.addAttribute("newProduct", new Product());
        // đầu tiên phải khởi tạo đối tượng cho view, rồi sau đó view lấy đối tượng ấy
        // lắp vô những thông tin của giao diện rồi trar về post

        return "admin/product/create";
    }

    @PostMapping("/admin/product/create")
    public String postNewProduct(Model model, @ModelAttribute("newProduct") Product product,
            @RequestParam("proFile") MultipartFile file) {

        String avatar = this.uploadService.handleUploadFile(file, "avatar");
        return "redirect:/admin/product";
    }
    // khi validate, validate ở đâu?
    // 1/ validate ở client , required(HTML, JS) nhanh, dữ liệu rác thì xử lý tiện
    // nhưng hack vẫn hack đc
    // 2/ validate ở be => bảo mật, hay sd trong các ngân hàng , bắt buộc validate ở
    // be

}
