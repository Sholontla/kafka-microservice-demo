package com.microservices.demo.data.to.kafka.service.api.listener.config.client;

import com.microservices.demo.data.to.kafka.service.api.listener.model.Model;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

public class Config {
    public Flux<Model> webClientConfig() {
        WebClient webClient = WebClient.builder().build();
        WebClientConfiguration webClientConfiguration = new WebClientConfiguration(webClient);
        Flux<Model> prices = webClientConfiguration.pricesFor();
        return prices;
    }
}
