package com.eshop.api.basket.grpc;

import com.eshop.api.basket.BasketGrpc;
import com.eshop.api.basket.BasketOuterClass;
import com.eshop.api.basket.model.BasketItem;
import com.eshop.api.basket.model.CustomerBasket;
import com.eshop.api.basket.repo.BasketRepository;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@GrpcService
public class BasketGrpcService extends BasketGrpc.BasketImplBase {

    private final BasketRepository basketRepository;

    @Override
    public void getBasketById(BasketOuterClass.BasketRequest request, StreamObserver<BasketOuterClass.CustomerBasketResponse> responseObserver) {
        log.info("Begin GRPC call from method {} for basket id {}", "GetBasketById", request.getId());
        String customerId = StringUtils.replace(request.getId(), "\n", "");
        CustomerBasket customerBasket = basketRepository.findByCustomerId(customerId);
        BasketOuterClass.CustomerBasketResponse reply;

        if (customerBasket != null && !StringUtils.isEmpty(customerBasket.getBuyerId())) {
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

        CustomerBasket toBeUpdated = new CustomerBasket();
        toBeUpdated.setBuyerId(request.getBuyerid());
        List<BasketItem> basketItemList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(request.getItemsList())) {
            request.getItemsList().stream().forEach(requestItem -> {
                BasketItem basketItem = new BasketItem();
                BeanUtils.copyProperties(requestItem, basketItem);
                basketItemList.add(basketItem);
            });
        }
        toBeUpdated.setItems(basketItemList);
        CustomerBasket updateResponse = basketRepository.updateBasket(toBeUpdated);

        BasketOuterClass.CustomerBasketResponse reply = mapDtoToResponse(updateResponse);
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    private BasketOuterClass.CustomerBasketResponse mapDtoToResponse(CustomerBasket customerBasket) {
        List<BasketItem> itemList = customerBasket.getItems();
        List<BasketOuterClass.BasketItemResponse> responses = new ArrayList<>();

        if (!CollectionUtils.isEmpty(itemList)) {
            responses = itemList.stream().map(item -> {
                BasketOuterClass.BasketItemResponse basketItemResponse = BasketOuterClass.BasketItemResponse.newBuilder()
                        .setId(item.getId())
                        .setOldunitprice(item.getOldUnitPrice())
                        .setPictureurl(item.getPictureUrl())
                        .setProductid(item.getProductId())
                        .setProductname(item.getProductName())
                        .setQuantity(item.getQuantity())
                        .setUnitprice(item.getUnitPrice())
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
