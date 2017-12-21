package cn.zjn.jx.bigdata.web.api;

import cn.zjn.jx.bigdata.domain.power.PowerMeterZXYGDNRecordView;
import cn.zjn.jx.bigdata.domain.power.PowerZXYGDNHoursInfo;
import cn.zjn.jx.bigdata.domain.power.PowerZXYGDNHoursView;
import cn.zjn.jx.bigdata.domain.powerandwater.PowerWaterZRecordView;
import cn.zjn.jx.bigdata.service.pwoer.PowerService;
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


}
