package com.example.jvm.demo.javac;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @Description: 自动装箱、拆箱与遍历循环
 * @ClassName: ForeachTest
 * @Author: yuexx
 * @Date: 2019/1/18 14:15
 * @Version: 1.0
 */
public class ForeachTest {

    public void javcBefor() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        //如果在JDK 1.7中,还有另外一颗语法糖[1]
        //能让上面这句代码进一步简写成List<Integer>list=[1,2,3,4];
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        System.out.println(sum);
    }

    public void javcAfter() {
        List list = Arrays.asList(new Integer[]{
                Integer.valueOf(1),
                Integer.valueOf(2),
                Integer.valueOf(3),
                Integer.valueOf(4)});
        int sum = 0;
        for (Iterator localIterator = list.iterator(); localIterator.hasNext(); ) {
            int i = ((Integer) localIterator.next()).intValue();
            sum += i;
        }
        System.out.println(sum);
    }

    public void javacAboutTrouble() {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d); //true
        System.out.println(e == f); //false
        System.out.println(c == (a + b)); //true
        System.out.println(c.equals(a + b));//true
        System.out.println(g == (a + b)); //true
        System.out.println(g.equals(a + b));//false

    }
}
