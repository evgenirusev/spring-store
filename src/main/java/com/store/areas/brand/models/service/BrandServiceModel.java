package com.store.areas.brand.models.service;

import com.store.areas.product.models.service.ProductServiceModel;

import java.util.Set;

public class BrandServiceModel {
    private String id;

    private String name;

    private Set<ProductServiceModel> products;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ProductServiceModel> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductServiceModel> products) {
        this.products = products;
    }
}
