package com.example.jvm.demo.class1.execution_engine.dispatch;

/**
 * @Description: 方法动态分派演示
 * @ClassName: DynamicDispatch
 * @Author: yuexx
 * @Date: 2019/1/16 15:07
 * @Version: 1.0
 */
public class DynamicDispatch {

    static abstract class Human {
        protected abstract void sayHello();
    }

    static class Man extends Human {
        @Override
        protected void sayHello() {
            System.out.println("man say hello");
        }
    }

    static class Woman extends Human {
        @Override
        protected void sayHello() {
            System.out.println("woman say hello");
        }
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        man.sayHello();//man say hello
        woman.sayHello();//woman say hello
        man = new Woman();
        man.sayHello();//woman say hello

    }
}
