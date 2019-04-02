package com.example.jvm.demo.thread.volatile1;

/**
 * @Description: volatile变量自增运算测试
 * @ClassName: VolatileTest
 * @Author: yuexx
 * @Date: 2019/1/21 11:51
 * @Version: 1.0
 */
public class VolatileTest {
    public static volatile int race = 0;

    public static void increase() {
        race++;
    }

    public static void increaseFor() {
//        try {
////            Thread.sleep(500);
////        } catch (Exception e) {
////
////        }
        int i = 10000;
        while (i > 0) {
            increase();
            i--;
        }
    }

    private static final int THREADS_COUNT = 20;

    // -XX:+PrintAssembly   输出反汇编
    //-XX:+UnlockDiagnosticVMOptions 要执行在环境下
//    -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < THREADS_COUNT; i++) {
//            new Thread(() -> increaseFor()).start();
//            ThreadGroup threadGroup = new ThreadGroup("222");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    increaseFor();
                }
            },"test"+i).start();
        }
//
//        Thread[]threads=new Thread[THREADS_COUNT];
//        for(int i=0;i<THREADS_COUNT;i++){
//            threads[i]=new Thread(new Runnable(){
//                @Override
//                public void run(){
//                    for(int i=0;i<10000;i++){
//                        increase();
//                    }
//                }
//            });
//            threads[i].start();
//        }

        //等待所有累加线程都结束
        //返回当前线程的线程组中活动线程的数目。
//        Thread.sleep(15000);
        while (Thread.activeCount() > 2) {//1可能不对 ，参考JVM main 启动 开启了几个线程  debug：1，  start：2
//            //输出线程组中所有线程名字
//            ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
//            Thread[] ts = new Thread[threadGroup.activeCount()];
//            threadGroup.enumerate(ts);
//            for(Thread t:ts){
//                System.out.println(t.getName());
//            }
//            String threadGroupName = Thread.currentThread().getThreadGroup().getName();
//            System.out.println("线程组名" + threadGroupName);
//            System.out.println("线程数目：" + Thread.activeCount());
//            System.out.println("线程：" + Thread.getAllStackTraces().toString());
            Thread.yield();
        }
        System.out.println("计数 : " + race);

    }
}
