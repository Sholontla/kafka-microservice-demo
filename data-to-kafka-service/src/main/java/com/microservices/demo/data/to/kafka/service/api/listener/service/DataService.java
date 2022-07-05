package com.microservices.demo.data.to.kafka.service.api.listener.service;
import com.microservices.demo.data.to.kafka.service.api.listener.model.Model;
import com.microservices.demo.data.to.kafka.service.api.listener.config.client.Config;
import com.microservices.demo.data.to.kafka.service.api.listener.config.client.WebClientConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class DataService {


    public Flux<Model> webClientService() {
        WebClient webClient = WebClient.builder().build();
        WebClientConfiguration webClientConfiguration = new WebClientConfiguration(webClient);
        Flux<Model> prices = webClientConfiguration.pricesFor();
        return prices;
    }

    public Flux<Model> filterByTotalService(Double total) {
        Config config = new Config();
        Flux<Model> prices = config.webClientConfig();
        return prices
                .map(a -> {
            //a.setSymbol("");
            a.setTotal(a.getPrice() * a.getSubTotal());
            a.setQuantity(a.getPrice() * a.getSubTotal());
            return a;
        }).filter(a -> a.getTotal() < total)
          .filter(a -> a.getPrice() < 50);
    }
}
