package com.store.areas.brand.models.service;

import com.store.areas.product.models.service.ProductServiceModel;

import java.util.Set;

public class BrandServiceModel {
    private String id;

    private String name;

    private Set<ProductServiceModel> products;
}
