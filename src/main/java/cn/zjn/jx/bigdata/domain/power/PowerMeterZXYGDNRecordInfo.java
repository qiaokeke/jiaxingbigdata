package cn.zjn.jx.bigdata.domain.power;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017-12-21 17:53
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
public class PowerMeterZXYGDNRecordInfo {

    String meterCode;
    String companyCode;
    String companyName;
    float ZXYGDN;

    public PowerMeterZXYGDNRecordInfo() {
    }

    public PowerMeterZXYGDNRecordInfo(String meterCode, String companyCode, String companyName, float ZXYGDN) {
        this.meterCode = meterCode;
        this.companyCode = companyCode;
        this.companyName = companyName;
        this.ZXYGDN = ZXYGDN;
    }

    public String getMeterCode() {
        return meterCode;
    }

    public void setMeterCode(String meterCode) {
        this.meterCode = meterCode;
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

    public float getZXYGDN() {
        return ZXYGDN;
    }

    public void setZXYGDN(float ZXYGDN) {
        this.ZXYGDN = ZXYGDN;
    }

    @Override
    public String toString() {
        return "PowerMeterZXYGDNRecordInfo{" +
                "meterCode='" + meterCode + '\'' +
                ", companyCode='" + companyCode + '\'' +
                ", companyName='" + companyName + '\'' +
                ", ZXYGDN='" + ZXYGDN + '\'' +
                '}';
    }
}
