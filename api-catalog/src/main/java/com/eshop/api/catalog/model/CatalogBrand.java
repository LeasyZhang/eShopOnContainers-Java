package com.eshop.api.catalog.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table("catalog_brand")
public class CatalogBrand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "brand")
    private String brand;
}
