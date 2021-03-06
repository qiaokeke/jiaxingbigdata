$(function (){
        mChart1 = echarts.init(document.getElementById('ele'));
        mChart1.showLoading();
        mChart1.title = '某站点用户访问来源';
        var data_tip = [0,0,0,0,0,0,0];  //尖能耗
        var data_peak = [0,0,0,0,0,0,0];  //峰能耗
        var data_valley = [0,0,0,0,0,0,0]; //谷能耗
        var data_total = [0,0,0,0,0,0,0];  //总能耗
        option = {
            tooltip : {
                trigger: 'axis',
                axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                    type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                }
            },
            toolbox: {
                feature: {
                    dataView: { show: true, readOnly: false },
                    restore: { show: true },
                    saveAsImage: { show: true }
                }
            },
            legend: {
                data: ['尖能耗', '峰能耗','谷能耗','总能耗']
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            xAxis:  {
                type: 'value'
            },
            yAxis: {
                type: 'category',
                data: ['周一','周二','周三','周四','周五','周六','周日']
            },
            series: [
                {
                    name: '尖能耗',
                    type: 'bar',
                    stack: '总量',
                    label: {
                        normal: {
                            show: true,
                            position: 'insideRight'
                        }
                    },
                    data:data_tip
                },
                {
                    name: '峰能耗',
                    type: 'bar',
                    stack: '总量',
                    label: {
                        normal: {
                            show: true,
                            position: 'insideRight'
                        }
                    },
                    data: data_peak
                },
                {
                    name: '谷能耗',
                    type: 'bar',
                    stack: '总量',
                    label: {
                        normal: {
                            show: true,
                            position: 'insideRight'
                        }
                    },
                    data: data_valley
                },
                {
                    name: '总能耗',
                    type: 'bar',
                    stack: '总量',
                    label: {
                        normal: {
                            show: true,
                            position: 'insideRight'
                        }
                    },
                    data: data_total
                }

            ]
        };
        mChart1.hideLoading();
        mChart1.setOption(option);

        click_qynh = false;
        $("#qynh").click(function(){
            if(!click_qynh){
                $.ajax({
                    type: 'POST',
                    dataType: 'json',
                    async: true,
                    url: '/jx/api/tswkZJFPGViews?companyCode=1&pCode=0',
                    success: function(data) {
                        //处理时间为星期几
                        for(var index in data){
                            data[index].time = new Date(data[index].time+'').getDay();
                        }
                        //装入数据
                        for (var index in data) {
                            var date = parseInt(data[index].time);
                            if(date!=0){
                                data_tip[date - 1] = data[index].zxygdnJ;
                                data_peak[date - 1] = data[index].zxygdnF;
                                data_valley[date - 1] = data[index].zxygdnG;
                                data_total[date -1 ] = data[index].zxygdnZ;
                            }else{
                                data_tip[6] = data[index].zxygdnJ;
                                data_peak[6] = data[index].zxygdnF;
                                data_valley[6] = data[index].zxygdnG;
                                data_total[6] = data[index].zxygdnZ;
                            }
                        }
                        //表格重新绘制
                        mChart1.hideLoading();
                        mChart1.setOption({
                            series: [
                                {
                                    name: '尖能耗',
                                    data:data_tip
                                },
                                {
                                    name: '峰能耗',
                                    data: data_peak
                                },
                                {
                                    name: '谷能耗',
                                    data: data_valley
                                },
                                {
                                    name: '总能耗',
                                    data: data_total
                                }
                            ]
                        });
                    },
                    error: function() {
                        console.log("企业能耗json信息请求失败");
                    }
                });
                click_qynh = true;
            }
        });
    $("#clickNH").click(function(){
        var allConsumption = 0;//统计所有能耗
         data_tip = [0,0,0,0,0,0,0];  //尖能耗
         data_peak = [0,0,0,0,0,0,0];  //峰能耗
         data_valley = [0,0,0,0,0,0,0]; //谷能耗
         data_total = [0,0,0,0,0,0,0];  //总能耗
        var acode = $("#name").val();
        var pCode = $("#companyMeter").val();
        var setUrl = '/jx/api/tswkZJFPGViews?companyCode='+acode+'&pCode='+pCode;
        $.ajax({
            type: 'POST',
            dataType: 'json',
            async: true,
            url: setUrl,
            success: function(data) {
                //数据为空
                if(JSON.stringify(data) == '[]'){
                    nullData();
                    console.log("json请求成功，但该公司暂无数据！");
                }
                //处理时间
                for(var index in data){
                    data[index].time = new Date(data[index].time+'').getDay();
                }
                //装入数据
                for (var index in data) {
                    var date = parseInt(data[index].time);
                    if(date!=0){
                        data_tip[date - 1] = data[index].zxygdnJ;
                        data_peak[date - 1] = data[index].zxygdnF;
                        data_valley[date - 1] = data[index].zxygdnG;
                        data_total[date -1 ] = data[index].zxygdnZ;
                    }else{
                        data_tip[6] = data[index].zxygdnJ;
                        data_peak[6] = data[index].zxygdnF;
                        data_valley[6] = data[index].zxygdnG;
                        data_total[6] = data[index].zxygdnZ;
                    }

                }
                //再次判断，当数据全为0时提示无数据
                for(var i = 0;i < data_total.length;i++){
                    allConsumption += data_total[i];
                }
                if(allConsumption == 0){
                    nullData();
                }
                //表格重新绘制
                mChart1.hideLoading();
                mChart1.setOption({
                    series: [
                        {
                            name: '尖能耗',
                            data:data_tip
                        },
                        {
                            name: '峰能耗',
                            data: data_peak
                        },
                        {
                            name: '谷能耗',
                            data: data_valley
                        },
                        {
                            name: '总能耗',
                            data: data_total
                        }
                    ]
                });
            },
            error: function() {
                console.log("企业能耗json信息请求失败");
            }
        });
    });
    //当选择公司下拉框发生改变时
    $("#name").change(function(){
        // companyInfomatins = JSON.parse(companyInfomatins);
        var comIndex = parseInt($("#name").val()) - 1;
        $("#companyMeter").html("");
        $("#companyMeter").append('<option value='+0+'>'+'0  所有电表</option>');
        // 填充到公司电表信息下拉框
       if(companyInfomatins[comIndex].powerMeterInfos.length != 0){
           for(var i in companyInfomatins[comIndex].powerMeterInfos){
               $("#companyMeter").append('<option value='+companyInfomatins[comIndex].powerMeterInfos[i].pCode+'>'+companyInfomatins[comIndex].powerMeterInfos[i].pCode+' '+companyInfomatins[comIndex].powerMeterInfos[i].pName+'</option>');
           }
       }
    });
});
<!--对日历的操作限制-->
    function showChartZZT() {
        var queryHY = document.getElementById("name").value; //行业
        var queryQY = document.getElementById("name").value; //企业名称
        var queryTime_1 = document.getElementById("startdate").value;  //开始日期
        var queryTime_2 = document.getElementById("enddate").value;    //结束日期
    }

