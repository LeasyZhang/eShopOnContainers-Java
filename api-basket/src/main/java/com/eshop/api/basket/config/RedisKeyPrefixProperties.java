package com.eshop.api.basket.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.redis.prefix")
@Getter
@Setter
public class RedisKeyPrefixProperties {

    private String key;
}
