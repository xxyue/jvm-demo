package com.example.jvm.demo.class1.loader.initialization;

/**
 * @Description: ${description}
 * @ClassName: Test
 * @Author: yuexx
 * @Date: 2019/1/11 14:02
 * @Version: 1.0
 */
public class Test{

    //////////静态语句块在前可以赋值，但是不能访问////////////
    static{
    i = 0;//给变量赋值可以正常编译通过
//    System.out.print(i);//这句编译器会提示"非法向前引用"
    }
    static int i=1;
    static {
        System.out.print(i);//这句编译器会正常
    }

    ///////////////////父类中定义的静态语句块要优先于子类的变量赋值操作//////////////////////

    static class Parent{
        public static int A=1;
        static{
            A=2;
        }
    }
    static class Sub extends Parent{
        public static int B=A;
    }
    public static void main(String[]args){
        System.out.println("***********: " + Sub.B);
    }



}
