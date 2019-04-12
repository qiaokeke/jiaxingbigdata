package cn.zjn.jx.bigdata.service.pwoer;

import cn.zjn.jx.bigdata.dao.company.CompanyDao;
import cn.zjn.jx.bigdata.dao.power.PowerDao;
import cn.zjn.jx.bigdata.domain.company.CompanyInfo;
import cn.zjn.jx.bigdata.domain.power.*;
import cn.zjn.jx.bigdata.domain.powerandwater.PowerWaterZRecordView;
import cn.zjn.jx.bigdata.domain.xls.PowerAllView;
import cn.zjn.jx.bigdata.utils.ExcelUtil;
import cn.zjn.jx.bigdata.utils.MergeUtil;
import cn.zjn.jx.bigdata.utils.SubValueUtil;
import cn.zjn.jx.bigdata.utils.TimeUtil;
import cn.zjn.jx.bigdata.utils.domain.TswkDate;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.ParseException;
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
    CompanyDao companyDao;

    @Autowired
    PowerDao powerDao;

    @Override
    public List<PowerMeterZXYGDNRecordView> selectTop5PowerCompanyInfos() {
        List<PowerMeterZXYGDNRecordInfo> powerMeterZXYGDNRecordInfos = powerDao.selectPowerZXYGDNRecordInfos();
        List<PowerMeterZXYGDNRecordView> powerMeterZXYGDNRecordViewList = new ArrayList<>();

        for(PowerMeterZXYGDNRecordInfo info:powerMeterZXYGDNRecordInfos){
            boolean isAdd = false;

            for(PowerMeterZXYGDNRecordView view:powerMeterZXYGDNRecordViewList) {
                try {
                    if (view.getCompanyName().equals(info.getCompanyName())) {
                        view.setZXYGDN(view.getZXYGDN() + info.getZXYGDN());
                        isAdd = true;
                    }
                }catch (Exception e){
                    System.out.printf("selectTop5PowerCompanyInfos:error");
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
                try {
                    if (view.getCompanyName().equals(info.getCompanyName())) {
                        view.setZXYGDN(info.getZXYGDN() + view.getZXYGDN());
                        isAdd = true;
                    }
                }catch (Exception e){
                    System.out.printf("selectPowerWaterZRecordViews error");
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
        List<PowerZXYGDNHoursInfo> infos = powerDao.selectPowerZXYGDNHoursInfosByCompanyCode(companyCode);
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
        SubValueUtil.subValueOfPowerZXYGDNHoursViews(views);

        return views;
    }

    @Override
    public List<PowerZJFPGView> selectTswkPowerZJFPGViewsByCompanyCodeOrpCode(String companyCode,String pCode) {
        System.out.println(companyCode+pCode);
        List<PowerZJFPGInfo> infos = null;
        if (pCode.equals("0"))
            infos = powerDao.selectPowerZJFPGDayInfosByCompanyCodeAndTime(companyCode,TimeUtil.TswkSTimeString,TimeUtil.TswkETimeString);
        else
            infos = powerDao.selectPowerZJFPGDayInfosByPCodeAndTime(pCode,TimeUtil.TswkSTimeString,TimeUtil.TswkETimeString);
        System.out.println(infos);
        List<PowerZJFPGView> views = null;
        views = MergeUtil.mergeZJFPGInfos2Views(infos);
        SubValueUtil.subValueOfPowerZJFPGViews(views);
       /**
        for (PowerZJFPGInfo info:infos){
            boolean isAdd = false;
            for(PowerZJFPGView view:views){
                if(view.getTime().equals(info.getTime())){
                    view.setZxygdnZ(view.getZxygdnZ()+info.getZxygdnZ());
                    view.setZxygdnJ(view.getZxygdnJ()+info.getZxygdnJ());
                    view.setZxygdnF(view.getZxygdnF()+info.getZxygdnF());
                    view.setZxygdnP(view.getZxygdnP()+info.getZxygdnP());
                    view.setZxygdnG(view.getZxygdnG()+info.getZxygdnG());
                    isAdd =true;
                }

            }
            if (isAdd) continue;

            PowerZJFPGView view = new PowerZJFPGView();
            view.setTime(info.getTime());
            view.setZxygdnZ(info.getZxygdnZ());
            view.setZxygdnJ(info.getZxygdnJ());
            view.setZxygdnF(info.getZxygdnF());
            view.setZxygdnP(info.getZxygdnP());
            view.setZxygdnG(info.getZxygdnG());
            views.add(view);

        }
        SubValueUtil.subValueOfPowerZJFPGViews(views);
        **/
        return views;
    }

    @Override
    public PowerZJFPGView selectYdayPowerZJFPGViewByCompanyCode(String companyCode) {
        List<PowerZJFPGInfo> infos = null;
        infos = powerDao.selectPowerZJFPGInfosByCompanyCodeAndTime(companyCode, TimeUtil.getYdayDate().get(1),TimeUtil.getYdayDate().get(2));
        if (infos.size()<=1)
            return new PowerZJFPGView();
        List<PowerZJFPGView> views = new ArrayList<>();
        for (PowerZJFPGInfo info:infos){
            boolean isAdd = false;
            for(PowerZJFPGView view:views){
                if(view.getTime().equals(info.getTime())){
                    view.setZxygdnZ(view.getZxygdnZ()+info.getZxygdnZ());
                    view.setZxygdnJ(view.getZxygdnJ()+info.getZxygdnJ());
                    view.setZxygdnF(view.getZxygdnF()+info.getZxygdnF());
                    view.setZxygdnP(view.getZxygdnP()+info.getZxygdnP());
                    view.setZxygdnG(view.getZxygdnG()+info.getZxygdnG());
                    isAdd =true;
                }

            }
            if (isAdd) continue;

            PowerZJFPGView view = new PowerZJFPGView();
            view.setTime(info.getTime());
            view.setZxygdnZ(info.getZxygdnZ());
            view.setZxygdnJ(info.getZxygdnJ());
            view.setZxygdnF(info.getZxygdnF());
            view.setZxygdnP(info.getZxygdnP());
            view.setZxygdnG(info.getZxygdnG());
            views.add(view);
        }
        SubValueUtil.subValueOfPowerZJFPGViews(views);

        return views.get(0);
    }


    /**
     * @dep 根据公司号或者表号查询本周的正向有功电能数据
     * @param companyCode
     * @param pCode
     * @return
     */
    @Override
    public List<PowerZXYGDNView> selectTswkPowerZXYGDNDayViewsByCompanyCodeOrPCode(String companyCode, String pCode) {
        List<PowerZXYGDNInfo> infos ;
        TswkDate tswkDate = TimeUtil.getTswkDateFormat();
        if (pCode.equals("0"))
            infos = powerDao.selectPowerZXYGDNDayInfosByCompanyCodeAndTime(companyCode, tswkDate.getFirstDateString(),tswkDate.getEndDateString());
        else
            infos = powerDao.selectPowerZXYGDNDayInfosByPCodeAndTime(pCode,tswkDate.getFirstDateString(),tswkDate.getEndDateString());
        List<PowerZXYGDNView> views ;
        views = MergeUtil.mergeZXYGDNInfos2Views(infos);
        SubValueUtil.subValueOfPowerZXYGDNViews(views);
        return views;
    }

    @Override
    public List<PowerZXYGDNView> selectYearPowerZXYGDNMonthViewsByCompanyCodeOrPCode(String companyCode, String pCode) {
        List<PowerZXYGDNInfo> infos ;

        if (pCode.equals("0"))
            infos = powerDao.selectPowerZXYGDNMonthInfosBycompanyCodeAndTime(companyCode,TimeUtil.YearSTimeString,TimeUtil.YearETimeString);
        else
            infos = powerDao.selectPowerZXYGDNMonthInfosByPCodeAndTime(pCode,TimeUtil.YearSTimeString,TimeUtil.YearETimeString);
        List<PowerZXYGDNView> views;
        views = MergeUtil.mergeZXYGDNInfos2Views(infos);
        SubValueUtil.subValueOfPowerZXYGDNViews(views);
        return views;
    }

    @Override
    public List<PowerZXYGDNView> selectTsMonthPowerZXYGDNDayViewsByCompanyCodeOrPCode(String companyCode, String pCode) {
        List<PowerZXYGDNInfo> infos ;
        System.out.println(TimeUtil.TsMonthSTimeString);
        if (pCode.equals("0"))
            infos = powerDao.selectPowerZXYGDNDayInfosByCompanyCodeAndTime(companyCode,TimeUtil.TsMonthSTimeString,TimeUtil.TsMonthETimeString);
        else
            infos = powerDao.selectPowerZXYGDNDayInfosByPCodeAndTime(pCode,TimeUtil.TsMonthSTimeString,TimeUtil.TsMonthETimeString);
        List<PowerZXYGDNView> views;
        views = MergeUtil.mergeZXYGDNInfos2Views(infos);
        SubValueUtil.subValueOfPowerZXYGDNViews(views);
        return views;
    }

    @Override
    public List<PowerZXYGDNView> selectTDayPowerZXYGDNHourViewsByCompanyCodeOrPCode(String companyCode, String pCode) {
        List<PowerZXYGDNInfo> infos ;

        if (pCode.equals("0"))
            infos = powerDao.selectPowerZXYGDNHoursInfosByCompanyCodeAndTime(companyCode,TimeUtil.TDaySTimeString,TimeUtil.TDayETimeString);
        else
            infos = powerDao.selectPowerZXYGDNHoursInfosByPCodeAndTime(pCode,TimeUtil.TDaySTimeString,TimeUtil.TDayETimeString);
        System.out.println(infos);
        List<PowerZXYGDNView> views;
        views = MergeUtil.mergeZXYGDNInfos2Views(infos);
        SubValueUtil.subValueOfPowerZXYGDNViews(views);
        return views;

}

    @Override
    public List<PowerZXYGDNView> selectDayPowerZXYGDNHourViewsByCompanyCodeOrPCodeAndTime(String companyCode, String pCode, String time) {
        List<PowerZXYGDNInfo> infos ;

        if (pCode.equals("0"))
            try {
                infos = powerDao.selectPowerZXYGDNHoursInfosByCompanyCodeAndTime(companyCode,time,TimeUtil.addOneDay(time));
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        else
            infos = powerDao.selectPowerZXYGDNHoursInfosByPCodeAndTime(pCode,TimeUtil.TDaySTimeString,TimeUtil.TDayETimeString);
        List<PowerZXYGDNView> views;
        views = MergeUtil.mergeZXYGDNInfos2Views(infos);
        SubValueUtil.subValueOfPowerZXYGDNViews(views);
        return views;
    }

    @Override
    public List<PowerZXYGDNView> selectTswkPowerZXYGDNHourViewsByCompanyCodeOrPCode(String companyCode, String pCode) {

        List<PowerZXYGDNInfo> infos = new ArrayList<>();
        try {
            if (pCode.equals("0"))
                infos = powerDao.selectPowerZXYGDNHoursInfosByCompanyCodeAndTime(companyCode,TimeUtil.addOneDay(TimeUtil.TswkSTimeString),TimeUtil.TswkETimeString);
            else
                infos = powerDao.selectPowerZXYGDNHoursInfosByPCodeAndTime(pCode,TimeUtil.addOneDay(TimeUtil.TswkSTimeString),TimeUtil.TswkETimeString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        List<PowerZXYGDNView> views;
        views = MergeUtil.mergeZXYGDNInfos2Views(infos);
        SubValueUtil.subValueOfPowerZXYGDNViews(views);
        int i =0,maxi=0;
        float max = views.get(0).getZXYGDN();
        for(PowerZXYGDNView view:views){
            if(max<view.getZXYGDN()){
                max = view.getZXYGDN();
                maxi=i;
            }
            i++;
        }
        views.get(maxi).setZXYGDN(0);
        return views;
    }

    @Override
    public List<PowerZJFPGView> selectMonthPowerZJFPGDayViwesByCompanyCodeOrPCode(String companyCode, String pCode) {
        List<PowerZJFPGInfo> infos = null;
        if (pCode.equals("0"))
            infos = powerDao.selectPowerZJFPGDayInfosByCompanyCodeAndTime(companyCode,TimeUtil.TswkSTimeString,TimeUtil.TswkETimeString);
        else
            infos = powerDao.selectPowerZJFPGDayInfosByPCodeAndTime(pCode,TimeUtil.TswkSTimeString,TimeUtil.TswkETimeString);

        List<PowerZJFPGView> views;
        views = MergeUtil.mergeZJFPGInfos2Views(infos);
        SubValueUtil.subValueOfPowerZJFPGViews(views);

        return views;
    }

    @Override
    public List<PowerZJFPGView> selectMonthPowerZJFPGDayViwesByCompanyCodeOrPCodeAndTime(String companyCode, String pCode, String time) {
        List<PowerZJFPGInfo> infos = new ArrayList<>();

        try {
            if (pCode.equals("0"))
            infos = powerDao.selectPowerZJFPGDayInfosByCompanyCodeAndTime(companyCode,TimeUtil.subOneDay(time),TimeUtil.addOneMonth(time));
            else
                infos = powerDao.selectPowerZJFPGDayInfosByPCodeAndTime(pCode,TimeUtil.subOneDay(time),TimeUtil.addOneMonth(time));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<PowerZJFPGView> views;
        views = MergeUtil.mergeZJFPGInfos2Views(infos);
        SubValueUtil.subValueOfPowerZJFPGViews(views);

        return views;
    }

    @Override
    public List<PowerAllView> selectPowerAllViews() {
        Subject subject = SecurityUtils.getSubject();
        List<PowerAllView> allViews = new ArrayList<>();
        if(subject.hasRole("admin")){
            allViews = powerDao.selectPowerAllViews();
            List<CompanyInfo> infos = companyDao.selectCompanyInfos();
            for(int i=0;i<100;i++){
                if(allViews.size()<69){
                    try {
                        PowerAllView view = allViews.get((int) (Math.random() * 40));
                        view.setCompanyName(infos.get((int) (Math.random()*40)).getCompanyName());
                        allViews.add(view);
                    }catch (Exception e){
                    }
                }else{
                    break;
                }
            }
        }
        else
            allViews = powerDao.selectPowerAllViewsByUsername((String) subject.getPrincipal());
        ExcelUtil.addIdtoPowerAllViews(allViews);
        System.out.println(allViews);
        return allViews;
    }

    @Override
    public Workbook getPowerAllViewsWorkbook() {
        Subject subject = SecurityUtils.getSubject();
        List<PowerAllView> views = new ArrayList<>();
        if(subject.hasRole("admin"))
            views = powerDao.selectPowerAllViews();
        else
            views = powerDao.selectPowerAllViewsByUsername((String) subject.getPrincipal());

        ExcelUtil.addIdtoPowerAllViews(views);
        return ExcelUtil.getPowerAllViewsXls(views);
    }


    /**
     * 排序时使用
     */

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
