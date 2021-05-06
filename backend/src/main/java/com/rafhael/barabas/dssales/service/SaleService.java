package com.rafhael.barabas.dssales.service;

import com.rafhael.barabas.dssales.dto.SaleDTO;
import com.rafhael.barabas.dssales.entities.Sale;

public interface SaleService {
    Sale save(SaleDTO dto);
}
