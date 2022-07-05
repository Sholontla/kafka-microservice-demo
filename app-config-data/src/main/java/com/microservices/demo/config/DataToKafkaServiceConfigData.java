package com.microservices.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix = "data-to-kafka-service")
public class DataToKafkaServiceConfigData {
        private List<String> dataKeywords;
        private String welcomeMessage;
        private LocalDate date;

}
