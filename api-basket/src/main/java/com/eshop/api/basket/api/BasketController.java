package com.eshop.api.basket.api;

import com.eshop.api.basket.model.BasketCheckout;
import com.eshop.api.basket.model.CustomerBasket;
import com.eshop.api.basket.repo.BasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BasketController {

    private final BasketRepository basketRepository;

    @GetMapping("/{id}")
    public ResponseEntity<CustomerBasket> getBasketById(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(basketRepository.findByCustomerId(id));
    }

    @PostMapping
    public ResponseEntity<CustomerBasket> update(@RequestBody CustomerBasket customerBasket) {
        return ResponseEntity.ok(basketRepository.updateBasket(customerBasket));
    }

    @PostMapping("/checkout")
    public ResponseEntity<String> checkout(@RequestBody BasketCheckout basketCheckout) {
        return ResponseEntity.ok("OK");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBasketById(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(String.valueOf(basketRepository.deleteBasketById(id)));
    }
}
