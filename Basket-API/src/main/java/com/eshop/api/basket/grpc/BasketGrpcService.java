package com.eshop.api.basket.grpc;

import com.eshop.api.basket.BasketGrpc;
import com.eshop.api.basket.BasketOuterClass;
import com.eshop.api.basket.dto.BasketItemDTO;
import com.eshop.api.basket.dto.CustomerBasketDTO;
import com.eshop.api.basket.service.BasketService;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class BasketGrpcService extends BasketGrpc.BasketImplBase {

    private final BasketService basketService;

    @Override
    public void getBasketById(BasketOuterClass.BasketRequest request, StreamObserver<BasketOuterClass.CustomerBasketResponse> responseObserver) {
        log.info("Begin GRPC call from method {} for basket id {}", "GetBasketById", request.getId());
        CustomerBasketDTO customerBasket = basketService.getBasketByCustomerId(request.getId());
        BasketOuterClass.CustomerBasketResponse reply;

        if (customerBasket != null) {
            reply = mapDtoToResponse(customerBasket);
        } else {
            reply = BasketOuterClass.CustomerBasketResponse.newBuilder().build();
            log.info("Customer {} basket do not exist", request.getId());
        }

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void updateBasket(BasketOuterClass.CustomerBasketRequest request, StreamObserver<BasketOuterClass.CustomerBasketResponse> responseObserver) {

        CustomerBasketDTO toBeUpdated = new CustomerBasketDTO();
        toBeUpdated.setBuyerId(request.getBuyerid());
        List<BasketItemDTO> basketItemList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(request.getItemsList())) {
            request.getItemsList().stream().forEach(requestItem -> {
                BasketItemDTO basketItemDTO = new BasketItemDTO();
                BeanUtils.copyProperties(requestItem, basketItemDTO);
                basketItemList.add(basketItemDTO);
            });
        }
        toBeUpdated.setBasketItems(basketItemList);
        CustomerBasketDTO updateResponse = basketService.updateBasket(toBeUpdated);

        BasketOuterClass.CustomerBasketResponse reply = mapDtoToResponse(updateResponse);
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    private BasketOuterClass.CustomerBasketResponse mapDtoToResponse(CustomerBasketDTO customerBasket) {
        List<BasketItemDTO> itemList = customerBasket.getBasketItems();
        List<BasketOuterClass.BasketItemResponse> responses = new ArrayList<>();

        if (!CollectionUtils.isEmpty(itemList)) {
            responses = itemList.stream().map(item -> {
                BasketOuterClass.BasketItemResponse basketItemResponse = BasketOuterClass.BasketItemResponse.newBuilder()
                        .setId(item.getId())
                        .setOldunitprice(item.getOldUnitPrice().doubleValue())
                        .setPictureurl(item.getPictureUrl())
                        .setProductid(item.getProductId())
                        .setProductname(item.getProductName())
                        .setQuantity(item.getQuantity())
                        .setUnitprice(item.getUnitPrice().doubleValue())
                        .build();
                return basketItemResponse;
            }).collect(Collectors.toList());
        }

        return BasketOuterClass.CustomerBasketResponse.newBuilder()
                .setBuyerid(customerBasket.getBuyerId())
                .addAllItems(responses)
                .build();
    }
}
