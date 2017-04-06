package com.joey.thread;

/**
 * Created by Joey on 2017/3/23.
 */
public class TestJoin {
    public static void main(String[] args) {
        Thread t1 = new Thread(new RunnableImpl("T1"));
        Thread t2 = new Thread(new RunnableImpl("T2"));
        Thread t3 = new Thread(new RunnableImpl("T3"));
        t1.start();
        t2.start();
        t3.start();
    }
}

class RunnableImpl implements Runnable{
    public RunnableImpl(String name) {
        this.name = name;
    }
    private String name;

    @Override
    public void run() {
        System.out.println(name+" run...");
    }
}
