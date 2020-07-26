package com.eshop.api.basket.repo;

import com.eshop.api.basket.model.CustomerBasket;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BasketRepositoryImpl implements BasketRepository {
    @Override
    public Optional<CustomerBasket> findByCustomerId(String customerId) {
        return Optional.empty();
    }

    @Override
    public CustomerBasket updateBasket(CustomerBasket customerBasket) {
        return null;
    }

    @Override
    public Boolean deleteBasketById(String id) {
        return null;
    }

    @Override
    public List<String> getUsers() {
        return null;
    }
}
