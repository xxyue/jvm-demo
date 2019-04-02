package com.example.jvm.demo.gc;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description: ${description}
 * @ClassName: MinorGCTest
 * @Author: yuexx
 * @Date: 2018/12/17 17:53
 * @Version: 1.0
 */
public class MinorGCTest {

    private MinorGC minorGC = new MinorGC();

    @Test
    public void testAllocation() {
        minorGC.testAllocation();
    }

    @Test
    public void testPretenureSizeThreshold() {

        minorGC.testPretenureSizeThreshold();
    }

    @Test
    public void testTenuringThreshold() {

        minorGC.testTenuringThreshold();
    }

    @Test
    public void testTenuringThreshold2() {
        minorGC.testTenuringThreshold2();
    }

    @Test
    public void testHandlePromotion() {
        minorGC.testHandlePromotion();
    }
}