package com.rafhael.barabas.dssales.service.impl;

import com.rafhael.barabas.dssales.dto.SaleDTO;
import com.rafhael.barabas.dssales.entities.Sale;
import com.rafhael.barabas.dssales.repositories.SaleRepository;
import com.rafhael.barabas.dssales.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public Sale save(SaleDTO dto) {
        return saleRepository.save(new Sale());
    }
}
