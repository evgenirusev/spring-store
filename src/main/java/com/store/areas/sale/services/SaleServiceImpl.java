package com.store.areas.sale.services;

import com.store.areas.sale.entities.Sale;
import com.store.areas.sale.models.service.SaleServiceModel;
import com.store.areas.sale.repositories.SaleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImpl implements SaleService {

    private final ModelMapper modelMapper;

    private final SaleRepository saleRepository;

    @Autowired
    public SaleServiceImpl(ModelMapper modelMapper, SaleRepository saleRepository) {
        this.modelMapper = modelMapper;
        this.saleRepository = saleRepository;
    }

    @Override
    public void createSale(SaleServiceModel saleServiceModel) {
        Sale saleEntity = this.modelMapper.map(saleServiceModel, Sale.class);
        this.saleRepository.save(saleEntity);
    }
}
