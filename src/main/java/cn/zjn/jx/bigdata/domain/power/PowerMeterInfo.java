package cn.zjn.jx.bigdata.domain.power;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017-12-27 17:41
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
public class PowerMeterInfo {
    String pCode;
    String pName;

    public PowerMeterInfo() {
    }

    public PowerMeterInfo(String pCode, String pName) {
        this.pCode = pCode;
        this.pName = pName;
    }

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    public String getpName() {
        if (pName==null)
            pName="";
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    @Override
    public String toString() {
        return "PowerMeterInfo{" +
                "pCode='" + pCode + '\'' +
                ", pName='" + pName + '\'' +
                '}';
    }
}
