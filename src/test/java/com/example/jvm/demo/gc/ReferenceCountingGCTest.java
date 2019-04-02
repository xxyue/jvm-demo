package com.example.jvm.demo.gc;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description: ${description}
 * @ClassName: ReferenceCountingGCTest
 * @Author: yuexx
 * @Date: 2018/12/4 14:35
 * @Version: 1.0
 */
public class ReferenceCountingGCTest {

    private ReferenceCountingGC referenceCountingGC= new ReferenceCountingGC();

    @Test
    public void testGC() {
        ReferenceCountingGC.testGC();
    }
}