package com.eshop.api.catalog.controller;

import com.eshop.api.catalog.model.CatalogItem;
import com.eshop.api.catalog.repo.CatalogBrandRepo;
import com.eshop.api.catalog.repo.CatalogItemRepo;
import com.eshop.api.catalog.repo.CatalogTypeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/catalog")
@RequiredArgsConstructor
public class CatalogController {

    private final CatalogBrandRepo catalogBrandRepo;
    private final CatalogItemRepo catalogItemRepo;
    private final CatalogTypeRepo catalogTypeRepo;

    @RequestMapping("/items")
    public ResponseEntity<Page<CatalogItem>> getItems(@RequestBody(required = false) List<Long> idList, @RequestParam Integer pageSize, @RequestParam Integer pageIndex) {
        if (!CollectionUtils.isEmpty(idList)) {
            List<CatalogItem> itemList = (List<CatalogItem>) catalogItemRepo.findAllById(idList);
            if (CollectionUtils.isEmpty(itemList)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Page.empty());
            }
            PageImpl<CatalogItem> pageResult = new PageImpl<CatalogItem>(itemList, PageRequest.of(0, itemList.size()), itemList.size());
            return ResponseEntity.ok(pageResult);
        }

        return ResponseEntity.ok(catalogItemRepo.findAll(PageRequest.of(pageIndex - 1, pageSize)));
    }

    @RequestMapping("/item/{id}")
    public CatalogItem getItemById(@PathVariable("id") Integer id) {
        return new CatalogItem();
    }

    @RequestMapping("/items/withname/{name}")
    public List<CatalogItem> itemsWithName(@PathVariable("name") String name) {
        return new ArrayList<>();
    }

    @RequestMapping("")
    public List<CatalogItem> itemsByCatalogAndBrandId() {
        return new ArrayList<>();
    }
}
