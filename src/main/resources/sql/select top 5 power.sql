SELECT
power_meter_info.meter_code AS meterCode,
power_meter_info.company_code AS companyCode,
company_info.company_name AS companyName,
MAX(power_meter_record.p_zxygdn) AS ZXYGDN

FROM
power_meter_info
LEFT JOIN company_info ON power_meter_info.company_code = company_info.company_code
LEFT JOIN power_meter_record ON power_meter_record.p_code = power_meter_info.meter_code
GROUP BY
meterCode
ORDER BY
companyCode