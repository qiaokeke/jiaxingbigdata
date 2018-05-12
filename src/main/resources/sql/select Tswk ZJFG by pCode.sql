SELECT
DATE_FORMAT(power_meter_record.p_time,'%Y-%m-%d') AS time,
power_meter_record.p_code as pCode,
power_meter_record.p_zxygdn AS zxygdnZ,
power_meter_record.p_zxygdn_1 AS zxygdnJ,
power_meter_record.p_zxygdn_2 AS zxygdnF,
power_meter_record.p_zxygdn_3 AS zxygdP,
power_meter_record.p_zxygdn_4 AS zxygdnG
FROM
power_meter_record
WHERE
 power_meter_record.id in(
SELECT
max(id)
FROM
power_meter_record
WHERE
power_meter_record.p_code=65381
AND
p_time
BETWEEN
'2018-05-07'
AND
'2018-05-11'
GROUP BY
DAY(power_meter_record.p_time),
power_meter_record.p_code
)