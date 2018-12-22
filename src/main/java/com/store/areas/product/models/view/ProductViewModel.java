package com.store.areas.product.models.view;

import com.store.areas.brand.models.view.BrandViewModel;
import com.store.areas.category.models.view.CategoryNamesViewModel;

import java.math.BigDecimal;
import java.util.Set;

public class ProductViewModel {
    private String name;

    private String description;

    private BigDecimal price;

    private BrandViewModel brand;

    private Set<CategoryNamesViewModel> categories;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BrandViewModel getBrand() {
        return brand;
    }

    public void setBrand(BrandViewModel brand) {
        this.brand = brand;
    }

    public Set<CategoryNamesViewModel> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryNamesViewModel> categories) {
        this.categories = categories;
    }
}