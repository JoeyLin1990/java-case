package com.joey.concurrent;

/**
 * Created by Joey on 2017/3/23.
 */
public class Container {
    // 库存最大量
    private final static int MAX_COUNT = 10;
    // 当前量
    private int currentCount = 5;


    public synchronized void produce(String user,int count){
        while (count+currentCount>MAX_COUNT){
            System.out.println(user+"生产"+count+"时,超出最大库存量，当前库存量"+currentCount+",需要等待...");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        currentCount+=count;
        System.out.println(user+"已生产"+count+",剩余库存量"+currentCount);
        this.notifyAll();
    }

    public synchronized void consume(String user,int count){
        while (count>currentCount){
            System.out.println(user+"消费"+count+"时,剩余库存量不足，当前库存量"+currentCount+",需要等待...");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        currentCount-=count;
        System.out.println(user+"已消耗"+count+",剩余库存量"+currentCount);
        this.notifyAll();
    }
}
