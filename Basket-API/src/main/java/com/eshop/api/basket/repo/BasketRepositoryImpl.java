package com.eshop.api.basket.repo;

import com.eshop.api.basket.exception.FormatException;
import com.eshop.api.basket.model.CustomerBasket;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
@RequiredArgsConstructor
@Slf4j
public class BasketRepositoryImpl implements BasketRepository {

    private final RedisTemplate<String, Object> redisTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Optional<CustomerBasket> findByCustomerId(String customerId) {
        CustomerBasket customerBasket;
        try {
            customerBasket = (CustomerBasket) redisTemplate.opsForValue().get(customerId);
        } catch (Exception e) {
            log.warn("failed to parse customer basket for {}", customerId, e);
            throw new FormatException("Failed to parse customer basket for " + customerId);
        }
        return Optional.ofNullable(customerBasket);
    }

    @Override
    public CustomerBasket updateBasket(CustomerBasket customerBasket) {
        redisTemplate.opsForValue().set(customerBasket.getBuyerId(), customerBasket);
        return findByCustomerId(customerBasket.getBuyerId()).get();
    }

    @Override
    public Boolean deleteBasketById(String id) {
        return redisTemplate.delete(id);
    }

    @Override
    public Set<String> getUsers() {
        return redisTemplate.keys("*");
    }
}
