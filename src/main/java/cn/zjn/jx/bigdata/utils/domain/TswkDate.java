package cn.zjn.jx.bigdata.utils.domain;

import java.util.Date;

/**
 * @Author: qiaokk
 * @Description:
 * @Date: Created in 2018-05-10 20:39
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
public class TswkDate {
    String firstDateString;
    String endDateString;
    Date firstDateDate;
    Date endDateDate;
    int countDayOfWeek;

    public TswkDate() {
    }

    public TswkDate(String firstDateString, String endDateString, Date firstDateDate, Date endDateDate, int countDayOfWeek) {
        this.firstDateString = firstDateString;
        this.endDateString = endDateString;
        this.firstDateDate = firstDateDate;
        this.endDateDate = endDateDate;
        this.countDayOfWeek = countDayOfWeek;
    }

    public TswkDate(String firstDateString, String endDateString, int countDayOfWeek) {
        this.firstDateString = firstDateString;
        this.endDateString = endDateString;
        this.countDayOfWeek = countDayOfWeek;
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

    public Date getFirstDateDate() {
        return firstDateDate;
    }

    public void setFirstDateDate(Date firstDateDate) {
        this.firstDateDate = firstDateDate;
    }

    public Date getEndDateDate() {
        return endDateDate;
    }

    public void setEndDateDate(Date endDateDate) {
        this.endDateDate = endDateDate;
    }

    public int getCountDayOfWeek() {
        return countDayOfWeek;
    }

    public void setCountDayOfWeek(int countDayOfWeek) {
        this.countDayOfWeek = countDayOfWeek;
    }

    @Override
    public String toString() {
        return "TswkDate{" +
                "firstDateString='" + firstDateString + '\'' +
                ", endDateString='" + endDateString + '\'' +
                ", firstDateDate=" + firstDateDate +
                ", endDateDate=" + endDateDate +
                ", countDayOfWeek=" + countDayOfWeek +
                '}';
    }
}
