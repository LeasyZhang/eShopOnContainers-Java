package com.eshop.api.catalog.repo;

import com.eshop.api.catalog.model.CatalogItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface CatalogItemRepo extends CrudRepository<CatalogItem, Long> {

    Page<CatalogItem> findAll(Pageable pageable);
}
