package cn.zjn.jx.bigdata.dao.power;

import cn.zjn.jx.bigdata.domain.power.PowerMeterZXYGDNRecordInfo;
import cn.zjn.jx.bigdata.domain.power.PowerZXYGDNHoursInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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


    @Select({"SELECT\n" +
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
            "companyCode"})
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
    public List<PowerZXYGDNHoursInfo> selectPowerZXYGDNHoursInfos(String companyCode);



}
