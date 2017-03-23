package com.joey.concurrent;

/**
 * Created by Joey on 2017/3/23.
 */
public class Producer implements Runnable {

    private Container container;
    private int count;
    private String user;

    public Producer(Container container, int count,String user) {
        this.container = container;
        this.count = count;
        this.user = user;
    }

    @Override
    public void run() {
        container.produce(user,count);
    }
}
