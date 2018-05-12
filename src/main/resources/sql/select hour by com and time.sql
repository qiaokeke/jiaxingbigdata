SELECT
	DATE_FORMAT(
		power_meter_record.p_time,
		'%Y-%m-%d %H:00:00'
	) AS time,
	power_meter_record.p_code AS pCode,
	power_meter_info.beilv AS beiLv,
	power_meter_record.p_zxygdn AS ZXYGDN
FROM
	power_meter_record,
	power_meter_info
WHERE
	power_meter_info.company_code = 1
AND power_meter_info.meter_code = power_meter_record.p_code
AND power_meter_record.id IN (
	SELECT
		max(id)
	FROM
		power_meter_record
	WHERE
		p_time BETWEEN '2018-04-05 23:00:00'
	AND '2018-04-06 23:59:00'
	GROUP BY
		YEAR (power_meter_record.p_time),
		MONTH (power_meter_record.p_time),
		DAY (power_meter_record.p_time),
		HOUR (power_meter_record.p_time),
		power_meter_record.p_code
)
AND power_meter_info.meter_code = power_meter_record.p_code