package com.rafhael.barabas.dssales.entities;

import com.rafhael.barabas.dssales.dto.SellerDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_sellers")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "seller")
    private List<Sale> sales = new ArrayList<>();

    public Seller() {
    }

    public Seller(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Seller (SellerDTO dto){
        id = dto.getId();
        name = dto.getName();
    }

    public Seller convert(SellerDTO dto){
        return new Seller(dto);
    }

    public SellerDTO convert(){
        return new SellerDTO(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void addSale(Sale sale) {
        this.sales.add(sale);
    }
}
