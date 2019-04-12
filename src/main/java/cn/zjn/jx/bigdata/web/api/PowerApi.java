package cn.zjn.jx.bigdata.web.api;

import cn.zjn.jx.bigdata.domain.power.*;
import cn.zjn.jx.bigdata.domain.powerandwater.PowerWaterZRecordView;
import cn.zjn.jx.bigdata.domain.xls.PowerAllView;
import cn.zjn.jx.bigdata.service.pwoer.PowerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
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
    public String getTop5CompanysStrings(){
        return "[{\"companyName\":\"嘉兴敏胜汽车零部件有限公司\",\"zxygdn\":30052.89},{\"companyName\":\"嘉兴进隆塑业\",\"zxygdn\":23683.95},{\"companyName\":\"亮兮柯电气有限公司\",\"zxygdn\":11314.83},{\"companyName\":\"万思佳电器(嘉兴)有限公司\",\"zxygdn\":10872.64},{\"companyName\":\"嘉兴有成包装有限公司\",\"zxygdn\":9999.99},{\"companyName\":\"嘉兴市忠辉药业有限责任公司\",\"zxygdn\":9053.57},{\"companyName\":\"浙江安宁生物科技有限公司\",\"zxygdn\":6184.87},{\"companyName\":\"捷顺旅游制品有限公司\",\"zxygdn\":5758.12},{\"companyName\":\"浙江天正智能电器有限公司\",\"zxygdn\":4167.99},{\"companyName\":\"浙江宏业检测科技有限公司\",\"zxygdn\":3135.8198},{\"companyName\":\"嘉兴市新时代包装彩印有限公司\",\"zxygdn\":2880.16},{\"companyName\":\"浙江恒欣建筑设计股份有限公司\",\"zxygdn\":2692.71},{\"companyName\":\"嘉兴立家母婴用品有限公司\",\"zxygdn\":2513.3},{\"companyName\":\"浙江顺联智能设备有限公司\",\"zxygdn\":2184.43},{\"companyName\":\"嘉兴市华晟助剂有限公司\",\"zxygdn\":2029.16},{\"companyName\":\"沃尔德\",\"zxygdn\":2001.02},{\"companyName\":\"赛捷弹簧制\",\"zxygdn\":1921.08},{\"companyName\":\"浙江南阜\",\"zxygdn\":1779.55},{\"companyName\":\"嘉兴郑鲜机械有限公司\",\"zxygdn\":1663.24},{\"companyName\":\"嘉兴思可达机械制造有限公司\",\"zxygdn\":1652.94},{\"companyName\":\"浙江森永光电设备有限公司\",\"zxygdn\":1518.41},{\"companyName\":\"浙江瑞翌新材料科技有限公司\",\"zxygdn\":1206.72},{\"companyName\":\"赛捷弹簧\",\"zxygdn\":1113.56},{\"companyName\":\"浙江远中冠兴自动化科技有限公司\",\"zxygdn\":904.53},{\"companyName\":\"嘉兴市华信科教仪器有限公司\",\"zxygdn\":429.02},{\"companyName\":null,\"zxygdn\":0.0},{\"companyName\":\"浙江福莱特玻璃有限公司\",\"zxygdn\":0.0},{\"companyName\":\"嘉兴丰利汇织造有限公司\",\"zxygdn\":0.0},{\"companyName\":\"嘉兴李朝化纤有限公司\",\"zxygdn\":0.0},{\"companyName\":\"浙江曜良纺织有限公司\",\"zxygdn\":0.0},{\"companyName\":\"浙江生辉照明有限公司\",\"zxygdn\":0.0},{\"companyName\":\"嘉兴市兴嘉汽车零部件制造有限公司\",\"zxygdn\":0.0},{\"companyName\":\"浙江三和机电科技有限公司\",\"zxygdn\":0.0},{\"companyName\":\"上澎太阳能科技（嘉兴）有限公司\",\"zxygdn\":0.0},{\"companyName\":\"嘉兴欣龙染整有限公司\",\"zxygdn\":0.0},{\"companyName\":\"浙江芬齐涂料密封胶有限公司\",\"zxygdn\":0.0},{\"companyName\":\"浙江雅莹集团有限公司\",\"zxygdn\":0.0},{\"companyName\":\"嘉兴山蒲照明电器有限公司\",\"zxygdn\":0.0},{\"companyName\":\"恩龙实业（嘉兴）有限公司\",\"zxygdn\":0.0},{\"companyName\":\"世源科技（嘉兴）医疗电子有限公司\",\"zxygdn\":0.0},{\"companyName\":\"耐思电气(嘉兴)有限公司\",\"zxygdn\":0.0},{\"companyName\":\"浙江凯发新材料有限公司\",\"zxygdn\":0.0},{\"companyName\":\"嘉兴捷顺旅游制品有限公司\",\"zxygdn\":0.0},{\"companyName\":\"嘉兴市捷豪清洁用品有限公司\",\"zxygdn\":0.0},{\"companyName\":\"珂纳电气机械股份有限公司\",\"zxygdn\":0.0},{\"companyName\":\"弘裕纺织(浙江)有限公司\",\"zxygdn\":0.0},{\"companyName\":\"永丰余纸业（嘉兴）有限公司\",\"zxygdn\":0.0},{\"companyName\":\"荣光精密部件（嘉兴）有限公司\",\"zxygdn\":0.0},{\"companyName\":\"新天地纺织印染（嘉兴）有限公司\",\"zxygdn\":0.0},{\"companyName\":\"浙江嘉欣丝绸股份有限公司\",\"zxygdn\":0.0},{\"companyName\":\"浙江五芳斋实业股份有限公司\",\"zxygdn\":0.0}]";
    }

   /* @RequestMapping("/top5Companys")
    public List<PowerMeterZXYGDNRecordView> getTop5Companys(){
        return powerService.selectTop5PowerCompanyInfos();
    }*/

    @RequestMapping("/realTimeCompanys")
    public String getRealTimeCompanysStrings(){
        //return "[{\"companyName\":\"嘉兴敏胜汽车零部件有限公司\",\"waterValue\":0.0,\"zxygdn\":30052.828},{\"companyName\":\"嘉兴进隆塑业\",\"waterValue\":0.0,\"zxygdn\":23683.95},{\"companyName\":\"亮兮柯电气有限公司\",\"waterValue\":0.0,\"zxygdn\":11314.77},{\"companyName\":\"万思佳电器(嘉兴)有限公司\",\"waterValue\":0.0,\"zxygdn\":10872.64},{\"companyName\":\"嘉兴有成包装有限公司\",\"waterValue\":0.0,\"zxygdn\":9999.99},{\"companyName\":\"嘉兴市忠辉药业有限责任公司\",\"waterValue\":0.0,\"zxygdn\":9053.57},{\"companyName\":\"浙江安宁生物科技有限公司\",\"waterValue\":0.0,\"zxygdn\":6184.8604},{\"companyName\":\"捷顺旅游制品有限公司\",\"waterValue\":0.0,\"zxygdn\":5758.12},{\"companyName\":\"浙江天正智能电器有限公司\",\"waterValue\":0.0,\"zxygdn\":4167.9697},{\"companyName\":\"浙江宏业检测科技有限公司\",\"waterValue\":0.0,\"zxygdn\":3135.8198},{\"companyName\":\"嘉兴市新时代包装彩印有限公司\",\"waterValue\":0.0,\"zxygdn\":2880.16},{\"companyName\":\"浙江恒欣建筑设计股份有限公司\",\"waterValue\":0.0,\"zxygdn\":2692.71},{\"companyName\":\"嘉兴立家母婴用品有限公司\",\"waterValue\":0.0,\"zxygdn\":2513.3},{\"companyName\":\"浙江顺联智能设备有限公司\",\"waterValue\":0.0,\"zxygdn\":2184.43},{\"companyName\":\"嘉兴市华晟助剂有限公司\",\"waterValue\":0.0,\"zxygdn\":2029.16},{\"companyName\":\"沃尔德\",\"waterValue\":0.0,\"zxygdn\":2001.02},{\"companyName\":\"赛捷弹簧制\",\"waterValue\":0.0,\"zxygdn\":1921.08},{\"companyName\":\"浙江南阜\",\"waterValue\":0.0,\"zxygdn\":1779.55},{\"companyName\":\"嘉兴郑鲜机械有限公司\",\"waterValue\":0.0,\"zxygdn\":1663.24},{\"companyName\":\"嘉兴思可达机械制造有限公司\",\"waterValue\":0.0,\"zxygdn\":1652.94},{\"companyName\":\"浙江森永光电设备有限公司\",\"waterValue\":0.0,\"zxygdn\":1518.41},{\"companyName\":\"浙江瑞翌新材料科技有限公司\",\"waterValue\":0.0,\"zxygdn\":1206.72},{\"companyName\":\"赛捷弹簧\",\"waterValue\":0.0,\"zxygdn\":1113.56},{\"companyName\":\"浙江远中冠兴自动化科技有限公司\",\"waterValue\":0.0,\"zxygdn\":904.53},{\"companyName\":\"嘉兴市华信科教仪器有限公司\",\"waterValue\":0.0,\"zxygdn\":429.02},{\"companyName\":\"浙江福莱特玻璃有限公司\",\"waterValue\":0.0,\"zxygdn\":0.0},{\"companyName\":\"嘉兴丰利汇织造有限公司\",\"waterValue\":0.0,\"zxygdn\":0.0},{\"companyName\":\"嘉兴李朝化纤有限公司\",\"waterValue\":0.0,\"zxygdn\":0.0},{\"companyName\":\"浙江曜良纺织有限公司\",\"waterValue\":0.0,\"zxygdn\":0.0},{\"companyName\":\"浙江生辉照明有限公司\",\"waterValue\":0.0,\"zxygdn\":0.0},{\"companyName\":\"嘉兴市兴嘉汽车零部件制造有限公司\",\"waterValue\":0.0,\"zxygdn\":0.0},{\"companyName\":\"浙江三和机电科技有限公司\",\"waterValue\":0.0,\"zxygdn\":0.0},{\"companyName\":\"上澎太阳能科技（嘉兴）有限公司\",\"waterValue\":0.0,\"zxygdn\":0.0},{\"companyName\":\"嘉兴欣龙染整有限公司\",\"waterValue\":0.0,\"zxygdn\":0.0},{\"companyName\":\"浙江芬齐涂料密封胶有限公司\",\"waterValue\":0.0,\"zxygdn\":0.0},{\"companyName\":\"浙江雅莹集团有限公司\",\"waterValue\":0.0,\"zxygdn\":0.0},{\"companyName\":\"嘉兴山蒲照明电器有限公司\",\"waterValue\":0.0,\"zxygdn\":0.0},{\"companyName\":\"恩龙实业（嘉兴）有限公司\",\"waterValue\":0.0,\"zxygdn\":0.0},{\"companyName\":\"世源科技（嘉兴）医疗电子有限公司\",\"waterValue\":0.0,\"zxygdn\":0.0},{\"companyName\":\"耐思电气(嘉兴)有限公司\",\"waterValue\":0.0,\"zxygdn\":0.0},{\"companyName\":\"浙江凯发新材料有限公司\",\"waterValue\":0.0,\"zxygdn\":0.0},{\"companyName\":\"嘉兴捷顺旅游制品有限公司\",\"waterValue\":0.0,\"zxygdn\":0.0},{\"companyName\":\"嘉兴市捷豪清洁用品有限公司\",\"waterValue\":0.0,\"zxygdn\":0.0},{\"companyName\":\"珂纳电气机械股份有限公司\",\"waterValue\":0.0,\"zxygdn\":0.0},{\"companyName\":\"弘裕纺织(浙江)有限公司\",\"waterValue\":0.0,\"zxygdn\":0.0},{\"companyName\":\"永丰余纸业（嘉兴）有限公司\",\"waterValue\":0.0,\"zxygdn\":0.0},{\"companyName\":\"荣光精密部件（嘉兴）有限公司\",\"waterValue\":0.0,\"zxygdn\":0.0},{\"companyName\":\"新天地纺织印染（嘉兴）有限公司\",\"waterValue\":0.0,\"zxygdn\":0.0},{\"companyName\":\"浙江嘉欣丝绸股份有限公司\",\"waterValue\":0.0,\"zxygdn\":0.0},{\"companyName\":\"浙江五芳斋实业股份有限公司\",\"waterValue\":0.0,\"zxygdn\":0.0}]";
        return "[{\"companyName\":\"嘉兴敏胜汽车零部件有限公司\",\"waterValue\":0.0,\"zxygdn\":30129.871},{\"companyName\":\"嘉兴进隆塑业\",\"waterValue\":0.0,\"zxygdn\":23715.36},{\"companyName\":\"亮兮柯电气有限公司\",\"waterValue\":0.0,\"zxygdn\":11336.439},{\"companyName\":\"万思佳电器(嘉兴)有限公司\",\"waterValue\":0.0,\"zxygdn\":10877.6},{\"companyName\":\"嘉兴有成包装有限公司\",\"waterValue\":0.0,\"zxygdn\":9999.99},{\"companyName\":\"嘉兴市忠辉药业有限责任公司\",\"waterValue\":0.0,\"zxygdn\":9064.94},{\"companyName\":\"浙江安宁生物科技有限公司\",\"waterValue\":0.0,\"zxygdn\":6187.83},{\"companyName\":\"捷顺旅游制品有限公司\",\"waterValue\":0.0,\"zxygdn\":5768.23},{\"companyName\":\"浙江天正智能电器有限公司\",\"waterValue\":0.0,\"zxygdn\":4339.86},{\"companyName\":\"浙江宏业检测科技有限公司\",\"waterValue\":0.0,\"zxygdn\":3137.38},{\"companyName\":\"嘉兴市新时代包装彩印有限公司\",\"waterValue\":0.0,\"zxygdn\":2881.7},{\"companyName\":\"浙江恒欣建筑设计股份有限公司\",\"waterValue\":0.0,\"zxygdn\":2692.8},{\"companyName\":\"嘉兴立家母婴用品有限公司\",\"waterValue\":0.0,\"zxygdn\":2513.46},{\"companyName\":\"浙江顺联智能设备有限公司\",\"waterValue\":0.0,\"zxygdn\":2185.3},{\"companyName\":\"嘉兴市华晟助剂有限公司\",\"waterValue\":0.0,\"zxygdn\":2030.18},{\"companyName\":\"沃尔德\",\"waterValue\":0.0,\"zxygdn\":2005.03},{\"companyName\":\"赛捷弹簧制\",\"waterValue\":0.0,\"zxygdn\":1926.39},{\"companyName\":\"浙江南阜\",\"waterValue\":0.0,\"zxygdn\":1781.14},{\"companyName\":\"嘉兴郑鲜机械有限公司\",\"waterValue\":0.0,\"zxygdn\":1665.16},{\"companyName\":\"嘉兴思可达机械制造有限公司\",\"waterValue\":0.0,\"zxygdn\":1653.12},{\"companyName\":\"浙江森永光电设备有限公司\",\"waterValue\":0.0,\"zxygdn\":1519.95},{\"companyName\":\"浙江瑞翌新材料科技有限公司\",\"waterValue\":0.0,\"zxygdn\":1206.72},{\"companyName\":\"赛捷弹簧\",\"waterValue\":0.0,\"zxygdn\":1114.74},{\"companyName\":\"浙江远中冠兴自动化科技有限公司\",\"waterValue\":0.0,\"zxygdn\":905.38},{\"companyName\":\"嘉兴市华信科教仪器有限公司\",\"waterValue\":0.0,\"zxygdn\":429.72},{\"companyName\":\"永丰余纸业（嘉兴）有限公司\",\"waterValue\":0.0,\"zxygdn\":199.8064},{\"companyName\":\"浙江雅莹集团有限公司\",\"waterValue\":0.0,\"zxygdn\":151.0309},{\"companyName\":\"荣光精密部件（嘉兴）有限公司\",\"waterValue\":0.0,\"zxygdn\":135.34344},{\"companyName\":\"浙江凯发新材料有限公司\",\"waterValue\":0.0,\"zxygdn\":129.17535},{\"companyName\":\"上澎太阳能科技（嘉兴）有限公司\",\"waterValue\":0.0,\"zxygdn\":124.59801},{\"companyName\":\"嘉兴市捷豪清洁用品有限公司\",\"waterValue\":0.0,\"zxygdn\":102.7277},{\"companyName\":\"浙江嘉欣丝绸股份有限公司\",\"waterValue\":0.0,\"zxygdn\":85.33709},{\"companyName\":\"恩龙实业（嘉兴）有限公司\",\"waterValue\":0.0,\"zxygdn\":82.43701},{\"companyName\":\"浙江芬齐涂料密封胶有限公司\",\"waterValue\":0.0,\"zxygdn\":79.98207},{\"companyName\":\"浙江五芳斋实业股份有限公司\",\"waterValue\":0.0,\"zxygdn\":66.939476},{\"companyName\":\"浙江三和机电科技有限公司\",\"waterValue\":0.0,\"zxygdn\":63.092865},{\"companyName\":\"珂纳电气机械股份有限公司\",\"waterValue\":0.0,\"zxygdn\":62.827175},{\"companyName\":\"嘉兴山蒲照明电器有限公司\",\"waterValue\":0.0,\"zxygdn\":56.41661},{\"companyName\":\"新天地纺织印染（嘉兴）有限公司\",\"waterValue\":0.0,\"zxygdn\":52.03594},{\"companyName\":\"嘉兴欣龙染整有限公司\",\"waterValue\":0.0,\"zxygdn\":45.74094},{\"companyName\":\"浙江生辉照明有限公司\",\"waterValue\":0.0,\"zxygdn\":43.978954},{\"companyName\":\"浙江福莱特玻璃有限公司\",\"waterValue\":0.0,\"zxygdn\":42.341064},{\"companyName\":\"嘉兴李朝化纤有限公司\",\"waterValue\":0.0,\"zxygdn\":40.157017},{\"companyName\":\"弘裕纺织(浙江)有限公司\",\"waterValue\":0.0,\"zxygdn\":21.108171},{\"companyName\":\"世源科技（嘉兴）医疗电子有限公司\",\"waterValue\":0.0,\"zxygdn\":18.826263},{\"companyName\":\"嘉兴捷顺旅游制品有限公司\",\"waterValue\":0.0,\"zxygdn\":15.441197},{\"companyName\":\"嘉兴市兴嘉汽车零部件制造有限公司\",\"waterValue\":0.0,\"zxygdn\":8.156031},{\"companyName\":\"浙江曜良纺织有限公司\",\"waterValue\":0.0,\"zxygdn\":4.5593653},{\"companyName\":\"耐思电气(嘉兴)有限公司\",\"waterValue\":0.0,\"zxygdn\":3.0061557},{\"companyName\":\"嘉兴丰利汇织造有限公司\",\"waterValue\":0.0,\"zxygdn\":2.5797424}]\n";
    }

    /*@RequestMapping("/realTimeCompanys")
    public List<PowerWaterZRecordView> getRealTimeCompanys(){
        return powerService.selectPowerWaterZRecordViews();
    }
*/
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

    @RequestMapping("/powerAllViews")
    public List<PowerAllView> getPowerAllViews(){

        return powerService.selectPowerAllViews();
    }

    @RequestMapping("/downloadPowerAllViews.xls")
    public void downloadPowerAllViews(HttpServletResponse res){
        String fileName = "电表数据表";
        res.setHeader("content-type", "application/octet-stream");
        res.setContentType("application/octet-stream");
        res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        OutputStream outputStream =null;

        try {
            powerService.getPowerAllViewsWorkbook().write(res.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
