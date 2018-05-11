package cn.zjn.jx.bigdata.domain.power;

import java.io.Serializable;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017-12-21 21:29
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
public class PowerZXYGDNHoursInfo {

    String meterCode;
    int hour;
    float ZXYGDN;



    public PowerZXYGDNHoursInfo() {
    }

    public PowerZXYGDNHoursInfo(String meterCode, int time, float ZXYGDN) {
        this.meterCode = meterCode;
        this.hour = time;
        this.ZXYGDN = ZXYGDN;
    }

    public String getMeterCode() {
        return meterCode;
    }

    public void setMeterCode(String meterCode) {
        this.meterCode = meterCode;
    }

    public int getHour() {
        return hour;
    }

    public void setTime(int hour) {
        this.hour = hour;
    }

    public float getZXYGDN() {
        return ZXYGDN;
    }

    public void setZXYGDN(float ZXYGDN) {
        this.ZXYGDN = ZXYGDN;
    }

    @Override
    public String toString() {
        return "PowerZXYGDNHoursInfo{" +
                "pCode='" + meterCode + '\'' +
                ", hour=" + hour +
                ", ZXYGDN=" + ZXYGDN +
                '}';
    }
}
