package cn.zjn.jx.bigdata.service.pwoer;

import cn.zjn.jx.bigdata.domain.power.PowerMeterZXYGDNRecordView;
import cn.zjn.jx.bigdata.domain.power.PowerZXYGDNHoursInfo;
import cn.zjn.jx.bigdata.domain.power.PowerZXYGDNHoursView;
import cn.zjn.jx.bigdata.domain.powerandwater.PowerWaterZRecordView;

import java.util.List;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017-12-21 18:57
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
public interface PowerService {

    public List<PowerMeterZXYGDNRecordView> selectTop5PowerCompanyInfos();

    public List<PowerWaterZRecordView> selectPowerWaterZRecordViews();

    public List<PowerZXYGDNHoursView> selectPowerZXYGDNHousrViews(String companyCode);
}
