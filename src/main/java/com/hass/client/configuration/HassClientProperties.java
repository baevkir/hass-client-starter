package com.hass.client.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "hass")
public class HassClientProperties {
    private String token;
    private String url;
}
