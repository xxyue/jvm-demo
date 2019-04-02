package com.example.jvm.demo.gc;

/**
 * 在大量使用反射、动态代理、CGLib等ByteCode框架、动态生成JSP以及OSGi这类频繁
 * 自定义ClassLoader的场景都需要虚拟机具备类卸载的功能，以保证永久代不会溢出
 *
 * 垃圾收集算法：
 *  1.标记-清除算法
 *  2.复制算法（年轻代）
 *  3、标记-整理算法（老年代）
 *  4.分代收集算法
 *
 */
public class JavaMethodAreaGC {
}
