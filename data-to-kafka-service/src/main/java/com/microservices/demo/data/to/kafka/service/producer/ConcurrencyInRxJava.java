package com.microservices.demo.data.to.kafka.service.producer;


import io.reactivex.rxjava3.core.Observable;
import com.microservices.demo.data.to.kafka.service.api.listener.controller.RestApiDataConsumer;

public class ConcurrencyInRxJava {

    private RestApiDataConsumer restApiDataConsumer;

    public static void main(String[] args) {

        Observable<String> source = Observable.create(
                e -> {
                    new Thread( () ->
                    {
                        e.onNext("Hello");
                        e.onNext("RxJava");
                    }
                    ).start();
                }
        );

        source
                .subscribe(e -> System.out.println("Observer 1 :"+e + " Thread is :" +Thread.currentThread().getName()));

        source
                .subscribe(e -> System.out.println("Observer 2 :"+e+ " Thread is :" +Thread.currentThread().getName()));

    }

}