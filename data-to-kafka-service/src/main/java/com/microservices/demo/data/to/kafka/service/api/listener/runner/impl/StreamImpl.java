package com.microservices.demo.data.to.kafka.service.api.listener.runner.impl;

import com.microservices.demo.data.to.kafka.service.api.listener.config.ApiKakfaStatusListener;
import com.microservices.demo.data.to.kafka.service.api.listener.config.DataToKafkaServiceConfig;
import com.microservices.demo.data.to.kafka.service.api.listener.model.Model;
import com.microservices.demo.data.to.kafka.service.api.listener.runner.StreamRunner;
import com.microservices.demo.data.to.kafka.service.api.listener.service.DataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import javax.annotation.PreDestroy;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

@Component
public class StreamImpl implements StreamRunner {

    private final DataToKafkaServiceConfig dataToKafkaServiceConfig;

    private final ApiKakfaStatusListener apiKakfaStatusListener;
    private static final Logger LOG = LoggerFactory.getLogger(StreamImpl.class);
    @Autowired
    public StreamImpl(DataToKafkaServiceConfig dataToKafkaServiceConfig,
                      ApiKakfaStatusListener apiKakfaStatusListener) {
        this.dataToKafkaServiceConfig = dataToKafkaServiceConfig;
        this.apiKakfaStatusListener = apiKakfaStatusListener;
    }

    @Override
    public Flux<Model> start(Double symbol) throws ExecutionException {
        DataService dataService = new DataService();
        LOG.info("Data Stream {}", dataService.filterByTotalService(symbol));
        addFilter();
        return dataService.filterByTotalService(symbol);
    }

    @PreDestroy
    public void shutdown() {

    }

    private void addFilter() {
        String[] keywords = dataToKafkaServiceConfig.getDataKeywords().toArray(new String[0]);
        LOG.info("Started filtering twitter stream for keywords {}", Arrays.toString(keywords));
    }
}


