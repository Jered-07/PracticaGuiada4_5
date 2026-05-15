package com.example.demo.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dtos.ProductDto;
import com.example.demo.mappers.ProductMapper;
import com.example.demo.services.IProductServices;

@Component
public class ProductFacade implements IProductFacade {

    @Autowired
    private IProductServices productServices;
    @Autowired
    private ProductMapper productMapper;


    @Override
    public List<ProductDto> getAll() {
        return productMapper.toProductDtoList(productServices.getAll());
    }
    
}
