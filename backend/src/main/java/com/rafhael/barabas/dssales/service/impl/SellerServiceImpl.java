package com.rafhael.barabas.dssales.service.impl;

import com.rafhael.barabas.dssales.dto.SellerDTO;
import com.rafhael.barabas.dssales.entities.Seller;
import com.rafhael.barabas.dssales.repositories.SellerRepository;
import com.rafhael.barabas.dssales.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;

    @Autowired
    public SellerServiceImpl(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public SellerDTO save(SellerDTO dto) {
        Seller save = sellerRepository.saveAndFlush(dto.convert());
        return save.convert();
    }

    @Override
    public List<SellerDTO> findAll() {
        return sellerRepository
                .findAll()
                .stream()
                .map(Seller::convert)
                .collect(Collectors.toList());
    }
}
