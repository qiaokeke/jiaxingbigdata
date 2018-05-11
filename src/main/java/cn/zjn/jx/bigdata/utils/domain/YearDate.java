package cn.zjn.jx.bigdata.utils.domain;

/**
 * @Author: qiaokk
 * @Description:
 * @Date: Created in 2018-05-11 21:37
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
public class YearDate {

    String firstDateString;
    String endDateString;


    public YearDate() {
    }

    public YearDate(String firstDateString, String endDateString) {
        this.firstDateString = firstDateString;
        this.endDateString = endDateString;
    }

    public String getFirstDateString() {
        return firstDateString;
    }

    public void setFirstDateString(String firstDateString) {
        this.firstDateString = firstDateString;
    }

    public String getEndDateString() {
        return endDateString;
    }

    public void setEndDateString(String endDateString) {
        this.endDateString = endDateString;
    }

    @Override
    public String toString() {
        return "YearDate{" +
                "firstDateString='" + firstDateString + '\'' +
                ", endDateString='" + endDateString + '\'' +
                '}';
    }
}
