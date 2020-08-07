package com.eshop.api.catalog.controller;

import com.eshop.api.catalog.model.CatalogItem;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/catalog")
public class CatalogController {

    @RequestMapping("/items[?pageSize=3&pageIndex=10]\n")
    public List<CatalogItem> getItems(@RequestBody(required = false) List<Integer> idList, @RequestParam Integer pageSize, @RequestParam Integer pageIndex) {
        return new ArrayList<>();
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

    }
}
