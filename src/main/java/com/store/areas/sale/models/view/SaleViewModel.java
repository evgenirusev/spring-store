package com.store.areas.sale.models.view;

import com.store.areas.product.models.view.ProductViewModel;
import com.store.areas.user.models.view.UserViewModel;

public class SaleViewModel {
    private ProductViewModel product;

    private UserViewModel user;

    public ProductViewModel getProduct() {
        return product;
    }

    public void setProduct(ProductViewModel product) {
        this.product = product;
    }

    public UserViewModel getUser() {
        return user;
    }

    public void setUser(UserViewModel user) {
        this.user = user;
    }
}
