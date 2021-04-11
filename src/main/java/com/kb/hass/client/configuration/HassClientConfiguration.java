package com.kb.hass.client.configuration;

import com.kb.hass.client.service.StateClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@ConditionalOnProperty(value = {"token", "url"}, prefix = "hass")
@EnableConfigurationProperties(HassClientProperties.class)
public class HassClientConfiguration {

    @Bean
    public WebClient webClient(HassClientProperties properties) {
        return WebClient.builder()
                .baseUrl(properties.getUrl() + "/api")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + properties.getToken())
                .build();
    }

    @Bean
    public StateClient stateClient(WebClient webClient) {
        return new StateClient(webClient);
    }
}
