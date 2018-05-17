package cn.zjn.jx.bigdata.service.pwoer;

import cn.zjn.jx.bigdata.domain.power.*;
import cn.zjn.jx.bigdata.domain.powerandwater.PowerWaterZRecordView;
import cn.zjn.jx.bigdata.domain.xls.PowerAllView;
import org.apache.poi.ss.usermodel.Workbook;

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

    public List<PowerZJFPGView> selectTswkPowerZJFPGViewsByCompanyCodeOrpCode(String companyCode,String pCode);

    public PowerZJFPGView selectYdayPowerZJFPGViewByCompanyCode(String companyCode);


    public List<PowerZXYGDNView> selectTswkPowerZXYGDNDayViewsByCompanyCodeOrPCode(String companyCode, String pCode);

    public List<PowerZXYGDNView> selectYearPowerZXYGDNMonthViewsByCompanyCodeOrPCode(String companyCode, String pCode);

    public List<PowerZXYGDNView> selectTsMonthPowerZXYGDNDayViewsByCompanyCodeOrPCode(String companyCode, String pCode);

    public List<PowerZXYGDNView> selectTDayPowerZXYGDNHourViewsByCompanyCodeOrPCode(String companyCode, String pCode);

    public List<PowerZXYGDNView> selectDayPowerZXYGDNHourViewsByCompanyCodeOrPCodeAndTime(String companyCode, String pCode, String time);

    public List<PowerZXYGDNView> selectTswkPowerZXYGDNHourViewsByCompanyCodeOrPCode(String companyCode, String pCode);

    public List<PowerZJFPGView> selectMonthPowerZJFPGDayViwesByCompanyCodeOrPCode(String companyCode, String pCode);

    public List<PowerZJFPGView> selectMonthPowerZJFPGDayViwesByCompanyCodeOrPCodeAndTime(String companyCode, String pCode,String time);

    public List<PowerAllView> selectPowerAllViews();

    public Workbook getPowerAllViewsWorkbook();
}
