package cn.zjn.jx.bigdata.domain.powerandwater;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017-12-21 21:00
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
public class PowerWaterHoursView{
    String time;
    float powerValue;
    float waterValue;

    public PowerWaterHoursView(){
    }

    public PowerWaterHoursView(String time, float powerValue, float waterValue) {
        this.time = time;
        this.powerValue = powerValue;
        this.waterValue = waterValue;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public float getPowerValue() {
        return powerValue;
    }

    public void setPowerValue(float powerValue) {
        this.powerValue = powerValue;
    }

    public float getWaterValue() {
        return waterValue;
    }

    public void setWaterValue(float waterValue) {
        this.waterValue = waterValue;
    }

    @Override
    public String toString() {
        return "PowerWaterHoursView{" +
                "time='" + time + '\'' +
                ", powerValue=" + powerValue +
                ", waterValue=" + waterValue +
                '}';
    }
}
