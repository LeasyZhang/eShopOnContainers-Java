package com.eshop.api.basket.api;

import com.eshop.api.basket.dto.BasketCheckoutDTO;
import com.eshop.api.basket.dto.CustomerBasketDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class BasketController {

    @GetMapping("/{id}")
    public ResponseEntity<CustomerBasketDTO> getBasketById(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(new CustomerBasketDTO());
    }

    @PostMapping
    public ResponseEntity<CustomerBasketDTO> update(@RequestBody CustomerBasketDTO customerBasket) {
        return ResponseEntity.ok(new CustomerBasketDTO());
    }

    @PostMapping("/checkout")
    public ResponseEntity<String> checkout(@RequestBody BasketCheckoutDTO basketCheckout) {
        return ResponseEntity.ok("OK");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBasketById(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok("Deleted");
    }
}
