package com.example.jvm.demo.thread.volatile1;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 指令重排序
 * @ClassName: VolatileDemo2
 * @Author: yuexx
 * @Date: 2019/1/21 17:40
 * @Version: 1.0
 */
public class VolatileDemo2 {
    Map<String, String> configOptions;
    char[] configText;
    //此变量必须定义为volatile
    volatile boolean initialized = false;

    public void test() throws InterruptedException{
        //假设以下代码在线程A中执行
        //模拟读取配置信息，当读取完成后将initialized设置为true以通知其他线程配置可用
        configOptions = new HashMap<String, String>();
        String fileName = "";
        configText = readConfigFile(fileName);
        processConfigOptions(configText, configOptions);
        initialized = true;
        //假设以下代码在线程B中执行
        //等待initialized为true，代表线程A已经把配置信息初始化完成
        while (!initialized) {

            Thread.sleep(1);
        }

        //使用线程A中初始化好的配置信息
        doSomethingWithConfig();

    }

    public char[] readConfigFile(String fileName) {
        return null;
    }

    void processConfigOptions(char[] configText, Map map){

    }

    void doSomethingWithConfig(){

    }

}
