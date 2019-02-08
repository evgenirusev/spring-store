package com.store.areas.product.models.binding;

import com.store.constants.Constants;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class CreateProductBindingModel {
    @Size(min = 1, max = 50, message = Constants.PRODUCT_NAME_LENGTH)
    private String name;

    private String description;

    @NotNull
    private String brand;

    private String[] categories;

    @NotNull
    private BigDecimal price;

    public CreateProductBindingModel() {
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
