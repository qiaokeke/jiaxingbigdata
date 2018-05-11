package cn.zjn.jx.bigdata.domain.power;

/**
 * @Author: qiaokk
 * @Description:
 * @Date: Created in 2018-05-11 20:33
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
public class PowerZXYGDNView {

    String time;
    float ZXYGDN;


    public PowerZXYGDNView() {
    }

    public PowerZXYGDNView(String time, float ZXYGDN) {
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
        return "PowerZXYGDNView{" +
                "time='" + time + '\'' +
                ", ZXYGDN=" + ZXYGDN +
                '}';
    }
}
