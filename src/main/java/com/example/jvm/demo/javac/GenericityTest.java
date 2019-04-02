package com.example.jvm.demo.javac;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 泛型
 * @ClassName: GenericityTest
 * @Author: yuexx
 * @Date: 2019/1/18 10:38
 * @Version: 1.0
 */
public class GenericityTest {

    /**
     * 泛型擦除前的例子
     * 手动编写
     */
    public void javacBefor() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("hello", "你好");
        map.put("how are you?", "吃了没？");
        System.out.println(map.get("hello"));
        System.out.println(map.get("how are you?"));
    }

    /**
     * 泛型擦除后的例子
     * javac之后反编译上边的方法
     */
    public void javacAfter() {
        Map map = new HashMap();
        map.put("hello", "你好");
        map.put("how are you?", "吃了没？");
        System.out.println((String) map.get("hello"));
        System.out.println((String) map.get("how are you?"));
    }

}
