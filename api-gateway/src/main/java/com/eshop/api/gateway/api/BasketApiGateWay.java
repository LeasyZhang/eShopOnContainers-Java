package com.eshop.api.gateway.api;

import com.eshop.api.gateway.dto.BasketRsp;
import com.eshop.api.gateway.service.BasketGrpcClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("gateway")
public class BasketApiGateWay {

    private final BasketGrpcClientService basketGrpcClientService;

    @GetMapping("/basket/{customerId}")
    public ResponseEntity<BasketRsp> getBasketByCustomerId(
            @PathVariable("customerId") String customerId) {
        return ResponseEntity.ok(basketGrpcClientService.getBasketByCustomerId(customerId));
    }
}
