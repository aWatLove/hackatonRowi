package ru.chaikhana.service.product;

import lombok.Data;
import org.springframework.stereotype.Service;
import ru.chaikhana.model.Product;
import ru.chaikhana.repository.ProductRepository;

import java.util.List;

@Service
@Data
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> getProductByCategory(String category) {
        return productRepository.findAllProductByCategory(category);
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }
}
