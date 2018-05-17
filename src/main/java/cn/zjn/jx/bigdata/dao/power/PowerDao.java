package cn.zjn.jx.bigdata.dao.power;

import cn.zjn.jx.bigdata.domain.power.*;
import cn.zjn.jx.bigdata.domain.xls.PowerAllView;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017-12-21 18:13
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */

@Mapper
public interface PowerDao {

    /**
     *  {"SELECT\n" +
     "power_meter_info.meter_code AS meterCode,\n" +
     "power_meter_info.company_code AS companyCode,\n" +
     "company_info.company_name AS companyName,\n" +
     "MAX(power_meter_record.p_zxygdn) AS ZXYGDN\n" +
     "\n" +
     "FROM\n" +
     "power_meter_info\n" +
     "LEFT JOIN company_info ON power_meter_info.company_code = company_info.company_code\n" +
     "LEFT JOIN power_meter_record ON power_meter_record.p_code = power_meter_info.meter_code\n" +
     "GROUP BY\n" +
     "meterCode\n" +
     "ORDER BY\n" +
     "companyCode"}
     * @return
     */
    public List<PowerMeterZXYGDNRecordInfo> selectPowerZXYGDNRecordInfos();



    @Select({"SELECT\n" +
            "power_meter_info.meter_code AS meterCode,\n" +
            "Hour(power_meter_record.p_time) AS hour,\n" +
            "power_meter_record.p_zxygdn AS zxygdn\n" +
            "FROM power_meter_info\n" +
            "\n" +
            "LEFT JOIN power_meter_record ON power_meter_info.company_code=#{companyCode} and power_meter_record.p_code = power_meter_info.meter_code \n" +
            "AND\n" +
            " power_meter_record.id in(\n" +
            "\tSELECT MAX(id)\n" +
            "\tFROM power_meter_record\n" +
            "\tWHERE DATE(power_meter_record.p_time)=CURDATE()\n" +
            "\tGROUP BY HOUR(power_meter_record.p_time),power_meter_record.p_code\n" +
            ")\n" +
            "\n" +
            "ORDER BY hour\n"})
    public List<PowerZXYGDNHoursInfo> selectPowerZXYGDNHoursInfosByCompanyCode(String companyCode);


    @Select({"SELECT\n" +
            "DATE_FORMAT(power_meter_record.p_time,'%Y-%m-%d') AS time,\n" +
            "power_meter_record.p_code as pCode,\n" +
            "power_meter_record.p_zxygdn AS zxygdnZ,\n" +
            "power_meter_record.p_zxygdn_1 AS zxygdnJ,\n" +
            "power_meter_record.p_zxygdn_2 AS zxygdnF,\n" +
            "power_meter_record.p_zxygdn_3 AS zxygdP,\n" +
            "power_meter_record.p_zxygdn_4 AS zxygdnG\n" +
            "\n" +
            "FROM\n" +
            "power_meter_record,\n" +
            "power_meter_info\n" +
            "WHERE power_meter_info.company_code=#{arg0} and power_meter_info.meter_code=power_meter_record.p_code AND power_meter_record.id in(\n" +
            "SELECT\n" +
            "max(id)\n" +
            "FROM\n" +
            "power_meter_record\n" +
            "WHERE\n" +
            "p_time\n" +
            "BETWEEN\n" +
            "#{arg1}\n" +
            "AND\n" +
            "#{arg2}\n" +
            "GROUP BY\n" +
            "DAY(power_meter_record.p_time),\n" +
            "power_meter_record.p_code\n" +
            ")"})
    public List<PowerZJFPGInfo> selectPowerZJFPGInfosByCompanyCodeAndTime(String companyCode,String sTime,String eTime);



    @Select({"SELECT\n" +
            "DATE_FORMAT(power_meter_record.p_time,'%Y-%m-%d') AS time,\n" +
            "power_meter_record.p_code as pCode,\n" +
            "power_meter_record.p_zxygdn AS zxygdnZ,\n" +
            "power_meter_record.p_zxygdn_1 AS zxygdnJ,\n" +
            "power_meter_record.p_zxygdn_2 AS zxygdnF,\n" +
            "power_meter_record.p_zxygdn_3 AS zxygdP,\n" +
            "power_meter_record.p_zxygdn_4 AS zxygdnG\n" +
            "FROM\n" +
            "power_meter_record\n" +
            "WHERE\n" +
            " power_meter_record.id in(\n" +
            "SELECT\n" +
            "max(id)\n" +
            "FROM\n" +
            "power_meter_record\n" +
            "WHERE\n" +
            "power_meter_record.p_code=#{arg0}\n" +
            "AND\n" +
            "p_time\n" +
            "BETWEEN\n" +
            "#{arg1}\n" +
            "AND\n" +
            "#{arg2}\n" +
            "GROUP BY\n" +
            "DAY(power_meter_record.p_time),\n" +
            "power_meter_record.p_code\n" +
            ")"})
    public List<PowerZJFPGInfo> selectPowerZJFPGInfosBypCodeAndTime(String pCode,String sTime,String eTime);


    @Select({"SELECT\n" +
            "power_meter_info.meter_code AS pCode,\n" +
            "power_meter_info.meter_name AS pName\n" +
            "FROM\n" +
            "power_meter_info\n" +
            "WHERE\n" +
            "power_meter_info.company_code=#{arg0}"})
    public List<PowerMeterInfo> selectPowerMeterInfosByCompanyCode(String companyCode);


    public List<PowerZXYGDNInfo> selectPowerZXYGDNDayInfosByPCodeAndTime(@Param("pCode") String pCode, @Param("sTime") String sTime, @Param("eTime") String eTime);

    public List<PowerZXYGDNInfo> selectPowerZXYGDNDayInfosByCompanyCodeAndTime(@Param("companyCode") String companyCode, @Param("sTime") String sTime, @Param("eTime") String eTime);


    public List<PowerZXYGDNInfo> selectPowerZXYGDNMonthInfosByPCodeAndTime(@Param("pCode") String pCode, @Param("sTime") String sTime, @Param("eTime") String eTime);

    public List<PowerZXYGDNInfo> selectPowerZXYGDNMonthInfosBycompanyCodeAndTime(@Param("companyCode") String companyCode,@Param("sTime") String sTime, @Param("eTime") String eTime);

    public List<PowerZXYGDNInfo> selectPowerZXYGDNHoursInfosByCompanyCodeAndTime(@Param("companyCode") String companyCode,@Param("sTime") String sTime, @Param("eTime") String eTime);

    public List<PowerZXYGDNInfo> selectPowerZXYGDNHoursInfosByPCodeAndTime(@Param("pCode") String pCode, @Param("sTime") String sTime, @Param("eTime") String eTime);

    public List<PowerZJFPGInfo> selectPowerZJFPGDayInfosByCompanyCodeAndTime(@Param("companyCode") String companyCode,@Param("sTime") String sTime, @Param("eTime") String eTime);

    public List<PowerZJFPGInfo> selectPowerZJFPGDayInfosByPCodeAndTime(@Param("pCode") String pCode,@Param("sTime") String sTime, @Param("eTime") String eTime);

    public List<PowerAllView> selectPowerAllViews();
}
