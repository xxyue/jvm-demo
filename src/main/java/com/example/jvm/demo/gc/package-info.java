package com.example.jvm.demo.gc;

/**
 * GC
 *
 *　idea打印gc日志的2种方法：
 * １．在vm options处加入-XX:+PrintGCDetails
 * ２．打开idea-help-edit custom vm options...
 *      在文件中加入
 *      -verbose:gc ： 开启gc日志
 *      -XX:+PrintGCDetails ： 打印gc详情
 *      -XX:+PrintGCDateStamps ： 打印gc时间戳
 *      -Xloggc:gcc.log ： 将日志输出到文件xx(默认位置为桌面)
 *
 * 存活的算法:
 * 1.引用计数算法(很难解决对象之间相互循环引用的问题。)
 * 2.可达性分析算法
 *
 *  GC Roots的对象包括下面几种:
 *          1.虚拟机栈（栈帧中的本地变量表）中引用的对象。
 *          2.方法区中类静态属性引用的对象。
 *          3.方法区中常量引用的对象
 *          4.本地方法栈中JNI（即一般说的Native方法）引用的对象。
 *
 *
 * 引用分为
 * 强引用（Strong Reference）、永远不会回收掉
 * 软引用（Soft Reference）、 软引用是用来描述一些还有用但并非必需的对象。 发生内存溢出异常之前，将会把这些对象列进回收范围之中进行第二次回收。
 * 弱引用（Weak Reference）、当垃圾收集器工作时，无论当前内存是否足够，都会回收掉只被弱引用关联的对象
 * 虚引用（Phantom Reference）对象设置虚引用关联的唯一目的就是能在这个对象被收集器回收时收到一个系统通知
 * 4种
 *
 * 垃圾收集算法：
 *   1.标记-清除算法
 *   2.复制算法（年轻代）
 *   3、标记-整理算法（老年代）
 *   4.分代收集算法
 *
 *
 *  垃圾收集器：
 *  1.Serial收集器  在Client模式下的默认新生代收集器（桌面应用）
 *              1、单线程
 *              2、新生代
 *  2.Serial Old收集器（单线程）
 *      Serial/Serial Old 只会使用一个CPU或一条收集线程去完成垃圾收集工作，更重要的是在它进行垃圾收集时，必须暂停其他所有的工作线程，直到它收集结束
 *           1.新生代采取复制算法  Serial
 *            2.老年代采取标记-整理算法 Serial Old
 *  3.ParNew收集器 可以简单的理解为--多条线程进行垃圾收集Serial收集器
 *          1、多线程
 *  *       2、新生代
 *  4.Parallel Scavenge收集器
 *        1.关注点 2
 *       2.复制算法
 *       3。新生代
 *       4.多线程
 *   5.Parallel Old收集器
 *          1.老年代
 *          2.多线程
 *          3.标记-整理
 *
 *    6.CMS收集器（Concurrent Mark Sweep）
 *          1.取最短回收停顿时间为目标
 *          2.“标记—清除”算法
 *                  过程：
 *                      初始标记（CMS initial mark）
 *                      并发标记（CMS concurrent mark）
 *                      重新标记（CMS remark）
 *                      并发清除（CMS concurrent sweep）
 *
 *           缺点：
 *                  1.无法处理浮动垃圾
 *                  2.有大量空间碎片产生
 *   7.G1收集器
 *      特点：
 *          1.并行与并发
 *          2.分代收集
 *          3.空间整合 --整体来看 标记—整理         两个Region之间  复制
 *          4.可预测的停顿：
 *        过程：
 *              初始标记（Initial Marking）
 *              并发标记（Concurrent Marking）
 *              最终标记（Final Marking）
 *              筛选回收（Live Data Counting and Evacuation）
 *
 *
 *  垃圾回收器关注点：
 *  1.尽可能地缩短垃圾收集时用户线程的停顿时间
 *  2.达到一个可控制的吞吐量（Throughput）（适合在后台运算而不需要太多交互的任务。）
 *      每次停顿时间
 *      吞吐量（虚拟机总时间中（吞吐量=运行用户代码时间/（运行用户代码时间+垃圾收集时间）））
 *      新生代内存大小
 *
 *
 * 内存分配规则：
 *      1.对象优先在Eden分配   （Minor GC）
 *      2.大对象直接进入老年代 --很长的字符串以及数组
 *      3.长期存活的对象将进入老年代 age(一次Minor GC +1) 默认age>15  放入老年代  -XX:MaxTenuringThreshold
 *      4.动态对象年龄判定  (在Survivor空间中相同年龄所有对象大小的总 和大于Survivor空间的一半 ，年龄大于或等于该年龄的对象就可以直接进入老年代)
 *      5.空间分配担保
 *              1)老年代最大可用的连续空间是否大于新生代所有对象总空间   是-->Minor GC可  否 -->2）
 *              2)HandlePromotionFailure 是否允许担保失败  是-->3)  否：Full GC  （JDK 6 Update 24之后该参数不再使用 ，但可以理解为默认是）
 *              3）老年代最大可用的连续空间是否大于历次晋升到老年代对象的平均大小  是-->尝试有风险的Minor GC  否 -->Full GC
 *
 *
 *
 * SUN JDK 监控和故障处理工具：
 *1. JDK 命令行工具
 *    工具目录：\jdk1.8.0_181\bin （这些命令行工具大多数是jdk/lib/tools.jar类库的一层薄包装而已  ---tools.jar\sun\tools ）
 *
 *      1、jps   -- JVM Process Status Tool  显示指定系统内所有的HotSpot虚拟机进程
 *              jps　[options]　[hostid]    hostid为RMI注册表中注册的主机名  例：jps -l
 *                      -q  只输出LVMID,省略主类名称
 *                      -m  输出虚拟机进程启动时传递给主类main()函数的参数
 *                      -l  输出主类全名，如果进程执行的是jar包，输出jar路径
 *                      -v  输出虚拟机进程启动时JVM参数
 *
 *      2、jstat --JVM Statistics Monitoring Tool 用于收集HotSpot虚拟机各方面的运行数据
 *             jstat　[option 　vmid　[interval[s|ms][count]]]    参数interval和count代表查询间隔和次数  例：jstat-gc 2764 250 20   每250毫秒查询一次进程2764垃圾收集状况，一共查询20次
 *                      -calss      监视类装载、卸载数量、总空间以及类装载所耗费的时间
 *                      -gc         监视java对状况，包含Eden区，两个survivor区、老年代、永久代等的容量，已用空间，GC时间合计等信息
 *                      -gccapatity 监视内容与-gc基本相同，但输出主要关注java堆各区域使用到的最大，最小空间
 *                      -gcutil     监视内容与-gc基本相同，但输出主要关注已使用空间占用总空间的百分比
 *                      -gccause    与-gcutil功能一样，但会额外输出导致上一次GC的原因
 *                      -gcnew      监视新生代GC状况
 *                      -gcnewcapatity  监视内容与-gcnew基本相同，但输出主要关注使用到的最大，最小空间
 *                      -gcold      监视老年代GC状况
 *                      -gcoldcapatity  监视内容与-gcold基本相同，但输出主要关注使用到的最大，最小空间
 *                      -gcpermcapatity 输出永久代使用的最大，最小空间
 *                      -compiler       输出JIT编译器编译过的方法、耗时等信息
 *                      -printcompilation   输出已经被JIT编译的方法
 *
 *      3、jinfo -- Configuration Info for Java 显示虚拟机配置信息
 *              jinfo　[option]　pid            例：jinfo -glags 23172
 *                      -flag <name>  打印VM参数名为name的值
 *                      -flag [+|-]<name>  VM参数名为name是否可使用 + ：可， -：不能
 *                      -flag <name>=<value>  设置VM参数
 *                      -flags  打印所有VM参数
 *                      -sysprops   进程的System.getProperties（）的内容打印出来
 *
 *      4、jmap  --Memory Map for java 生成虚拟机的内存存储快照（heapdump文件）
 *              jmap　[option]　vmid
 *                      -dump       生成java堆转存快照。格式为：-dump:[live, ]format=b,file=<filename>, 其中；live子参数说明是否只dump出存货的对象
 *                      -finalizerinfo  显示在F-Queue中等待Finalizer线程执行finalize方法的对象。只在Linux/Solaris平台下有效
 *                      -heap       显示java堆详细信息，如使用哪种回收器，参数配置，分代情况等。只在Linux/Solaris平台下有效
 *                      -histo      线束堆中对象统计信息，包括类、实例数量、合计容量
 *                      -pernstat   以ClassLoader为统计口径显示永久代内存状态。只在Linux/Solaris平台下有效
 *                      -F          当虚拟机进程对-dump选项没有响应时，可使用这个选项强制生成dump快照。只在Linux/Solaris平台下有效
 *      5、jhat  --JVM Heap Dump Browser 用于分析heapdump文件，他会穿件一个HTTP/HTML服务器，让用户可以在浏览器上查看分析结果
 *              jhat [-stack <bool>] [-refs <bool>] [-port <port>] [-baseline <file>] [-debug <int>] [-version] [-h|help] <file>  因使用场景很少就不列举参数意义，可help 自己查看
 *                   默认所有bool为true
 *                  屏幕显示“Server is ready.”的提示后，用户在浏览器中键入http://localhost：7000/就可以看到分析结果，
 *
 *      6、jstack    --Stack Trace for java 显示虚拟机线程快照（一般称为threaddump或者javacore文件）　使用场景：如线程间死锁、死循环、请求外部资源导致的长时间等待等都是导致线程长时间停顿的常见原因
 *              jstack　[option]　vmid
 *                         -F       当正常输出的请求不做相应时，强制输出线程堆栈
 *                         -l       除对站外，显示当前锁的附加信息
 *                         -m       如果调用到本地方法的话，可以显示C/C++的堆栈
 *       7、HSDIS        --JIT生成代码反汇编
 *                  -XX：+PrintAssembly指令调用它来把动态生成的本地代码还原为汇编代码输出，同时还生成了大量非常有价值的注释，
 *                      Product版的HotSpot，那还要额外加入 -XX：+UnlockDiagnosticVMOptions参数
 *
 *2.JDK的可视化工具
 *
 *              1.JConsole：Java监视与管理控制台
 *              2.VisualVM：多合一故障处理工具
 *                      VisualVM可以做到：
 *                          显示虚拟机进程以及进程的配置、环境信息（jps、jinfo）。
 *                          监视应用程序的CPU、GC、堆、方法区以及线程的信息（jstat、jstack）。
 *                          dump以及分析堆转储快照（jmap、jhat）。
 *                          方法级的程序运行性能分析，找出被调用最多、运行时间最长的方法。
 *                          离线程序快照：收集程序的运行时配置、线程dump、内存dump等信息建立一个快照，可以将快照发送开发者处进行Bug反馈。
 *                          其他plugins的无限的可能性。。。。
 *
 * ------------------------------------------------------------------------------------------------------------
 *  调优案例分析与实战
 *          在高性能硬件上部署程序，目前主要有两种方式：
 *                  1.通过64位JDK来使用大内存。（需要控制 Full GC频率 (最好晚上定时触发，或重启) 请求级或者页面级的，会话级和全局级的长生命对象相对很少）
 *                  2.使用若干个32位虚拟机建立逻辑集群来利用硬件资源
 *
 *          集群间同步导致的内存溢出
 *                   1.不应当有过于频繁的写操作，那样会带来很大的网络同步的开销
 *
 *          堆外内存导致的溢出错误
 *                   1.NIO操作需要使用到Direct Memory内存,
 *                   注意事项:
 *                             1.Direct Memory：可通过-XX：MaxDirectMemorySize调整大小，内存不足时抛出OutOfMemoryError或者OutOfMemoryError：Direct buffer memory。
 *                             2.线程堆栈：可通过-Xss调整大小，内存不足时抛出StackOverflowError（纵向无法分配，即无法分配新的栈帧）或者OutOfMemoryError：unable to create new native thread（横向无法分配，即无法建立新的线程）
 *                             3.Socket缓存区：每个Socket连接都Receive和Send两个缓存区，分别占大约37KB和25KB内 存，连接多的话这块内存占用也比较可观。如果无法分配，则可能会抛出IOException：Too many open files异常。
 *                             4.JNI代码：如果代码中使用JNI调用本地库，那本地库使用的内存也不在堆中。
 *                             5.虚拟机和GC：虚拟机、GC的代码执行也要消耗一定的内存。
 *
 *           外部命令导致系统缓慢
 *
 *           服务器JVM进程崩溃
 *                      异步处理时请求与返回的速度严重不对等导致
 *                      等待的线程堆积
 *                      Socket连接堆积
 *
 *                  1.异步调用改为生产者/消费者模式的消息队列
 *
 *           不恰当数据结构导致内存占用过大
 *                  导致原因，在minor GC时 有到两对象生存而不是理想中的“朝生夕灭”
 *
 *           由Windows虚拟内存导致的长时间停顿
 *
 *
 *
 * map<long,long>小号的内存  （Long（24B）×2）+Entry（32B）+HashMap Ref（8B）=88B，空间效率为16B/88B=18%，
 * Long（24B）=long+对象头(MarkWord + Klass) =8+（8+8）
 * Entry（32B） = 对象头(MarkWord + Klass)  + next + int hash = （8+8） + 8 + （4 + 空白补齐4）
 *
 *
 *          三大块非用户程序时间：
 *                  1、Compile Time  编译时间        JIT编译器（Just In Time Compiler）编译热点代码（Hot Spot Code）的耗时
 *                          提升JDK 版本
 *                  2、Class Load Time  类加载时间
 *                          提升JDK 版本
 *                          参数-Xverify：none禁止掉字节码验证过程
 *                  3、GC Time
 *                          调整内存设置控制垃圾收集频率
 *                              1.频繁增加相应代内存
 *                              2.不频繁但是耗时长 更具GC日志 如因每次都是扩容是增大最小内存，或者指定与最大相同，避免自动扩展
 *
 *
 *
 *
 *
 */
