package com.example.jvm.demo.jit_compiling;

/**
 *即时编译器
 *
 *
 *      解释器
 *      编译器
 *              Client Compiler     C1编译器
 *              Server Compiler     C2编译器也叫Opto编译器
 *
 *
 *   被即时编译器编译的“热点代码”有两类
 *            被多次调用的方法。
 *            被多次执行的循环体。
 *
 *    热点探测判定方式有两种：
 *          基于采样的热点探测（Sample Based Hot Spot Detection）
 *          基于计数器的热点探测（Counter Based Hot Spot Detection）（HotSpot虚拟）
 *                  方法调用计数器（Invocation Counter）
 *                              阈值：-XX：CompileThreshold （默认c1-15000 C2-10000）（两种计数器和达到阈值申请JIT编译，已经编译过的直接使用JIT编译后的不在计数）
 *                              热度衰减开关：-XX：-UseCounterDecay
 *                              半衰期时长（秒）  -XX：CounterHalfLifeTime
 *                  回边计数器（Back EdgeCounter）（循环体）（触发OSR编译。）(无衰减)
 *                            阈值：
 *                                   C1:方法调用计数器阈值（CompileThreshold）×OSR比率（OnStackReplacePercentage）/100   --OnStackReplacePercentage（默认933）
 *                                   C2:方法调用计数器阈值（CompileThreshold）×（OSR比率（OnStackReplacePercentage）-解释器监控比率（InterpreterProfilePercentage）/100
 *                                                      -- OnStackReplacePercentage默认值为140，InterpreterProfilePercentage默认值为33
 *
 *
 *
 *
 */

