package cn.zjn.jx.bigdata.domain.power;

import java.io.Serializable;

/**
 * @Author: qiaokk
 * @Description:
 * @Date: Created in 2018-05-10 20:16
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
public class PowerZXYGDNDayInfo implements Serializable{

    private static final long serialVersionUID = 1L;

    String pCode;
    int beiLv;
    String time;
    float ZXYGDN;



    public PowerZXYGDNDayInfo() {
    }

    public PowerZXYGDNDayInfo(String pCode, int beiLv, String time, float ZXYGDN) {
        this.pCode = pCode;
        this.beiLv = beiLv;
        this.time = time;
        this.ZXYGDN = ZXYGDN;
    }

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public float getZXYGDN() {
        return ZXYGDN*this.beiLv;
    }

    public void setZXYGDN(float ZXYGDN) {
        this.ZXYGDN = ZXYGDN;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getBeiLv() {
        return beiLv;
    }

    public void setBeiLv(int beiLv) {
        this.beiLv = beiLv;
    }

    @Override
    public String toString() {
        return "PowerZXYGDNDayInfo{" +
                "pCode='" + pCode + '\'' +
                ", beiLv=" + beiLv +
                ", time='" + time + '\'' +
                ", ZXYGDN=" + ZXYGDN +
                '}';
    }
}
