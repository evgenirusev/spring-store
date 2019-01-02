package com.store.areas.sale.services;

import com.store.areas.sale.models.service.SaleServiceModel;

import java.util.List;

public interface SaleService {

    List<SaleServiceModel> findSalesByUsername(String username);

    void createSale(SaleServiceModel saleServiceModel);
}
