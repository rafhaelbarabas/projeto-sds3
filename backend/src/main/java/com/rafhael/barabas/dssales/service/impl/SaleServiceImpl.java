package com.rafhael.barabas.dssales.service.impl;

import com.rafhael.barabas.dssales.dto.SaleDTO;
import com.rafhael.barabas.dssales.entities.Sale;
import com.rafhael.barabas.dssales.repositories.SaleRepository;
import com.rafhael.barabas.dssales.repositories.SellerRepository;
import com.rafhael.barabas.dssales.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;
    private final SellerRepository sellerRepository;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository, SellerRepository sellerRepository) {
        this.saleRepository = saleRepository;
        this.sellerRepository = sellerRepository;
    }

    @Override
    public SaleDTO save(SaleDTO dto) {
        Sale save = saleRepository.save(dto.convert());
        return save.convert();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<SaleDTO> findAll(Pageable pageable) {
        sellerRepository.findAll(); // n + 1
        Page<Sale> result = saleRepository.findAll(pageable);
        return result.map(Sale::convert);
    }
}
