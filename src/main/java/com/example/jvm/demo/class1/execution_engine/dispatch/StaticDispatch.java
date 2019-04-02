package com.example.jvm.demo.class1.execution_engine.dispatch;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 方法静态分派演示
 * @ClassName: StaticDispatch
 * @Author: yuexx
 * @Date: 2019/1/15 17:12
 * @Version: 1.0
 */
@Slf4j
public  class StaticDispatch {

    static interface People{

    }

    static abstract class Human{

    }
    static class Man extends Human implements People{

    }
    static class Woman extends Human implements People{

    }
    public void sayHello(People people){
        System.out.println("hello,people！");
    }

    public void sayHello(Human guy){
        System.out.println("hello,guy！");
    }

    public void sayHello(Man guy){
        System.out.println("hello,gentleman！");
    }
    public void sayHello(Woman guy){
        System.out.println("hello,lady！");
    }

    /**
     *
     * 输出结果
     * hello,guy！
     * hello,guy！
     * @param args
     */
    public static void main(String[]args){
        StaticDispatch sr=new StaticDispatch();
        log.info("**********静态类型Human************");
        Human man=new Man();
        Human woman=new Woman();
        sr.sayHello(man);
        sr.sayHello(woman);
        log.info("**********静态类型People************");
        People man1=new Man();
        People woman1=new Woman();
        sr.sayHello(man1);
        sr.sayHello(woman1);
        log.info("**********实际类型************");
        Man man2=new Man();
        Woman woman2=new Woman();
        sr.sayHello(man2);
        sr.sayHello(woman2);

        log.info("**********静态类型Human, 实际类型转换************");
        //实际类型变化
        Human man4=new Man();
        man4=new Woman();
        //静态类型变化
        sr.sayHello((Man)man);
        sr.sayHello((Woman)man); //因为类型转换，强转报错
    }
}
