package com.example.jvm.demo.class1.execution_engine.instruction_set;

/**
 * @Description: 基于栈的解释器执行过程
 * @ClassName: InstructionSetTest
 * @Author: yuexx
 * @Date: 2019/1/17 11:02
 * @Version: 1.0
 */
public class InstructionSetTest {

    /**
     * 段简单的算术代码
     * @return
     */
    public int calc() {
        int a = 100;
        int b = 200;
        int c = 300;
        return (a + b) * c;
    }
}
