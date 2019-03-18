package com.violence.service;

/**
 * created by user violence
 * created on 18.03.2019
 * class created for project producerCons
 */

public class Consumer {
    public static int consumerCount = 0;

    public static void runConsumer() {
        for (int i = 0; i < consumerCount; i++) {
            new Thread(new Runnable() {
                public void run() {
                    ExecutingService executingService = ExecutingService.getExecutingService();
                    while (true) {
                        try {
                            executingService.getProducts();
                            Thread.sleep(320);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }
}
