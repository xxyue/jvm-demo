package com.example.jvm.demo.class1.loader.passive_citation;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description: ${description}
 * @ClassName: NotInitializationTest
 * @Author: yuexx
 * @Date: 2019/1/9 16:59
 * @Version: 1.0
 */
public class NotInitializationTest {

    NotInitialization notInitialization = new NotInitialization();


    @Test
    public void test1() {
        notInitialization.test1();
    }

    @Test
    public void test2() {
        notInitialization.test2();
    }

    @Test
    public void test3() {
        notInitialization.test3();
    }

    @Test
    public void test4() {
        notInitialization.test4();
    }

    @Test
    public void test5() {
        notInitialization.test5();
    }
}