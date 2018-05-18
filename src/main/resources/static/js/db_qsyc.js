$(function () {
    var d = new Date();
    var thisMonth = d.getMonth() + 1;
    var selectedCompanyName = $("#qsComName option:selected").text().split(" ")[1] || "雅莹集团";
    /*企业能耗的点击事件*/
    var data_consition = [0, 0, 0, 0, 0, 0, 0];
    var myChart = echarts.init(document.getElementById('qsyc'));
    option = {
        title: {
            text: '折线图堆叠'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            top: 30,
            data: [selectedCompanyName]
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            top: 80,
            containLabel: true
        },
        toolbox: {
            feature: {
                dataView: {show: true, readOnly: false},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
        },
        yAxis: {
            type: 'value',

            axisLabel: {
                formatter: '{value} 千瓦时'
            }
        },
        series: [
            {
                name: selectedCompanyName,
                type: 'line',
                data: [0, 0, 0, 0, 0, 0, 0]
            }
        ]
    };
    myChart.setOption(option);
    $.ajax({
        type: 'POST',
        dataType: 'json',
        async: true,
        url: "/jx/api/tswkZXYGDNViews",
        data: {
            companyCode: 1,
            pCode: 0
        },
        success: function (data) {
            if (JSON.stringify(data) === '[]') {
                console.log("用电状态趋势json请求成功，但该公司暂无数据！");
                return 0;
            }
            //处理时间
            for (var index in data) {
                var timeStr = data[index].time.split(" ");
                data[index].time = timeStr[0];
                data[index].time = new Date(data[index].time + '').getDay();
            }
            //装入数据
            for (var i in data) {
                if (data[i].time != 0) {
                    data_consition[data[i].time - 1] = data[i].zxygdn;
                }
                else {
                    data_consition[6] = data[i].zxygdn;
                }
            }
            //表格重新绘制
            myChart.setOption({
                series: [
                    {
                        name: '湖州三盟纺织科技有限公司',
                        data: data_consition
                    }
                ]
            });
        },
        error: function () {
            console.log("用电状态及趋势json信息请求失败");
        }
    });
    $("#click_qs").click(function () {

        // 获取公司名
        var selectedCompanyName = $("#qsComName option:selected").text().split(" ")[1] || "雅莹集团";
        data_consition = [0, 0, 0, 0, 0, 0, 0];
        $.ajax({
            type: 'POST',
            dataType: 'json',
            async: true,
            url: "/jx/api/tswkZXYGDNViews",
            data: {
                companyCode: $("#qsComName").val(),
                pCode: $("#qsMeter").val()
            },
            success: function (data) {
                if (JSON.stringify(data) === '[]') {
                    nullData();
                    console.log("用电状态趋势json请求成功，但该公司暂无数据！");
                    myChart.setOption({
                        legend: {
                            top: 30,
                            data: [selectedCompanyName]
                        },
                        series: [
                            {
                                name: selectedCompanyName,
                                data: [0, 0, 0, 0, 0, 0, 0]
                            }
                        ]
                    });
                    return 0;
                }
                //判断是否全为0
                var ydztIsNull = true;
                for (var i in data) {
                    if (parseFloat(data[i].electricWeekCon) != 0) {
                        ydztIsNull = false;
                    }
                }
                if (ydztIsNull == true) {
                    nullData();
                }
                //处理时间
                for (var index in data) {
                    var timeStr = data[index].time.split(" ");
                    data[index].time = timeStr[0];
                    data[index].time = new Date(data[index].time + '').getDay();
                }
                //装入数据
                for (var i in data) {
                    if (data[i].time != 0) {
                        data_consition[data[i].time - 1] = data[i].zxygdn;
                    }
                    else {
                        data_consition[6] = data[i].zxygdn;
                    }
                }
                //表格重新绘制
                myChart.setOption({
                    legend: {
                        top: 30,
                        data: [selectedCompanyName]
                    },
                    series: [
                        {
                            name: selectedCompanyName,
                            data: data_consition
                        }
                    ]
                });
            },
            error: function () {
                console.log("用电状态及趋势json信息请求失败");
            }
        });
    });

    //当选择公司下拉框发生改变时
    $("#qsComName").change(function () {
        // companyInfomatins = JSON.parse(companyInfomatins);
        var comIndex = parseInt($("#qsComName").val()) - 1;
        $("#qsMeter").html("");
        $("#qsMeter").append('<option value=' + 0 + '>' + '0  所有电表</option>');
        // 填充到公司电表信息下拉框
        if (companyInfomatins[comIndex].powerMeterInfos.length != 0) {
            for (var i in companyInfomatins[comIndex].powerMeterInfos) {
                $("#qsMeter").append('<option value=' + companyInfomatins[comIndex].powerMeterInfos[i].pCode + '>' + companyInfomatins[comIndex].powerMeterInfos[i].pCode + ' ' + companyInfomatins[comIndex].powerMeterInfos[i].pName + '</option>');
            }
        }
    });
});

<!--日历使用的函数-->
function showChartZZT() {
    var queryHY = document.getElementById("queryHY").value; //行业
    var queryQY = document.getElementById("queryQY").value; //企业名称
    var queryTime_1 = document.getElementById("startdate").value;  //开始日期
    var queryTime_2 = document.getElementById("enddate").value;    //结束日期
    alert('提交数据为：' + "行业=" + queryHY + "； 企业=" + queryQY + "； 开始时间=" + queryTime_1 + "； 结束时间=" + queryTime_2);
}

// 开始时间不能晚于结束时间
var modal = (function () {
    var initDate = function (startDateTimeId, endDateTimeId) {
        var startDate;
        var endDate;
        startDateTimeId = "#" + startDateTimeId;
        endDateTimeId = "#" + endDateTimeId;
        $(startDateTimeId).datetimepicker({
            format: 'Y-m-d',
            minDate: false,
            onChangeDateTime: function (dp, $input) {
                startDate = $(startDateTimeId).val();
            },
            onClose: function (current_time, $input) {
                if (startDate > endDate) {
                    $(startDateTimeId).val(endDate);
                    startDate = endDate;
                }
            }
        });
        $(endDateTimeId).datetimepicker({
            format: 'Y-m-d',
            onClose: function (current_time, $input) {
                endDate = $(endDateTimeId).val();
                if (startDate > endDate) {
                    $(endDateTimeId).val(startDate);
                    endDate = startDate;
                }
            }
        });
    };
    return {
        initDate: initDate
    };
})();
modal.initDate("startdate", "enddate");
//只需要日期选择,disable时间选择器
$("#startdate").datetimepicker({format: 'Y-m-d', timepicker: false});
$("#enddate").datetimepicker({format: 'Y-m-d', timepicker: false});