package com.microservices.demo.data.to.kafka.service.api.listener.config.client;

import com.microservices.demo.data.to.kafka.service.api.listener.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.util.retry.Retry;

import java.io.IOException;
import java.time.Duration;


public class WebClientConfiguration {

    private WebClient webClient;
    private Logger LOG = LoggerFactory.getLogger(WebClientConfiguration.class);

    public WebClientConfiguration(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<Model> pricesFor() {
        return webClient.get()
                .uri("http://127.0.0.1:8001/streamdata")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToFlux(Model.class)
                .retryWhen(Retry.backoff(5, Duration.ofSeconds(1)))
                .doOnError(IOException.class, e -> LOG.error(e.getMessage()));

    }

}