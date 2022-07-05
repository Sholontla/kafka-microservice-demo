package com.microservices.demo.data.to.kafka.service;

import com.microservices.demo.config.DataToKafkaServiceConfigData;

import com.microservices.demo.data.to.kafka.service.api.listener.init.StreamInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication
@ComponentScan(basePackages = "com.microservices.demo")
public class DataToKafkaServiceApplication implements CommandLineRunner {
    private final StreamInitializer streamInitializer;
    private static final Logger LOG = LoggerFactory.getLogger(DataToKafkaServiceApplication.class);
    private final DataToKafkaServiceConfigData dataToKafkaServiceConfigData;

    public DataToKafkaServiceApplication(StreamInitializer streamInitializer, DataToKafkaServiceConfigData configData) {
        this.streamInitializer = streamInitializer;
        this.dataToKafkaServiceConfigData = configData;
    }
    public static void main(String[] args) {
        SpringApplication.run(DataToKafkaServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOG.info("Application Starter ...........");
        LOG.info(Arrays.toString(dataToKafkaServiceConfigData.getDataKeywords().toArray(new String[] {})));
        LOG.info(dataToKafkaServiceConfigData.getWelcomeMessage());
        LOG.info("Date: ", dataToKafkaServiceConfigData.getDate());
        streamInitializer.init();


    }
}
