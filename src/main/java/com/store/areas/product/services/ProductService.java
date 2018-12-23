package com.store.areas.product.services;

import com.store.areas.product.models.service.ProductServiceModel;

import java.util.Set;

public interface ProductService {
    void create(ProductServiceModel productServiceModel);

    Set<ProductServiceModel> findAll();

    ProductServiceModel findByName(String name);

    ProductServiceModel findById(String id);

    Set<ProductServiceModel> findAllContainingName(String name);
}
