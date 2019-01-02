package com.store.areas.sale.models.service;

import com.store.areas.product.models.service.ProductServiceModel;
import com.store.areas.user.models.service.UserServiceModel;

import java.math.BigDecimal;

public class SaleServiceModel {

    private UserServiceModel user;

    private ProductServiceModel product;

    private BigDecimal price;

    public UserServiceModel getUser() {
        return user;
    }

    public void setUser(UserServiceModel user) {
        this.user = user;
    }

    public ProductServiceModel getProduct() {
        return product;
    }

    public void setProduct(ProductServiceModel product) {
        this.product = product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
