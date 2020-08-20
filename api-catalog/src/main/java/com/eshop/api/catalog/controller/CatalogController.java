package com.eshop.api.catalog.controller;

import com.eshop.api.catalog.exception.CatalogItemNotFoundException;
import com.eshop.api.catalog.model.CatalogItem;
import com.eshop.api.catalog.repo.CatalogBrandRepo;
import com.eshop.api.catalog.repo.CatalogItemRepo;
import com.eshop.api.catalog.repo.CatalogTypeRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/catalog")
@RequiredArgsConstructor
@Slf4j
public class CatalogController {

    private final CatalogItemRepo catalogItemRepo;
    private final CatalogTypeRepo catalogTypeRepo;
    private final CatalogBrandRepo catalogBrandRepo;

    @Value("${picServer.baseUrl}")
    private String imageServerUrl;

    @GetMapping("items")
    public ResponseEntity<Page<CatalogItem>> getItems(@RequestBody(required = false) String idList, @RequestParam Integer pageSize, @RequestParam Integer pageIndex) {
        if (pageIndex < 1 || pageSize < 1) {
            throw new IllegalArgumentException("Bad request param pageIndex " + pageIndex + " pageSize " + pageSize);
        }
        List<Long> itemIdList = new ArrayList<>();
        if (!StringUtils.isEmpty(idList)) {
            String[] idListStr = idList.split(",");
            for (String str : idListStr) {
                itemIdList.add(Long.valueOf(str));
            }
        }
        if (!CollectionUtils.isEmpty(itemIdList)) {
            List<CatalogItem> itemList = (List<CatalogItem>) catalogItemRepo.findAllById(itemIdList);
            if (CollectionUtils.isEmpty(itemList)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Page.empty());
            }
            itemList.stream().forEach(item -> item.fillImageUrl(imageServerUrl));
            PageImpl<CatalogItem> pageResult = new PageImpl<>(itemList, PageRequest.of(0, itemList.size(), Sort.by("name").ascending()), itemList.size());
            return ResponseEntity.ok(pageResult);
        }

        Page<CatalogItem> pageResult = catalogItemRepo.findAll(PageRequest.of(pageIndex - 1, pageSize, Sort.by("name").ascending()));
        pageResult.get().forEach(item -> item.fillImageUrl(imageServerUrl));
        return ResponseEntity.ok(pageResult);
    }

    @GetMapping("item/{id}")
    public CatalogItem getItemById(@PathVariable("id") Long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Bad request id " + id);
        }
        Optional<CatalogItem> catalogItem = catalogItemRepo.findById(id);
        return catalogItem.map(item -> {
            item.fillImageUrl(imageServerUrl);
            return item;
        }).orElseGet(() -> {
            log.info("No result found for {}", id);
            return new CatalogItem();
        });
    }

    @GetMapping("items/withname/{name}")
    public ResponseEntity<Page<CatalogItem>> itemsWithName(@PathVariable("name") String name, @RequestParam Integer pageSize, @RequestParam Integer pageIndex) {
        if (pageIndex < 1 || pageSize < 1) {
            throw new IllegalArgumentException("Bad request param pageIndex " + pageIndex + " pageSize " + pageSize);
        }
        Page<CatalogItem> itemPage = catalogItemRepo.findAllByNameStartingWith(name, PageRequest.of(pageIndex - 1, pageSize));
        itemPage.get().forEach(item -> item.fillImageUrl(imageServerUrl));
        return ResponseEntity.ok(itemPage);
    }

    @GetMapping("items/type/{catalogTypeId}/brand/{catalogBrandId}")
    public ResponseEntity<Page<CatalogItem>> itemsByCatalogAndBrandId(@PathVariable("catalogTypeId") Long catalogTypeId,
                                                                      @PathVariable("catalogBrandId") Long catalogBrandId,
                                                                      @RequestParam Integer pageSize, @RequestParam Integer pageIndex) {
        if (pageIndex < 1 || pageSize < 1) {
            throw new IllegalArgumentException("Bad request param pageIndex " + pageIndex + " pageSize " + pageSize);
        }
        Page<CatalogItem> items = catalogItemRepo.findAllByCatalogTypeIdAndCatalogBrandId(catalogTypeId, catalogBrandId, PageRequest.of(pageIndex - 1, pageSize, Sort.by("name").ascending()));
        items.get().forEach(item -> item.fillImageUrl(imageServerUrl));
        return ResponseEntity.ok(items);
    }

    @GetMapping("items/type/all/brand/{catalogBrandId}")
    public ResponseEntity<Page<CatalogItem>> itemdByBrandId(@PathVariable("catalogBrandId") Long catalogBrandId,
                                                            @RequestParam("pageSize") int pageSize,
                                                            @RequestParam("pageIndex") int pageIndex) {
        Page<CatalogItem> items = catalogItemRepo.findALlByCatalogBrandId(catalogBrandId,
                PageRequest.of(pageIndex - 1, pageSize));
        items.get().forEach(item -> item.fillImageUrl(imageServerUrl));
        return ResponseEntity.ok(items);
    }

    @GetMapping("catalogbrands")
    public ResponseEntity<List<String>> catalogBrands() {
        List<String> res = new ArrayList<>();
        catalogBrandRepo.findAll().forEach(item -> res.add(item.getBrand()));
        return ResponseEntity.ok(res);
    }

    @GetMapping("catalogtypes")
    public ResponseEntity<List<String>> catalogTypes() {
        List<String> res = new ArrayList<>();
        catalogTypeRepo.findAll().forEach(item -> res.add(item.getType()));
        return ResponseEntity.ok(res);
    }

    @PutMapping("items")
    public ResponseEntity<CatalogItem> updateProduct(@RequestBody CatalogItem itemToUpdate) {
        Optional<CatalogItem> oldItem = catalogItemRepo.findById(itemToUpdate.getId());
        return ResponseEntity.ok(oldItem.map(item -> {
            if (!item.getPrice().equals(itemToUpdate.getPrice())) {
                //raise event
            }
            return catalogItemRepo.save(itemToUpdate);
        }).orElseThrow(() -> new CatalogItemNotFoundException("Item not found for " + itemToUpdate.getId())));
    }

    @PostMapping("items")
    public ResponseEntity<CatalogItem> createProduct(@RequestBody CatalogItem newProduct) {
        return ResponseEntity.ok(catalogItemRepo.save(newProduct));
    }

    @DeleteMapping("items/{itemId}")
    public ResponseEntity<String> deleteProduct(@PathVariable("itemId") Long itemId) {
        Optional<CatalogItem> product = catalogItemRepo.findById(itemId);

        return product.map(item -> {
            catalogItemRepo.deleteById(itemId);
            return ResponseEntity.ok("Success");
        }).orElseThrow(() -> new CatalogItemNotFoundException("Item not found for " + itemId));
    }

}
