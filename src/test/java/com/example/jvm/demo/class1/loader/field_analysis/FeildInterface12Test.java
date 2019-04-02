package com.example.jvm.demo.class1.loader.field_analysis;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description: ${description}
 * @ClassName: FeildInterface12Test
 * @Author: yuexx
 * @Date: 2019/1/11 11:13
 * @Version: 1.0
 */
@Slf4j
public class FeildInterface12Test {

    private FieldClass fieldClass = new FieldClass();

    @Test
    public void test1(){
        //feildStr12 字段只有FeildInterface12中存在
        String a1 = FeildInterface12.feildStr12;
        log.info("{}  当前接口存在改字段， 直接返回该字段索引", a1);
        //feildStr11 FeildInterface12 extends FeildInterface11 都存在
        String a2 = FeildInterface12.feildStr11;
        log.info("{}  当前接口存在改字段， 直接返回该字段索引 , 尽管父类接口也存在，不差往上查询，就近 ", a2);
//        String a3 = FeildInterface12.feildStr;
        log.info("{}  符接口有，但是因为因为是final，是个常量池中字符串不能引用过来，就近 ", a2);
//        fieldClass.;
        String a4 = FeildInterface03.feildStr;


    }
}