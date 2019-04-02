package com.example.jvm.demo.class1.loader.passive_citation;

/**
 * @Description: ${description}
 * @ClassName: ConstClass
 * @Author: yuexx
 * @Date: 2019/1/9 17:14
 * @Version: 1.0
 */
public class ConstClass {

    static{
        System.out.println("ConstClass init！");
    }
    public static final String HELLOWORLD = "hello world";
}
