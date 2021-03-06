package cn.zjn.jx.bigdata.domain.power;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017-12-27 16:28
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
public class PowerZJFPGView {
    String time;
    float zxygdnZ;
    float zxygdnJ;
    float zxygdnF;
    float zxygdnP;
    float zxygdnG;

    public PowerZJFPGView() {
    }

    public PowerZJFPGView(String time, float zxygdnZ, float zxygdnJ, float zxygdnF, float zxygdnP, float zxygdnG) {
        this.time = time;
        this.zxygdnZ = zxygdnZ;
        this.zxygdnJ = zxygdnJ;
        this.zxygdnF = zxygdnF;
        this.zxygdnP = zxygdnP;
        this.zxygdnG = zxygdnG;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public float getZxygdnZ() {
        return zxygdnZ;
    }

    public void setZxygdnZ(float zxygdnZ) {
        this.zxygdnZ = zxygdnZ;
    }

    public float getZxygdnJ() {
        return zxygdnJ;
    }

    public void setZxygdnJ(float zxygdnJ) {
        this.zxygdnJ = zxygdnJ;
    }

    public float getZxygdnF() {
        return zxygdnF;
    }

    public void setZxygdnF(float zxygdnF) {
        this.zxygdnF = zxygdnF;
    }

    public float getZxygdnP() {
        return zxygdnP;
    }

    public void setZxygdnP(float zxygdnP) {
        this.zxygdnP = zxygdnP;
    }

    public float getZxygdnG() {
        return zxygdnG;
    }

    public void setZxygdnG(float zxygdnG) {
        this.zxygdnG = zxygdnG;
    }

    @Override
    public String toString() {
        return "PowerZJFPGView{" +
                "time='" + time + '\'' +
                ", zxygdnZ=" + zxygdnZ +
                ", zxygdnJ=" + zxygdnJ +
                ", zxygdnF=" + zxygdnF +
                ", zxygdnP=" + zxygdnP +
                ", zxygdnG=" + zxygdnG +
                '}';
    }
}
