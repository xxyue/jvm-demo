package com.example.jdk;

import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;


/**
 * @Description: ${description}
 * @ClassName: StringDemoTest
 * @Author: yuexx
 * @Date: 2018/12/28 9:40
 * @Version: 1.0
 */
@Slf4j
public class StringDemoTest {

    private StringDemo stringDemo = new StringDemo();

    /**
     * 测试boolean类型转成String
     * 场景： 当同一个参数 在不同的系统返回的 可能是boolean 或者 String
     *         只需要把两个都转换成String 作比较即可
     *
     */
    @Test
    public void doBoolean2String() {


        boolean flag = true;
        String re = stringDemo.doBoolean2String(flag);
        Assert.assertNotNull(re);
        log.info("doBoolean2String 请求值为：{}，  返回值为：{}", flag, re);
    }




    @Test
    public void doByteArr2String() {
      UserDemo user =  new UserDemo();
      user.setAge("11");
      user.setName("猪");
      String jsonUser = JSONObject.toJSONString(user);
      log.info("doByteArr2String  User2JsonString  - jsonUser :  {}",jsonUser);
      byte[] bytes = JSONObject.toJSONString(user).getBytes();
//      log.info("doByteArr2String  User2JsonString2ByteArr- bytes :  {}",bytes);
//      String userStr = JSONObject.parseObject(bytes, String.class);
//      log.info("doByteArr2String  ByteArr2JsonString -- userStr :  {}",userStr);
//      UserDemo user1 =JSONObject.parseObject(userStr, UserDemo.class);
//      log.info("doByteArr2String JsonString2User - user1 :  {}",user1);
      UserDemo user2 =JSONObject.parseObject(bytes, UserDemo.class);
      log.info("doByteArr2String JsonString2User - user2 :  {}",user2);




    }
}