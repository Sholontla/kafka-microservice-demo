package com.microservices.demo.data.to.kafka.service.api.listener.runner;

import com.microservices.demo.data.to.kafka.service.api.listener.model.Model;
import reactor.core.publisher.Flux;

import java.util.concurrent.ExecutionException;

public interface StreamRunner {

    Flux<Model> start(Double symbol) throws ExecutionException;
}
