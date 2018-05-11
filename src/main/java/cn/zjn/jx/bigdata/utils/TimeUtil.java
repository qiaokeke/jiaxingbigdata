package cn.zjn.jx.bigdata.utils;

import cn.zjn.jx.bigdata.utils.domain.TswkDate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017-12-21 21:39
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
public class TimeUtil {

    public static String TswkSTimeString;
    public static String TswkETimeString;


    //返回去年的12月
    public static String YearSTimeString;
    public static String YearETimeString;

    static {


        //设置本周查询的起始日期
        String formatter = "yyyy-MM-dd";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int d = calendar.get(Calendar.DAY_OF_WEEK)-1;
        if(d==0) d=7;
        TswkSTimeString = new SimpleDateFormat(formatter).format(new Date(new Date().getTime()-d*24*60*60*1000));
        TswkETimeString = new SimpleDateFormat(formatter).format(new Date(new Date().getTime()+24*60*60*1000));



        //设置年份查询的起始日期
        calendar.setTime(new Date());
        int year = calendar.get(Calendar.YEAR);
        calendar.clear();
        calendar.set(Calendar.YEAR, year-1);
        calendar.set(Calendar.MONTH,11);
        YearSTimeString = new SimpleDateFormat(formatter).format(calendar.getTime());
        YearETimeString = new SimpleDateFormat(formatter).format(new Date(new Date().getTime()+24*60*60*1000));



    }



    /**
     *
     * @dep 根据当时时间，返回本周的开始时期和结束日期
     * @return 1代表起始日期，2代表结束日期,3代表本周的天数
     */
    public static Map<Integer,String> getTswkDate(){
        String formatter = "yyyy-MM-dd";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int d = calendar.get(Calendar.DAY_OF_WEEK)-1;
        if(d==0) d=7;
        Map<Integer,String> tswkDateMap = new HashMap();
        tswkDateMap.put(1,new SimpleDateFormat(formatter).format(new Date(new Date().getTime()-d*24*60*60*1000)));
        tswkDateMap.put(2,new SimpleDateFormat(formatter).format(new Date(new Date().getTime()+24*60*60*1000)));
        tswkDateMap.put(3,String.valueOf(d));

        return tswkDateMap;
    }




    /**
     * @dep说明，之后的函数调用新方法。
     * @return
     */
    public static TswkDate getTswkDateFormat(){
        String formatter = "yyyy-MM-dd";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int d = calendar.get(Calendar.DAY_OF_WEEK)-1;
        if(d==0) d=7;
        TswkDate tswkDate = new TswkDate();

        String firstDateString = new SimpleDateFormat(formatter).format(new Date(new Date().getTime()-d*24*60*60*1000));
        String endDateString = new SimpleDateFormat(formatter).format(new Date(new Date().getTime()+24*60*60*1000));

        tswkDate.setFirstDateString(firstDateString);
        tswkDate.setEndDateString(endDateString);
        tswkDate.setCountDayOfWeek(d);
        return tswkDate;
    }




    public static Map<Integer,String >getYdayDate(){
        String formatter = "yyyy-MM-dd";

        Map<Integer,String> tswkDateMap = new HashMap();
        tswkDateMap.put(1,new SimpleDateFormat(formatter).format(new Date(new Date().getTime()-2*24*60*60*1000)));
        tswkDateMap.put(2,new SimpleDateFormat(formatter).format(new Date(new Date().getTime()+60*60*1000)));
        tswkDateMap.put(3,String.valueOf(2));
        return tswkDateMap;
    }


}

