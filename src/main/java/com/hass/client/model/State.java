package com.hass.client.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class State {
    private String entityId;
    private String state;
    private Map<String, Object> attributes;
    private LocalDateTime lastChanged;
}
