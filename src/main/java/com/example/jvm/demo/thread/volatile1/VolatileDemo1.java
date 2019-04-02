package com.example.jvm.demo.thread.volatile1;

/**
 * @Description: volatile的使用场景1
 * @ClassName: VolatileDemo1
 * @Author: yuexx
 * @Date: 2019/1/21 17:36
 * @Version: 1.0
 */
public class VolatileDemo1 {
    volatile boolean shutdownRequested;

    public void shutdown() {
        shutdownRequested = true;
    }

    public void doWork() {
        while (!shutdownRequested) {
            //do stuff
        }
    }
}
