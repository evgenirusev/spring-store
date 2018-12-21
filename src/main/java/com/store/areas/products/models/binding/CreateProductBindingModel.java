package com.store.areas.products.models.binding;

import java.math.BigDecimal;

public class CreateProductBindingModel {
    private String name;

    private String category;

    private BigDecimal price;

    public CreateProductBindingModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
