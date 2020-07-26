package com.eshop.api.basket.api;

import com.eshop.api.basket.dto.BasketCheckoutDTO;
import com.eshop.api.basket.dto.CustomerBasketDTO;
import com.eshop.api.basket.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BasketController {

    private final BasketService basketService;

    @GetMapping("/{id}")
    public ResponseEntity<CustomerBasketDTO> getBasketById(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(basketService.getBasketByCustomerId(id));
    }

    @PostMapping
    public ResponseEntity<CustomerBasketDTO> update(@RequestBody CustomerBasketDTO customerBasket) {
        return ResponseEntity.ok(basketService.updateBasket(customerBasket));
    }

    @PostMapping("/checkout")
    public ResponseEntity<String> checkout(@RequestBody BasketCheckoutDTO basketCheckout) {
        return ResponseEntity.ok("OK");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBasketById(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(String.valueOf(basketService.deleteBasketById(id)));
    }
}
