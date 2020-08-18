package com.eshop.api.catalog.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "catalog_type")
public class CatalogType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(name = "type")
    public String type;
}
