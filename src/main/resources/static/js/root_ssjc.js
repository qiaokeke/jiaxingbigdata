var companyInfomatins; //定义全局变量，存储公司信息

// 获取公司信息
$.ajax({
    url: '/jx/api/company/companyInfos',
    dataType: 'json',
    success: function (info) {
        companyInfomatins = info;
        $("#aCode").html(info[0].companyName);
        $("#cName").html(info[0].companyName);
        for (var p in info) {
            $("#companyNameList").append('<option value=' + info[p].companyCode + '>' + info[p].companyCode + ' ' + info[p].companyName + '</option>');
        }
        //填充到公司电表信息下拉框
        if (info[0].powerMeterInfos.length != 0) {
            for (var i in info[0].powerMeterInfos) {
                $("#companyMeterList").append('<option value=' + info[0].powerMeterInfos[i].pCode + '>' + info[0].powerMeterInfos[i].pCode + ' ' + info[0].powerMeterInfos[i].pName + '</option>');
            }
        }
    },
    error: function () {
        console.log("公司信息获取失败。");
    }
});

//当选择公司下拉框发生改变时
$("#companyNameList").change(function () {
    // companyInfomatins = JSON.parse(companyInfomatins);
    var comIndex = parseInt($("#companyNameList").val()) - 1;
    $("#companyMeterList").html("");
    $("#companyMeterList").append('<option value=' + 0 + '>' + '0  所有电表</option>');
    // 填充到公司电表信息下拉框
    if (companyInfomatins[comIndex].powerMeterInfos.length != 0) {
        for (var i in companyInfomatins[comIndex].powerMeterInfos) {
            $("#companyMeterList").append('<option value="' + companyInfomatins[comIndex].powerMeterInfos[i].pCode + '">' + companyInfomatins[comIndex].powerMeterInfos[i].pCode + ' ' + companyInfomatins[comIndex].powerMeterInfos[i].pName + '</option>');
        }
    }
});

function GetArgsFromHref(sHref, sArgName) {
    var args = sHref.split("?");
    var retval = "";
    /*参数为空*/
    if (args[0] == sHref) {
        return retval;
    }
    var str = args[1];
    args = str.split("&");
    for (var i = 0; i < args.length; i++) {
        str = args[i];
        var arg = str.split("=");
        if (arg.length <= 1) continue;
        if (arg[0] == sArgName) retval = arg[1];
    }
    return retval;
}

<!--加载导航条-->
$(function () {
    //让下拉框显示当前年月份
    var thisdate = new Date();
    var thisMonth = thisdate.getMonth() + 1;
    var thisYear = thisdate.getFullYear();
    $("#month option:nth-child(" + thisMonth + ")").attr('selected', 'selected');
    $("#year option[value=" + thisYear + "]").attr('selected', 'selected');
    /*加载导航条*/
    var params;
    var value = GetArgsFromHref(window.location.href, params);
});
/**/

