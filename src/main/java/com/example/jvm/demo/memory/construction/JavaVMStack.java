package com.example.jvm.demo.memory.construction;

import java.util.ArrayList;

/**
 * @Description: 测试栈内数据 方法的影响
 * @ClassName: JavaVMStack
 * @Author: yuexx
 * @Date: 2018/12/3 16:46
 * @Version: 1.0
 */
public class JavaVMStack {


    public void changeIntOfmethod(int a){
        a= 22;
        System.out.println("方法内 Int a ： " + a );
    }

    public void changeIntegerOfmethod(Integer a){
        a= new Integer(22);
        System.out.println("方法内 Integer a ： " + a );
    }


    public void changeStringOfmethod(String a){
        System.out.println(a);
        a= "22";
        System.out.println("方法内 String  a ： " + a );
    }

    public void changeStringBuilderOfmethod(StringBuilder a){
        a.append("22");
        System.out.println("方法内 String  a ： " + a );
    }

    public void newStringBuilderOfmethod(StringBuilder a){
        a = new StringBuilder(a);
        a.append("22");
        System.out.println("方法内 String  a ： " + a );
    }

    public void changeArrayListOfmethod(ArrayList<String> a){
        a.add("22");
        System.out.println("方法内 ArrayList<String>  a ： " + a );
    }

}
