$(function() {
  $("#filter").css('height', $(window).height()); /*设置滤镜层可视高度高度为文档*/
  setInterval("clock()", 1000);
  item2();
  fontDiv();
  showEnergyProportion();
  showUserProportion();
  item3();
  getConsumptionTop5()
});

function clock() {
  var now = new Date().toLocaleString();
  $(".now").html(now);
}

function item2() {
  var item2 = echarts.init(document.getElementById("item2"));
  var option = {
    legend: {
      data: ['已购', '已用'],
      textStyle: {
        color: '#fff'
      }
    },
    tooltip: {},
    grid: {
      left: 50,
      right: 15,
      top: 40,
      bottom: 50
    },
    xAxis: {
      type: 'value',
      name: '吨标准煤',
      min: 0,
      max: 60,
      nameRotate: 45,
      nameGap: 5,
      nameLocation: 'start'
    },
    yAxis: {
      data: ['公司1', '公司2', '公司3', '公司4', '公司5']
    },
    textStyle: {
      color: '#fff'
    },
    series: [{
      type: 'bar',
      name: '已购',
      data: [58, 47, 35, 15, 27],
      itemStyle: {
        normal: {
          color: '#3D78D2',
          barBorderRadius: 10
        },
        emphasis: {
          shadowColor: '#3D78D2',
          shadowBlur: 5
        }
      }
    }, {
      type: 'bar',
      name: '已用',
      barGap: '-100%',
      data: [45, 35, 27, 10, 21],
      itemStyle: {
        normal: {
          color: '#7CF4F3',
          barBorderRadius: 10
        },
        emphasis: {
          shadowColor: '#7CF4F3',
          shadowBlur: 5
        }
      },
      barWidth: '40%'
    }]
  };
  item2.setOption(option);
}

function fontDiv() {
  var fontDiv = $("#fontDiv");
  var fDiv;
  fDiv = $("<div class='fDiv'>0</div>");
  fontDiv.append(fDiv);
  fDiv = $("<div class='fDiv'>0</div>");
  fontDiv.append(fDiv);
  fDiv = $("<div class='fDiv'>1</div>");
  fontDiv.append(fDiv);
  fDiv = $("<div class='fDiv'>4</div>");
  fontDiv.append(fDiv);
  fDiv = $("<div class='fDiv'>2</div>");
  fontDiv.append(fDiv);
  fDiv = $("<div class='fDiv'>1</div>");
  fontDiv.append(fDiv);
  fDiv = $("<div class='fDiv'>1</div>");
  fontDiv.append(fDiv);
  fDiv = $("<div class='fDiv'>7</div>");
  fontDiv.append(fDiv);
  fontDiv.append("<div style='background-color:transparent;color:#F2BD17;font-size:150%;width:10em;' class='fDiv text-left'>千克标煤</div>");
}

function item3() {
  myChart3 = echarts.init(document.getElementById('center-bottom'));
  // 指定图表的配置项和数据
   option3 = {
      title: {
          text: '能耗榜单',
          textAlign: 'center',
          x: 'center',
          textStyle: {
              color: 'white',
              fontSize: 20
          }
      },
      tooltip: {
          trigger: 'item',
          formatter: "{b}: <br/> {c}"
      },
      textStyle: {
          color: '#fff',
          fontSize: 20
      },
      grid: {
          show: false,
          left: 40,
          right: 40,
          top: 40,
          bottom: 0
      },
      xAxis: {
          show: false
      },
      yAxis: {
          data: [],
          show: false
      },
      series: [{
          name: '',
          type: 'bar',
          data: [/*{
              name: 'NO.5 湖州凯研生物科技有限公司',
              value: 180
          }, {
              name: 'NO.4 湖州优创电子商务有限公司',
              value: 280
          }, */{
              name: 'NO.3 湖州舒乐网络科技有限公司',
              value: 380
          }, {
              name: 'NO.2 湖州恩赐智能科技有限公司',
              value: 480
          }, {
              name: 'NO.1 湖州丽锦环保科技有限公司',
              value: 580
          }],
          itemStyle: {
              normal: {
                  color: '#7CF4F3'
              }
          },
          label: {
              normal: {
                  show: true,
                  position: 'topLeft',
                  formatter: '{b}'
              }
          },
          barWidth: '10%'
      }]
  };
    myChart3.setOption(option3);
}
//获取实时能耗排行
function getConsumptionSort() {
    $.ajax({
        url: '/company/getEConsumption',
        dataType: 'json',
        success: function (myJson) {
            for (var i = 0; i < myJson.length; i++) {
                var index = i + 1;
                $("#cons").append('<tr class=\"text-center\"><td><span class=\"badge\">' + index + '</span></td><td>' + myJson[i].eName + '</td><td>' + myJson[i].consumption + '</td><td>' + myJson[i].water + '</td></tr>');
            }
        }
    })
}

