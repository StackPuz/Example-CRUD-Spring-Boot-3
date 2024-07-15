package com.stackpuz.example.service;

import com.stackpuz.example.entity.Product;
import com.stackpuz.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product getProductById(int id) {
        return repository.findById(id).get();
    }

    public Product updateProduct(int id, Product product) {
        Product existing = repository.findById(id).get();
        existing.setName(product.getName());
        existing.setPrice(product.getPrice());
        return repository.save(existing);
    }

    public void deleteProduct(int id) {
        repository.deleteById(id);
    }
}
