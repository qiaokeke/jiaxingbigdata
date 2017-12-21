package cn.zjn.jx.bigdata.power;

import cn.zjn.jx.bigdata.dao.power.PowerDao;
import cn.zjn.jx.bigdata.domain.power.PowerMeterZXYGDNRecordInfo;
import cn.zjn.jx.bigdata.domain.power.PowerZXYGDNHoursInfo;
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
        List<PowerZXYGDNHoursInfo> infos = powerDao.selectPowerZXYGDNHoursInfos("1");
        logger.info(String.valueOf(infos.size()));
        for(PowerZXYGDNHoursInfo info:infos)
            logger.info(info.toString());
    }


}
