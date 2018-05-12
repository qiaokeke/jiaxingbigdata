package cn.zjn.jx.bigdata.web.api;

import cn.zjn.jx.bigdata.domain.power.*;
import cn.zjn.jx.bigdata.domain.powerandwater.PowerWaterZRecordView;
import cn.zjn.jx.bigdata.service.pwoer.PowerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017-12-21 20:34
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */

@RestController
@RequestMapping("/jx/api")
public class PowerApi {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PowerService powerService;

    @RequestMapping("/top5Companys")
    public List<PowerMeterZXYGDNRecordView> getTop5Companys(){
        return powerService.selectTop5PowerCompanyInfos();
    }

    @RequestMapping("/realTimeCompanys")
    public List<PowerWaterZRecordView> getRealTimeCompanys(){
        return powerService.selectPowerWaterZRecordViews();
    }

    /**
     * 后期加上水的
     * @param companyCode
     * @return
     */
    @RequestMapping("/hoursViews")
    public List<PowerZXYGDNHoursView> getRealTimeHoursViews(@RequestParam("companyCode")String companyCode){
        return powerService.selectPowerZXYGDNHousrViews(companyCode);
    }



    @RequestMapping("/tswkZJFPGViews")
    public List<PowerZJFPGView> getTswkZJFPGViews(@RequestParam("companyCode")String companyCode,@RequestParam("pCode") String pCode){
        //logger.info(pCode);
        return powerService.selectTswkPowerZJFPGViewsByCompanyCodeOrpCode(companyCode,pCode);
    }

    @RequestMapping("/tswkZXYGDNViews")
    public List<PowerZXYGDNView> getTswkZXYGDNViews(@RequestParam("companyCode")String companyCode, @RequestParam("pCode") String pCode){
        //logger.info(pCode);
        return powerService.selectTswkPowerZXYGDNDayViewsByCompanyCodeOrPCode(companyCode,pCode);
    }

    @RequestMapping("/yearZXYGDNMonthViews")
    public List<PowerZXYGDNView> getYearZXYGDNMonthViews(@RequestParam("companyCode")String companyCode, @RequestParam("pCode") String pCode){
        return powerService.selectYearPowerZXYGDNMonthViewsByCompanyCodeOrPCode(companyCode,pCode);
    }

    @RequestMapping("/tDayZXYGDNHourViews")
    public List<PowerZXYGDNView> getTDayZXYGDNViews(@RequestParam("companyCode")String companyCode, @RequestParam("pCode") String pCode){
        return powerService.selectTDayPowerZXYGDNHourViewsByCompanyCodeOrPCode(companyCode,pCode);
    }

    @RequestMapping("/dayZXYGDNHourViews")
    public List<PowerZXYGDNView> getDayZXYGDNViewsByTime(@RequestParam("companyCode")String companyCode, @RequestParam("pCode") String pCode,@RequestParam("time") String time){
        return powerService.selectDayPowerZXYGDNHourViewsByCompanyCodeOrPCodeAndTime(companyCode,pCode,time);
    }

    @RequestMapping("/tsMonthZXYGDNDayViews")
    public List<PowerZXYGDNView> gtTsMonthZXYGDNDayViews(@RequestParam("companyCode")String companyCode, @RequestParam("pCode") String pCode){
        return powerService.selectTsMonthPowerZXYGDNDayViewsByCompanyCodeOrPCode(companyCode,pCode);
    }

    @RequestMapping("/ydayZJFPGView")
    public PowerZJFPGView getYdayZJFPGView(@RequestParam("companyCode") String companyCode){
        return powerService.selectYdayPowerZJFPGViewByCompanyCode(companyCode);
    }


    @RequestMapping("/tswkZXYGDNHourViews")
    public List<PowerZXYGDNView> getTswkZXYGDNHourViews(@RequestParam("companyCode")String companyCode, @RequestParam("pCode") String pCode){
        return powerService.selectTswkPowerZXYGDNHourViewsByCompanyCodeOrPCode(companyCode,pCode);
    }

    @RequestMapping("/monthZJFPGDayViews")
    public List<PowerZJFPGView> getTsMonthZJFPGDayViewsByTime(@RequestParam("companyCode")String companyCode, @RequestParam("pCode") String pCode,@RequestParam("time") String time){
        return powerService.selectMonthPowerZJFPGDayViwesByCompanyCodeOrPCodeAndTime(companyCode,pCode,time);
    }
}
