package com.store.areas.product.models.service;

import com.store.areas.category.models.service.CategoryServiceModel;
import com.store.areas.user.models.service.UserServiceModel;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductServiceModel {
    private String id;

    private String name;

    private String description;

    private BigDecimal price;

    private LocalDateTime createdAt;

    private CategoryServiceModel category;

    private UserServiceModel user;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public CategoryServiceModel getCategory() {
        return category;
    }

    public void setCategory(CategoryServiceModel category) {
        this.category = category;
    }

    public UserServiceModel getUser() {
        return user;
    }

    public void setUser(UserServiceModel user) {
        this.user = user;
    }
}