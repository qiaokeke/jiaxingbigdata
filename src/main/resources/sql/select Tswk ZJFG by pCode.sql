SELECT
	DATE_FORMAT(
		power_meter_record.p_time,
		'%Y-%m-%d'
	) AS time,
	power_meter_record.p_code AS pCode,
	power_meter_info.beilv AS beiLv,
	power_meter_record.p_zxygdn AS zxygdnZ,
	power_meter_record.p_zxygdn_1 AS zxygdnJ,
	power_meter_record.p_zxygdn_2 AS zxygdnF,
	power_meter_record.p_zxygdn_3 AS zxygdP,
	power_meter_record.p_zxygdn_4 AS zxygdnG
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
		AND p_time BETWEEN '2018-05-07'
		AND '2018-05-11'
		GROUP BY
			DAY (power_meter_record.p_time),
			power_meter_record.p_code
	)
AND power_meter_info.meter_code = power_meter_record.p_code