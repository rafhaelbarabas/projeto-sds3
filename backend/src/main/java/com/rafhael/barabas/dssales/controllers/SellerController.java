package com.rafhael.barabas.dssales.controllers;

import com.rafhael.barabas.dssales.dto.SellerDTO;
import com.rafhael.barabas.dssales.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sellers")
public class SellerController {

    private final SellerService service;

    @Autowired
    public SellerController(SellerService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<SellerDTO>> findAll(){
        List<SellerDTO> list = service.findAll();
        return ResponseEntity.ok(list);
    }
}
