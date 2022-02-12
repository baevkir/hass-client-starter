package com.kb.hass.client.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class State {
    @JsonProperty("entity_id")
    private String entityId;
    private String state;
    private String temperature;
    @JsonProperty("hvac_mode")
    private String hvacMode;
    @JsonProperty("fan_speed")
    private String fanSpeed;
    private Map<String, Object> attributes;
}
