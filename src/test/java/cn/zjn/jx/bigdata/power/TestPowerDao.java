package cn.zjn.jx.bigdata.power;

import cn.zjn.jx.bigdata.dao.power.PowerDao;
import cn.zjn.jx.bigdata.domain.power.*;
import cn.zjn.jx.bigdata.utils.TimeUtil;
import cn.zjn.jx.bigdata.utils.domain.TswkDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017-12-21 18:50
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPowerDao {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PowerDao powerDao;
    @Test
    public void testPowerMeterNewRecordInfo(){
        List<PowerMeterZXYGDNRecordInfo> powerMeterZXYGDNRecordInfoList = powerDao.selectPowerZXYGDNRecordInfos();
        logger.info(String.valueOf(powerMeterZXYGDNRecordInfoList.size()));
        for (PowerMeterZXYGDNRecordInfo powerMeterZXYGDNRecordInfo : powerMeterZXYGDNRecordInfoList){
            logger.info(powerMeterZXYGDNRecordInfo.toString());
        }
    }

    @Test
    public void testPowerHoursInfos(){
        List<PowerZXYGDNHoursInfo> infos = powerDao.selectPowerZXYGDNHoursInfosByCompanyCode("3");
        logger.info(String.valueOf(infos.size()));
        for(PowerZXYGDNHoursInfo info:infos)
            logger.info(info.toString());
    }

    @Test
    public void testSelectPowerZJFPGInfos(){
        List<PowerZJFPGInfo> infos = powerDao.selectPowerZJFPGInfosByCompanyCodeAndTime("2","2017-12-24","2017-12-28");

        for (PowerZJFPGInfo info:infos)
            System.out.println(info);

    }

    @Test
    public void testselectPowerZJFPGInfosBypCodeAndTime(){
        List<PowerZJFPGInfo> infos = powerDao.selectPowerZJFPGInfosBypCodeAndTime("65381","2017-12-24","2017-12-28");
        for (PowerZJFPGInfo info:infos)
            System.out.println(info);

    }


    @Test
    public void testSelectDayinfos(){

        TswkDate tswkDate = TimeUtil.getTswkDateFormat();
        List<PowerZXYGDNInfo> infos = powerDao.selectPowerZXYGDNDayInfosBypCodeAndTime("65381",TimeUtil.TswkSTimeString,TimeUtil.TswkETimeString);

        for (PowerZXYGDNInfo info:infos)
            System.out.println(info);
    }

    @Test
    public void testSelectDayinfosbyCompanycode(){

        TswkDate tswkDate = TimeUtil.getTswkDateFormat();
        List<PowerZXYGDNInfo> infos = powerDao.selectPowerZXYGDNDayInfosBycompanyCodeAndTime("1",tswkDate.getFirstDateString(),tswkDate.getEndDateString());

        for (PowerZXYGDNInfo info:infos)
            System.out.println(info);
    }

    @Test
    public void testSelectMonthInfosbyCompanycode(){
        System.out.println(TimeUtil.YearSTimeString+"  "+ TimeUtil.YearETimeString);
        List<PowerZXYGDNInfo> infos = powerDao.selectPowerZXYGDNMonthInfosBycompanyCodeAndTime("1",TimeUtil.YearSTimeString,TimeUtil.YearETimeString);

        for (PowerZXYGDNInfo info:infos)
            System.out.println(info);
    }
    @Test
    public void testSelectMonthInfosbyPcode(){
        System.out.println(TimeUtil.YearSTimeString+"  "+ TimeUtil.YearETimeString);
        List<PowerZXYGDNInfo> infos = powerDao.selectPowerZXYGDNMonthInfosBypCodeAndTime("65381",TimeUtil.YearSTimeString,TimeUtil.YearETimeString);


        for (PowerZXYGDNInfo info:infos)
            System.out.println(info);
    }


}
