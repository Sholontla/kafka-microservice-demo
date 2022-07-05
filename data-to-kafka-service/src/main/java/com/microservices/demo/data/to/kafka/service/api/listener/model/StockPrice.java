package com.microservices.demo.data.to.kafka.service.api.listener.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockPrice {
        private String symbol;
        private Double price;
        private String time;
        private Double quantity;
        private Double subTotal;
        private  Double Total;
        private Double order;


}
