package com.microservices.demo.data.to.kafka.service.api.listener.exception;

public class DataToKafkaServiceException extends RuntimeException {

    public DataToKafkaServiceException() {
        super();
    }

    public DataToKafkaServiceException(String message) {
        super(message);
    }

    public DataToKafkaServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
