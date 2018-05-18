<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>大数据分析首页</title>
    <!--把font文件夹丢进来就没错误了-->
    <link href="/static/css/font-awesome.min.css" rel="stylesheet"/>
    <link rel="icon" href="/static/picture/logo.ico"/>
    <!--新增导航样式-->
    <link href="/static/css/nav/newmain.css" rel="stylesheet"/>
    <link href="/static/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
    <link href="/static/css/main.css" type="text/css" rel="stylesheet"/>
    <link href="/static/css/font-awesome.min.css" type="text/css" rel="stylesheet"/>
    <link href="/static/css/dataTables.bootstrap.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="/static/css/nav/nav-style.css"/>
    <link rel="stylesheet" type="text/css" href="/static/css/layer.css"/>
    <!--日期选择器-->
    <link type="text/css" href="/static/css/jquery.datetimepicker.css" rel="stylesheet"/>
    <script src="/static/js/echarts/echarts.js"></script>
    <script src="/static/js/echarts/china.js"></script>
    <script src="/static/js/jquery.min.js"></script>
    <script src="/static/js/layer.js"></script>
    <script src="/static/js/alert_null_data.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
    <script src="/static/js/common.js"></script>
    <script src="/static/js/json2.js"></script>

    <script src="/static/js/datetimepicker/jquery.datetimepicker.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="/static/js/jquery.metisMenu.js"></script>
    <!-- DATA TABLE SCRIPTS -->
    <script src="/static/js/dataTables/jquery.dataTables.js"></script>
    <script src="/static/js/dataTables/dataTables.bootstrap.js"></script>


    <style type="text/css">
        a:link, a:visited {
            text-decoration: none; /*超链接无下划线*/
        }

        a:hover {
            text-decoration: underline; /*鼠标放上去有下划线*/
            color: #f1a179;
        }

        a {
            font-size: 14px;
        }

        .highlight {
            border: 1px solid #FFE4C4;
            background-color: #E6E6FA
        }

        .col-md-2 {
            height: 150px;
        }

        .main-text {
            font-size: 14px;
            font-weight: 500;
            text-align: center;
            vertical-align: middle;
            color: #444;
        }

        .icon-box {
            display: block;
            margin: 10px 20px 10px 35px;
            width: 50px;
            height: 50px;
            line-height: 55px;
            vertical-align: middle;
            text-align: center;
            font-size: 30px;
        }

        .bg-color-red {
            background-color: #DB0630;
            color: #fff;
        }

        .bg-color-green {
            background-color: #00CE6F;
            color: #fff;
        }

        .bg-color-blue {
            background-color: #A95DF0;
            color: #fff;
        }

        .bg-color-brown {
            background-color: #B94A00;
            color: #fff;
        }

        .bg-color-pink {
            background-color: #FFC0CB;
            color: #fff;
        }

        .set-icon {
            -webkit-border-radius: 50px;
            -moz-border-radius: 50px;
            border-radius: 50px;
        }

        .noti-box {
            min-height: 100px;
            padding: 20px;
        }

        .bg-color {
            margin-top: 20px;
            background-color: #F5F5DC;
            height: 150px;
        }

        #qynh-child, #qyydl-child, #yqnh-child, #ydzc-child {
            display: none;
        }

        /*实现日历框的日历小图标db_nenghaotongji.html*/
        #datetimepicker {
            /*.after('<span class="ui-icon ui-icon-calendar" style="position: absolute; right:2px; top:1px;"></span>');*/
            background: url(/static/picture/calendar.jpg) center right no-repeat;
        }

        /*实现日历框的日历小图标 db_ydl.html*/
        #enddate, #startdate {
            background: url(/static/picture/calendar.jpg) center right no-repeat;
        }
    </style>
</head>
<body class="bg">
<div class="wrapper">
    <div class="main">
        <!--导航条-->
        <div id="nav"><#include "nav.html"></div>
        <div class="container">
            <div class="row ">
                <div class=" ">
                    <a href="javascript:void(0)">首页</a>
                    >><a href="javascript:void(0)">绿色•低碳•能源•大数据平台</a>
                    >><a href="javascript:void(0)">大数据分析</a>
                </div>
            </div>
            <div class="row bg-color">

                <div class="col-md-2 col-md-offset-1 col-xs-3 ">
                    <a id="qynh" href="javascript:void(0)">
                        <div class="noti-box">
                <span class="icon-box bg-color-green set-icon">
                    <i class="glyphicon glyphicon-leaf"></i>
                </span>
                            <div class='main-text'>
                                企业能耗统计
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-md-2 col-xs-3">
                    <a id="qyydl" href="javascript:void(0)">
                        <div class="noti-box">
                <span class="icon-box bg-color-brown set-icon">
                    <i class="fa fa-battery-quarter" aria-hidden="true"></i>
                </span>
                            <div class='main-text'>
                                企业用电量统计
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-md-2 col-xs-3 highlight">
                    <a id="ydzt" class="" href="javascript:void(0)">
                        <div class="noti-box">
                <span class="icon-box bg-color-red set-icon">
                   <i class="fa fa-heartbeat" aria-hidden="true"></i>
                </span>
                            <div class='main-text'>
                                用电状态及趋势
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-md-2 col-xs-3">
                    <a id="ydzc" href="javascript:void(0)">
                        <div class="noti-box">
                <span class="icon-box bg-color-pink set-icon">
                    <i class="fa fa-arrow-up" aria-hidden="true"></i>
                </span>
                            <div class='main-text'>
                                用电同比增长
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-md-2 col-xs-3">
                    <a id="yqnh" href="javascript:void(0)">
                        <div class="noti-box">
                <span class="icon-box bg-color-blue set-icon">
                    <i class="fa fa-bell" aria-hidden="true"></i>
                </span>
                            <div class='main-text'>
                                能耗指标分析
                            </div>
                        </div>
                    </a>
                </div>
            </div>
        </div>
        <div class="container" id="data">
    <#include "db_analysis_of_electric_energy.html">
    <#include "db_ydl.html">
    <#include "db_qsyc.html">
    <#include "db_electricity_consumption_growth.html">
    <#include "db_nenghaotongji.html">
        </div>
    </div>
