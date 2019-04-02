package com.example.jvm.demo.memory.oom;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 *本机直接内存溢出
 * Exception in thread"main"java.lang.OutOfMemoryErr
 *
 *DirectMemory容量可通过-XX：MaxDirectMemorySize指定，如果不指定，则默认与Java
 * 堆最大值（-Xmx指定）一样
 *
 * 由DirectMemory导致的内存溢出，一个明显的特征是在Heap Dump文件中不会看见明显
 * 的异常，如果读者发现OOM之后Dump文件很小，而程序中又直接或间接使用了NIO，那就
 * 可以考虑检查一下是不是这方面的原因
 *
 *VM Args：-Xmx20M-XX：MaxDirectMemorySize=10M
 *@author zzm
 */
public class DirectMemoryOOM{
    private static final int _1MB = 1024*1024;
    public static void main(String[]args)throws Exception{
        Field unsafeField=Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe=(Unsafe)unsafeField.get(null);
        while(true){
            unsafe.allocateMemory(_1MB);
        }
    }

}
