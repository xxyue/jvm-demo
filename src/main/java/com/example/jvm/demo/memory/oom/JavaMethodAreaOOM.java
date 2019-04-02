package com.example.jvm.demo.memory.oom;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 借助CGLib使方法区出现内存溢出异常
 * Caused by：java.lang.OutOfMemoryError：PermGen space
 *
 * 动态生成Class
 * 1.CGLib字节码增强和动态语言
 * 2.大量JSP或动态产生JSP文件的应用（JSP第一次运行时需要编译为Java类）
 * 3.基于OSGi的应用（即使是同一个类文件，被不同的加载器加载也会视为不同的类）
 *
 *
 *VM Args：-XX：PermSize=10M-XX：MaxPermSize=10M
 *@author zzm
 */
public class JavaMethodAreaOOM{
    public static void main(String[]args){
        while(true){
            Enhancer enhancer=new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor(){
                public Object intercept(Object obj, Method method, Object[]args, MethodProxy proxy)throws Throwable{
                    return proxy.invokeSuper(obj,args);
                }
            });

            enhancer.create();
        }
    }
    static class OOMObject{
    }
}