SELECT
	DATE_FORMAT(
		power_meter_record.p_time,
		'%Y-%m'
	) AS time,
	power_meter_info.beilv AS beiLv,
	power_meter_record.p_code AS pCode,
	power_meter_record.p_zxygdn AS ZXYGDN
FROM
	power_meter_record,
	power_meter_info
WHERE
	power_meter_record.id IN (
		SELECT
			max(id)
		FROM
			power_meter_record
		WHERE
			power_meter_record.p_code = 65381
		AND p_time BETWEEN '2017-12-01'
		AND '2018-05-11'x
		GROUP BY
			MONTH (power_meter_record.p_time),
			power_meter_record.p_code
	)
AND power_meter_record.p_code = power_meter_info.meter_code