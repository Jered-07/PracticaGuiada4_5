package com.example.demo.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.ProductRequestDto;
import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;

@Service
public class ProductServices implements IProductServices {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public Product addProduct(ProductRequestDto productRequestDto) {
        Product product =  Product.builder()
            .name(productRequestDto.getName())
            .description(productRequestDto.getDescription())
            .price(productRequestDto.getPrice())
            .resourceId(UUID.randomUUID())
            .build();

        return productRepository.addProduct(product);
    }

    @Override
    public Product updateProduct(UUID resourceId, ProductRequestDto productDto) {
        var product = productRepository.findByResourceId(resourceId).orElseThrow(() -> new RuntimeException("Objeto no encontrado"));
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        return productRepository.updateProduct(product);
    }

    @Override
    public Product getByResourceId(UUID resourceId) {
        return productRepository.getByResourceID(resourceId);
    }

    

    
    
}
