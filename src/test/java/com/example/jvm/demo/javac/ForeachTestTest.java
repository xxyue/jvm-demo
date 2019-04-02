package com.example.jvm.demo.javac;

import org.junit.Test;
import scala.collection.parallel.ParIterableLike;

import static org.junit.Assert.*;

/**
 * @Description: ${description}
 * @ClassName: ForeachTestTest
 * @Author: yuexx
 * @Date: 2019/1/18 14:25
 * @Version: 1.0
 */
public class ForeachTestTest {
    ForeachTest foreachTest = new ForeachTest();

    @Test
    public void javacAboutTrouble() {
        foreachTest.javacAboutTrouble();
    }
}