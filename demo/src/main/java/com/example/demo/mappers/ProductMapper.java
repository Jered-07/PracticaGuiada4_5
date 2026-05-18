package com.example.demo.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.dtos.ProductDto;
import com.example.demo.dtos.ProductRequestDto;
import com.example.demo.entities.Product;
import com.example.demo.models.ProductRequestModel;
import com.example.demo.models.ProductResponceModel;

@Component
public class ProductMapper {
    public ProductDto toProductDto(Product product){
        if (product == null) {
            return null;
        }

        return new ProductDto(product.getName(), product.getDescription(), product.getPrice(), product.getResourceId());
    }

    public List<ProductDto> toProductDtoList(List<Product> products){
            if (products == null) {
                return null;
            }

            return products.stream()
                .map(this::toProductDto)
                .collect(Collectors.toList());
    }


    public ProductResponceModel toProductResponceModel(ProductDto productDto){
        if (productDto == null) {
            return null;
        }

        return new ProductResponceModel(productDto.name(), productDto.description(), productDto.price(), productDto.resource_id());
    }

    public List<ProductResponceModel> tProductResponceModelList(List<ProductDto> productDtos){
        if (productDtos == null) {
            return null;
        }

        return productDtos.stream()
            .map(this::toProductResponceModel)
            .collect(Collectors.toList());
    }


    public ProductRequestDto toProductRequestDto(ProductRequestModel product){
        if (product == null) {
            return null;
        }

        ProductRequestDto productDto = new ProductRequestDto();
        productDto.setName(product.name());
        productDto.setDescription(product.description());
        productDto.setPrice(product.price());
        return productDto;
    }
}

