package com.example.jvm.demo.memory.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * Java堆内存溢出
 *
 *VM Args：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 将堆的最小值-Xms参数与最 大值-Xmx参数设置为一样即可避免堆自动扩展
 *
 * 当出现Java堆内存溢出时，异常堆栈信息“java.lang.OutOfMemoryError”会跟着进一步提示“Java heap space”
 *
 * 内存泄漏（Memory Leak）
 * 是内存溢出（Memory Overflow）
 *@author zzm
 */
public class HeapOOM{

    //静态内部类
    static class OOMObject{

    }

    public static void main(String[] args){
        List<OOMObject> list=new ArrayList<OOMObject>();
        while(true){

            list.add(new OOMObject());
//            System.out.println(1);
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e){
//
//            }
        }

    }

}
