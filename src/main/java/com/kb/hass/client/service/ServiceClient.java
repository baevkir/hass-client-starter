package com.kb.hass.client.service;

import com.kb.hass.client.model.State;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Slf4j
public class ServiceClient {
    private final WebClient webClient;

    public ServiceClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<State> postUpdate(String domain, String service, State state) {
       return webClient.post()
           .uri("/services/" + domain + "/" + service)
           .bodyValue(state)
           .retrieve()
           .bodyToFlux(State.class);
    }
}
