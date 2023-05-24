package ru.chaikhana.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.chaikhana.model.Product;
import ru.chaikhana.model.User;
import ru.chaikhana.service.product.ProductService;

@AllArgsConstructor
@RestController
@RequestMapping("/api/product")
public class ProductController {
    ProductService productService;

    @GetMapping("/")
    public ResponseEntity<?> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @PutMapping("/")
    public ResponseEntity<?> updateUser(@RequestBody Product product) {
        return ResponseEntity.ok(productService.updateProduct(product));
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteUser(@RequestBody Product product) {
        productService.deleteProduct(product);
        return ResponseEntity.ok("deleted");
    }
}
