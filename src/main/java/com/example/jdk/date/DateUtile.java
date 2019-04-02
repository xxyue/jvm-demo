package com.example.jdk.date;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: ${description}
 * @ClassName: DateUtile
 * @Author: yuexx
 * @Date: 2019/1/7 16:24
 * @Version: 1.0
 */
@Slf4j
public class DateUtile {

    /**
     * 获得某个月最大天数
     *
     * @param year 年份
     * @param month 月份 (1-12)
     * @return 某个月最大天数
     */
    public int getMaxDayByYearMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        return calendar.getActualMaximum(Calendar.DATE);
    }

    public Map<String, String> doDayAll(){
        //天
        ///////////////////////调用数据库得到的数据/////////////////////////
        Map<String, String> dayMap = new HashMap<String, String>();//假设sql 抓出来的数据
        dayMap.put("1","10");
        ///////////////////////补齐24小时数据/////////////////////////
        Map<String, String> day24Map = new HashMap<String, String>();//假设sql 抓出来的数据
        for (int i = 0; i < 24; i++){
            String key = Integer.toString(i);
            String value =dayMap.get(key);
            //当没有数据时变0
            if(StringUtils.isBlank(value)){
                value = "0";
            }
            day24Map.put(key, value);

        }

        //测试结果
        for (String key : day24Map.keySet()) {
            log.info("测试结果  key：{},value:{} \n",key,day24Map.get(key));

        }

        return day24Map;
    }


    public Map<String, String> doMonthAll(){
        //月
        ///////////////////////调用数据库得到的数据/////////////////////////
        Map<String, String> monthMap = new HashMap<String, String>();//假设sql 抓出来的数据
        monthMap.put("2","10");
        ///////////////////////补齐12月数据/////////////////////////
        Map<String, String> month12Map = new HashMap<String, String>();//假设sql 抓出来的数据
        for (int i = 0; i < 12; i++){
            String key = Integer.toString(i);
            String value =month12Map.get(key);
            //当没有数据时变0
            if(StringUtils.isBlank(value)){
                value = "0";
            }
            month12Map.put(key, value);
        }
        //测试结果
        for (String key : month12Map.keySet()) {
            log.info("测试结果  key：{},value:{} \n",key,month12Map.get(key));
        }
        return month12Map;
    }

    public static void main(String[] args){
        int year = LocalDate.now().getYear();
        log.info("year : {}", year);
        int month = LocalDate.now().getMonth().getValue();
        log.info("month : {}", month);
        int day = LocalDate.now().getDayOfMonth();
        log.info("day : {}", day);
       int maxDay = new DateUtile().getMaxDayByYearMonth(2019,2);
        log.info("maxDay : {}", maxDay);
//        new DateUtile().doDayAll();
        new DateUtile().doMonthAll();




    }


}
