package com.violence.service;

/**
 * created by user violence
 * created on 18.03.2019
 * class created for project producerCons
 */

public class Producer {
    public static int producerCount = 0;
    private static int productCode = 0;

    public static void runProducer() {
        for (int i = 0; i < producerCount; i++) {
            new Thread(new Runnable() {
                public void run() {
                    ExecutingService executingService = ExecutingService.getExecutingService();
                    while (true) {
                        try {
                            executingService.setProducts(getProductCode());
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }

    private synchronized static int getProductCode() {
        return productCode++;
    }
}
