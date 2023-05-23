package ru.chaikhana.service.product;

import ru.chaikhana.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProduct();
    Product getProductById(String id);
    List<Product> getProductByCategory(String category);
    Product addProduct(Product product);
    void deleteProduct(Product product);
    Product updateProduct(Product product);
}
