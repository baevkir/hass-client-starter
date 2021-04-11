package com.kb.hass.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class State {
    @JsonProperty("entity_id")
    private String entityId;
    private String state;
    private Map<String, Object> attributes;
}
