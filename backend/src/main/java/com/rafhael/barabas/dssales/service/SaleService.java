package com.rafhael.barabas.dssales.service;

import com.rafhael.barabas.dssales.dto.SaleDTO;
import com.rafhael.barabas.dssales.dto.SaleSumDTO;
import com.rafhael.barabas.dssales.dto.TaxSuccessDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SaleService {
    SaleDTO save(SaleDTO dto);

    Page<SaleDTO> findAll(Pageable pageable);

    List<SaleSumDTO> amountGroupedBySeller();

    List<TaxSuccessDTO> successGroupedBySeller();
}
