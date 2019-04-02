package com.example.jvm.demo.class1.loader.field_analysis;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description: ${description}
 * @ClassName: SubFeildClassTest
 * @Author: yuexx
 * @Date: 2019/1/11 11:00
 * @Version: 1.0
 */
@Slf4j
public class SubFeildClassTest {
    SubFeildClass subFeildClass= new SubFeildClass();

    /**
     *
     */
    @Test
    public void test1(){
//        subFeildClass.subFeildStr
        log.info("按顺序先找子类，再找父类，因子类已经存在，不在找父类， 并且子类权限不能访问故，无法找到该再短 subFeildClass.subFeildStr");
//        subFeildClass.superFeildStr
        log.info("按顺序先找子类，再找父类，父类存在， 但权限不能访问故，无法找到该再短 subFeildClass.subFeildStr");

    }

}