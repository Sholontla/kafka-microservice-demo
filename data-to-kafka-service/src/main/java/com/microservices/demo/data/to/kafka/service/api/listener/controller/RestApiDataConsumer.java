package com.microservices.demo.data.to.kafka.service.api.listener.controller;


import com.microservices.demo.data.to.kafka.service.DataToKafkaServiceApplication;
import com.microservices.demo.data.to.kafka.service.api.listener.model.Model;
import com.microservices.demo.data.to.kafka.service.api.listener.runner.impl.StreamImpl;
import com.microservices.demo.data.to.kafka.service.api.listener.service.DataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.concurrent.ExecutionException;


@RestController
public class RestApiDataConsumer {

    private DataService dataService;
    private StreamImpl streamImpl;

    private static final Logger LOG = LoggerFactory.getLogger(DataToKafkaServiceApplication.class);

    @Autowired
    RestApiDataConsumer(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping(value = "/web_client/{total}", produces=MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Model> getData(@PathVariable Double total) {
        return dataService.filterByTotalService(total);

    }

    @GetMapping(value = "/web_client_start/{total}", produces=MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Model> getDataStart(@PathVariable Double total) throws ExecutionException {
        return streamImpl.start(total);

    }




}
