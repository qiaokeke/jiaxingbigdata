package cn.zjn.jx.bigdata.power;

import cn.zjn.jx.bigdata.domain.power.*;
import cn.zjn.jx.bigdata.service.pwoer.PowerService;
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
 * @Date: Created in 2017-12-21 19:45
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPowerService {


    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    PowerService powerService;

    @Test
    public void testTop5(){
        List<PowerMeterZXYGDNRecordView> views = powerService.selectTop5PowerCompanyInfos();
        
        for(PowerMeterZXYGDNRecordView view:views){
            logger.info(view.toString());
        }
    }

    @Test
    public void testPowerZJFPG(){
        List<PowerZJFPGView> views = powerService.selectTswkPowerZJFPGViewsByCompanyCodeOrpCode("1","0");
        for (PowerZJFPGView view:views)
            logger.info(view.toString());
    }

    @Test
    public void testPowerDayViews(){
        List<PowerZXYGDNView>  views = powerService.selectTswkPowerZXYGDNDayViewsByCompanyCodeOrPCode("1","0");
        for (PowerZXYGDNView view : views)
            logger.info(view.toString());
    }

    @Test
    public void testPowerTDAYViews(){
        List<PowerZXYGDNView>  views = powerService.selectTDayPowerZXYGDNHourViewsByCompanyCodeOrPCode("2","0");
        for (PowerZXYGDNView view : views)
            logger.info(view.toString());
    }



}
