function showTable() {
    var queryType = document.getElementById("queryType").value;
    var queryTime = document.getElementById("datetimepicker").value;  //日期
    alert('提交数据为：'+" 查询类型="+queryType+"； 时间="+queryTime) ;
}
$(function () {
        mChart5  = echarts.init(document.getElementById("equalsTo"));
        mChart5.showLoading();
        var xData = function(){
            var data = [];
            for(var i=1;i<15;i++){
                data.push(i+"号店");
            }
            return data;
        }();
        option = {
            "title": {
                "text": "节能潜力",
                "subtext": "本公司 vs 行业平均",
                "x": "center"
            },
            "tooltip": {
                "trigger": "axis",
                "axisPointer": {
                    "type": "shadow"
                },
            },
            toolbox: {
                feature: {
                    dataView: { show: true, readOnly: false },
                    restore: { show: true },
                    saveAsImage: { show: true }
                }
            },
            "grid": {
                "borderWidth": 0,
                "y2": 200
            },
            "legend": {
                "x": "right",
                "data": [ ]
            },
            "calculable": true,
            "xAxis": [
                {
                    "type": "category",
                    "splitLine": {
                        "show": false
                    },
                    "axisTick": {
                        "show": false
                    },
                    "splitArea": {
                        "show": false
                    },
                    "axisLabel": {
                        "interval": 0,
                        "rotate": 45,
                        "show": true,
                        "splitNumber": 15,
                        "textStyle": {
                            "fontFamily": "微软雅黑",
                            "fontSize": 12
                        }
                    },
                    "data": [
                        '亮兮柯电气有限公司',
                        '捷顺旅游制品有限公司',
                        '福莱特玻璃集团股份有限公司',
                        '嘉兴协鑫环保热电有限公司',
                        '新天地纺织印染（嘉兴）有限公司',
                        '嘉兴敏胜汽车零部件有限公司',
                        '浙江嘉欣丝绸股份有限公司',
                        '浙江五芳斋实业股份有限公司',
                        '浙江福莱特玻璃有限公司',
                        '嘉兴丰利汇织造有限公司',
                        '嘉兴李朝化纤有限公司',
                        '嘉兴市兴嘉汽车零部件制造有限公司',
                        '浙江三和机电科技有限公司',
                        '上澎太阳能科技（嘉兴）有限公司',
                        '浙江生辉照明有限公司']
                }
            ],
            "yAxis": [
                {
                    "type": "value",
                    "splitLine": {
                        "show": false
                    },
                    "axisLine": {
                        "show": true
                    },
                    "axisTick": {
                        "show": false
                    },
                    "splitArea": {
                        "show": false
                    },
                    axisLabel: {
                        formatter: '{value} 吨标煤'
                    }
                }
            ],
            "dataZoom": [
                {
                    "show": true,
                    "height": 30,
                    "xAxisIndex": [
                        0
                    ],
                    bottom:20,
                    "start": 0,
                    "end": 80
                },
                {
                    "type": "inside",
                    "show": true,
                    "height": 15,
                    "xAxisIndex": [
                        0
                    ],
                    "start": 1,
                    "end": 35
                }
            ],
            "series": [
                {
                    "name": "上月",
                    "type": "bar",
                    "stack": "总量",
                    "barMaxWidth": 50,
                    "barGap": "10%",
                    "itemStyle": {
                        "normal": {
                            "barBorderRadius": 0,
                            "color": "rgba(60,169,196,0.5)",
                            "label": {
                                "show": true,
                                "textStyle": {
                                    "color": "rgba(0,0,0,1)"
                                },
                                "position": "insideTop",
                                formatter : function(p) {
                                    return p.value > 0 ? (p.value ): '';
                                }
                            }
                        }
                    },
                    "data": [20, 11, 15, 21, 21, 13, 8, 14, 17, 24, 23, 9, 9, 5,7]
                },
                {
                    "name": "少于平均",
                    "type": "bar",
                    "stack": "总量",
                    "itemStyle": {
                        "normal": {
                            "color": "rgba(51,204,112,1)",
                            "barBorderRadius": 0,
                            "label": {
                                "show": true,
                                "position": "top",
                                formatter : function(p) {
                                    return p.value > 0 ? ('▼'
                                        + p.value + '')
                                        : '';
                                }
                            }
                        }
                    },
                    "data": [76, 79.2, 80, 62.2, 76.1, 57.1, 50, 64.0, 74.6, 56, 58.15, 67.5, 57.0, 65.9,72.0]
                },
                {
                    "name": "高出平均",
                    "type": "bar",
                    "stack": "总量",
                    "itemStyle": {
                        "normal": {
                            "color": "rgba(193,35,43,1)",
                            "barBorderRadius": 0,
                            "label": {
                                "show": true,
                                "position": "top",
                                formatter : function(p) {
                                    return p.value > 0 ? ('▲'
                                        + p.value + '')
                                        : '';
                                }
                            }
                        }
                    },
                    "data": [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0]
                }
            ]
        };
        mChart5.hideLoading();
        mChart5.setOption(option);
        mChart5.on('click', function (params) {
            alert("点击柱子"+params.value);
        })
    })
