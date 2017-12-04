package com.realdolmen.thomasmore.service;

import com.realdolmen.thomasmore.domain.Product;
import com.realdolmen.thomasmore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void createProduct(String name, int price, String description, int stock, Long categoryId) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);
        product.setStock(stock);
        product.setCategoryId(categoryId);

        productRepository.save(product);
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public void deleteProduct(Long id) {
        productRepository.delete(id);

    }

    public Product getProductById(Long id) {
        return productRepository.findProductById(id);
    }

    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    public List<Product> findAllProductsOrderByNameAsc() {
        return productRepository.findAllByOrderByNameAsc();
    }


    //public List<Product> findAllProductsOrderByNameDesc() {
    //    return productRepository.findAllByNameOrderByNameDesc();
    //}
}
