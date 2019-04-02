package com.example.jvm.demo.javac;

/**
 * @Description: ${description}
 * @ClassName: IfTest
 * @Author: yuexx
 * @Date: 2019/1/18 14:38
 * @Version: 1.0
 */
public class IfTest {
    /**
     * 编译会去掉else分支
     * class 反编译 将只有一行数据代码
     */
    public void javacBeforOfIf() {
        if (true) {
            System.out.println("block 1");
        } else {
            System.out.println("block 2");
        }
    }

    /**
     * 对比class文件中两个方法的javap 信息相同
     */
    public void javacAfterOfIf() {
        System.out.println("block 1");
    }

    /**
     * 当是个变量是就会有分支
     */
    public void javacBeforOfIf2() {
        boolean flage = false;
        flage = true;
        if (flage) {//ifeq
            System.out.println("block 1");
        } else {//goto
            System.out.println("block 2");
        }
    }

    /**
     * 当是个变量是就会有分支
     */
    public void javacBeforOfIf3() {
        String flage = "2";
        if ("1".equals(flage)) {//ifeq
            System.out.println("block 1");
            //goto
        } else if("2".equals(flage)){//ifeq
            System.out.println("block 2");

            //goto
        }else {
            System.out.println("block 3");
        }
    }

    /**
     * 不能使用其他条件语句来完成条件编译
     */
    public void javacBeforOfWhile1() {
        ///编译器将会提示“Unreachable code”
//        while (false){
//          System.out.println("");
//        }
    }


}
