package com.example.jvm.demo.class1.loader.field_analysis;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description: ${description}
 * @ClassName: FieldClassTest
 * @Author: yuexx
 * @Date: 2019/1/11 10:51
 * @Version: 1.0
 */
@Slf4j
public class FieldClassTest {

    /**
     *字段在本身，直接返回直接引用
     */
    @Test
    public void testFeildClass(){
        log.info("字段在类本身，直接返回字段， {}", new FieldClass().fieldClass);
    }
}