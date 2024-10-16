package vn.hoidanit.laptopshop.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.service.ProductService;
import vn.hoidanit.laptopshop.service.UploadService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ProductController {

    private final UploadService uploadService;
    private final ProductService productService;

    public ProductController(UploadService uploadService, ProductService productService) {
        this.uploadService = uploadService;
        this.productService = productService;
    }

    @GetMapping("/admin/product")
    public String getProduct(Model model) {
        List<Product> prd = this.productService.fetchProduct();
        model.addAttribute("products", prd);
        return "admin/product/show";
    }

    @GetMapping("/admin/product/create")
    public String getNewProduct(Model model) {
        model.addAttribute("newProduct", new Product());
        // đầu tiên phải khởi tạo đối tượng cho view, rồi sau đó view lấy đối tượng ấy
        // lắp vô những thông tin của giao diện rồi trar về post

        return "admin/product/create";
    }

    @PostMapping("/admin/product/create")
    public String handleCreateProduct(Model model, @ModelAttribute("newProduct") @Valid Product product,
            // phải có @Valid mới bắt được lỗi không sẽ nhảy vô whiteboard
            BindingResult newProductBindingResult,
            @RequestParam("proFile") MultipartFile file) {

        if (newProductBindingResult.hasErrors()) {
            List<FieldError> errors = newProductBindingResult.getFieldErrors();
            for (FieldError error : errors) {
                // khi .getField() thì sẽ hiển thị những trường gặp lỗi
                System.out.println(error.getField() + "-" + error.getDefaultMessage());
            }
            System.out.println("Lỗi rooifdfsgdfgdfghfghnfg");
            return "/admin/product/create";
        }
        String avatar = this.uploadService.handleUploadFile(file, "product");
        product.setImage(avatar);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Check:" + product);
        this.productService.createProduct(product);
        System.out.println("hahahahahahahhaksjhdkjahkjshdjkhajksh");
        return "redirect:/admin/product";
        // return "/admin/product";
    }
    // khi validate, validate ở đâu?
    // 1/ validate ở client , required(HTML, JS) nhanh, dữ liệu rác thì xử lý tiện
    // nhưng hack vẫn hack đc
    // 2/ validate ở be => bảo mật, hay sd trong các ngân hàng , bắt buộc validate ở
    // be

    @GetMapping("/admin/product/update/{id}")
    public String getUpdateProduct(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        model.addAttribute("newProduct", this.productService.handleProductById(id));
        return "admin/product/update";
    }

    @PostMapping("/admin/product/update")
    public String postUpdateProduct(Model model, @ModelAttribute("newProduct") @Valid Product product,
            BindingResult bindingUpdateProductResult, @RequestParam("proFile") MultipartFile file) {
        if (bindingUpdateProductResult.hasErrors()) {
            List<FieldError> errors = bindingUpdateProductResult.getFieldErrors();
            for (FieldError error : errors) {
                // khi .getField() thì sẽ hiển thị những trường gặp lỗi
                System.out.println(error.getField() + "-" + error.getDefaultMessage());
            }
            System.out.println("Lỗi rooifdfsgdfgdfghfghnfg");
            return "/admin/product/update";
        } else {
            Product currentProduct = this.productService.handleProductById(product.getId());
            System.out.println(product.getId());
            System.out.println(currentProduct);
            if (currentProduct == null) {
                this.productService.handleSaveProduct(product);
            } else {
                if (!file.isEmpty()) {
                    String avatar = this.uploadService.handleUploadFile(file, "product");
                    currentProduct.setImage(avatar);
                    System.out.println(avatar);
                }

                currentProduct.setName(product.getName());
                currentProduct.setPrice(product.getPrice());
                currentProduct.setDetaiDesc(product.getDetaiDesc());
                currentProduct.setShortDesc(product.getShortDesc());
                currentProduct.setQuantity(product.getQuantity());
                currentProduct.setFactory(product.getFactory());
                currentProduct.setTarget(product.getTarget());

                this.productService.handleSaveProduct(currentProduct);
            }
            return "redirect:/admin/product";
        }
    }

    @GetMapping("/admin/product/delete/{id}")
    public String getDeleteProduct(Model model, @PathVariable long id) {
        model.addAttribute("newProduct", new Product());
        model.addAttribute("id", id);
        return "/admin/product/delete";
    }

    @PostMapping("/admin/product/delete")
    public String postDeleteProduct(Model model, @ModelAttribute("newProduct") Product product) {
        this.productService.handleDelProductById(product.getId());
        return "redirect:/admin/product";
    }

    @GetMapping("/admin/product/{id}")
    public String getMethodName(Model model, @PathVariable long id) {
        model.addAttribute("product", this.productService.handleProductById(id));
        return "admin/product/detail";
    }

}
