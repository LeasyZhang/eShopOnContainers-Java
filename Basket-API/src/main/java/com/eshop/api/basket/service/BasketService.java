package com.eshop.api.basket.service;

import com.eshop.api.basket.dto.CustomerBasketDTO;
import com.eshop.api.basket.model.CustomerBasket;
import com.eshop.api.basket.repo.BasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BasketService {

    private final BasketRepository basketRepository;

    public CustomerBasketDTO getBasketByCustomerId(String customer) {
        Optional<CustomerBasket> basket = basketRepository.findByCustomerId(customer);
        return basket.map(item -> {
            CustomerBasketDTO dto = new CustomerBasketDTO();
            BeanUtils.copyProperties(item, dto);
            return dto;
        }).orElseGet(CustomerBasketDTO::new);
    }

    public CustomerBasketDTO updateBasket(CustomerBasketDTO customerBasket) {
        CustomerBasket before = new CustomerBasket();
        BeanUtils.copyProperties(customerBasket, before);
        CustomerBasket updatedBasket = basketRepository.updateBasket(before);
        CustomerBasketDTO result = new CustomerBasketDTO();
        BeanUtils.copyProperties(updatedBasket, result);
        return result;
    }

    public Boolean deleteBasketById(String id) {
        return basketRepository.deleteBasketById(id);
    }

    public List<String> getUsers() {
        return basketRepository.getUsers();
    }
}
