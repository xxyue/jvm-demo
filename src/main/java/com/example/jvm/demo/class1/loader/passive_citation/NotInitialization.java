package com.example.jvm.demo.class1.loader.passive_citation;

/**
 * @Description: 非主动使用类字段演示
 * @ClassName: NotInitialization
 * @Author: yuexx
 * @Date: 2019/1/9 16:46
 * @Version: 1.0
 */
public class NotInitialization {

    /**
     * 被动使用类字段演示一：通过子类引用父类的静态字段，不会导致子类初始化
     *
     * 只会输出“SuperClass init！”，而不会输出“SubClass init！”。对于静
     * 态字段，只有直接定义这个字段的类才会被初始化，因此通过其子类来引用父类中定义的静
     * 态字段，只会触发父类的初始化而不会触发子类的初始化
     */
    public void test1(){
        System.out.println(SubClass.value);
    }

    /**
     *
     * *被动使用类字段演示二：
     * *通过数组定义来引用类，不会触发此类的初始化
     */
    public void test2(){
        SuperClass[] sca = new SuperClass[10];
    }

    /**
     *
     *被动使用类字段演示三：
     *常量在编译阶段会存入调用类的常量池中，本质上并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化。
     *
     * 常量池的引用会转换成本类自己的常量池中，不会真的引用ConstClass的常量池
     *
     *
     */
    public void test3(){
        System.out.println(ConstClass.HELLOWORLD);
    }

    /**
     *
     * 个接口在初始化时，并不要求其父接口全部都完成了初始化，只有在真正使用到父接口的时候（如引用接口中定义的常量）才会初始化
     */
    public void test4(){
        System.out.println(ConstInterface.HELLOWORLD);
    }

    /**
     *
     */
    public void test5(){
        System.out.println(ClassInterface.HELLOWORLD);
    }
}
