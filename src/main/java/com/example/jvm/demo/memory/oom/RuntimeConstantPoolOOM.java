package com.example.jvm.demo.memory.oom;


import java.util.ArrayList;
import java.util.List;

/**
 *运行时常量池导致的内存溢出
 * Exception in thread"main"java.lang.OutOfMemoryError：PermGen space
 *
 *VM Args：-XX:PermSize=10M -XX:MaxPermSize=10M
 *
 * 1.6及之前的版本中，由 于常量池分配在永久代内，我们可以通过-XX：PermSize和-XX：MaxPermSize限制方法区大 小，从而间接限制其中常量池的容量
 * JDK 1.7运行这段程序就不会得到相同的结果，while循环将一直进行下去
 *
 *@author zzm
 */
public class RuntimeConstantPoolOOM{

    public static void main(String[]args){
        List<String> list=new ArrayList<String>();
        //10MB的PermSize在integer范围内足够产生OOM了
        int i=0;
        while(true){
            list.add(String.valueOf(i++).intern());
        }
    }


}


/**
 * 字符串常量池的实现问题，还可以引申出一个更有意思的影响
 * JDK 1.6中运行，会得到两个false
 * JDK 1.7中运行，会得到一个true和一个false。产
 *
 * 在JDK 1.6中，intern（）方法会把首次遇到的字符串实例复制 到永久代中，返回的也是永久代中这个字符串实例的引用，而由StringBuilder创建的字符串实例在Java堆上故 必然不是同一个引用
 *  JDK 1.7 中，intern（）实现不会再复制实例，只是在常量池中记录首次出现的实例引用
 *
 */
class RuntimeConstantPoolOOM1{
    public static void main(String[] args){
        String str1=new StringBuilder("计算机").append("软件").toString();//首次出现
        System.out.println(str1.intern()==str1);
        String str2=new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern()==str2);
    }
}

