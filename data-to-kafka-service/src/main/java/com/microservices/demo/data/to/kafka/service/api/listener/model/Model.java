package com.microservices.demo.data.to.kafka.service.api.listener.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Model {
    private String symbol;
    private Double price;
    private String time;
    private Double quantity;
    private Double subTotal;
    private Double total;
    private Double order;
}