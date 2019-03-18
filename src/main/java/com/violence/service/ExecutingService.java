package com.violence.service;

import java.util.LinkedList;
import java.util.Queue;

/**
 * created by user violence
 * created on 18.03.2019
 * class created for project producerCons
 */

public class ExecutingService {
    private Object lock = new Object();
    private static ExecutingService service;
    private Queue<Integer> products = new LinkedList<>();
    private static final Integer SIZE = 50;

    public synchronized Integer getProducts() throws InterruptedException {
        int product = 0;
        if (products.isEmpty())
            this.wait();
        product = products.poll();
        if (products.size() == SIZE) {
            this.notifyAll();
        }
        System.out.println("getProduct --> " + product);
        return product;
    }

    public synchronized void setProducts(Integer product) throws InterruptedException {
        if (products.size() < SIZE) {
            if (products.isEmpty()) {
                this.products.offer(product);
                this.notifyAll();
            } else
                this.products.offer(product);
        } else {
            this.wait();
        }
        System.out.println("setProduct ----------------> " + product);
    }

    public static ExecutingService getExecutingService() {
        if (service == null)
            service = new ExecutingService();
        return service;
    }

    private ExecutingService(){}
}
