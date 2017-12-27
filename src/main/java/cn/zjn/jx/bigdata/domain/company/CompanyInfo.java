package cn.zjn.jx.bigdata.domain.company;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017-12-27 17:33
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
public class CompanyInfo {

    String companyCode;
    String companyName;


    public CompanyInfo() {
    }

    public CompanyInfo(String companyCode, String companyName) {
        this.companyCode = companyCode;
        this.companyName = companyName;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "CompanyInfo{" +
                "companyCode='" + companyCode + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
