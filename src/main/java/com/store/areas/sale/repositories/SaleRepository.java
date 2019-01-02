package com.store.areas.sale.repositories;

import com.store.areas.sale.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, String> {
    List<Sale> findAllByUserUsername(String usename);
}
