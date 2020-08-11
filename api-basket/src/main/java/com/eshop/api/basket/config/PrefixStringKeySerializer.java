package com.eshop.api.basket.config;

import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class PrefixStringKeySerializer extends StringRedisSerializer {

    private Charset charset = StandardCharsets.UTF_8;
    private final RedisKeyPrefixProperties prefix;

    public PrefixStringKeySerializer(RedisKeyPrefixProperties prefix) {
        super();
        this.prefix = prefix;
    }

    @Override
    public String deserialize(byte[] bytes) {
        String saveKey = new String(bytes, charset);
        String prefixKey = spliceKey(prefix.getKey());
        int indexOf = saveKey.indexOf(prefixKey);
        if (indexOf > 0) {
            saveKey = saveKey.substring(indexOf);
        }
        return saveKey.getBytes() == null ? null : saveKey;
    }

    @Override
    public byte[] serialize(@Nullable String key) {
        key = spliceKey(prefix.getKey()) + key;
        return key == null ? null : key.getBytes(charset);
    }

    private String spliceKey(String prefixKey) {
        if (!StringUtils.isEmpty(prefixKey) && !prefixKey.endsWith(":")) {
            prefixKey = prefixKey + "::";
        }
        return prefixKey;
    }
}
