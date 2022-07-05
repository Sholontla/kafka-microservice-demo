package com.microservices.demo.data.to.kafka.service.api.listener.config;

import com.microservices.demo.config.KafkaConfigData;
import com.microservices.demo.data.to.kafka.service.api.listener.model.Model;
import com.microservices.demo.data.to.kafka.service.api.listener.transform.DataStatusToAvroTransformer;
import com.microservices.demo.kafka.avro.model.StreamAvroModel;
import com.microservices.demo.kafka.producer.config.service.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class ApiKakfaStatusListener {

    private static final Logger LOG = LoggerFactory.getLogger(ApiKakfaStatusListener.class);

    private final KafkaConfigData kafkaConfigData;

    private final KafkaProducer<Long, StreamAvroModel> kafkaProducer;

    private final DataStatusToAvroTransformer twitterStatusToAvroTransformer;
    @Autowired
    public ApiKakfaStatusListener(KafkaConfigData configData,
                                      KafkaProducer<Long, StreamAvroModel> producer,
                                      DataStatusToAvroTransformer transformer) {
        this.kafkaConfigData = configData;
        this.kafkaProducer = producer;
        this.twitterStatusToAvroTransformer = transformer;
    }
    public void onStatus() {
        LOG.info("Received status text {} sending to kafka topic {}");

    }

}
