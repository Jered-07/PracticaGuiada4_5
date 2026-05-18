package com.example.demo.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dtos.ProductDto;
import com.example.demo.dtos.ProductRequestDto;
import com.example.demo.mappers.ProductMapper;
import com.example.demo.services.IProductServices;

import jakarta.transaction.Transactional;

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


    @Override
        @Transactional //Es una anotacion que hace un "Todo o nada", es decir que si encuentra un error detiene el proceso y hace un rollback
    public ProductDto addProduct(ProductRequestDto productRequestDto) {
        var entity = productServices.addProduct(productRequestDto);
        return productMapper.toProductDto(entity);
    }
    
}
