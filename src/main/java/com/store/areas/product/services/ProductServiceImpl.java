package com.store.areas.product.services;

import com.store.areas.product.entities.Product;
import com.store.areas.product.models.service.ProductServiceModel;
import com.store.areas.product.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void create(ProductServiceModel productServiceModel) {
        Product productEntity = this.modelMapper.map(productServiceModel, Product.class);
        this.productRepository.save(productEntity);
    }
}