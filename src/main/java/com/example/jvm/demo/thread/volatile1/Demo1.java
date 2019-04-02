package com.example.jvm.demo.thread.volatile1;

/**
 * @Description: 先行发生原则示例2
 * @ClassName: demo1
 * @Author: yuexx
 * @Date: 2019/1/22 10:25
 * @Version: 1.0
 */
public class Demo1 {

    private Demo1() {
        System.out.println("Demo1 : " + 0);
    }

     Demo1 d1 = new Demo1();
//    static Demo1 d2 = new Demo1();

    public static void main(String[] args) {
        Demo1 demo2 = new Demo1();
//        Demo1 demo1 =  Demo1.d2;
//        demo2.test(10);
        System.out.println("main : " + 1);
    }

    public void test(int i) {
        if (i < 0) {
            return;
        }
        System.out.println("test : "+ i);
        i--;
        test(i);
    }
}
