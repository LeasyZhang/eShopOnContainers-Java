package com.eshop.api.gateway.service;

import com.eshop.api.gateway.BasketGrpc;
import com.eshop.api.gateway.BasketOuterClass;
import com.eshop.api.gateway.dto.BasketItemDTO;
import com.eshop.api.gateway.dto.BasketRsp;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class BasketGrpcClientService {

    public BasketRsp getBasketByCustomerId(String customerId) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9081)
                .usePlaintext()
                .build();

        BasketGrpc.BasketBlockingStub stub = BasketGrpc.newBlockingStub(channel);
        BasketOuterClass.CustomerBasketResponse response = stub.getBasketById(BasketOuterClass
                .BasketRequest.newBuilder()
                .setId(customerId)
                .build());

        channel.shutdownNow();

        BasketRsp rsp = new BasketRsp();
        rsp.setBuyerId(response.getBuyerid());

        rsp.setBasketItems(response.getItemsList().stream().map(item -> {
            BasketItemDTO basketItem = new BasketItemDTO();
            basketItem.setId(item.getId());
            basketItem.setOldUnitPrice(item.getOldunitprice());
            basketItem.setUnitPrice(item.getUnitprice());
            basketItem.setPictureUrl(item.getPictureurl());
            basketItem.setProductId(item.getProductid());
            basketItem.setProductName(item.getProductname());
            basketItem.setQuantity(item.getQuantity());
            return basketItem;
        }).collect(Collectors.toList()));
        return rsp;
    }
}
