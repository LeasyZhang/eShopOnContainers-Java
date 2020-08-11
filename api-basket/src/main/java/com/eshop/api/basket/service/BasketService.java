package com.eshop.api.basket.service;

import com.eshop.api.basket.dto.BasketItemDTO;
import com.eshop.api.basket.dto.CustomerBasketDTO;
import com.eshop.api.basket.model.BasketItem;
import com.eshop.api.basket.model.CustomerBasket;
import com.eshop.api.basket.repo.BasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BasketService {

    private final BasketRepository basketRepository;

    public CustomerBasketDTO getBasketByCustomerId(String customer) {
        Optional<CustomerBasket> basket = basketRepository.findByCustomerId(customer);
        return basket.map(item -> {
            CustomerBasketDTO dto = new CustomerBasketDTO();
            BeanUtils.copyProperties(item, dto);
            List<BasketItemDTO> basketItemDTOList = new ArrayList<>();
            for (BasketItem basketItem : item.getItems()) {
                BasketItemDTO basketItemDTO = new BasketItemDTO();
                BeanUtils.copyProperties(basketItem, basketItemDTO);
                basketItemDTOList.add(basketItemDTO);
            }
            dto.setBasketItems(basketItemDTOList);
            return dto;
        }).orElseGet(CustomerBasketDTO::new);
    }

    public CustomerBasketDTO updateBasket(CustomerBasketDTO customerBasket) {
        CustomerBasket before = new CustomerBasket();
        List<BasketItem> basketItemList = new ArrayList<>();
        BeanUtils.copyProperties(customerBasket, before);
        for (BasketItemDTO item : customerBasket.getBasketItems()) {
            BasketItem basketItem = new BasketItem();
            BeanUtils.copyProperties(item, basketItem);
            basketItemList.add(basketItem);
        }
        before.setItems(basketItemList);
        CustomerBasket updatedBasket = basketRepository.updateBasket(before);
        CustomerBasketDTO result = new CustomerBasketDTO();
        List<BasketItemDTO> basketItemDTOList = new ArrayList<>();
        BeanUtils.copyProperties(updatedBasket, result);
        for (BasketItem item : updatedBasket.getItems()) {
            BasketItemDTO dto = new BasketItemDTO();
            BeanUtils.copyProperties(item, dto);
            basketItemDTOList.add(dto);
        }
        result.setBasketItems(basketItemDTOList);
        return result;
    }

    public Boolean deleteBasketById(String id) {
        return basketRepository.deleteBasketById(id);
    }

    public Set<String> getUsers() {
        return basketRepository.getUsers();
    }
}
