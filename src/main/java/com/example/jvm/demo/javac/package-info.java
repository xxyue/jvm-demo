package com.example.jvm.demo.javac;

/**
 *  Javac编译器
 *      大致处理过程
 *              1.解析与填充符号表过程
 *                      语法分析和词法分析
 *                      填充符号表
 *              2.插入式注解处理器的注解处理过程。
 *              3.分析与字节码生成过程
 *                      语义分析
 *                          标注检查
 *                              变量使用前是否已被声明、变量与赋值之间的数据类型是否能够匹配等
 *                          数据、控制流分析
 *                              局部变量在使用前是否有赋值
 *                              方法的每条路径是否都有返回值
 *                              是否所有的受查异常都被正确处理了等
 *                          解语法糖（糖衣语法）   ---虚拟机运行时不支持这些语法，它们在编译阶段还原回简单的基础语法结构，这个过程称为解语法糖
 *                                  泛型
 *                                  变长参数
 *                                  自动装箱/拆箱
 *                      字节码生成
 *                             转化成字节码写到磁盘中
 *
 *
 * Java语法糖的味道
 *              泛型与类型擦除
 *              自动装箱、拆箱与遍历循环
 *              条件编译
 *
 *
 */
