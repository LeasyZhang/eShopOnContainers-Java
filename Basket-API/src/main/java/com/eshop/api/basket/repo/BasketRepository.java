package com.eshop.api.basket.repo;

import com.eshop.api.basket.model.CustomerBasket;

import java.util.List;
import java.util.Optional;

public interface BasketRepository {
    Optional<CustomerBasket> findByCustomerId(String customerId);

    CustomerBasket updateBasket(CustomerBasket customerBasket);

    Boolean deleteBasketById(String id);

    List<String> getUsers();
}
