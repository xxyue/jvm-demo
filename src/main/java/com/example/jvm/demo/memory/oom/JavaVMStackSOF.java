package com.example.jvm.demo.memory.oom;

/**
 * 虚拟机栈和本地方法栈溢出　（一个线程 不勾搭了 -Xss）
 * Exception in thread"main"java.lang.StackOverflowError
 * <p>
 * VM Args：-Xss128k
 * 每个线程栈容量
 *
 * @author zzm
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom = new JavaVMStackSOF();

        try {
            oom.stackLeak();

        } catch (Throwable e) {

            System.out.println("stack length：" + oom.stackLength);
            throw e;
        }
    }
}