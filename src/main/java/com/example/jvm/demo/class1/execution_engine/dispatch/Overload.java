package com.example.jvm.demo.class1.execution_engine.dispatch;

import java.io.Serializable;

/**
 * @Description: 重载方法匹配优先级
 * @ClassName: Overload
 * @Author: yuexx
 * @Date: 2019/1/16 14:26
 * @Version: 1.0
 */
public class Overload {

    public static void sayHello(char arg){
        System.out.println("hello char");
    }

    public static void sayHello(int arg){
        System.out.println("hello int");
    }

    public static void sayHello(long arg){
        System.out.println("hello long");
    }
    public static void sayHello(Character arg){
        System.out.println("hello Character");
    }
    public static void sayHello(Integer arg) {
        System.out.println("hello Integer");
    }

    public static void sayHello(Serializable arg) {
        System.out.println("hello Serializable");
    }

    public static void sayHello(Object arg) {
        System.out.println("hello Object");
    }

    // 一个实参个数可变
    public static void sayHello(char... arg) {
        System.out.println("hello char...");
    }

    // 一个实参个数可变
    public static void sayHello(int... arg) {
        System.out.println("hello int...");
    }

    public static void sayHello(long... arg){
        System.out.println("hello long...");
    }

    public static void sayHello(Character... arg){
        System.out.println("hello Character");
    }


    public static void sayHello(Serializable... arg) {
        System.out.println("hello Serializable");
    }

    public static void sayHello(Object... arg) {
        System.out.println("hello Object");
    }

    public static void main(String[] args) {
//        1.基本类型 自动升级 按照byte-＞short-＞char-＞int-＞long-＞float-＞double的顺序转型进行匹配
//        2. 基本类型找不到值 自动装箱该类，但不会转型
//        3.迭代找父类 （如果在同一级父类出现两个，编译不通过）
//        4．可见变长参数 （参考 1,2,3顺序, 123，满足的多参只能是一个）
        //sayHello(char arg) 存在 输出   hello ch　    基本类型升级
        //上边的方法不存在 sayHello(int arg)存在  hello int       基本类型升级
        //上边的方法不存在 sayHello(long arg)存在  hello long       基本类型升级
        //上边的方法不存在 sayHello(Character arg)存在  hello Character  自动装箱
        //上边的方法不存在 sayHello(Serializable arg)存在  hello Serializable 父类
        //上边的方法不存在 sayHello(Object arg)存在  hello Object    父类
        //上边的方法不存在 sayHello(char... arg)存在  hello char...  可见变长参数(不能出现满足多个的123 的多参)
        sayHello('a');
//        sayHello(97L);

    }
}
