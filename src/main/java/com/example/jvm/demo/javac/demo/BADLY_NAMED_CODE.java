package com.example.jvm.demo.javac.demo;

/**
 * @Description: 包含了多处不规范命名的代码样例
 * @ClassName: BADLY_NAMED_CODE
 * @Author: yuexx
 * @Date: 2019/1/18 15:22
 * @Version: 1.0
 */
public class BADLY_NAMED_CODE {
    enum colors {
        red, blue, green;
    }

    static final int _FORTY_TWO = 42;
    public static int NOT_A_CONSTANT = _FORTY_TWO;

    protected void BADLY_NAMED_CODE() {
        return;
    }

    public void NOTcamelCASEmethodNAME() {
        return;
    }
}