package com.rafhael.barabas.dssales.repositories;

import com.rafhael.barabas.dssales.dto.SaleSumDTO;
import com.rafhael.barabas.dssales.dto.TaxSuccessDTO;
import com.rafhael.barabas.dssales.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT new com.rafhael.barabas.dssales.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) "
            + " FROM Sale AS obj "
            + " GROUP BY obj.seller")
    List<SaleSumDTO> amountGroupedBySeller();


    @Query("SELECT new com.rafhael.barabas.dssales.dto.TaxSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
            + " FROM Sale AS obj "
            + " GROUP BY obj.seller")
    List<TaxSuccessDTO> successGroupedBySeller();
}
