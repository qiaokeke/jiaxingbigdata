package cn.zjn.jx.bigdata.service.pwoer;

import cn.zjn.jx.bigdata.dao.power.PowerDao;
import cn.zjn.jx.bigdata.domain.power.PowerMeterZXYGDNRecordInfo;
import cn.zjn.jx.bigdata.domain.power.PowerMeterZXYGDNRecordView;
import cn.zjn.jx.bigdata.domain.power.PowerZXYGDNHoursInfo;
import cn.zjn.jx.bigdata.domain.power.PowerZXYGDNHoursView;
import cn.zjn.jx.bigdata.domain.powerandwater.PowerWaterZRecordView;
import cn.zjn.jx.bigdata.utils.SubValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017-12-21 19:03
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
@Service
public class PowerServiceImpl implements PowerService {

    @Autowired
    PowerDao powerDao;

    @Override
    public List<PowerMeterZXYGDNRecordView> selectTop5PowerCompanyInfos() {
        List<PowerMeterZXYGDNRecordInfo> powerMeterZXYGDNRecordInfos = powerDao.selectPowerZXYGDNRecordInfos();
        List<PowerMeterZXYGDNRecordView> powerMeterZXYGDNRecordViewList = new ArrayList<>();

        for(PowerMeterZXYGDNRecordInfo info:powerMeterZXYGDNRecordInfos){
            boolean isAdd = false;

            for(PowerMeterZXYGDNRecordView view:powerMeterZXYGDNRecordViewList) {
                if (view.getCompanyName().equals(info.getCompanyName())) {
                    view.setZXYGDN(view.getZXYGDN() + info.getZXYGDN());
                    isAdd = true;
                }
            }
            if(isAdd) continue;

            PowerMeterZXYGDNRecordView view = new PowerMeterZXYGDNRecordView();
            view.setCompanyName(info.getCompanyName());
            view.setZXYGDN(info.getZXYGDN());
            powerMeterZXYGDNRecordViewList.add(view);
        }

        Collections.sort(powerMeterZXYGDNRecordViewList,new PowerMeterZXYGDNRecordViewCompare());
        return powerMeterZXYGDNRecordViewList;
    }

    @Override
    public List<PowerWaterZRecordView> selectPowerWaterZRecordViews() {
        List<PowerMeterZXYGDNRecordInfo> infos = powerDao.selectPowerZXYGDNRecordInfos();
        List<PowerWaterZRecordView> views = new ArrayList<>();
        for(PowerMeterZXYGDNRecordInfo info:infos){
            boolean isAdd = false;
            for(PowerWaterZRecordView view:views){
                if(view.getCompanyName().equals(info.getCompanyName())){
                    view.setZXYGDN(info.getZXYGDN()+view.getZXYGDN());
                    isAdd = true;
                }
            }

            if(isAdd) continue;

            PowerWaterZRecordView view = new PowerWaterZRecordView();
            view.setCompanyName(info.getCompanyName());
            view.setZXYGDN(info.getZXYGDN());
            view.setWaterValue(0);
            views.add(view);
        }

        Collections.sort(views,new PowerWaterZRecordViewCompare());
        return views;
    }

    @Override
    public List<PowerZXYGDNHoursView> selectPowerZXYGDNHousrViews(String companyCode) {
        List<PowerZXYGDNHoursInfo> infos = powerDao.selectPowerZXYGDNHoursInfos(companyCode);
        List<PowerZXYGDNHoursView> views = new ArrayList<>();

        for(PowerZXYGDNHoursInfo info:infos){

            boolean isAdd = false;
            for(PowerZXYGDNHoursView view:views){
                if(view.getHour()==info.getHour()){
                    view.setZXYGDN(view.getZXYGDN()+info.getZXYGDN());
                    isAdd=true;
                }
            }
            if(isAdd)continue;

            PowerZXYGDNHoursView view = new PowerZXYGDNHoursView();
            view.setHour(info.getHour());
            view.setZXYGDN(info.getZXYGDN());

            views.add(view);

        }
        SubValueUtil.subValue(views);

        return views;
    }


    class PowerMeterZXYGDNRecordViewCompare implements Comparator{

        @Override
        public int compare(Object o1, Object o2) {
            PowerMeterZXYGDNRecordView view1 = (PowerMeterZXYGDNRecordView) o1;
            PowerMeterZXYGDNRecordView view2 = (PowerMeterZXYGDNRecordView) o2;

            float v1 = view1.getZXYGDN();
            float v2 = view2.getZXYGDN();

            if(v1>v2)
                return -1;
            if(v1<v2)
                return 1;

            return 0;
        }
    }

    class PowerWaterZRecordViewCompare implements Comparator{

        @Override
        public int compare(Object o1, Object o2) {
            PowerWaterZRecordView view1 = (PowerWaterZRecordView) o1;
            PowerWaterZRecordView view2 = (PowerWaterZRecordView) o2;
            float v1 = view1.getZXYGDN();
            float v2 = view2.getZXYGDN();

            if (v1>v2)
                return -1;
            if (v1<v2)
                return 1;
            float w1 = view1.getWaterValue();
            float w2 = view2.getWaterValue();
            if(w1>w2)
                return -1;
            if(w1<w2)
                return 1;
            return 0;
        }
    }

}
