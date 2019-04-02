package com.example.jvm.demo.memory;

/**
 *
 * 内存
 * 详情看 processon 的内存结构图
 * https://www.processon.com/diagraming/5bee336ae4b0993bf72e1c6a
 *
 * 运行时栈帧结构：
 *      1.局部变量表 (大小在编译class文件时已经确定最大容量)
 *             局部变量表（Local Variable Table）是一组变量值存储空间，用于存放方法参数和方法内部定义的局部变量
 *             （注意不包含类变量，以及对象变量，局部变量表中第0位索引的Slot默认是用于传递方法所属对象实例的引用）。
 *     2.操作数栈
 *             是一个后入先出（Last In First Out,LIFO）栈
 *             (正在处理的字节码指令 需要的数据)
 *      3.动态连接
 *             指向运行时常量池[1]中该栈帧所属方法的引用，持有这个引用是为了支持方法调用过程中的动态连接（Dynamic Linking）
 *      4.方法返回地址
 *           调整PC计数器的值以指向方法调用指令后面的一条指令地址
 *                  退出方式：
 *                          1）为正常完成出口（Normal Method Invocation Completion）
 *                          2）异常完成出口（Abrupt Method Invocation Completion）
 *      5.附加信息
 *
 *     一般会把动态连接、方法返回地址与其他附加信息全部归为一类，称为栈帧信息。
 *
 * 方法区：
 *          方法表
 *          类数据
 *
 *
 *
 *
 */

