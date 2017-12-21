package cn.zjn.jx.bigdata.domain.power;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017-12-21 21:53
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
public class PowerZXYGDNHoursView {
    int hour;
    float ZXYGDN;

    public PowerZXYGDNHoursView() {
    }

    public PowerZXYGDNHoursView(int hour, float ZXYGDN) {
        this.hour = hour;
        this.ZXYGDN = ZXYGDN;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
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
        return "PowerZXYGDNHoursView{" +
                "hour=" + hour +
                ", ZXYGDN=" + ZXYGDN +
                '}';
    }
}
