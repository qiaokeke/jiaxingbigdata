package cn.zjn.jx.bigdata.domain.power;

import java.io.Serializable;

/**
 * @Author: qiaokk
 * @Description: 保存所有的关于正向有功电能的数据，包括月。天。时
 * @Date: Created in 2018-05-11 20:29
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
public class PowerZXYGDNInfo implements Serializable{

    private static final long serialVersionUID=1L;

    String pCode;
    int beiLv;
    String time;
    float ZXYGDN;

    public PowerZXYGDNInfo() {
    }

    public PowerZXYGDNInfo(String pCode, int beiLv, String time, float ZXYGDN) {
        this.pCode = pCode;
        this.beiLv = beiLv;
        this.time = time;
        this.ZXYGDN = ZXYGDN;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    /**
     *
     * @return 正向有功电能的输出值乘上倍率
     */
    public float getZXYGDN() {
        return ZXYGDN*this.beiLv;
    }

    public void setZXYGDN(float ZXYGDN) {
        this.ZXYGDN = ZXYGDN;
    }

    @Override
    public String toString() {
        return "PowerZXYGDNInfo{" +
                "pCode='" + pCode + '\'' +
                ", beiLv=" + beiLv +
                ", time='" + time + '\'' +
                ", ZXYGDN=" + ZXYGDN +
                '}';
    }
}
