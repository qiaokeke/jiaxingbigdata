<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8"/>
    <title>实时监测</title>
    <script src="/static/js/jquery.min.js"></script>
    <script src="/static/js/echarts/echarts.js"></script>
    <script src="/static/js/echarts/echarts-liquidfill.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
    <script src="/static/js/echarts/echartGL.js"></script>
    <link rel="stylesheet" type="text/css" href="/static/css/layer.css"/>
    <script src="/static/js/layer.js"></script>
    <script src="/static/js/alert_null_data.js"></script>
    <link href="/static/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
    <link rel="icon" href="/static/picture/logo.ico"/>
    <link rel="stylesheet" type="text/css" href="/static/css/nav/nav-style.css"/>

    <link href="/static/css/main.css" type="text/css" rel="stylesheet"/>
    <link href="/static/css/font-awesome.min.css" type="text/css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="/static/css/calendar.css"/>

    <!--新增导航样式-->
    <link href="/static/css/nav/newmain.css" rel="stylesheet"/>
    <style type="text/css">
        a {
            font-family: sans-serif 宋体;
            font-size: 16px;
        }

        .nav_tabs > li.active > a {
            color: #000;
        }

        #menu-top a:hover {
            color: white !important;
        }

        .report {
            float: right;
            margin-right: 10px;
        }

        .btn-primary {
            background-color: #5bc0de;
            border-color: #46b8da;
        }

        .btn-primary :hover {
            background-color: #46b8da;
        }
    </style>
</head>

