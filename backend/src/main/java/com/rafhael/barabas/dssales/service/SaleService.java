package com.rafhael.barabas.dssales.service;

import com.rafhael.barabas.dssales.dto.SaleDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SaleService {
    SaleDTO save(SaleDTO dto);

    Page<SaleDTO> findAll(Pageable pageable);
}
