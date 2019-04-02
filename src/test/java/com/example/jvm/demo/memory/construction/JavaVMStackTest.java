package com.example.jvm.demo.memory.construction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @Description: ${description}
 * @ClassName: JavaVMStackTest
 * @Author: yuexx
 * @Date: 2018/12/3 16:50
 * @Version: 1.0
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest@RunWith(SpringRunner.class)
////@SpringBootTest
@RunWith(JUnit4.class)
public class JavaVMStackTest {
//    @Autowired
    private JavaVMStack javaVMStack = new JavaVMStack();

    @Test
    public void changeIntOfmethod() {
        int a = 11;
        System.out.println("调用方法后 int a:" + a );
        javaVMStack.changeIntOfmethod(a);
        System.out.println("调用方法后 int a:" + a );
        System.out.println("方法内 方法外 基本类型数据互补影响，因栈中直接储存真实值！ 故改变的是自己本身 不会影响到其他地方");
    }
    
    @Test
    public void changeIntegerOfmethod() {
        Integer a = 11;
        System.out.println("调用方法后 Integer a:" + a );
        javaVMStack.changeIntegerOfmethod(a);
        System.out.println("调用方法后 Integer a:" + a );
        System.out.println("方法内 方法外 基本类型数据互补影响，因栈中直接储存真实值！ 故改变的是自己本身 不会影响到其他地方");
        System.out.println("参数方法的包装类 java会自动，开箱， 与基本类型相同");
        
    }

    @Test
    public void changeStringOfmethod() {
        String  a = "11";
        System.out.println("调用方法后 String a:" + a );

        javaVMStack.changeStringOfmethod(a);
        System.out.println("调用方法后 String a:" + a );
        System.out.println("String的操作都会修改器栈中的指针地址(并且String的方法都是返回一个new String 指针直接变了)， 故还是原来的， 与newStringBuilderOfmethod 这种方式相同" );

    }

    @Test
    public void changeStringBuilderOfmethod() {
        StringBuilder a =  new StringBuilder();
        a.append("11");
        System.out.println("调用方法后 String a:" + a );
        javaVMStack.changeStringBuilderOfmethod(a);
        System.out.println("调用方法后 String a:" + a );
        System.out.println("参数方法的引用类型 栈中存储的是指针， 故修改数据时 是修改指针指向的堆数据，因指针不变，数据会改变");
    }

    @Test
    public void newStringBuilderOfmethod() {
        StringBuilder a =  new StringBuilder();
        a.append("11");
        System.out.println("调用方法后 String a:" + a );
        javaVMStack.newStringBuilderOfmethod(a);
        System.out.println("调用方法后 String a:" + a );
        System.out.println("因为方法内重新new 了一个新对象， 指针改变， 再做操作不会影响原有数据");
    }

    @Test
    public void changeArrayListOfmethod() {
        ArrayList<String> a =  new ArrayList<String>();
        a.add("11");
        System.out.println("调用方法后 String a:" + a );
        javaVMStack.changeArrayListOfmethod(a);
        System.out.println("调用方法后 String a:" + a );
        System.out.println("参数方法的引用类型 栈中存储的是指针， 故修改数据时 是修改指针指向的堆数据，因指针不变，数据会改变");
    }



}