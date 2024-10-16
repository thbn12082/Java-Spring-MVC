package vn.hoidanit.laptopshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final UploadService uploadService;

    public ProductService(ProductRepository productRepository, UploadService uploadService) {
        this.productRepository = productRepository;
        this.uploadService = uploadService;
    }

    public void createProduct(Product product) {
        this.productRepository.save(product);
    }

    public List<Product> fetchProduct() {
        return this.productRepository.findAll();
    }

    public void handleDelProductById(long id) {
        this.productRepository.deleteById(id);
    }

    public Product handleProductById(long id) {
        return this.productRepository.findById(id);
    }

    public void handleSaveProduct(Product product) {
        this.productRepository.save(product);
    }
}
