package cn.zjn.jx.bigdata.domain.company;

import cn.zjn.jx.bigdata.domain.power.PowerMeterInfo;

import java.util.List;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017-12-27 17:46
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
public class CompanyMeterView {
    String companyCode;
    String companyName;
    List<PowerMeterInfo> powerMeterInfos;

    public CompanyMeterView() {
    }

    public CompanyMeterView(String companyCode, String companyName, List<PowerMeterInfo> powerMeterInfos) {
        this.companyCode = companyCode;
        this.companyName = companyName;
        this.powerMeterInfos = powerMeterInfos;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<PowerMeterInfo> getPowerMeterInfos() {
        return powerMeterInfos;
    }

    public void setPowerMeterInfos(List<PowerMeterInfo> powerMeterInfos) {
        this.powerMeterInfos = powerMeterInfos;
    }

    @Override
    public String toString() {
        return "CompanyMeterView{" +
                "companyCode='" + companyCode + '\'' +
                ", companyName='" + companyName + '\'' +
                ", powerMeterInfos=" + powerMeterInfos +
                '}';
    }
}
