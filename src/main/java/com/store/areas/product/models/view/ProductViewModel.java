package com.store.areas.product.models.view;

import com.store.areas.category.models.view.CategoryViewModel;

import java.math.BigDecimal;
import java.util.Set;

public class ProductViewModel {
    private String name;

    private BigDecimal price;

    private Set<CategoryViewModel> category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<CategoryViewModel> getCategory() {
        return category;
    }

    public void setCategory(Set<CategoryViewModel> category) {
        this.category = category;
    }
}