<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <link rel="stylesheet" type="text/css" href="/static/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="/static/css/manager.css"/>
    <link rel="shortcut icon" href="/static/picture/logo.ico"/>
    <link href="/static/css/nav/newmain.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="/static/css/nav/nav-style.css"/>
    <link href="/static/css/main.css" type="text/css" rel="stylesheet"/>
    <link href="/static/css/font-awesome.min.css" rel="stylesheet"/>
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
        a:link, a:visited {
            text-decoration: none; /*超链接无下划线*/
        }

        a:hover {
            text-decoration: underline; /*鼠标放上去有下划线*/
            color: #f1a179;
        }

        #menu-top a:hover {
            color: white !important;
        }
    </style>
    <title>管理页面</title>
</head>
<body class="bg">
<div class="wrapper">
    <div class="main">
        <!--导航条-->
        <div id="nav"><#include "nav.html"></div>
        <!--内容-->
        <div class="container">
            <div class="row ">
                <div class=" ">
                    <a href="main">首页</a>
                    >><a href="javascript:void (0)">绿色•低碳•能源•大数据平台</a>
                </div>
            </div>
            <div class="row" style="margin-top:20px;">
                <div class="col-sm-12 col-md-4 col-lg-4 common" id="dashboard-A"></div>
                <div class="col-sm-12 col-md-4 col-lg-4 common" id="dashboard-U"></div>
                <div class="col-sm-12 col-md-4 col-lg-4 common" id="dashboard-C"></div>
            </div>
            <div class="row" style="margin-top:20px;">
                <div class="col-sm-12 col-md-12 col-lg-12 common-grid" id="A-U"></div>
            </div>
            <div class="row" style="margin-top:40px;">
                <div class="col-sm-12 col-md-12 col-lg-12 common-grid">
                    <div class="row title">
                        <div class="col-md-6 col-sm-6 col-xs-6">今日能耗列表</div>
                        <div class="col-md-6 col-sm-6 col-xs-6">
                            <form action="/jx/api/downloadPowerAllViews.xls">
                                <input type="submit" class="btn btn-info btn-sm" id="report-btn" value="导出数据">
                            </form>
                        </div>
                    </div>
                    <div class="row table-container">
                        <table class="table table-striped table-hover">
                            <thead>
                            <tr>
                                <th>序号</th>
                                <th>企业</th>
                                <th>电表号</th>
                                <th>A相电压</th>
                                <th>B相电压</th>
                                <th>C相电压</th>
                                <th>总电能</th>
                                <th>尖电能</th>
                                <th>峰电能</th>
                                <th>谷电能</th>
                                <th>倍率</th>
                                <th>时间</th>
                            </tr>
                            </thead>
                            <tbody id="todayList">

                            </tbody>
                        </table>
                    </div>
                    <div id="page"></div>

                </div>
            </div>
        </div>
    </div>
</div>
<div id="footer-in"><#include "footer_1.html"></div>
<script type="text/javascript" src="/static/js/jquery.min.js"></script>
<script type="text/javascript" src="/static/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/static/js/jqPaginator.js"></script>
<script type="text/javascript" src="/static/js/manager.js"></script>
<script type="text/javascript" src="/static/js/echarts/echarts.js"></script>
<script src="/static/js/common.js"></script>
<script>
    $(function () {
        hasLogin = true;
        userHero = 'root';
    });
</script>
<script type="text/javascript">
    $(function () {
        $("tr").click(function () {
            window.open("rootSingleData", "about:blank");
        })
    });
</script>
<script type="text/javascript" src="/static/js/nav.js"></script>
</body>
</html>
