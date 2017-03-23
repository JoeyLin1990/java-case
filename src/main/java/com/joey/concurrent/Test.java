package com.joey.concurrent;

/**
 * Created by Joey on 2017/3/23.
 */
public class Test {

    public static void main(String[] args) {
        Container container = new Container();
        Thread c1 = new Thread(new Consumer(container,6,"c1"));
        Thread c2 = new Thread(new Consumer(container,5,"c2"));
        Thread c3 = new Thread(new Consumer(container,4,"c3"));

        Thread p1 = new Thread(new Producer(container,5,"p1"));
        Thread p2 = new Thread(new Producer(container,10,"p2"));
        c1.start();
        c2.start();
        c3.start();
        p1.start();
        p2.start();
    }
}
