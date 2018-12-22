package com.store.areas.brand.models.view;

import com.store.areas.product.models.service.ProductServiceModel;

import java.util.Set;

public class BrandViewModel {
    private String name;

    private Set<ProductServiceModel> products;

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