</div>
<div id="footer-in"><#include "footer_1.html"></div>
<script>
    var companyInfomatins; //定义全局变量，存储公司信息
    $(function () {
        $.ajax({
            type: 'POST',
            dataType: 'json',
            async: true,
            url: '/jx/api/company/companyInfos',
            success: function (myJson) {
                companyInfomatins = myJson;
                for (var index in myJson) {
                    $("#name").append("<option value=" + myJson[index].companyCode + ">" + myJson[index].companyCode + " " + myJson[index].companyName + "</option>");
                    $("#companyName").append("<option value=" + myJson[index].companyCode + ">" + myJson[index].companyCode + " " + myJson[index].companyName + "</option>");
                    $("#ydlCom").append("<option value=" + myJson[index].companyCode + ">" + myJson[index].companyCode + " " + myJson[index].companyName + "</option>");
                    $("#qsComName").append("<option value=" + myJson[index].companyCode + ">" + myJson[index].companyCode + " " + myJson[index].companyName + "</option>");
                }
                //填充到公司电表信息下拉框
                if (myJson[0].powerMeterInfos.length != 0) {
                    for (var i in myJson[0].powerMeterInfos) {
                        $("#companyMeter").append('<option value=' + myJson[0].powerMeterInfos[i].pCode + '>' + myJson[0].powerMeterInfos[i].pCode + ' ' + myJson[0].powerMeterInfos[i].pName + '</option>');
                        $("#ydlMeter").append('<option value=' + myJson[0].powerMeterInfos[i].pCode + '>' + myJson[0].powerMeterInfos[i].pCode + ' ' + myJson[0].powerMeterInfos[i].pName + '</option>');
                        $("#qsMeter").append('<option value=' + myJson[0].powerMeterInfos[i].pCode + '>' + myJson[0].powerMeterInfos[i].pCode + ' ' + myJson[0].powerMeterInfos[i].pName + '</option>');
                    }
                }
            },
            error: function () {
                console.log('获取公司json失败');
            }
        });
    })
</script>
<script type="text/javascript" src="/static/js/db_analysis_of_electric_energy.js"></script>
<script type="text/javascript" src="/static/js/db_electricity_consumption_growth.js"></script>
<script type="text/javascript" src="/static/js/db_nenghaotongji.js"></script>
<script type="text/javascript" src="/static/js/db_qsyc.js"></script>
<script type="text/javascript" src="/static/js/db_ydl.js"></script>
<script type="text/javascript">
    $(function () {
        function hideAll() {
            $("#qynh-child").hide();
            $("#qyydl-child").hide();
            $("#ydzt-child").hide();
            $("#yqnh-child").hide();
            $("#ydzc-child").hide();
        }

        hasLogin = true;
        userHero = 'root';
        /*企业能耗的点击事件*/
        $("#qynh").on("click", function () {
//            $("#data").load("db_analysis_of_electric_energy.html");
            $(this).parent().addClass("highlight").siblings().removeClass("highlight");
            hideAll();
            $("#qynh-child").show();
            $("#ele div").css('width', '100%');
            $("#ele canvas").css('width', '100%');
            mChart1.resize();
        });
        /*企业用电量的点击事件*/
        $("#qyydl").click(function () {
            $(this).parent().addClass("highlight").siblings().removeClass("highlight");
//            $("#data").load("db_ydl.html");
            hideAll();
            $("#qyydl-child").show();
            $("#ydl div").css('width', '100%');
            $("#ydl canvas").css('width', '100%');
            app.resize();
        });
        /*用电状态及趋势*/
        $("#ydzt").on("click", function () {
            $(this).parent().addClass("highlight").siblings().removeClass("highlight");
//            $("#data").load("db_qsyc.html");
            hideAll();
            $("#ydzt-child").show();
        });
//       /*用电增长*/
        $("#ydzc").on("click", function () {
            $(this).parent().addClass("highlight").siblings().removeClass("highlight");
//            $("#data").load("db_electricity_consumption_growth.html");
            hideAll();
            $("#ydzc-child").show();
        });
        /*园区所有能耗*/
        $("#yqnh").click(function () {
            $(this).parent().addClass("highlight").siblings().removeClass("highlight");
//          $("#data").load("db_nenghaotongji.html");
            hideAll();
            $("#yqnh-child").show();
            $("#equalsTo div").css('width', '100%');
            $("#equalsTo canvas").css('width', '100%');
            mChart5.resize();
        })
    });
</script>
<script type="text/javascript" src="/static/js/nav.js"></script>
</body>
</html>