/*实时数据*/
$(function () {
    var WEChart = echarts.init(document.getElementById('curdata'));
    var xData = function () {
        var data = [];
        for (var i = 1; i <= 24; i++) {
            data.push(i + "时");
        }
        return data;
    }();
    //设置默认值
    var data_power = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
    WEChart.showLoading();
    option = {
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross',
                crossStyle: {
                    color: '#999'
                }
            }
        },
        grid: {
            bottom: 80
        },
        toolbox: {
            feature: {
                dataView: {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar']},
                restore: {show: true},
                saveAsImage: {show: true},
                dataZoom: {
                    yAxisIndex: 'none'
                }
            }
        },
        dataZoom: [{
            show: true, //dataZoom，框选区域缩放，自动与存在的dataZoom控件同步，分别是启用，缩放后退
            start: 10,
            end: 80
        }],
        legend: {
            data: ['用电量']
        },

        xAxis: [{
            type: 'category',
            axisPointer: {
                type: 'shadow'
            },
            axisLabel: {
                interval: 0
            },
            data: xData
        }],
        yAxis: [
            {
                type: 'value',
                name: '用电量',
                axisLabel: {
                    formatter: '{value} KWH'
                },
                splitLine: {
                    lineStyle: {
                        color: '#2F4554'
                    }
                }
            }
        ],
        series: [
            {
                name: '用电量',
                type: 'bar',
                data: data_power
            }
        ]
    };
    WEChart.hideLoading();
    WEChart.setOption(option);

    // 获取实时电能
    function getMyJson(powerParamsData) {
        $.ajax({
            type: 'GET',
            dataType: 'json',
            async: false,
            url: "/jx/api/tDayZXYGDNHourViews",
            data: powerParamsData,
            success: function (myJson) {
                //处理时间
                for (var index in myJson) {
                    var timeStr = myJson[index].time.split(' ');
                    myJson[index].time = timeStr[1];
                    timeStr = myJson[index].time.split(":");
                    myJson[index].time = parseInt(timeStr[0]);
                }
                for (var i in myJson) {
                    if (myJson[i].zxygdn && myJson[i] != 0) {
                        data_power[myJson[i].time - 1] = myJson[i].zxygdn;
                    }
                }
                WEChart.hideLoading();
                WEChart.setOption({
                    series: [
                        {
                            name: '用电量',
                            data: data_power
                        }
                    ]
                });
            },
            error: function () {
                console.log("实时监测json信息读取失败");
            }
        });
    }

    // 请求实时电能参数
    var powerParamsData = {
        companyCode: 1,
        pCode: 0
    };
    getMyJson(powerParamsData);

    /*能耗日历 分时能耗*/

    //获取当前年月
    var myDate = new Date();
    var thisYear = myDate.getFullYear();
    var thisMonth = myDate.getMonth() + 1;
    var dateRange = ['2017-08-01', '2017-08-31'];
    //月份的天数
    var numDate1 = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
    var numDate2 = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
    var s = thisYear + '-' + thisMonth + '-01';
    if (thisMonth != 2) {
        e = thisYear + "-" + thisMonth + "-" + numDate1[thisMonth - 1];
    } else {
        //闰年
        if (thisYear % 4 == 0 && (thisYear % 100 != 0 || thisYear % 400 == 0)) {
            e = thisYear + "-" + thisMonth + "-" + numDate1[1];
        }
        //平年
        else {
            e = thisYear + "-" + thisMonth + "-" + numDate2[1];
        }
    }
    dateRange = [s, e];
    var ClaChart = echarts.init(document.getElementById('calendar1'));
    ClaChart.showLoading();

    function setClendarOption(calendarParamsData) {
        $.ajax({
            type: 'GET',
            dataType: "json",
            async: false,
            url: "/jx/api/tsMonthZXYGDNDayViews",
            data: calendarParamsData,
            success: function (myJson) {
                //处理时间
                for (var i in myJson) {
                    var d = myJson[i].time.split("-");
                    myJson[i].time = parseInt(d[2]);
                }

                function getVirtulData(year, month) {
                    year = year || '2017';
                    var date = +echarts.number.parseDate(year + '-' + month + '-01');
                    var end = +echarts.number.parseDate((+year) + '-' + (month + 1) + '-01');
                    var dayTime = 3600 * 24 * 1000;
                    var data = [];
                    for (var time = date; time < end; time += dayTime) {
                        data.push([
                            echarts.format.formatTime('yyyy-MM-dd', time), 0]);
                    }
                    for (var index in myJson) {
                        data[myJson[index].time - 1][1] = myJson[index].zxygdn;
                    }
                    return data;
                }

                var data = getVirtulData(thisYear, thisMonth);

                option = {
                    title: {
                        top: 6,
                        text: '能耗日历',
                        left: 'center',
                        textStyle: {
                            color: '#000'
                        }
                    },
                    tooltip: {
                        trigger: 'item',
                        formatter: function (params) {
                            return params.value[0] + '  ' + '能耗: ' + params.value[1];
                        }
                    },
                    legend: {
                        top: '30',
                        left: '900',
                        data: ['能耗', 'Top'],
                        textStyle: {
                            color: '#000'
                        }
                    },
                    visualMap: {
                        show: false,
                        min: 0,
                        max: 300,
                        inRange: {
                            color: ['#66CDAA', '#006edd'],
                            opacity: 0.3
                        },
                        controller: {
                            inRange: {
                                opacity: 0.5
                            }
                        }
                    },
                    calendar: [{
                        top: 80,
                        left: 'center',
                        range: dateRange,
                        splitLine: {
                            show: true,
                            lineStyle: {
                                color: '#000',
                                width: 1,
                                type: 'solid'
                            }
                        },
                        cellSize: [50, 50],
                        orient: 'vertical',
                        dayLabel: {
                            firstDay: 1,
                            nameMap: 'cn'
                        },
                        yearLabel: {show: false},
                        monthLabel: {
                            nameMap: 'cn',
                            show: true
                        },
                        itemStyle: {
                            normal: {
                                borderWidth: 0.6,
                                borderColor: '#111'
                            }
                        }
                    }],
                    series: [{
                        name: '能耗',
                        type: 'effectScatter',
                        coordinateSystem: 'calendar',
                        data: data,
                        /*随机获取scatter的大小*/
                        symbolSize: function (val) {
                            return Math.abs(val[1]) / 5 > 10 ? 5 : Math.abs(val[1]) / 5;
                        },
                        itemStyle: {
                            normal: {
                                color: '#ddb926'
                            }
                        }
                    },
                        {
                            name: 'Top',
                            type: 'effectScatter',
                            coordinateSystem: 'calendar',
                            calendarIndex: 0,
                            data: data.sort(function (a, b) {
                                return b[1] - a[1];
                            }).slice(0, 5),
                            symbolSize: function (val) {
                                return Math.abs(val[1]) / 50 > 30 ? 5 : Math.abs(val[1]) / 50;
                            },
                            showEffectOn: 'render',
                            rippleEffect: {
                                brushType: 'stroke'
                            },
                            hoverAnimation: true,
                            itemStyle: {
                                normal: {
                                    color: '#f4e925',
                                    shadowBlur: 10,
                                    shadowColor: '#333'
                                }
                            },
                            zlevel: 1
                        }, {
                            type: 'heatmap',
                            coordinateSystem: 'calendar',
                            data: data,
                            symbolSize: 1,
                            itemStyle: {
                                normal: {
                                    color: '#fff'
                                }
                            }
                        }
                    ]
                };
                ClaChart.hideLoading();
                ClaChart.setOption(option);
            },
            error: function () {
                console.log("分时能耗日历json信息读取失败");
            }
        });

        ClaChart.on('click', function (params) {
            var useage = echarts.init(document.getElementById('useage'));
            useage.showLoading();
            //分时能耗
            var data_timeConsumption = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
            var all_consumption = 0;
            option1 = {
                title: {
                    text: params.value[0],
                    x: 'center'
                },
                tooltip: {
                    trigger: 'item',
                    position: ['48.5%', '49.2%'],
                    backgroundColor: 'rgba(50,50,50,0)',
                    textStyle: {
                        color: 'yellow',
                        fontWeight: 'bold'
                    },
                    formatter: "{d}%"
                },
                series: [{
                    name: '上网时间',
                    type: 'pie',
                    radius: ['5%', '70%'],
                    roseType: 'area',
                    color: ['#3fa7dc'],
                    data: data_timeConsumption,
                    labelLine: {
                        normal: {
                            show: false
                        }
                    },
                    label: {
                        normal: {
                            show: false
                        }
                    },
                    itemStyle: {
                        normal: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        },
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                },
                    {
                        name: '',
                        type: 'gauge',
                        min: 0,
                        max: 24,
                        startAngle: 90,
                        endAngle: 449.9,
                        radius: '85%',
                        splitNumber: 24,
                        clockwise: false,
                        animation: false,
                        detail: {
                            formatter: '{value}',
                            textStyle: {
                                color: '#63869e'
                            }
                        },
                        detail: {
                            show: false
                        },
                        axisTick: {
                            show: false
                        },
                        axisLine: {
                            lineStyle: {
                                color: [
                                    [0.083, '#3EBF3E'],
                                    [0.125, '#024287'],
                                    [0.208, '#C23531'],
                                    [0.458, '#024287'],
                                    [0.542, '#3EBF3E'],
                                    [0.667, '#024287'],
                                    [1, '#3EBF3E'],
                                ],
                                width: '40%',
                                shadowColor: '#0d4b81', //默认透明
                                shadowBlur: 40,
                                opacity: 1
                            }
                        },
                        splitLine: {
                            length: 5,
                            lineStyle: {
                                color: '#ffffff',
                                width: 2
                            }
                        },
                        axisLabel: {
                            formatter: function (v) {
                                return v ? v : '';
                            },
                            textStyle: {
                                color: "white",
                                fontWeight: 700
                            }
                        },
                        itemStyle: {
                            normal: {
                                color: 'green',
                                width: 2
                            }
                        }
                    },
                    {
                        name: '',
                        type: 'gauge',
                        min: 0,
                        max: 24,
                        startAngle: 90,
                        endAngle: 449.9,
                        radius: '72%',
                        splitNumber: 24,
                        clockwise: false,
                        animation: false,
                        detail: {
                            formatter: '{value}',
                            textStyle: {
                                color: '#63869e'
                            }
                        },
                        detail: {
                            show: false
                        },
                        axisTick: {
                            show: false
                        },
                        axisLine: {
                            lineStyle: {
                                color: [
                                    [1, '#E8E8E8']
                                ],
                                width: '10%',
                                opacity: 0.8
                            }
                        },
                        splitLine: {
                            show: true,
                            length: '92%',
                            lineStyle: {
                                color: 'grey',
                                width: '1'
                            }
                        },
                        axisLabel: {
                            show: false,
                            formatter: function (v) {
                                return v ? v : '';
                            },
                            textStyle: {
                                color: "#fb5310",
                                fontWeight: 700
                            }
                        },
                        itemStyle: {
                            normal: {
                                color: 'green',
                                width: 2,
                                borderWidth: 3,
                            }
                        }
                    }
                ]
            };
            useage.hideLoading();
            useage.setOption(option1);

            $.ajax({
                type: 'POST',
                dataType: 'json',
                async: true,
                url: "/jx/api/dayZXYGDNHourViews",
                data: {
                    companyCode: $("#companyNameList").val(),
                    pCode: $("#companyMeterList").val(),
                    time: params.value[0]
                },
                success: function (data) {
                    //处理时间
                    for (var p in data) {
                        var timeStr = data[p].time.split(" ");
                        data[p].time = timeStr[1];
                        timeStr = data[p].time.split(":");
                        data[p].time = parseInt(timeStr[0]);
                    }
                    //装入数据
                    for (var index in data) {
                        if (data[index].time !== 0) {
                            data_timeConsumption[data[index].time - 1] = data[index].zxygdn;
                            all_consumption += parseInt(data[index].zxygdn);
                        }
                    }
                    //表格重新绘制
                    useage.hideLoading();
                    useage.setOption({
                        title: {
                            text: params.value[0] + " " + params.value[1]  //显示日期和当天的总耗能
                        },
                        series: [{
                            name: '上网时间',
                            data: data_timeConsumption,
                        }]
                    });
                },
                error: function () {
                    console.log("json信息请求失败");
                }
            });
        });
    }

    var calendarParamsData = {
        companyCode: 1,
        pCode: 0
    };
    setClendarOption(calendarParamsData);

    /*能耗目标----耗电情况*/
    var powerChart = echarts.init(document.getElementById('electrical'));
    powerChart.showLoading();
    var percent = 26.8 + '%';

    function getData() {
        return [{
            value: percent,
            itemStyle: {
                normal: {
                    color: '#89C222',
                    shadowBlur: 5,
                    shadowColor: '#89C222'
                }
            }
        }, {
            value: 100 - percent,
            itemStyle: {
                normal: {
                    color: 'transparent'
                }
            }
        }];
    }

    option = {
        title: {
            text: (percent) + '',
            x: 'center',
            y: 'center',
            textStyle: {
                color: '#98a0c4',
                fontWeight: 'bolder',
                fontSize: 44
            }
        },
        series: [{
            type: 'pie',
            radius: ['39%', '49%'],
            silent: true,
            label: {
                normal: {
                    show: false
                }
            },

            data: [{
                value: 1,
                itemStyle: {
                    normal: {
                        color: '#313443',
                        shadowBlur: 10,
                        shadowColor: '#1b1e25'


                    }
                }
            }],

            animation: false
        },

            {
                type: 'pie',
                radius: ['39%', '49%'],
                silent: true,
                label: {
                    normal: {
                        show: false,
                    }
                },

                data: [{
                    value: 1,
                    itemStyle: {
                        normal: {
                            color: '#313443',
                            shadowBlur: 10,
                            shadowColor: '#1b1e25'
                        }
                    }
                }],

                animation: false
            },

            {
                name: 'main',
                type: 'pie',
                radius: ['50%', '51%'],
                label: {
                    normal: {
                        show: false,
                    }
                },
                data: getData(),

                animationEasingUpdate: 'cubicInOut',
                animationDurationUpdate: 1000
            }
        ]
    };
    powerChart.hideLoading();
    powerChart.setOption(option);

    /*能耗目标----耗水情况*/
    var waterChart = echarts.init(document.getElementById('water'));
    waterChart.showLoading();
    var option = {
        series: [{
            name: '用水情况',
            type: 'liquidFill',
            radius: '50%',
            data: [0.89],
            label: {
                normal: {
                    //                        formatter: '{a}\n {c}',
                    textStyle: {
                        color: 'red',
                        insideColor: 'yellow',
                        fontSize: 30
                    }
                }
            }
        }]
    };
    waterChart.hideLoading();
    waterChart.setOption(option);

    /*能耗目标----企业分类*/
    var compareChart = echarts.init(document.getElementById('comType'));
    compareChart.showLoading();
    option = {
        tooltip: {},
        legend: {
            top: 18,
            data: ['该公司', '同行业']
        },
        radar: {
            // shape: 'circle',
            indicator: [
                {name: '1月', max: 1650},
                {name: '2月', max: 3000},
                {name: '3月', max: 3800},
                {name: '4月', max: 3800},
                {name: '5月', max: 3800},
                {name: '6月', max: 3800},
                {name: '7月', max: 3800},
                {name: '8月', max: 3800},
                {name: '9月', max: 2600},
                {name: '10月', max: 650},
                {name: '11月', max: 6500},
                {name: '12月', max: 6500}
            ]
        },
        series: [{

            type: 'radar',
            data: [{
                value: [600, 800, 680, 790, 960, 1020, 1020, 0, 0, 0, 0, 0],
                name: '该公司'
            },
                {
                    value: [900, 1400, 1680, 2110, 2510, 2810, 2810, 0, 0, 0, 0, 0],
                    name: '同行业'
                }
            ]
        }]
    };
    compareChart.hideLoading();
    compareChart.setOption(option);

    /*可用余额*/
    var myChartYE = echarts.init(document.getElementById('left_money'));
    myChartYE.showLoading();
    option = {
        tooltip: {
            formatter: "{a} <br />{b} : {c}%"
        },
        toolbox: {
            feature: {
                restore: {},
                saveAsImage: {}
            }
        },
        series: [{
            name: '用电量',
            type: 'gauge',
            radius: '60%',
            center: ['75%', '50%'],
            title: {
                textStyle: { // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                    fontWeight: 'bolder',
                    fontSize: 22,
                    fontStyle: 'italic'
                }
            },
            detail: {
                formatter: '{value}%',
                textStyle: { // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                    fontWeight: 'bolder',
                    fontSize: 18
                }
            },
            data: [{value: 8, name: '用电量'}]
        },
            {
                name: '用水量',
                type: 'gauge',
                radius: '55%',
                center: ['25%', '50%'],
                title: {
                    textStyle: { // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                        fontWeight: 'bolder',
                        fontSize: 22,
                        fontStyle: 'italic'
                    }
                },
                detail: {
                    formatter: '{value}%',
                    textStyle: { // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                        fontWeight: 'bolder',
                        fontSize: 18
                    }
                },
                data: [{value: 3, name: '用水量'}]
            }

        ]
    };
    myChartYE.hideLoading();
    myChartYE.setOption(option);

    // 选择企业点击确定之后
    $("#selectCom").click(function () {
        // 刷新实时数据
        var powerParamsData = {
            companyCode: $("#companyNameList").val(),
            pCode: $("#companyMeterList").val()
        };
        getMyJson(powerParamsData);

        // 刷新分时能耗日历
        var calendarParamsData = {
            companyCode: $("#companyNameList").val(),
            pCode: $("#companyMeterList").val()
        };
        setClendarOption(calendarParamsData);

        // 刷新周能耗日历
        var weekClandarParamsData = {
            companyCode: $("#companyNameList").val(),
            pCode: $("#companyMeterList").val()
        };
        weekClandarGetJson(weekClandarParamsData);

        $("#aCode").html($("#companyNameList option:selected").text().split(" ")[1]);
        $("#cName").html($("#companyNameList option:selected").text().split(" ")[1]);
    });
});

