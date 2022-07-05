package com.microservices.demo.data.to.kafka.service.api.listener.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix = "data-to-kafka-service")
public class DataToKafkaServiceConfig {
    private List<String> dataKeywords;
    private String welcomeMessage;
}