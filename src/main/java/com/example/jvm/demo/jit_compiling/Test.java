package com.example.jvm.demo.jit_compiling;

/**
 * @Description: ${description}
 * @ClassName: Test
 * @Author: yuexx
 * @Date: 2019/1/18 16:19
 * @Version: 1.0
 */
public class Test {
    public static final int NUM = 15000;

    public static int doubleValue(int i) {
        //这个空循环用于后面演示JIT代码优化过程
        for (int j = 0; j < 100000; j++) ;
        return i * 2;
    }

    public static long calcSum() {
        long sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += doubleValue(i);
        }
        return sum;
    }
    //-XX:+PrintCompilation  打印即时编译信息 将被编译成本地代码的方法名称打印出来
    //-XX:+PrintInlining  虚拟机输出方法内联信息   必须在这个环境下 才可以 使用-XX:+UnlockDiagnosticVMOptions

    public static void main(String[] args) {
        for (int i = 0; i < NUM; i++) {
            calcSum();
        }
    }

}
