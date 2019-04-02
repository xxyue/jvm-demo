package com.example.jvm.demo.thread.volatile1;

/**
 * @Description: DCL单例模式
 * @ClassName: Singleton
 * @Author: yuexx
 * @Date: 2019/1/21 18:01
 * @Version: 1.0
 */
public class Singleton {
    private volatile static Singleton instance;

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton.getInstance();
    }
}
