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
    int beiLv;

    public PowerMeterInfo() {
    }

    public PowerMeterInfo(String pCode, String pName,int beiLv) {
        this.pCode = pCode;
        this.pName = pName;
        this.beiLv = beiLv;
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


    public int getBeiLv() {
        return beiLv;
    }

    public void setBeiLv(int beiLv) {
        this.beiLv = beiLv;
    }

    @Override
    public String toString() {
        return "PowerMeterInfo{" +
                "pCode='" + pCode + '\'' +
                ", pName='" + pName + '\'' +
                ", beiLv=" + beiLv +
                '}';
    }
}