<body class="bg">
<div class="wrapper">
    <div class="main">
        <!--导航条-->
        <div id="nav"><#include "nav.html"></div>
        <div class="container ">
            <div class="row">
                <div class="col-md-4">
                    <a href="main.ftl">首页</a> >>
                    <a href="javascript:void (0)">绿色•低碳•能源•大数据平台</a> >>
                    <a href="javascript:void (0)"><span id="aCode"></span></a>
                </div>
            </div>
            <div class="row" style="line-height: 50px;">
                <div class="col-md-4">
                    公司名称：<span id="cName"></span>
                </div>
            </div>
            <div class="row">
                &nbsp;&nbsp;&nbsp;&nbsp;选择企业：&nbsp;
                <select class="input-sm" id="companyNameList" style="margin-bottom: 30px;">
                </select>&nbsp;&nbsp;
                选择电表：
                <select class="input-sm" id="companyMeterList" style="margin-bottom: 30px;">
                    <option value="0">0&nbsp;所有电表</option>
                </select>
                <button class="btn btn-info" id="selectCom" style="margin-left: 50px;">确定</button>
            </div>
            <div class="row">
                <ul class="nav nav-tabs" role="tablist" id="mytabs">
                    <li role="presentation" class="active"><a href="#curdata" aria-controls="home" role="tab"
                                                              data-toggle="tab">实时数据</a></li>
                    <li role="presentation"><a href="#calendar" aria-controls="profile" role="tab" data-toggle="tab">分时能耗日历</a>
                    </li>
                    <li role="presentation"><a href="#calendar-new" aria-controls="profile" role="tab"
                                               data-toggle="tab">峰谷能耗日历</a></li>
                    <li role="presentation"><a href="#calendar-week" aria-controls="profile" role="tab"
                                               data-toggle="tab">周能耗日历</a></li>
                    <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">能耗目标</a>
                    </li>
                    <li role="presentation"><a href="#money" aria-controls="money" role="tab" data-toggle="tab">可用余额</a>
                    </li>
                </ul>
                <div class="tab-content">
                    <!--实时监测-->
                    <div role="tabpanel" class="tab-pane active" id="curdata"
                         style="width: 100%; height: 400px; border: 1px solid #ccc; padding: 10px;"></div>
                    <!--能耗日历--分时能耗-->
                    <div role="tabpanel" class="tab-pane " id="calendar">
                        <div class="row">
                            <div class="col-md-6" id="calendar1"
                                 style="width: 585px; height: 420px; border: 1px solid #ccc; padding: 10px;"></div>
                            <div class="col-md-6"
                                 style="width: 585px; height: 420px; border: 1px solid #ccc; padding: 10px;">
                                <a href="javascript:void(0)" style=" color:#111;">分时能耗</a>
                                <div id="useage" style="width: 585px; height: 400px;"></div>
                            </div>
                        </div>
                    </div>
                    <!--峰谷能耗日历-->
                    <div role="tabpanel" class="tab-pane" id="calendar-new">
                        <div class="container">
                            <div class="row">
                                <div class="col-sm-12 col-md-12" style="height: 620px;">
                                    <div style="width: 570px;margin: 0 auto 20px;">
                                        <form class="form-inline pull-left" style="width: 260px;">
                                            <div class="form-group">
                                                <select name="year" class="form-control" id="year">
                                                    <option value="2017">2017</option>
                                                    <option value="2018">2018</option>
                                                    <option value="2019">2019</option>
                                                    <option value="2020">2020</option>
                                                    <option value="2021">2021</option>
                                                </select>
                                                <label for="year">年</label>
                                            </div>
                                            <div class="form-group">
                                                <select name="month" class="form-control" id="month">
                                                    <option value="01">1</option>
                                                    <option value="02">2</option>
                                                    <option value="03">3</option>
                                                    <option value="04">4</option>
                                                    <option value="05">5</option>
                                                    <option value="06">6</option>
                                                    <option value="07">7</option>
                                                    <option value="08">8</option>
                                                    <option value="09">9</option>
                                                    <option value="10">10</option>
                                                    <option value="11">11</option>
                                                    <option value="12">12</option>
                                                </select>
                                                <label for="month">月</label>
                                            </div>
                                            <input type="button" value="查询" class="btn btn-primary" id="findit"/>
                                        </form>
                                    </div>
                                    <div style="height: 500px;width: 570px; margin: 0 auto;margin-top: 50px;"
                                         id="calendar-container"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- 周能耗日历 -->
                    <div role="tabpanel" class="tab-pane" id="calendar-week"
                         style="width: 1148px; height: 700px; padding: 10px;"></div>
                    <!--能耗目标-->
                    <div role="tabpanel" class="tab-pane " id="messages">
                        <div class="container">
                            <div class="row" style="padding-top: 20px;">
                                <div class="col-md-4">
                                    当月电能耗目标&nbsp;&nbsp;&nbsp;
                                    <input type="text" value="60KWH" title="能耗" id="eleTarget">
                                </div>
                                <div class="col-md-4">
                                    当月水能耗目标&nbsp;&nbsp;&nbsp;
                                    <input type="text" value="30m³" title="能耗" id="warTarget">
                                </div>
                                <div class="col-md-4">
                                    企业分类
                                </div>
                            </div>
                            <div class="row" style="padding-top: 20px;">
                                <div class="col-md-4" id="electrical"
                                     style="width: 390px; height: 400px; border: 1px solid #ccc;  "></div>
                                <div class="col-md-4" id="water"
                                     style="width: 390px; height: 400px; border: 1px solid #ccc;  "></div>
                                <div class="col-md-4" id="comType"
                                     style="width: 390px; height: 400px; border: 1px solid #ccc;  "></div>
                            </div>
                        </div>
                    </div>
                    <!--余额-->
                    <div role="tabpanel" class="tab-pane" id="money">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-6" id="left_money"
                                     style="width:585px; height: 410px; border: 1px solid #ccc;"></div>
                                <div class="col-md-6" style=" width:585px;height: 410px; border: 1px solid #ccc;">
                                    <div class="row">
                                        <ul class="nav nav-tabs" role="tablist">
                                            <li role="presentation" class="active"><a href="#home" aria-controls="home"
                                                                                      role="tab"
                                                                                      data-toggle="tab">电费</a></li>
                                            <li role="presentation"><a href="#profile" aria-controls="profile"
                                                                       role="tab" data-toggle="tab">水费</a></li>
                                        </ul>
                                        <div class="tab-content">
                                            <div role="tabpanel" class="tab-pane active" id="home">
                                                <div class="row" style="padding: 20px 20px 0 20px">
                                                    <div class="col-md-4">
                                                        <div class="panel panel-info">
                                                            <div class="panel-heading">1000元</div>
                                                            <div class="panel-body">
                                                                预充值1000元
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="panel panel-info">
                                                            <div class="panel-heading">2000元</div>
                                                            <div class="panel-body">
                                                                预充值2000元
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="panel panel-info">
                                                            <div class="panel-heading">3000元</div>
                                                            <div class="panel-body">
                                                                预充值3000元
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="panel panel-info">
                                                            <div class="panel-heading">5000元</div>
                                                            <div class="panel-body">
                                                                预充值5000元
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="panel panel-info">
                                                            <div class="panel-heading">10000元</div>
                                                            <div class="panel-body">
                                                                预充值10000元
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="panel panel-info">
                                                            <div class="panel-heading">20000元</div>
                                                            <div class="panel-body">
                                                                预充值20000元
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div role="tabpanel" class="tab-pane" id="profile">
                                                <div class="row" style="padding: 20px 20px 0 20px">
                                                    <div class="col-md-4">
                                                        <div class="panel panel-info">
                                                            <div class="panel-heading">200元</div>
                                                            <div class="panel-body">
                                                                预充值200元
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="panel panel-info">
                                                            <div class="panel-heading">300元</div>
                                                            <div class="panel-body">
                                                                预充值300元
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="panel panel-info">
                                                            <div class="panel-heading">500元</div>
                                                            <div class="panel-body">
                                                                预充值500元
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="panel panel-info">
                                                            <div class="panel-heading">1000元</div>
                                                            <div class="panel-body">
                                                                预充值1000元
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="panel panel-info">
                                                            <div class="panel-heading">2000元</div>
                                                            <div class="panel-body">
                                                                预充值2000元
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="panel panel-info">
                                                            <div class="panel-heading">3000元</div>
                                                            <div class="panel-body">
                                                                预充值3000元
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row" style="padding-left: 20px;">
                                        <h3>支付方式</h3>
                                        <a class="btn btn-info" href="javascript:void(0)" aria-label="Delete">

                                            <i class="fa fa-credit-card fa-2x"></i>
                                        </a>
                                        <a class="btn btn-info" href="javascript:void(0)" aria-label="Delete">
                                            <i class="fa fa-weixin fa-2x"></i>
                                        </a>
                                        <img src="/static/picture/pay.png" class="btn btn-info"/>
                                        <a class="report" href="note" target="_blank">
                                            <button class="btn btn-primary">通知单</button>
                                        </a>
                                        <a class="report" href="report" target="_blank">
                                            <button class="btn btn-primary">电费单</button>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
<div id="footer-in"><#include "footer_1.html"></div>
<script type="text/javascript" src="/static/js/root_ssjc.js"></script>
<script type="text/javascript" src="/static/js/nav.js"></script>
<script type="text/javascript" src="/static/js/calendar.js"></script>
</body>
</html>