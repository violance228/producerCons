package com.violence;

import com.violence.service.Consumer;
import com.violence.service.Producer;

/**
 * created by user violence
 * created on 18.03.2019
 * class created for project producerCons
 */

public class Main {
    public static void main(String[] args) {
        Producer.producerCount = 8;
        Producer.runProducer();
        Consumer.consumerCount = 5;
        Consumer.runConsumer();
    }
}
