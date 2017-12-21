package cn.zjn.jx.bigdata.domain.power;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017-12-21 17:39
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
public class PowerCompanyInfo {
    String company;
    float ZXYGDN;


    public PowerCompanyInfo() {
    }

    public PowerCompanyInfo(String company, float ZXYGDN) {
        this.company = company;
        this.ZXYGDN = ZXYGDN;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public float getZXYGDN() {
        return ZXYGDN;
    }

    public void setZXYGDN(float ZXYGDN) {
        this.ZXYGDN = ZXYGDN;
    }

    @Override
    public String toString() {
        return "PowerCompanyInfo{" +
                "company='" + company + '\'' +
                ", ZXYGDN=" + ZXYGDN +
                '}';
    }
}
