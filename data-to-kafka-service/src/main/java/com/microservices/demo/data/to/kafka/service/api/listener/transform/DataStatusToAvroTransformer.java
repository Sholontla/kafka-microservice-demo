package com.microservices.demo.data.to.kafka.service.api.listener.transform;

import com.microservices.demo.data.to.kafka.service.api.listener.model.Model;
import com.microservices.demo.kafka.avro.model.StreamAvroModel;
import org.springframework.stereotype.Component;

@Component
public class DataStatusToAvroTransformer {

    public StreamAvroModel getDataAvroModelFromStatus(Model data) {
        return StreamAvroModel
                .newBuilder()
                .setSymbol(data.getSymbol())
                .setPrice(data.getPrice())
                .setQuantity(data.getQuantity())
                .setTime(data.getTime())
                .setSubTotal(data.getSubTotal())
                .setTotal(data.getTotal())
                .build();
    }
}
