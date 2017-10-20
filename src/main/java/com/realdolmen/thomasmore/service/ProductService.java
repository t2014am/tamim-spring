package com.realdolmen.thomasmore.service;

import com.realdolmen.thomasmore.domain.Product;
import com.realdolmen.thomasmore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void createProduct(String name, int price, String description, int stock) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);
        product.setStock(stock);

        productRepository.save(product);
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }
}
