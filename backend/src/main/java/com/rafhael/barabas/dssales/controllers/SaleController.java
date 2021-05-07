package com.rafhael.barabas.dssales.controllers;

import com.rafhael.barabas.dssales.dto.SaleDTO;
import com.rafhael.barabas.dssales.dto.SaleSumDTO;
import com.rafhael.barabas.dssales.dto.TaxSuccessDTO;
import com.rafhael.barabas.dssales.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    private final SaleService service;

    @Autowired
    public SaleController(SaleService service) {
        this.service = service;
    }

    @GetMapping("/amount-by-seller")
    public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller() {
        List<SaleSumDTO> saleSumDTOS = service.amountGroupedBySeller();
        return ResponseEntity.ok(saleSumDTOS);
    }

    @GetMapping("/success-by-seller")
    public ResponseEntity<List<TaxSuccessDTO>> successGroupedBySeller() {
        List<TaxSuccessDTO> list = service.successGroupedBySeller();
        return ResponseEntity.ok(list);
    }

    @GetMapping
    public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
        Page<SaleDTO> list = service.findAll(pageable);
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<SaleDTO> save(@RequestBody SaleDTO dto) {
        SaleDTO save = service.save(dto);
        return ResponseEntity.ok(save);
    }
}
