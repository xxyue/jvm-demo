package com.example.jdk;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: ${description}
 * @ClassName: CharDemo
 * @Author: yuexx
 * @Date: 2019/1/10 18:02
 * @Version: 1.0
 */
@Slf4j
public class CharDemo {

    public void charOf0(){
        char char0 = '\u0000';
        log.info("char 类型的0值 为 ： ***{}+++" , char0);
    }
}
