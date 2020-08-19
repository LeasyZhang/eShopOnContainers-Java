package com.eshop.api.catalog.repo;

import com.eshop.api.catalog.model.CatalogItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogItemRepo extends PagingAndSortingRepository<CatalogItem, Long> {

    Page<CatalogItem> findAll(Pageable pageable);

    Page<CatalogItem> findAllByNameStartingWith(String name, Pageable pageable);

    Page<CatalogItem> findAllByCatalogTypeIdAndCatalogBrandId(Long catalogTypeId, Long catalogBrandId, Pageable pageable);

    Page<CatalogItem> findALlByCatalogBrandId(Long catalogBrandId, Pageable pageable);
}
