package cn.zjn.jx.bigdata.domain.power;

import java.io.Serializable;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017-12-27 16:11
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
public class PowerZJFPGInfo implements Serializable{

    private static final long serialVersionUID=1L;

    String pCode;
    int beiLv;
    String time;
    float zxygdnZ;
    float zxygdnJ;
    float zxygdnF;
    float zxygdnP;
    float zxygdnG;

    public PowerZJFPGInfo() {
    }

    public PowerZJFPGInfo(String pCode, int beiLv, String time, float zxygdnZ, float zxygdnJ, float zxygdnF, float zxygdnP, float zxygdnG) {
        this.pCode = pCode;
        this.beiLv = beiLv;
        this.time = time;
        this.zxygdnZ = zxygdnZ;
        this.zxygdnJ = zxygdnJ;
        this.zxygdnF = zxygdnF;
        this.zxygdnP = zxygdnP;
        this.zxygdnG = zxygdnG;
    }

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    public int getBeiLv() {
        return beiLv;
    }

    public void setBeiLv(int beiLv) {
        this.beiLv = beiLv;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public float getZxygdnZ() {
        return zxygdnZ*this.beiLv;
    }

    public void setZxygdnZ(float zxygdnZ) {
        this.zxygdnZ = zxygdnZ;
    }

    public float getZxygdnJ() {
        return zxygdnJ*this.beiLv;
    }

    public void setZxygdnJ(float zxygdnJ) {
        this.zxygdnJ = zxygdnJ;
    }

    public float getZxygdnF() {
        return zxygdnF*this.beiLv;
    }

    public void setZxygdnF(float zxygdnF) {
        this.zxygdnF = zxygdnF;
    }

    public float getZxygdnP() {
        return zxygdnP*this.beiLv;
    }

    public void setZxygdnP(float zxygdnP) {
        this.zxygdnP = zxygdnP;
    }

    public float getZxygdnG() {
        return zxygdnG*this.beiLv;
    }

    public void setZxygdnG(float zxygdnG) {
        this.zxygdnG = zxygdnG;
    }

    @Override
    public String toString() {
        return "PowerZJFPGInfo{" +
                "pCode='" + pCode + '\'' +
                ", beiLv=" + beiLv +
                ", time='" + time + '\'' +
                ", zxygdnZ=" + zxygdnZ +
                ", zxygdnJ=" + zxygdnJ +
                ", zxygdnF=" + zxygdnF +
                ", zxygdnP=" + zxygdnP +
                ", zxygdnG=" + zxygdnG +
                '}';
    }
}
