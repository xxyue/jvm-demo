package com.example.jvm.demo.class1.loader.field_analysis;

/**
 * @Description: ${description}
 * @ClassName: FieldResolution
 * @Author: yuexx
 * @Date: 2019/1/11 11:29
 * @Version: 1.0
 */
public class FieldResolution {

    interface Interface0{
        int A = 0;
        int G = 0;
        int M= 0;
    }
    interface Interface1 extends Interface0{
        int A = 1;
        int B = 1;
        int F = 1;
        int M= 1;
    }
    interface Interface2{
        int A=2;
        int B=2;
        int C=2;
        int E=2;
    }
    static class Parent implements Interface1 {
         public static int A = 3;
        public static int C = 3;
        public static int D = 3;
    }
    static class Sub extends Parent implements Interface2 {
        public static int A = 4;
    }
    public static void main(String[]args){
        System.out.println(Sub.A);//如果本类有，不关心父类
//        System.out.println(Sub.B);//当父类（包含接口）重复的不知道用哪个故不可用该字段
//        System.out.println(Sub.C);////当父类（包含接口）重复的不知道用哪个故不可用该字段
        System.out.println(Sub.D);
        System.out.println(Sub.E);
        System.out.println(Sub.F);
        System.out.println(Sub.G);
        System.out.println(Sub.M);
        
        System.out.println("只要不在统一及的继承中存在相同的字段即可！，以就近原则");
    }
}