//周能耗日历
function myMap(data) {
    var weekHours = ['1时', '2时', '3时', '4时', '5时', '6时',
        '7时', '8时', '9时', '10时', '11时', '12时',
        '13时', '14时', '15时', '16时', '17时', '18时',
        '19时', '20时', '21时', '22时', '23时', '24时'
    ];
    var weekDays = ['周一', '周二', '周三', '周四', '周五', '周六', '周日'];
    myData = [];
    var i = 0;
    for (var k = 0; k < weekDays.length; k++) {
        for (var j = 0; j < weekHours.length; j++) {
            myData.push([weekDays[k], weekHours[j], data[i][2]]);
            myData.push([weekDays[k], weekHours[j], 0]);
            i++;
        }
    }
    return myData;
}

$(function () {
    var weekHours = ['1时', '2时', '3时', '4时', '5时', '6时',
        '7时', '8时', '9时', '10时', '11时', '12时',
        '13时', '14时', '15时', '16时', '17时', '18时',
        '19时', '20时', '21时', '22时', '23时', '24时'
    ];
    var weekDays = ['周一', '周二', '周三', '周四', '周五', '周六', '周日'];
    var weekCladarData = [
        [0, 0, 0], [0, 1, 0], [0, 2, 0], [0, 3, 0], [0, 4, 0], [0, 5, 0], [0, 6, 0], [0, 7, 0], [0, 8, 0], [0, 9, 0], [0, 10, 0], [0, 11, 0], [0, 12, 0],
        [0, 13, 0], [0, 14, 0], [0, 15, 0], [0, 16, 0], [0, 17, 0], [0, 18, 0], [0, 19, 0], [0, 20, 0], [0, 21, 0], [0, 22, 0], [0, 23, 0], [1, 0, 0],
        [1, 1, 0], [1, 2, 0], [1, 3, 0], [1, 4, 0], [1, 5, 0], [1, 6, 0], [1, 7, 0], [1, 8, 0], [1, 9, 0], [1, 10, 0], [1, 11, 0], [1, 12, 0], [1, 13, 0],
        [1, 14, 0], [1, 15, 0], [1, 16, 0], [1, 17, 0], [1, 18, 0], [1, 19, 0], [1, 20, 0], [1, 21, 0], [1, 22, 0], [1, 23, 0], [2, 0, 0], [2, 1, 0],
        [2, 2, 0], [2, 3, 0], [2, 4, 0], [2, 5, 0], [2, 6, 0], [2, 7, 0], [2, 8, 0], [2, 9, 0], [2, 10, 0], [2, 11, 0], [2, 12, 0], [2, 13, 0], [2, 14, 0],
        [2, 15, 0], [2, 16, 0], [2, 17, 0], [2, 18, 0], [2, 19, 0], [2, 20, 0], [2, 21, 0], [2, 22, 0], [2, 23, 0], [3, 0, 0], [3, 1, 0], [3, 2, 0], [3, 3, 0],
        [3, 4, 0], [3, 5, 0], [3, 6, 0], [3, 7, 0], [3, 8, 0], [3, 9, 0], [3, 10, 0], [3, 11, 0], [3, 12, 0], [3, 13, 0], [3, 14, 0], [3, 15, 0], [3, 16, 0],
        [3, 17, 0], [3, 18, 0], [3, 19, 0], [3, 20, 0], [3, 21, 0], [3, 22, 0], [3, 23, 0], [4, 0, 0], [4, 1, 0], [4, 2, 0], [4, 3, 0], [4, 4, 0], [4, 5, 0],
        [4, 6, 0], [4, 7, 0], [4, 8, 0], [4, 9, 0], [4, 10, 0], [4, 11, 0], [4, 12, 0], [4, 13, 0], [4, 14, 0], [4, 15, 0], [4, 16, 0], [4, 17, 0], [4, 18, 0],
        [4, 19, 0], [4, 20, 0], [4, 21, 0], [4, 22, 0], [4, 23, 0], [5, 0, 0], [5, 1, 0], [5, 2, 0], [5, 3, 0], [5, 4, 0], [5, 5, 0], [5, 6, 0], [5, 7, 0],
        [5, 8, 0], [5, 9, 0], [5, 10, 0], [5, 11, 0], [5, 12, 0], [5, 13, 0], [5, 14, 0], [5, 15, 0], [5, 16, 0], [5, 17, 0], [5, 18, 0], [5, 19, 0], [5, 20, 0],
        [5, 21, 0], [5, 22, 0], [5, 23, 0], [6, 0, 0], [6, 1, 0], [6, 2, 0], [6, 3, 0], [6, 4, 0], [6, 5, 0], [6, 6, 0], [6, 7, 0], [6, 8, 0], [6, 9, 0], [6, 10, 0],
        [6, 11, 0], [6, 12, 0], [6, 13, 0], [6, 14, 0], [6, 15, 0], [6, 16, 0], [6, 17, 0], [6, 18, 0], [6, 19, 0], [6, 20, 0], [6, 21, 0], [6, 22, 0], [6, 23, 0]
    ];

    calendarWeekOption = {
        tooltip: {},
        toolbox: {
            feature: {
                dataView: {show: true, readOnly: false},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        visualMap: [{
            type: 'continuous',
            min: 0,
            max: 15,
            range: [0, 15],
            calculable: true,
            bottom: '10%'
        }],
        grid3D: {
            show: true,
            boxWidth: 70,
            boxHeight: 100,
            boxDepth: 250,
            light: {
                main: {
                    shadow: true
                }
            },
            viewControl: {
                damping: 0.9,
                distance: 280,
                center: [0, -40, 0]
            }
        },
        xAxis3D: {
            show: true,
            name: 'X',
            type: 'category',
            data: weekDays
        },
        yAxis3D: {
            show: true,
            name: 'Y',
            type: 'category',
            data: weekHours
        },
        zAxis3D: {
            show: true,
            name: 'Z',
            type: 'value',
            axisLabel: {
                formatter: '{value}kw/h'
            },
            nameGap: 25
        },
        series: {
            type: 'bar3D',
            shading: 'lambert',
            name: '能耗',
            data: myMap(weekCladarData),
            emphasis: {
                itemStyle: {
                    color: 'red'
                }
            },
            itemStyle: {
                opacity: 0.8
            }
        }
    };
    calendarWeek.hideLoading();
    calendarWeek.setOption(calendarWeekOption);
});

function weekClandarGetJson(weekClandarParamsData) {
    calendarWeek = echarts.init(document.getElementById("calendar-week"));
    $.ajax({
        url: "/jx/api/tswkZXYGDNHourViews",
        dataType: 'json',
        data: weekClandarParamsData,
        success: function (myJson) {
            //重置
            weekCladarData = [
                [0, 0, 0], [0, 1, 0], [0, 2, 0], [0, 3, 0], [0, 4, 0], [0, 5, 0], [0, 6, 0], [0, 7, 0], [0, 8, 0], [0, 9, 0], [0, 10, 0], [0, 11, 0], [0, 12, 0],
                [0, 13, 0], [0, 14, 0], [0, 15, 0], [0, 16, 0], [0, 17, 0], [0, 18, 0], [0, 19, 0], [0, 20, 0], [0, 21, 0], [0, 22, 0], [0, 23, 0], [1, 0, 0],
                [1, 1, 0], [1, 2, 0], [1, 3, 0], [1, 4, 0], [1, 5, 0], [1, 6, 0], [1, 7, 0], [1, 8, 0], [1, 9, 0], [1, 10, 0], [1, 11, 0], [1, 12, 0], [1, 13, 0],
                [1, 14, 0], [1, 15, 0], [1, 16, 0], [1, 17, 0], [1, 18, 0], [1, 19, 0], [1, 20, 0], [1, 21, 0], [1, 22, 0], [1, 23, 0], [2, 0, 0], [2, 1, 0],
                [2, 2, 0], [2, 3, 0], [2, 4, 0], [2, 5, 0], [2, 6, 0], [2, 7, 0], [2, 8, 0], [2, 9, 0], [2, 10, 0], [2, 11, 0], [2, 12, 0], [2, 13, 0], [2, 14, 0],
                [2, 15, 0], [2, 16, 0], [2, 17, 0], [2, 18, 0], [2, 19, 0], [2, 20, 0], [2, 21, 0], [2, 22, 0], [2, 23, 0], [3, 0, 0], [3, 1, 0], [3, 2, 0], [3, 3, 0],
                [3, 4, 0], [3, 5, 0], [3, 6, 0], [3, 7, 0], [3, 8, 0], [3, 9, 0], [3, 10, 0], [3, 11, 0], [3, 12, 0], [3, 13, 0], [3, 14, 0], [3, 15, 0], [3, 16, 0],
                [3, 17, 0], [3, 18, 0], [3, 19, 0], [3, 20, 0], [3, 21, 0], [3, 22, 0], [3, 23, 0], [4, 0, 0], [4, 1, 0], [4, 2, 0], [4, 3, 0], [4, 4, 0], [4, 5, 0],
                [4, 6, 0], [4, 7, 0], [4, 8, 0], [4, 9, 0], [4, 10, 0], [4, 11, 0], [4, 12, 0], [4, 13, 0], [4, 14, 0], [4, 15, 0], [4, 16, 0], [4, 17, 0], [4, 18, 0],
                [4, 19, 0], [4, 20, 0], [4, 21, 0], [4, 22, 0], [4, 23, 0], [5, 0, 0], [5, 1, 0], [5, 2, 0], [5, 3, 0], [5, 4, 0], [5, 5, 0], [5, 6, 0], [5, 7, 0],
                [5, 8, 0], [5, 9, 0], [5, 10, 0], [5, 11, 0], [5, 12, 0], [5, 13, 0], [5, 14, 0], [5, 15, 0], [5, 16, 0], [5, 17, 0], [5, 18, 0], [5, 19, 0], [5, 20, 0],
                [5, 21, 0], [5, 22, 0], [5, 23, 0], [6, 0, 0], [6, 1, 0], [6, 2, 0], [6, 3, 0], [6, 4, 0], [6, 5, 0], [6, 6, 0], [6, 7, 0], [6, 8, 0], [6, 9, 0], [6, 10, 0],
                [6, 11, 0], [6, 12, 0], [6, 13, 0], [6, 14, 0], [6, 15, 0], [6, 16, 0], [6, 17, 0], [6, 18, 0], [6, 19, 0], [6, 20, 0], [6, 21, 0], [6, 22, 0], [6, 23, 0]
            ];
            //处理时间
            var date = new Date();
            for (var i in myJson) {
                myJson[i].time = myJson[i].time.split(' ');
                var thatDay = new Date(myJson[i].time[0] + '').getDay();
                thatDay = parseInt(thatDay);
                if (parseInt(thatDay) == 0) {
                    thatDay = 7;
                }
                myJson[i].time = myJson[i].time[1].split(":");
                var thatHour = parseInt(myJson[i].time[0]);
                weekCladarData[(thatDay - 1) * 24 + thatHour - 1][2] = myJson[i].zxygdn;
            }
            calendarWeek.hideLoading();
            calendarWeek.setOption({
                series: {
                    data: myMap(weekCladarData)
                }
            });
        },
        error: function () {
            console.log('周能耗json请求失败');
        }
    })
}

var weekClandarParamsData = {
    companyCode: 1,
    pCode: 0
};
weekClandarGetJson(weekClandarParamsData);