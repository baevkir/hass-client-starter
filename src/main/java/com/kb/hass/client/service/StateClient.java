package com.kb.hass.client.service;

import com.kb.hass.client.model.State;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
public class StateClient {
    private final WebClient webClient;

    public StateClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<State> getStates() {
        return webClient.get()
                .uri("/states")
                .retrieve()
                .bodyToFlux(State.class);
    }

    public Mono<State> getState(String entityId) {
        return webClient.get()
                .uri("/states/" + entityId)
                .retrieve()
                .bodyToMono(State.class);
    }

    public Mono<State> updateState(String entityId, State state) {
        return webClient.post()
                .uri("/states/" + entityId)
                .bodyValue(state)
                .retrieve()
                .bodyToMono(State.class);
    }
}
