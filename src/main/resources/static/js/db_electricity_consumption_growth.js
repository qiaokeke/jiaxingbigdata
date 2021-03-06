 function showChartBZT() {
        var  dateInfo = $("#queryTime").val()+"-"+$("#queryMonth").val()+"-01";
        // console.log("yue:"+$("#companyName").val());
        var acodeStr = $("#companyName").val().split(" ");
        var acode = acodeStr[0];
        var getUrl = "/analysis/compare?aCode="+acode+"&time="+dateInfo;
        console.log("url: "+getUrl);
        mChart4 = echarts.init(document.getElementById('growth'));
        mChart4.clear();
        mChart4.showLoading();
        option = {
                title : {
                    text:'用电同比增速',
                    x:'center'
                },
                toolbox: {
                    feature: {
                        dataView: { show: true, readOnly: false },
                        restore: { show: true },
                        saveAsImage: { show: true }
                    }
                },
                tooltip : {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                legend: {
                    orient: 'vertical',
                    left: 'left',
                    data: ['上一结算月用电量','此次结算月用电量']
                },
                series : [
                    {
                        name: '访问来源',
                        type: 'pie',
                        radius : '55%',
                        center: ['50%', '60%'],
                        data:[
                            {value:0, name:'上一结算月用电量'},
                            {value:0, name:'此次结算月用电量'}
                        ],
                        itemStyle: {
                            emphasis: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }
                    }
                ]
            };
        mChart4.hideLoading();
        mChart4.setOption(option);
        //获取实时数据
     $.ajax({
         type: 'GET',
         dataType: "json",
         async: false,
         url: getUrl,
         success: function (myJson) {
             //如果存在数
             if(JSON.stringify(myJson) != '[]'){
                 mChart4.hideLoading();
                 mChart4.setOption({
                     series : [
                         {
                             name: '访问来源',
                             data:[
                                 {value: myJson[0].lMonthCon, name:'上一结算月用电量'},
                                 {value: myJson[0].monthCon, name:'此次结算月用电量'}
                             ]
                         }
                     ]
                 });
             }
             else{
                 console.log("同比增长json信息读取成功,该企业该月暂无数据！");
                 return 0;
             }
         },
         error: function () {
             console.log("同比增长json信息读取失败,该企业可能暂无数据！");
         }
     })

     }