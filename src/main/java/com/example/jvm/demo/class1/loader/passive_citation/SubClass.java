package com.example.jvm.demo.class1.loader.passive_citation;

/**
 * @Description: ${description}
 * @ClassName: SunClass
 * @Author: yuexx
 * @Date: 2019/1/9 16:44
 * @Version: 1.0
 */
public class SubClass extends SuperClass {
    static{
        System.out.println("SubClass init！");
    }
}
