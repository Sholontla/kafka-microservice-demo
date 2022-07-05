package com.microservices.demo.data.to.kafka.service.producer;

import com.microservices.demo.data.to.kafka.service.api.listener.controller.RestApiDataConsumer;
import com.microservices.demo.data.to.kafka.service.api.listener.model.Model;
import com.microservices.demo.data.to.kafka.service.api.listener.config.client.WebClientConfiguration;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

public class Process {
    public static RestApiDataConsumer restApiDataConsumer;
    public static WebClientConfiguration webClientConfiguration;
    public static void main(String[] args) throws InterruptedException {


        WebClient webClient = WebClient.builder().build();
        WebClientConfiguration webClientConfiguration = new WebClientConfiguration(webClient);
        Flux<Model> prices = webClientConfiguration.pricesFor();
        System.out.println(prices);

    }
}

