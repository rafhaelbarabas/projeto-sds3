package com.rafhael.barabas.dssales.service;

import com.rafhael.barabas.dssales.dto.SaleDTO;
import com.rafhael.barabas.dssales.dto.SellerDTO;
import com.rafhael.barabas.dssales.entities.Sale;
import com.rafhael.barabas.dssales.entities.Seller;

import java.util.List;

public interface SellerService {
    SellerDTO save(SellerDTO dto);
    List<SellerDTO> findAll();
}
