package com.store.areas.user.models.view;

import com.store.areas.product.models.view.ProductViewModel;

import java.util.Set;

public class UserViewModel {
    private String username;

    private String email;

    private Set<ProductViewModel> products;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<ProductViewModel> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductViewModel> products) {
        this.products = products;
    }
}