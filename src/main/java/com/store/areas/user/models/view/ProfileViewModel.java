package com.store.areas.user.models.view;

import com.store.areas.sale.models.view.SaleViewModel;

import java.util.List;

public class ProfileViewModel {
    private UserViewModel user;

    private List<SaleViewModel> sales;

    public UserViewModel getUser() {
        return user;
    }

    public void setUser(UserViewModel user) {
        this.user = user;
    }

    public List<SaleViewModel> getSales() {
        return sales;
    }

    public void setSales(List<SaleViewModel> sales) {
        this.sales = sales;
    }
}
