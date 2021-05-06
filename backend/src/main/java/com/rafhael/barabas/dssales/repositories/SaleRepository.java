package com.rafhael.barabas.dssales.repositories;

import com.rafhael.barabas.dssales.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
}
