package com.example.jvm.demo.memory.oom;

/**
 * 虚拟机栈和本地方法栈溢出 (多个线程 ，无内存飞陪下一个栈)
 *
 *VM Args：-Xss2M(这时候不妨设置大些)
 *
 * 注意 尝试运行改代码，请保存当前工作，由于Windows中，java线程映射到系统内核线程上的，
 * 因此此代码执行时有较大风险，可能导致操作系统假死。
 *@author zzm
 */
public class JavaVMStackOOM{

    private void dontStop(){
        while(true){
        }
    }

    public void stackLeakByThread(){
        while(true){
            Thread thread=new Thread(new Runnable(){
                @Override
                public void run(){
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[]args)throws Throwable{
        JavaVMStackOOM oom=new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