// 开始时间不能晚于结束时间
var modal = (function() {
    var initDate = function(startDateTimeId,endDateTimeId) {
        var startDate;
        var endDate;
        startDateTimeId="#"+startDateTimeId;
        endDateTimeId="#"+endDateTimeId;
        $(startDateTimeId).datetimepicker({
            format: 'Y-m-d',
            minDate: false,
            onChangeDateTime: function(dp, $input) {
                startDate = $(startDateTimeId).val();
            },
            onClose: function(current_time, $input) {
                if (startDate > endDate) {
                    $(startDateTimeId).val(endDate);
                    startDate=endDate;
                }
            }
        });
        $(endDateTimeId).datetimepicker({
            format: 'Y-m-d',
            onClose: function(current_time, $input) {
                endDate = $(endDateTimeId).val();
                if (startDate > endDate) {
                    $(endDateTimeId).val(startDate);
                    endDate=startDate;
                }
            }
        });
    };
    return {
        initDate: initDate
    };
})();
modal.initDate("startdate","enddate");
//只需要日期选择,disable时间选择器
$("#startdate").datetimepicker({ format: 'Y-m-d', timepicker: false });
$("#enddate").datetimepicker({ format: 'Y-m-d', timepicker: false });

<!--对选择条件进行的-->
    $(function  (){
        $("#test").on("click",function () {
            $("#name").empty();//首先清空select现在有的内容
            $("#name").append("<option selected='selected'  value=0>请选择..</option>");
            for (var i = 0; i < 10; i++) {
                $("#name").append("<option  value=" + i + ">" + i + "</option>");
            }
        });
    });