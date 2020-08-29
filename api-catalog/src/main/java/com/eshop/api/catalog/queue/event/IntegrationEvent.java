package com.eshop.api.catalog.queue.event;

import java.time.Instant;
import java.util.UUID;

public abstract class IntegrationEvent {

    private String guid;
    private Instant createDate;
    private String key;

    public String getGuid() {
        this.guid = UUID.randomUUID().toString();
        return this.guid;
    }

    public Instant getCreateDate() {
        this.createDate = Instant.now();
        return this.createDate;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
