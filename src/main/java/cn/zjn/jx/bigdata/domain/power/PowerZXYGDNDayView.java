package cn.zjn.jx.bigdata.domain.power;

/**
 * @Author: qiaokk
 * @Description:
 * @Date: Created in 2018-05-10 20:12
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
public class PowerZXYGDNDayView {
    String time;
    float ZXYGDN;

    public PowerZXYGDNDayView() {
    }

    public PowerZXYGDNDayView(String time, float ZXYGDN) {
        this.time = time;
        this.ZXYGDN = ZXYGDN;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public float getZXYGDN() {
        return ZXYGDN;
    }

    public void setZXYGDN(float ZXYGDN) {
        this.ZXYGDN = ZXYGDN;
    }

    @Override
    public String toString() {
        return "PowerZXYGDNDayView{" +
                "time='" + time + '\'' +
                ", ZXYGDN=" + ZXYGDN +
                '}';
    }
}
