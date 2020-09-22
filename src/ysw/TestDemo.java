package ysw;

import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/9/13 15:20
 * @Version
 **/
public class TestDemo {

    @Test
    public void test() throws Exception {
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = format1.parse("2020-09-01");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        Date date2 = format2.parse("2020-09-30");
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);
        long time1 = cal1.getTimeInMillis();
        long time2 = cal2.getTimeInMillis();
        int between_days = (int) (Math.abs(time2 - time1) / (1000 * 3600 * 24));
        System.out.println(between_days);
    }

    @Test
    public void test1(){
        Long l=2012L;
        System.out.println(2012^2013);
    }
}