function getConsumptionTop5() {
    $.ajax({
        url: '/jx/api/top5Companys',
        dataType: 'json',
        success: function (myJson) {
            //能耗榜单前五名
            myChart3.setOption({
                series: [{
                    name: '',
                    data: [/*{
                        name: "NO.5 " + myJson[4].companyName,
                        value: myJson[4].zxygdn
                    }, {
                        name: "NO.4 " + myJson[3].companyName,
                        value: myJson[3].zxygdn
                    }, */{
                        name: "NO.3 " + myJson[2].companyName,
                        value: myJson[2].zxygdn
                    }, {
                        name: "NO.2 " + myJson[1].companyName,
                        value: myJson[1].zxygdn
                    }, {
                        name: "NO.1 " + myJson[0].companyName,
                        value: myJson[0].zxygdn
                    }]
                }]
            });
        },
        error: function () {
            console.log("能耗排行json数据获取失败！");
        }
    });
}

// 显示消耗能源占比
function showEnergyProportion() {
  var energyProportion = echarts.init(document.getElementById('right-bottom'));
  option = {
    title: {
      text: '能源消耗占比',
      x: 'center',
      top: 40,
      textStyle: {
        color: 'white',
        fontSize: 20,
        fontWeight: 'bold'
      }
    },
    tooltip: {
      trigger: 'item',
      formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
      x: 'center',
      y: 'bottom',
      data: ['电能', '水'],
      textStyle: { //控制图例颜色
        color: 'white',
        fontWeight: 'bold',
        fontSize: 12
      }
    },
    color: [ /*'rgb(247,140,0)', */ 'rgb(242,7,100)', 'rgb(135,0,242)'],
    calculable: true,
    series: [{
      name: '能源占比',
      type: 'pie',
      radius: ['15%', '60%'],
      roseType: 'radius', //半径模式
      // x: '50%',
      sort: 'ascending',
      labelLine: {
        normal: {
          length: 10,
          length2: 10,
          lineStyle: {
            color: '#fff'
          }
        }
      },
      data: [{
        value: 85,
        name: '电能'
      }, {
        value: 15,
        name: '水'
      }, ],
      itemStyle: {
        normal: {
          label: {
            show: true,
            formatter: '{b}\n ({d}%)'
          },
          labelLine: {
            show: true
          }
        }
      },
      label: {
        normal: {
          textStyle: {
            color: 'white',
            fontSize: 12,
            fontWeight: 'bold'
          }
        }
      }
    }]
  };
  energyProportion.setOption(option);
}

/*显示用户占比*/
function showUserProportion() {
  var userProportion = echarts.init(document.getElementById('right-top'));
  option2 = {
    title: {
      text: '企业类型',
      x: 'center',
      textStyle: {
        color: 'white',
        fontSize: 18,
        fontWight: 'bold'
      }
    },
    tooltip: {
      trigger: 'item',
      formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    color: ['rgb(101,212,229)', 'white', 'rgb(247,140,0)'],
    calculable: true,
    series: [{
      name: '用户占比',
      type: 'pie',
      radius: ['50%', '70%'],
      // roseType : 'radius',
      itemStyle: {
        normal: {
          label: {
            show: false
          },
          labelLine: {
            show: false
          }
        },
        emphasis: {
          label: {
            show: true,
            position: 'center',
            textStyle: {
              fontSize: '20',
              fontWeight: 'bold'
            }
          }
        }
      },
      data: [{
        value: 73,
        name: '生产加工'
      }, {
        value: 12,
        name: '仓储'
      }, {
        value: 15,
        name: '其他'
      }],
      itemStyle: {
        normal: {
          label: {
            show: true,
            formatter: '{b} : {c} \n ({d}%)'
          },
          labelLine: {
            show: false
          },
        }
      },
      label: {
        normal: {
          textStyle: {
            color: 'white',
            fontSize: 10
              // fontWeight: 'bold'
          }
        }
      }
    }]
  };
  userProportion.setOption(option2);
}