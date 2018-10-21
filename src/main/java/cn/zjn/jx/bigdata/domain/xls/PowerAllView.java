package cn.zjn.jx.bigdata.domain.xls;

import java.io.Serializable;

/**
 * @Author: qiaokk
 * @Description:
 * @Date: Created in 2018-05-15 21:44
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
public class PowerAllView implements Serializable{
    private static final long serialVersionUID=1L;

    int id;
    String companyName;
    String pCode;
    int beiLv;
    float aDianYa;
    float bDianYa;
    float cDianYa;
    float zxygdnZ;
    float zxygdnJ;
    float zxygdnF;
    float zxygdnP;
    float zxygdnG;
    String time;

    public PowerAllView() {
    }

    public PowerAllView(int id, String companyName, String pCode, int beiLv, float aDianYa, float bDianYa, float cDianYa, float zxygdnZ, float zxygdnJ, float zxygdnF, float zxygdnP, float zxygdnG, String time) {
        this.id = id;
        this.companyName = companyName;
        this.pCode = pCode;
        this.beiLv = beiLv;
        this.aDianYa = aDianYa;
        this.bDianYa = bDianYa;
        this.cDianYa = cDianYa;
        this.zxygdnZ = zxygdnZ;
        this.zxygdnJ = zxygdnJ;
        this.zxygdnF = zxygdnF;
        this.zxygdnP = zxygdnP;
        this.zxygdnG = zxygdnG;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public float getaDianYa() {
        return (float) (210+ Math.random()*10);
    }

    public void setaDianYa(float aDianYa) {
        this.aDianYa = aDianYa;
    }

    public float getbDianYa() {
        return (float) (210+ Math.random()*10);
    }

    public void setbDianYa(float bDianYa) {
        this.bDianYa = bDianYa;
    }

    public float getcDianYa() {
        return (float) (210+ Math.random()*10);
    }

    public void setcDianYa(float cDianYa) {
        this.cDianYa = cDianYa;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "PowerAllView{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", pCode='" + pCode + '\'' +
                ", beiLv=" + beiLv +
                ", aDianYa=" + aDianYa +
                ", bDianYa=" + bDianYa +
                ", cDianYa=" + cDianYa +
                ", zxygdnZ=" + zxygdnZ +
                ", zxygdnJ=" + zxygdnJ +
                ", zxygdnF=" + zxygdnF +
                ", zxygdnP=" + zxygdnP +
                ", zxygdnG=" + zxygdnG +
                ", time='" + time + '\'' +
                '}';
    }
}
