package com.eshop.api.basket.repo;

import com.eshop.api.basket.model.CustomerBasket;

import java.util.Optional;
import java.util.Set;

public interface BasketRepository {
    Optional<CustomerBasket> findByCustomerId(String customerId);

    CustomerBasket updateBasket(CustomerBasket customerBasket);

    Boolean deleteBasketById(String id);

    Set<String> getUsers();
}
