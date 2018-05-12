SELECT
power_meter_info.meter_code AS meterCode,
Hour(power_meter_record.p_time) AS hour,
power_meter_record.p_zxygdn AS zxygdn
FROM power_meter_info

INNER JOIN power_meter_record ON power_meter_info.company_code=1 and power_meter_record.p_code = power_meter_info.meter_code 
AND
 power_meter_record.id in(
	SELECT MAX(id)
	FROM power_meter_record
	WHERE DATE(power_meter_record.p_time)=CURDATE()
	GROUP BY HOUR(power_meter_record.p_time),power_meter_record.p_code
)

ORDER BY hour
