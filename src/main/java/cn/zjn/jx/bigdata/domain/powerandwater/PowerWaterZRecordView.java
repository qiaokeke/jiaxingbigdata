package cn.zjn.jx.bigdata.domain.powerandwater;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017-12-21 20:41
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
public class PowerWaterZRecordView {

    String companyName;
    float ZXYGDN;
    float waterValue;


    public PowerWaterZRecordView() {
    }

    public PowerWaterZRecordView(String companyName, float ZXYGDN, float waterValue) {
        this.companyName = companyName;
        this.ZXYGDN = ZXYGDN;
        this.waterValue = waterValue;
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

    public float getWaterValue() {
        return waterValue;
    }

    public void setWaterValue(float waterValue) {
        this.waterValue = waterValue;
    }

    @Override
    public String toString() {
        return "PowerWaterZRecordView{" +
                "companyName='" + companyName + '\'' +
                ", ZXYGDN=" + ZXYGDN +
                ", waterValue=" + waterValue +
                '}';
    }
}
