package com.example.jvm.demo.thread.volatile1;

/**
 * @Description: volatile变量规则（Volatile Variable Rule）：
 *          对一个volatile变量的写操作先行发生于后面对这个变量的读操作，这里的“后面”同样是指时间上的先后顺序。
 * @ClassName: VolatileTest2
 * @Author: yuexx
 * @Date: 2019/1/22 10:45
 * @Version: 1.0
 */
public class VolatileTest2 {

    private volatile int i;

    public int getI() {
//        try {
//            Thread.sleep(30);
//        } catch (InterruptedException e){
//        }
        System.out.println("test : " + i);
        return i;
    }

    public void setI(int i) {
//        try {
//            Thread.sleep(20);
//        } catch (InterruptedException e){
//        }
        this.i = i;
    }

    public static void test(VolatileTest2 test2, int i) {
        test2.setI(i);
        System.out.println("test : " + test2.getI());
    }

    public static void main(String[] args) throws InterruptedException {
        //如果每个线程都有赋值  不能保证多线程之间的顺序
//    VolatileTest2 test2 = new VolatileTest2();
//    for (int i = 0; i < 10; i++) {
//            final int y = i;
//        new Thread(() -> test(test2,y)).start();
//    }
//
//    System.out.println("main : "+test2.getI());

        // 先行时间发生 值为2
//    VolatileTest2 test3 = new VolatileTest2();
//    new Thread(() -> test3.setI(2)).start();
//    new Thread(() ->test3.getI()).start();
        // 不能保证顺序
        for(int i = 0; i < 100; i++ ) {
            VolatileTest2 test3 = new VolatileTest2();
            new Thread(() -> test3.getI()).start();
            new Thread(() -> test3.setI(2)).start();
        }
//        多个线程 要看时间先后顺序 加上睡眠时间
//        VolatileTest2 test4 = new VolatileTest2();
//        new Thread(() -> test4.getI()).start();
//        new Thread(() -> test4.setI(2)).start();
////        Thread.sleep(100);
//        System.out.println("main : " + test4.getI());


    }

}
