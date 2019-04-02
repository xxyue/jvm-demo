package com.example.jvm.demo.class1.execution_engine.dispatch;

/**
 * @Description: 单分派和多分派
 * @ClassName: Dispatch
 * @Author: yuexx
 * @Date: 2019/1/16 16:02
 * @Version: 1.0
 */
public class Dispatch {
    static class QQ {
    }

    static class _360 {
    }

    public static class Father {
        public void hardChoice(QQ arg) {
            System.out.println("father choose qq");
        }

        public void hardChoice(_360 arg) {
            System.out.println("father choose 360");
        }
    }

    public static class Son extends Father {
        public void hardChoice(QQ arg) {
            System.out.println("son choose qq");
        }

        public void hardChoice(_360 arg) {
            System.out.println("son choose 360");
        }
    }

    public static void main(String[] args) {
        Father father = new Father();
        Father son = new Son();
        father.hardChoice(new _360());//father choose 360
        son.hardChoice(new QQ());//son choose qq
    }
}
