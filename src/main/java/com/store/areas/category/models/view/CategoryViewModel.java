package com.store.areas.category.models.view;

import com.store.areas.product.models.view.ProductViewModel;

import java.util.Set;

public class CategoryViewModel {

    private String id;

    private String name;

    private String description;

    private Set<ProductViewModel> products;

    public CategoryViewModel() {
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<ProductViewModel> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductViewModel> products) {
        this.products = products;
    }
}