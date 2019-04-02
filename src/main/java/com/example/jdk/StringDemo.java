package com.example.jdk;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Description: ${description}
 * @ClassName: StringDemo
 * @Author: yuexx
 * @Date: 2018/12/28 9:38
 * @Version: 1.0
 */
@Component
public class StringDemo {

    public String doBoolean2String(Boolean arg){
       return arg.toString();
    }

    public String doByteArr2String(byte[] arg){
        return arg.toString();

    }

}
