package cn.zjn.jx.bigdata.domain.power;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017-12-21 19:01
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */

/**
 * top5 domain
 */
public class PowerMeterZXYGDNRecordView {

    String companyName;
    float ZXYGDN;

    public PowerMeterZXYGDNRecordView() {
    }

    public PowerMeterZXYGDNRecordView(String companyName, float ZXYGDN) {
        this.companyName = companyName;
        this.ZXYGDN = ZXYGDN;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public float getZXYGDN() {
        return ZXYGDN;
    }

    public void setZXYGDN(float ZXYGDN) {
        this.ZXYGDN = ZXYGDN;
    }

    @Override
    public String toString() {
        return "PowerMeterZXYGDNRecordView{" +
                "companyName='" + companyName + '\'' +
                ", ZXYGDN=" + ZXYGDN +
                '}';
    }
}
