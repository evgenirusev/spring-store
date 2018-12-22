package com.store.areas.product.models.service;

import com.store.areas.brand.models.service.BrandServiceModel;
import com.store.areas.category.models.service.CategoryServiceModel;
import com.store.areas.user.models.service.UserServiceModel;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public class ProductServiceModel {
    private String id;

    private String name;

    private String description;

    private BigDecimal price;

    private LocalDateTime createdAt;

    private BrandServiceModel brand;

    private Set<CategoryServiceModel> categories;

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

    public Set<CategoryServiceModel> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryServiceModel> categories) {
        this.categories = categories;
    }

    public UserServiceModel getUser() {
        return user;
    }

    public void setUser(UserServiceModel user) {
        this.user = user;
    }

    public BrandServiceModel getBrand() {
        return brand;
    }

    public void setBrand(BrandServiceModel brand) {
        this.brand = brand;
    }
}